package com.mrinternauta.RestApi.web.controller;

import com.mrinternauta.RestApi.domain.dto.AuthenticationRequest;
import com.mrinternauta.RestApi.domain.dto.AuthenticationResponse;
import com.mrinternauta.RestApi.domain.dto.UserDomain;
import com.mrinternauta.RestApi.domain.service.UserOwnDatailService;
import com.mrinternauta.RestApi.domain.service.UserService;
import com.mrinternauta.RestApi.web.security.JwtUtil;
import com.mrinternauta.RestApi.web.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/users")
//@CrossOrigin
@CrossOrigin(origins = "*")

public class UserController {
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserOwnDatailService userOwnDatailService;
    @Autowired
    SecurityConfig securityConfig;

    @GetMapping(path = "/")
    public List<UserDomain> getAll(){
        return userService.getAll();
    }

    @GetMapping(path = "/{id}")
    UserDomain findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping(path = "/registerAccount")
    public ResponseEntity<UserDomain> save(@RequestBody UserDomain userDomain){
        UserDomain existedUser = userService.findByEmail(userDomain.getEmail());
        if (existedUser.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userDomain.setPassword(securityConfig.passwordEncoder().encode(userDomain.getPassword()));
        return new ResponseEntity<>(userService.save(userDomain), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public UserDomain update(@PathVariable Long id, @RequestBody UserDomain userDomain){
        //TODO: Validar
        userDomain.setPassword(securityConfig.passwordEncoder().encode(userDomain.getPassword()));
        return  userService.update(userDomain, id);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean delete(@PathVariable Long id){
        return userService.delete(id);
    }


    @GetMapping(path ="/byEmail/{email}")
    UserDomain findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }

    @PostMapping(path = "/auth")
    public ResponseEntity<AuthenticationResponse> createTokenToken (@RequestBody AuthenticationRequest request){
        if(request.getEmail() == null || request.getPassword() == null){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }

        UserDomain userDomain = userService.findByEmail(request.getEmail());

        if (userDomain.getId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //verificar contraseñas
        if (!securityConfig.passwordEncoder().matches(request.getPassword(), userDomain.getPassword())){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        userDomain.setLastLogin(LocalDate.now());

        userService.update(userDomain, userDomain.getId());

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())); //Realiza la auth

        UserDetails userDetails = userOwnDatailService.loadUserByUsername(request.getEmail());

        String token = jwtUtil.generateToken(userDetails);
        return new ResponseEntity<>(new AuthenticationResponse(token, userDomain), HttpStatus.OK);
    }
}

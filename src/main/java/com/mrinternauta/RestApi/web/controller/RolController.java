package com.mrinternauta.RestApi.web.controller;

import com.mrinternauta.RestApi.domain.dto.RolDomain;
import com.mrinternauta.RestApi.domain.service.RolService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*")
public class RolController {
    @Autowired
    private RolService rolService;
    @GetMapping(path = "/")
    @ApiOperation("Get all Roles of the user")
    public ResponseEntity<List<RolDomain>> getAll(){
        Optional<List<RolDomain>> response = Optional.of(rolService.findAll());
        return  response
                .map(data -> new ResponseEntity<>(data, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/{id}")
    @ApiOperation("Get a specific rol by id")
    ResponseEntity<RolDomain> findById(@PathVariable Long id){
        Optional<RolDomain> response = Optional.of(rolService.findById(id));
        return  response
                .map(data -> new ResponseEntity<>(data, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping(path = "/")
    @ApiOperation("Create a new rol")
    public ResponseEntity<RolDomain> save(@RequestBody RolDomain rolDomain){
        //TODO: Validar
        Optional<RolDomain> response = Optional.of(rolService.save(rolDomain));
        return  response
                .map(data -> new ResponseEntity<>(data, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @PutMapping(path = "/{id}")
    public ResponseEntity<RolDomain> update(@RequestBody RolDomain rolDomain, @PathVariable Long id){
        //TODO: Validar
        Optional<RolDomain> response = Optional.of( rolService.update(rolDomain, id));
        return  response
                .map(data -> new ResponseEntity<>(data, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        Boolean status = rolService.delete(id);
        return new ResponseEntity<>(rolService.delete(id), status ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }



    @GetMapping(path ="/byUserId")
    ResponseEntity<RolDomain> byUserId(@RequestParam Long id){
        Optional<RolDomain> response = Optional.of( rolService.update(rolService.findByUserId(id), id));
        return  response
                .map(data -> new ResponseEntity<>(data, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.RestController;

import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Entity.Employe.Employe;
import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Services.Svc.EmployeSvc;
import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployesAllRestController {

    @Autowired
    private EmployeSvc employeSvc;

    @PostMapping(value = "/saveEmploye", produces = "application/json")
    public Employe saveEmploye(@RequestBody final Employe employe) {

        return employeSvc.save(employe);
    }


    @DeleteMapping(value = "/deleteEmploye/{id}", produces = "application/json")
    public void deleteEmploye(@PathVariable(value = "id") final Integer id) {
        employeSvc.delete(id);
    }

    @GetMapping(value = "/getByEmployeById/{id}",produces = "application/json")
    public Employe getEmployeByID(@PathVariable(value = "id") final Integer id) throws ResourceNotFoundException {
        return employeSvc.getEmployeByID(id);
    }

 //  @GetMapping(value = "/getByAllEmployess", produces = "application/json")
    public List<Employe> getALLEmployesss() {
        return employeSvc.getAllEmployes();
    }


}

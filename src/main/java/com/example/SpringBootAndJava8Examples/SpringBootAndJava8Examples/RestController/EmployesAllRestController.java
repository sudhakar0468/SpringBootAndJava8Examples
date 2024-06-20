package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.RestController;

import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Entity.Employe;
import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Services.Svc.EmployeSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
public class EmployeRestController {

    @Autowired
    private EmployeSvc employeSvc;

    @PostMapping(name = "/saveEmploye", produces = "application/json")
    public Employe saveEmploye(final Employe employe) {

        return employeSvc.save(employe);
    }


    @DeleteMapping(name = "/deleteEmploye/{id}", produces = "application/json")
    public void deleteEmploye(final Integer id) {
        employeSvc.delete(id);
    }

    @GetMapping(name = "/getByEmployeById",produces = "application/json")
    public Employe getEmployeByID(@PathVariable final Integer id) {
        return employeSvc.getEmployeByID(id);
    }

    @GetMapping(name = "/getByAllEmployes", produces = "application/json")
    public List<Employe> getALLEmployes() {
        return employeSvc.getAllEmployes();
    }


}

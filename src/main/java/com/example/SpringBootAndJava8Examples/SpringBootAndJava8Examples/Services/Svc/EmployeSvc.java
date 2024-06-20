package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Services.Svc;

import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Entity.Employe;
import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.exceptions.ResourceNotFoundException;

import java.util.List;

public interface EmployeSvc {

    Employe save(final Employe employe);

    void delete(final Integer ID);

    void deleteByEmp(final Employe employe);

    Employe getEmployeByID(final Integer id) throws ResourceNotFoundException;

    List<Employe> getAllEmployes();
}

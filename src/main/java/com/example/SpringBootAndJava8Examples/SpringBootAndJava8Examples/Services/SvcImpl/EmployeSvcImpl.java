package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Services.SvcImpl;

import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Entity.Employe;
import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Repo.EmployeRepository;
import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Services.Svc.EmployeSvc;
import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeSvcImpl implements EmployeSvc {

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public Employe save(final Employe employe) {
       return employeRepository.save(employe);
    }

    @Override
    public void delete(final Integer ID) {
         employeRepository.deleteById(ID);
    }

    @Override
    public void deleteByEmp(final Employe employe) {

        employeRepository.delete(employe);
    }

    @Override
    public Employe getEmployeByID(final Integer id) throws ResourceNotFoundException {

        return employeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employe not found for this id ::"+id));
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }
}

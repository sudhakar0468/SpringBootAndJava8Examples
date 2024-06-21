package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Repo;

import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Entity.Employe.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface EmployeRepository extends JpaRepository<Employe,Integer> {

    @Override
    <S extends Employe> S save(S entity);

    @Override
    void delete(Employe entity);



    @Override
    void deleteById(Integer integer);

    @Override
    List<Employe> findAll();

    @Override
    Optional<Employe> findById(Integer integer);



}

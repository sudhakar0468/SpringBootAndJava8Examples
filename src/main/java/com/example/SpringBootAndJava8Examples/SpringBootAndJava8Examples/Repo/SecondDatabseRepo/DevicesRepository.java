package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Repo.SecondDatabseRepo;

import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Entity.Device.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface DevicesRepository extends JpaRepository<Device, Integer> {

    @Override
    List<Device> findAll();

    @Override
    Optional<Device> findById(Integer integer);

    @Override
    <S extends Device> S save(S entity);

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(Device entity);


}

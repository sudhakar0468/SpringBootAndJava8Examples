package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Services.Svc;

import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Entity.Device.Device;

import java.util.List;

public interface DeviceSvc {

Device save(final Device device);

void DeleteByID(final Integer Id);

void delete(final Device device);

Device getDeviceById(final Integer id);

List<Device> getAllDevice();



}

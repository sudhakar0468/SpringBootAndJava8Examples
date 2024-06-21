package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Services.SvcImpl;

import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Entity.Device.Device;
import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Repo.SecondDatabseRepo.DevicesRepository;
import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Services.Svc.DeviceSvc;
import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceSvcImpl implements DeviceSvc {

    @Autowired
    private DevicesRepository devicesRepository;
    @Override
    public Device save(final Device device) {
        return devicesRepository.save(device);
    }

    @Override
    public void DeleteByID(Integer Id) {
        devicesRepository.deleteById(Id);
    }

    @Override
    public void delete(final Device device) {
        devicesRepository.delete(device);
    }

    @Override
    public Device getDeviceById(Integer id) throws ResourceNotFoundException {
        return devicesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Device not found for this id ::"+id));
    }

    @Override
    public List<Device> getAllDevice() {
        return devicesRepository.findAll();
    }
}

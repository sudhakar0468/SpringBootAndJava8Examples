package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.RestController;

import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Entity.Device.Device;
import com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Services.Svc.DeviceSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class DeviceRestController {

    @Autowired
    private DeviceSvc deviceSvc;


    @PostMapping(value = "/saveDevice", produces = "application/json")
    public ResponseEntity<?> saveDevice(@RequestBody final Device device) {
        Device device1 = deviceSvc.save(device);
        return new ResponseEntity<>(device1, HttpStatus.OK);
    }

    @GetMapping(value = "/getDevics/{id}", produces = "application/json")
    public ResponseEntity<?> getDevice(@PathVariable final Integer id) {
        Device device = deviceSvc.getDeviceById(id);
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllDevinc", produces = "application/json")
    public ResponseEntity<?> getALLDevices() {
        final List<Device> listDevice = deviceSvc.getAllDevice();
        return new ResponseEntity<>(listDevice, HttpStatus.OK);
    }


    @DeleteMapping(value = "/deleteDevics", produces = "application/json")
    public ResponseEntity<?> deleteDevice(@PathVariable Integer id) {

        Device device = deviceSvc.getDeviceById(id);
        deviceSvc.delete(device);
        return new ResponseEntity<>(device, HttpStatus.OK);
    }


}

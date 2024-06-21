package com.example.SpringBootAndJava8Examples.SpringBootAndJava8Examples.Entity.Device;

import jakarta.persistence.*;

@Table(name = "device")
@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "devniceName")
    private String devniceName;
    @Column(name = "deviceType")
    private String deviceType;
    @Column(name = "deviceDesc")
    private String deviceDesc;

    public Device() {
    }

    public Device(Integer id, String devniceName, String deviceType, String deviceDesc) {
        this.id = id;
        this.devniceName = devniceName;
        this.deviceType = deviceType;
        this.deviceDesc = deviceDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevniceName() {
        return devniceName;
    }

    public void setDevniceName(String devniceName) {
        this.devniceName = devniceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceDesc() {
        return deviceDesc;
    }

    public void setDeviceDesc(String deviceDesc) {
        this.deviceDesc = deviceDesc;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", devniceName='" + devniceName + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", deviceDesc='" + deviceDesc + '\'' +
                '}';
    }
}

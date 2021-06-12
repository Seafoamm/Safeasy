package com.TCSS360.Sensor_System;

public class SensorInterface extends Sensor {

    public SensorInterface(int id, SensorStatus sensorStatus,
                           SensorTypes sensorTypes, boolean enable) {
        super(id, sensorStatus, sensorTypes, enable);
    }

    public void activateSensor() {
        super.enable = true;
    }
    public void deactivateSensor() {
        super.enable = false;
    }

    public String viewCamera(int cameraNumber) {
        return "Viewing camera" + cameraNumber;
    }
}

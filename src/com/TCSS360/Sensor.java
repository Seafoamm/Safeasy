package com.TCSS360;

public class Sensor extends SensorInterface {

    public Sensor(SensorBatteryStatus sensorBatteryStatus, SensorStatus sensorStatus,
                  SensorTypes sensorTypes, boolean enable) {
        super(sensorBatteryStatus, sensorStatus, sensorTypes, enable);
    }

    public SensorBatteryStatus batteryTrigger() {
        return super.getSensorBatteryStatus();
    }

    public SensorStatus sensorStatusTrigger() {
        return super.getSensorStatus();
    }

    public SensorTypes sensorTypesTrigger() {
        return super.getSensorTypes();
    }









}

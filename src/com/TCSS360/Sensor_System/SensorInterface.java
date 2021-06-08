package com.TCSS360.Sensor_System;

public class SensorInterface {
    public enum SensorBatteryStatus {
        Low("red"),
        Mid("yellow"),
        Full("green");

        private String status;

        private SensorBatteryStatus(String status) {
            this.status =  status;
        }
        public String getStatus() {
            return status;
        }
    }
    public enum SensorStatus {
        Detect("red"),
        NeedMaintenance("yellow"),
        NonDetect("green");

        private String status;

        private SensorStatus(String status) {
            this.status = status;
        }
        public String getStatus() {
            return status;
        }
    }

    public enum SensorTypes {
        Motion(1),
        Temperature(2),
        Water(3),
        Smoke(4);

        private int number;

        private SensorTypes(int number) {
            this.number = number;
        }

        public int getSensorType() {
            return number;
        }
    }

    private int id;
    private String batteryColor;
    private String sensorColor;
    private SensorTypes sensorTypes;
    private SensorBatteryStatus sensorBatteryStatus;
    private SensorStatus sensorStatus;
    private boolean enable;

    public SensorInterface(final SensorTypes sensorTypes, final boolean enable) {
        this.enable = enable;
        this.sensorTypes = sensorTypes;
    }

    public long getId() {
        return id;
    }
    public void setId(final int id) {
        this.id = id;
    }

    public SensorTypes getSensorTypes() {
        return sensorTypes;
    }
    public void setSensorTypes(final SensorTypes sensorTypes) {
        this.sensorTypes = sensorTypes;
    }

    public boolean isEnable() {
        return enable;
    }
    public void setEnable(final boolean enable) {
        this.enable = enable;
    }

    public SensorStatus getSensorStatus() { return sensorStatus; }
    public void setSensorStatus(final SensorStatus sensorStatus) { this.sensorStatus = sensorStatus; }

    public SensorBatteryStatus getSensorBatteryStatus() {
        return sensorBatteryStatus;
    }
    public void setSensorBatteryStatus(final SensorBatteryStatus sensorBatteryStatus) {
        this.sensorBatteryStatus = sensorBatteryStatus;
    }

    public String getBatteryColor() {
        return batteryColor;
    }

    public void setBatteryColor(String batteryColor) {
        this.batteryColor = batteryColor;
    }

    public String getSensorColor() {
        return sensorColor;
    }

    public void setSensorColor(String sensorColor) {
        this.sensorColor = sensorColor;
    }
}

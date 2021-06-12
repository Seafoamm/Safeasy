package com.TCSS360.Sensor_System;

public class Sensor {

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
    private SensorTypes sensorTypes;
    private SensorStatus sensorStatus;
    protected boolean enable;
    private Object[] myData;

    public Sensor(final int id, final SensorStatus sensorStatus,
                  final SensorTypes sensorTypes, final boolean enable) {
        this.enable = enable;
        this.sensorTypes = sensorTypes;
        this.id = id;
        this.sensorStatus = sensorStatus;
        myData = new Object[10];
        myData[0] = id;
        myData[1] = sensorStatus;
        myData[2] = sensorTypes;
        myData[3] = enable;
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

    public Object[] getMyData() {
        return myData;
    }

    public String toString() {
        return "Sensor type is " + getSensorTypes().name() + ", id: " + getId() + ", " +
                "sensor status: " + getSensorStatus().toString() + ", is enable: " + isEnable();
    }

    public String triggered() {
        return sensorTypes.name() + ", id: " + id + " is triggered";
    }
}

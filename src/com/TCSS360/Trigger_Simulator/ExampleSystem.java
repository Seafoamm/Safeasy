package com.TCSS360.Trigger_Simulator;

import com.TCSS360.Sensor_System.Sensor;
import com.TCSS360.Signaling_System.Database;

import java.util.List;

public class ExampleSystem {
    public static List<Sensor> mySensors;
    public static Database myDatabase;
    public ExampleSystem()
    {
        mySensors.add(new Sensor(1, Sensor.SensorStatus.NonDetect, Sensor.SensorTypes.Motion, false));
        mySensors.add(new Sensor(1, Sensor.SensorStatus.NonDetect, Sensor.SensorTypes.Temperature, false));
        mySensors.add(new Sensor(1, Sensor.SensorStatus.NonDetect, Sensor.SensorTypes.Water, false));
        mySensors.add(new Sensor(1, Sensor.SensorStatus.NonDetect, Sensor.SensorTypes.Smoke, false));
    }
}

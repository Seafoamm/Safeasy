package com.TCSS360.Trigger_Simulator;

import com.TCSS360.Sensor_System.Sensor;
import com.TCSS360.Sensor_System.SensorInterface;

public class TriggerSimulator{
    //boolean to check weather the sensor is on or not
   private boolean isEnabled;
    //the type of the sensor
   private SensorInterface.SensorTypes sensorType;
    //the id of the sensor
   private long id;


/*
takes an existing sensor method and a on/off option
@param A sensor object called sensor
 */
    public TriggerSimulator(Sensor sensor, boolean onOff){

        this.isEnabled = sensor.isEnable();
        this.id = sensor.getId();
        this.sensorType = sensor.getSensorTypes();
        buttonPress(sensor,onOff);
        guiUpdate(sensor);
    }

//@param a sensor object called sensor

    public void buttonPress(Sensor sensor, boolean onOff) {
        if (onOff == false) {
             sensor.setEnable(false);
        } else sensor.setEnable(true);
    }
//updates in the main gui
    public void guiUpdate(Sensor sensor){

    }
    }



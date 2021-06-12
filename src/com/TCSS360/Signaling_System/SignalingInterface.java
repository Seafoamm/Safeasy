/*
    Brandon Lu
 */
package com.TCSS360.Signaling_System;

import com.TCSS360.Sensor_System.Sensor;

import java.util.LinkedList;
import java.util.List;

/**
 * the SignalingInterface class contains public services that other systems can call upon
 * it acts as the bridge between the Central System and the Sensor System
 */
public class SignalingInterface {
    /**
     * activates a particular alarm associated with a sensor
     * @param s the sensor whose alarm should be triggered
     */
    public static void activateAlarm(Sensor s)
    {
        //trigger respective alarm
        //we do not have the hardware, so no code here
    }

    /**
     * sends the signal to the Central System to arm the system -- asks for a passcode if not entered already
     */
    public static void armSystem()
    {

    }

    /**
     * calls certain authorities based on the type of alarm
     * @param s the sensor to get the alarm from
     */
    public static void callAuthorities(Sensor s)
    {
        //should call respective authorities here, but is not coded out because that is beyond the scope of the project
    }

    /**
     * gives other systems the ability to access a copy of the database
     * @return a copy of the database
     */
    public static List<Event> accessDataBase()
    {
        return new LinkedList<>(Database.EVENTS);
    }

    /**
     * lets other systems to save an event to the database
     * @param e
     */
    public static void saveToDatabase(Event e)
    {
        Database.EVENTS.add(e);
    }

}

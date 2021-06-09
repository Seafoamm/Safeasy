/*
    Brandon Lu
    06/07/2021
 */
package com.TCSS360.Signalling_System;

import com.TCSS360.Sensor_System.SensorInterface;

import java.time.LocalDateTime;

/**
 * this class will contain information about an event that occurred
 * when a sensor was triggered
 */
public class Event {

    /**
     * mySensor will store which sensor was triggered along with its associated data
     */
    private SensorInterface mySensor;

    /**
     * myDateTime is used to store when the event occurred
     */
    private LocalDateTime myDateTime;

    /**
     * myData is used to store any extra data such as video footage and authorities called
     */
    private Object[] myData;

    /**
     * creates an event triggered by the sensor passed in
     * @param theSensor the sensor that triggered the event
     */
    public Event(SensorInterface theSensor)
    {
        mySensor = theSensor;
        myDateTime = LocalDateTime.now();
        myData = new Object[]{};
    }

    /**
     * creates an event triggered by a sensor and with
     * data passed in
     * @param theSensor the sensor that triggered it
     * @param theData extra data
     */
    public Event(SensorInterface theSensor, Object... theData)
    {
        this(theSensor);
        myData = theData;
    }

    /**
     * returns the datetime of this event
     * @return
     */
    public LocalDateTime getMyDateTime()
    {
        return myDateTime;
    }


    /**
     * returns the extra data of this event
     * @return
     */
    public Object[] getMyData() {
        return myData;
    }


    /**
     * returns the sensor that triggered this event
     * @return
     */
    public SensorInterface getMySensor() {
        return mySensor;
    }

    /**
     * returns if this event is equal to another
     * @param e the event to compare to
     * @return true if sensor, datetime, and data all equal the other sensor's fields
     */
    @Override
    public boolean equals(Object e) {
        return mySensor.equals(((Event)e).mySensor) && myDateTime.equals(((Event)e).myDateTime) && myData.equals(((Event)e).myData);
    }
}
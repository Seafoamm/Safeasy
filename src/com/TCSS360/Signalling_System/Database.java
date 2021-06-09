/*
    Brandon Lu
    06/07/2021
 */
package com.TCSS360.Signalling_System;

import com.TCSS360.Sensor_System.SensorInterface;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.LinkedList;

/**
 * this class adds events that the system receives into
 * its master database
 * it allows getting certain events into the database too
 */
public class Database {
    /**
     * EVENTS is a master database that stores all the events that have occurred
     */
    public static final LinkedList<Event> EVENTS = new LinkedList<>();

    /**
     * adds an event into the database
     * @param e the event to add
     */
    public static void addEvent(Event e)
    {
        EVENTS.add(e);
    }

    /**
     * returns an event specified exactly
     * @param e the event to return
     * @return the event. null if doesn't exist
     */
    public static Event getEvent(Event e)
    {
        if(EVENTS.contains(e))
        {
            return EVENTS.get(EVENTS.indexOf(e));
        }
        else
        {
            return null;
        }
    }

    /**
     * get an event based on order
     * @param i passing in a 1 will get the 1st event recorded, 2 will get the 2nd, etc.
     * @return the event
     */
    public static Event getEvent(int i)
    {
        Event result;
        try
        {
            result = EVENTS.get(i);
        }
        catch(Exception e)
        {
            result = null;
        }

        return result;
    }

    /**
     * will get events that match the exact date time
     * @param date the date time to match
     * @return the events that match
     */
    public static LinkedList<Event> getEvent(LocalDateTime date)
    {

        LinkedList<Event> events = new LinkedList<>();
        for(Event e : EVENTS)
        {
            if(e.getMyDateTime().equals(date))
            {
                events.add(e);
            }
        }

        return events;
    }

    /**
     * will get events that happened on a certain day
     * @param year the year
     * @param month the month
     * @param day the day
     * @return the events that happened on the day
     */
    public static LinkedList<Event> getEvent(int year, Month month, DayOfWeek day)
    {

        LinkedList<Event> events = new LinkedList<>();
        for(Event e : EVENTS)
        {
            if(e.getMyDateTime().getYear() == year)
            {
                if(e.getMyDateTime().getMonth() == month)
                {
                    if (e.getMyDateTime().getDayOfWeek().equals(day)) {
                        events.add(e);
                    }
                }
            }
        }

        return events;
    }

    /**
     * will get events that happened in a certain month
     * @param year the year it happened
     * @param date the month it happened
     * @return the list of events that happened in a month
     */
    public static LinkedList<Event> getEvent(int year, Month date)
    {

        LinkedList<Event> events = new LinkedList<>();
        for(Event e : EVENTS)
        {
            if(e.getMyDateTime().getYear() == year)
            {
                if(e.getMyDateTime().getMonth().equals(date))
                {
                    events.add(e);
                }
            }
        }

        return events;
    }

    /**
     * gets all events that were triggered by a certain sensor
     * @param sensor the sensor that triggered the event
     * @return the events
     */
    public static LinkedList<Event> getEvent(SensorInterface sensor)
    {
        LinkedList<Event> events = new LinkedList<>();
        for(Event e : EVENTS)
        {
           if(e.getMySensor() == sensor)
           {
               events.add(e);
           }
        }

        return events;
    }

}
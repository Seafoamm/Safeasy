package com.TCSS360.Trigger_Simulator;

import com.TCSS360.Central_System.ControlPanel;
import com.TCSS360.Sensor_System.Sensor;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        ExampleSystem mySystem = new ExampleSystem();
        for(Sensor s : mySystem.mySensors)
        {
            TriggerSimulator ts = new TriggerSimulator(s, true);
        }

        createControlPanel();
    }

    public static void createControlPanel() {
        EventQueue.invokeLater(() -> {
            final ControlPanel myControlPanel = new ControlPanel();
        });
    }
}

package com.TCSS360.Trigger_Simulator;

import com.TCSS360.Central_System.ControlPanel;
import com.TCSS360.Sensor_System.Sensor;

import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static ExampleSystem mySystem;
    public static void main(String[] args) {
        mySystem = new ExampleSystem();

        createControlPanel();
    }

    public static void createControlPanel() {
        EventQueue.invokeLater(() -> {
            final ControlPanel myControlPanel = new ControlPanel();
        });
    }
}

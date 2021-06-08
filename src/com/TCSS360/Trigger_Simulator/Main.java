package com.TCSS360.Trigger_Simulator;

import com.TCSS360.Central_System.ControlPanel;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        createControlPanel();
    }

    public static void createControlPanel() {
        EventQueue.invokeLater(() -> {
            final ControlPanel myControlPanel = new ControlPanel();
        });
    }
}

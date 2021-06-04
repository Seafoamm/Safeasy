package com.TCSS360;

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

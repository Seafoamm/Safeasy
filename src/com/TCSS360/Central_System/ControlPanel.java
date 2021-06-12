package com.TCSS360.Central_System;

import com.TCSS360.Sensor_System.Sensor;
import com.TCSS360.Signaling_System.Event;
import com.TCSS360.Signaling_System.SignalingInterface;
import com.TCSS360.Trigger_Simulator.ExampleSystem;
import com.TCSS360.Trigger_Simulator.Main;
import com.TCSS360.Trigger_Simulator.TriggerSimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JFrame {

    private static final long serialVersionUID = 360;
    private enum systemState { OFF, DISARMED, STANDBY, ARMED, TRIGGERED, DURESS }
    private static systemState currentState;
    private JPanel mainPanel;
    private JLabel textDisplay, numDisplay;
    private JButton onOff, armDisarm, key0, key1, key2, key3,
            key4, key5, key6, key7, key8, key9, keyEnter, keyDel, keyTest;
    //private JOptionPane alertBox;
    private String passcode = "360812"; // For demonstration purposes. This is obviously terrible.
    private String duressCode = "360360";

    public ControlPanel() {
        super("Safeasy Control Panel - OFF");
        currentState = systemState.OFF;
        start();
    }

    public void start() {
        setSize(800, 400);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(null);

        textDisplay = new JLabel("System is off", SwingConstants.CENTER);
        textDisplay.setBounds(0, 0, 800, 50);

        onOff = new JButton("On");
        onOff.setBounds(0, this.getHeight() - 89, 100, 50);
        onOff.addActionListener(new onOffListener());

        armDisarm = new JButton("Arm System");
        armDisarm.setBounds(100, this.getHeight() - 89, 200, 50);
        armDisarm.addActionListener(new armDisarmListener());
        armDisarm.setEnabled(false);

        makeKeypad();

        mainPanel.add(textDisplay);
        mainPanel.add(onOff);
        mainPanel.add(armDisarm);

        add(mainPanel);

        updateUI();
    }

    private void makeKeypad() { // Just trying to abstract and make cleaner code
        numDisplay = new JLabel("", SwingConstants.CENTER);
        numDisplay.setBounds(this.getWidth() - 16 - 150, this.getHeight() - 39 - 250, 100, 50);

        keyEnter = new JButton("Enter");
        keyEnter.setBounds(this.getWidth() - 16 - 75, this.getHeight() - 39 - 50, 75, 50);
        keyEnter.addActionListener(new keypadListener(10));

        keyDel = new JButton("<-");
        keyDel.setBounds(this.getWidth() - 16 - 50, this.getHeight() - 39 - 250, 50, 50);
        keyDel.addActionListener(new keypadListener(-1));

        key0 = new JButton("0");
        key0.setBounds(this.getWidth() - 16 - 150, this.getHeight() - 39 - 50, 75, 50);
        key0.addActionListener(new keypadListener(0));

        key1 = new JButton("1");
        key1.setBounds(this.getWidth() - 16 - 150, this.getHeight() - 39 - 100, 50, 50);
        key1.addActionListener(new keypadListener(1));

        key2 = new JButton("2");
        key2.setBounds(this.getWidth() - 16 - 100, this.getHeight() - 39 - 100, 50, 50);
        key2.addActionListener(new keypadListener(2));

        key3 = new JButton("3");
        key3.setBounds(this.getWidth() - 16 - 50, this.getHeight() - 39 - 100, 50, 50);
        key3.addActionListener(new keypadListener(3));

        key4 = new JButton("4");
        key4.setBounds(this.getWidth() - 16 - 150, this.getHeight() - 39 - 150, 50, 50);
        key4.addActionListener(new keypadListener(4));

        key5 = new JButton("5");
        key5.setBounds(this.getWidth() - 16 - 100, this.getHeight() - 39 - 150, 50, 50);
        key5.addActionListener(new keypadListener(5));

        key6 = new JButton("6");
        key6.setBounds(this.getWidth() - 16 - 50, this.getHeight() - 39 - 150, 50, 50);
        key6.addActionListener(new keypadListener(6));

        key7 = new JButton("7");
        key7.setBounds(this.getWidth() - 16 - 150, this.getHeight() - 39 - 200, 50, 50);
        key7.addActionListener(new keypadListener(7));

        key8 = new JButton("8");
        key8.setBounds(this.getWidth() - 16 - 100, this.getHeight() - 39 - 200, 50, 50);
        key8.addActionListener(new keypadListener(8));

        key9 = new JButton("9");
        key9.setBounds(this.getWidth() - 16 - 50, this.getHeight() - 39 - 200, 50, 50);
        key9.addActionListener(new keypadListener(9));

        keyTest = new JButton("Test");
        keyTest.setBounds(this.getWidth() - 100 - 150, this.getHeight() - 39 - 50, 75, 50);
        keyTest.addActionListener(new keypadListener(11));

        mainPanel.add(numDisplay);
        mainPanel.add(keyEnter);
        mainPanel.add(keyDel);
        mainPanel.add(key0);
        mainPanel.add(key1);
        mainPanel.add(key2);
        mainPanel.add(key3);
        mainPanel.add(key4);
        mainPanel.add(key5);
        mainPanel.add(key6);
        mainPanel.add(key7);
        mainPanel.add(key8);
        mainPanel.add(key9);
        mainPanel.add(keyTest);
    }

    private void enableKeypad(boolean b) {
        if (b) {
            keyEnter.setEnabled(true);
            keyDel.setEnabled(true);
            key0.setEnabled(true);
            key1.setEnabled(true);
            key2.setEnabled(true);
            key3.setEnabled(true);
            key4.setEnabled(true);
            key5.setEnabled(true);
            key6.setEnabled(true);
            key7.setEnabled(true);
            key8.setEnabled(true);
            key9.setEnabled(true);
        } else {
            keyEnter.setEnabled(false);
            keyDel.setEnabled(false);
            key0.setEnabled(false);
            key1.setEnabled(false);
            key2.setEnabled(false);
            key3.setEnabled(false);
            key4.setEnabled(false);
            key5.setEnabled(false);
            key6.setEnabled(false);
            key7.setEnabled(false);
            key8.setEnabled(false);
            key9.setEnabled(false);
        }
    }

    private void setFrameTitle(String s) {
        this.setTitle(s);
    }

    private void updateUI() { // Manage buttons based on state of system
        switch (currentState) {
            case OFF:
                textDisplay.setText("System is OFF");
                onOff.setText("On");
                onOff.setEnabled(true);
                armDisarm.setText("Arm System");
                armDisarm.setEnabled(false);
                enableKeypad(false);
                break;

            case DISARMED:
                textDisplay.setText("System is DISARMED. Enter passcode and press enter to set system to STANDBY");
                onOff.setText("Off");
                onOff.setEnabled(true);
                armDisarm.setText("Arm System");
                armDisarm.setEnabled(false);
                enableKeypad(true);
                break;

            case STANDBY:
                //textDisplay.setText("System is in STANDBY    ---    You have ___ before system disarms itself");
                textDisplay.setText("System is in STANDBY");
                onOff.setEnabled(true);
                armDisarm.setText("Arm System");
                armDisarm.setEnabled(true);
                enableKeypad(true);
                keyEnter.setEnabled(false);
                break;

            case ARMED:
                textDisplay.setText("System is ARMED. Enter passcode to DISARM");
                onOff.setEnabled(false);
                armDisarm.setText("Disarm System");
                armDisarm.setEnabled(false);
                enableKeypad(true);
                break;

            case TRIGGERED:
                textDisplay.setText("----- ALERT ----- Enter passcode to DISARM ----- ALERT -----");
                onOff.setEnabled(false);
                armDisarm.setEnabled(false);
                enableKeypad(true);
                break;

            case DURESS:
                System.out.println("Duress State Activated.");
                textDisplay.setText("System is DISARMED. Enter passcode and press enter to set system to STANDBY"); // Can't let intruder know it's in duress mode
                onOff.setEnabled(false);
                armDisarm.setEnabled(false);
                enableKeypad(true);
                break;
        }
    }

    public static void eventTriggered(Event e){ // This is called when an event takes place.
        if(currentState == systemState.ARMED || currentState == systemState.TRIGGERED) {
            currentState = systemState.TRIGGERED;
            createNotification(e);
        }
    }

    public static void testTriggers(ExampleSystem mySystem)
    {
        for(Sensor s : mySystem.mySensors)
        {
            TriggerSimulator ts = new TriggerSimulator(s, true);
        }
    }

    private static void createNotification(Event e) {
        Sensor sen = e.getMySensor();
        switch (sen.getSensorTypes().getSensorType()) {
            case 1 -> {
                JOptionPane.showMessageDialog(null, "Sensor " + sen.getId() + " activated at " + e.getMyDateTime()
                        + ".\nMotion detected.");
            }
            case 2 -> {
                JOptionPane.showMessageDialog(null, "Sensor " + sen.getId() + " activated at " + e.getMyDateTime()
                        + ".\nUnacceptable temperature detected.");
            }
            case 3 -> {
                JOptionPane.showMessageDialog(null, "Sensor " + sen.getId() + " activated at " + e.getMyDateTime()
                        + ".\nWater detected.");
            }
            case 4 -> {
                JOptionPane.showMessageDialog(null, "Sensor " + sen.getId() + " activated at " + e.getMyDateTime()
                        + ".\nSmoke detected.");
            }

        }
    }

    private class onOffListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            switch (currentState) {
                case OFF -> {
                    currentState = systemState.DISARMED;
                    setFrameTitle("Safeasy Control Panel - DISARMED");
                    updateUI();
                }
                case DISARMED, STANDBY -> {
                    currentState = systemState.OFF;
                    setFrameTitle("Safeasy Control Panel - OFF");
                    updateUI();
                }
                default ->
                        System.out.println("System must be disarmed or in standby to turn off.");
            }
        }
    }

    private class armDisarmListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            switch (currentState) {
                case DISARMED:
                    currentState = systemState.STANDBY;
                    setFrameTitle("Safeasy Control Panel - STANDBY");
                    updateUI();
                    break;

                case STANDBY:
                    currentState = systemState.ARMED;
                    setFrameTitle("Safeasy Control Panel - ARMED");
                    updateUI();
                    SignalingInterface.armSystem();
                    break;

                default: // If system is armed, triggered, or in duress
                    currentState = systemState.DISARMED;
                    setFrameTitle("Safeasy Control Panel - DISARMED");
                    updateUI();
                    break;
            }
        }
    }



    private class keypadListener implements ActionListener {
        private final int num;

        public keypadListener(int buttonNum) {
            num = buttonNum;
        }

        public void actionPerformed(ActionEvent ae) {
            String s = numDisplay.getText();

            if(s.length() >= 8 && num != -1 && num != 10) {
                return;
            }

            switch (num) {
                case 10: // Enter
                    // Based on state and which PIN is entered
                    if(currentState == systemState.DISARMED) {
                        if (numDisplay.getText().equals(passcode)) { // Require passcode. If passcode is right,
                            currentState = systemState.STANDBY;
                            setFrameTitle("Safeasy Control Panel - STANDBY");
                            updateUI();
                            numDisplay.setText("");
                            break;
                        }
                    } else if(currentState == systemState.ARMED || currentState == systemState.TRIGGERED || currentState == systemState.DURESS) {
                        if (numDisplay.getText().equals(passcode)) { // Require passcode. If passcode is right,
                            currentState = systemState.DISARMED;
                            setFrameTitle("Safeasy Control Panel - DISARMED");
                            updateUI();
                            numDisplay.setText("");
                            break;
                        }
                    }

                    if(numDisplay.getText().equals(duressCode)) {
                        currentState = systemState.DURESS;
                        SignalingInterface.callAuthorities(null);
                        setFrameTitle("Safeasy Control Panel - DISARMED");
                        updateUI();
                    } else {
                        textDisplay.setText("Incorrect passcode");
                    }
                    numDisplay.setText("");
                    break;

                case -1: // Del
                    if(s.length() == 0) {
                        return;
                    }
                    numDisplay.setText(s.substring(0, s.length() - 1));
                    break;

                case 0:
                    numDisplay.setText(s + "0");
                    break;

                case 1:
                    numDisplay.setText(s + "1");
                    break;

                case 2:
                    numDisplay.setText(s + "2");
                    break;

                case 3:
                    numDisplay.setText(s + "3");
                    break;

                case 4:
                    numDisplay.setText(s + "4");
                    break;

                case 5:
                    numDisplay.setText(s + "5");
                    break;

                case 6:
                    numDisplay.setText(s + "6");
                    break;

                case 7:
                    numDisplay.setText(s + "7");
                    break;

                case 8:
                    numDisplay.setText(s + "8");
                    break;

                case 9:
                    numDisplay.setText(s + "9");
                    break;
                case 11:
                    testTriggers(Main.mySystem);
                    break;
            }
        }
    }

}

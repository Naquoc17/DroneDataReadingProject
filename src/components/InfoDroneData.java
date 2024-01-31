package components;

import javax.swing.*;
import java.awt.*;

public class InfoDroneData extends JFrame {
    public InfoDroneData(Object[] droneData) {
        setTitle("Drone Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 980, 520);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(1, 3));
        setVisible(true);

        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.setBorder(BorderFactory.createEmptyBorder(70, 10, 2, 0));
        add(panelLeft);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        add(panelRight);
//fill the left Panel
        // Create labels to display drone data
        JLabel idLabel = new JLabel("ID: " + droneData[0]);
        JLabel typeLabel = new JLabel("Drone Type: " + droneData[1]);
        JLabel createdLabel = new JLabel("Created Date: " + droneData[2]);
        JLabel serialLabel = new JLabel("Serial Number: " + droneData[3]);
        JLabel weightLabel = new JLabel("Carriage Weight: " + droneData[4]);
        JLabel typeCarriageLabel = new JLabel("Carriage Type: " + droneData[5]);
        // Add labels to panel
        panelLeft.add(idLabel);
        panelLeft.add(typeLabel);
        panelLeft.add(createdLabel);
        panelLeft.add(serialLabel);
        panelLeft.add(weightLabel);
        panelLeft.add(typeCarriageLabel);
        //fill the right Panel
        //TODO ADD 3d model
        JLabel historyLabel = new JLabel("The right panelDONT FORGET DELETE THIS LABEL");
        panelRight.add(historyLabel);
    }
}
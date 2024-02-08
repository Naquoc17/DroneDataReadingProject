package components.table.overview;

import javax.swing.*;
import java.awt.*;

public class InfoDroneDynamics extends JFrame {
        public InfoDroneDynamics(Object[] droneDynamics) {
            setTitle("Drone Information");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(100, 100, 800, 600);
            setLocationRelativeTo(null);
            setResizable(false);
            setLayout(new GridLayout(3, 1));
            setVisible(true);

            JPanel panelTop = new JPanel();
            panelTop.setLayout(new BorderLayout());
            panelTop.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            panelTop.setLayout(new GridLayout(0, 2));
            add(panelTop, BorderLayout.NORTH);

            JPanel imagePanelTop = new JPanel();
            //TODO add image
            panelTop.add(imagePanelTop, BorderLayout.WEST);
            //panel for top labels
            JPanel labelPanelTop = new JPanel();
            labelPanelTop.setLayout(new BoxLayout(labelPanelTop, BoxLayout.Y_AXIS));
            labelPanelTop.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
            panelTop.add(labelPanelTop, BorderLayout.EAST);

            JPanel panelMiddle = new JPanel();
            panelMiddle.setLayout(new BorderLayout());
            panelMiddle.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            panelMiddle.setLayout(new GridLayout(0, 2));
            add(panelMiddle, BorderLayout.CENTER);

            JPanel imagePanelMiddle = new JPanel();
            //TODO add image
            panelMiddle.add(imagePanelMiddle, BorderLayout.WEST);
            //panel for middle labels
            JPanel labelPanelMiddle = new JPanel();
            labelPanelMiddle.setLayout(new BoxLayout(labelPanelMiddle, BoxLayout.Y_AXIS));
            labelPanelMiddle.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
            panelMiddle.add(labelPanelMiddle, BorderLayout.EAST);

            JPanel panelBottom = new JPanel();
            panelBottom.setLayout(new BorderLayout());
            panelBottom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            panelBottom.setLayout(new GridLayout(0, 2)); //two panel parts
            add(panelBottom, BorderLayout.SOUTH);

            JPanel imagePanelBottom = new JPanel();
            //TODO add image
            panelBottom.add(imagePanelBottom, BorderLayout.WEST);
            //panel for middle labels
            JPanel labelPanelBottom = new JPanel();
            labelPanelBottom.setLayout(new BoxLayout(labelPanelBottom, BoxLayout.Y_AXIS));
            labelPanelBottom.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
            panelBottom.add(labelPanelBottom, BorderLayout.EAST);

            // Create labels to display drone data
            JLabel idLabel = new JLabel("ID " + droneDynamics[0]);
            JLabel timestampLabel = new JLabel("Timestamp: " + droneDynamics[1]);
            JLabel droneLabel = new JLabel("Drone" + droneDynamics[2]);
            JLabel speedLabel = new JLabel("Speed: " + droneDynamics[3]);
            JLabel alignmentRollLabel = new JLabel("Alignment Roll: " + droneDynamics[4]);
            JLabel controlRangeLabel = new JLabel("Control Range: " + droneDynamics[5]);
            JLabel alignmentYawLabel = new JLabel("Alignment Yaw: " + droneDynamics[6]);
            JLabel longitudeLabel = new JLabel("Longitude: " + droneDynamics[7]);
            JLabel latitudeLabel = new JLabel("Latitude: " + droneDynamics[8]);
            JLabel batteryStatusLabel = new JLabel("Battery Status: " + droneDynamics[9]);
            JLabel lastSeenLabel = new JLabel("Last Seen: " + droneDynamics[10]);
            JLabel statusLabel = new JLabel("Status: " + droneDynamics[11]);
//fill labels
            labelPanelMiddle.add(idLabel);
            labelPanelMiddle.add(timestampLabel);
            labelPanelMiddle.add(droneLabel);
            labelPanelMiddle.add(speedLabel);
            labelPanelMiddle.add(alignmentRollLabel);
            labelPanelMiddle.add(controlRangeLabel);
            labelPanelMiddle.add(alignmentYawLabel);
            labelPanelMiddle.add(longitudeLabel);
            labelPanelMiddle.add(latitudeLabel);
            labelPanelTop.add(batteryStatusLabel);
            labelPanelBottom.add(lastSeenLabel);
            labelPanelBottom.add(statusLabel);

        }
}

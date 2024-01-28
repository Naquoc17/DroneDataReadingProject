package components;
import dataFunction.DroneData;
import dataFunction.DroneDynamics;
import dataFunction.ParserJson;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class DroneDynamicsView extends JPanel {

    private JTable table;

    public DroneDynamicsView(String jsonDroneDynamics) {
        setBackground(new Color(254, 255, 255));
        setLayout(null);

        String[] columns = {"ID", "Timestamp", "Drone", "Speed", "Alignm. Roll", "Control Range", "Alignm. Yaw", "Longitude", "Latitude", "Battery Status", "Last Seen", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        // =================== Push Data ======================= //
//        Object[][] data = {
//                {"test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test"},
//        }; //TODO data y

        List<DroneDynamics> droneDynamicsList = ParserJson.parseJsonToDroneDynamics(jsonDroneDynamics);
        for (DroneDynamics drone : droneDynamicsList){
            Object[] row = new Object[]{
                    drone.getTimestamp(),
                    drone.getDrone(),
                    drone.getSpeed(),
                    drone.getAlignmentRoll(),
                    drone.getControlRange(),
                    drone.getAlignmentYaw(),
                    drone.getLongitude(),
                    drone.getLatitude(),
                    drone.getBatteryStatus(),
                    drone.getLastSeen(),
                    drone.getStatus()
            };
            tableModel.addRow(row);
        }

        table = new JTable(tableModel);
        table.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        table.setBackground(new Color(255, 255, 255));
        table.setRowSelectionAllowed(true);
        table.setBounds(187, 0, 1086, 639);
        add(table);

        // Customizing column header appearance
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.LIGHT_GRAY); // Header background color
        tableHeader.setForeground(new Color(58, 140, 37)); // Header foreground (text) color
        tableHeader.setFont(new Font("Arial", Font.BOLD, 12)); // Header font

        JScrollPane scrollPane = new JScrollPane(table); // Place the table in a JScrollPane
        scrollPane.setBounds(187, 0, 1086, 639); // Set bounds for the scroll pane (optional)
        add(scrollPane); // Add the scroll pane to the container

    }
}

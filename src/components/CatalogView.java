package components;

import dataFunction.DroneData;
import dataFunction.ParserJson;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class CatalogView extends JPanel {

    private JTable table;
    /**
     * Create the panel.
     */
    public CatalogView(String jsonDroneData) {

        setBackground(new Color(244, 244, 244));
        setLayout(null);

        String[] columns = {"ID", "DroneType", "Created", "Serialnumber", "Carriage Weight", "Carriage Type"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
;
        // ======== Push data =========== //
//        Object[][] data = {
//                {"testID", "testDroneType", "12/31/2022", 2347652, 43.8, "testType"},
//                {"testID", "testDroneType", "12/31/2022", 2347652, 43.8, "testType"},
//                {"testID", "testDroneType", "12/31/2022", 2347652, 43.8, "testType"}
//        }; //TODO data hinzufuegen
        List<DroneData> droneDataList = ParserJson.parseJsonToDroneData(jsonDroneData);
        for (DroneData drone : droneDataList){
            Object[] row = new Object[]{
                    drone.getId(),
                    drone.getDronetype(),
                    drone.getCreated(),
                    drone.getSerialnumber(),
                    drone.getCarriage_weight(),
                    drone.getCarriage_type()
            };
            tableModel.addRow(row);
        }


//        table = new JTable(data, columns);
        table = new JTable(tableModel);
        table.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        table.setBackground(new Color(255, 255, 255));
        table.setRowSelectionAllowed(true);
        table.setBounds(187, 0, 1086, 639);
        add(table);

        // Customizing column header appearance
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.LIGHT_GRAY); // Header background color
        tableHeader.setForeground(new Color(58, 140, 37)); // Header foreground (text) color
        tableHeader.setFont(new Font("Arial", Font.BOLD, 18)); // Header font

        JScrollPane scrollPane = new JScrollPane(table); // Place the table in a JScrollPane
        scrollPane.setBounds(187, 0, 1086, 639); // Set bounds for the scroll pane (optional)
        add(scrollPane); // Add the scroll pane to the container
    }
}

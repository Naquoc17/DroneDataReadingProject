package components.table.overview;

import dataFunction.DroneTypes;
import dataFunction.ParserJson;

import javax.swing.table.DefaultTableModel;

import java.util.List;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

//public class DroneTypesView extends JPanel {
//    private JTable table;
//    private DefaultTableModel tableModel;
//    private String[] columns = {"ID", "Manufacturer", "Typename", "Weight", "Maximum Speed", "Battery Capacity", "Control Range", "Maximum Carriage"};
//
//    public DroneTypesView(String jsonDroneTypes) {
//        tableModel = new DefaultTableModel(columns, 0);
//        // =================== Push Data ========================== //
//        loadDataToTable(jsonDroneTypes);
//        initTable();
//    }
//
//    private void initTable(){
//        setBackground(Color.WHITE);
//        setLayout(null);
//        table = new JTable(tableModel);
//        table.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
//        table.setBackground(Color.WHITE);
//        table.setRowSelectionAllowed(true);
//        table.setLocation(187, 0);
//        table.setBounds(187, 0, 1086, 639);
//
//        // Customizing column header appearance
//        JTableHeader tableHeader = table.getTableHeader();
//        tableHeader.setBackground(Color.LIGHT_GRAY); // Header background color
//        tableHeader.setForeground(new Color(58, 140, 37)); // Header foreground (text) color
//        tableHeader.setFont(new Font("Arial", Font.BOLD, 12)); // Header font
//        add(table);
//
//        JScrollPane scrollPane = new JScrollPane(table); // Place the table in a JScrollPane
//        scrollPane.setBounds(187, 0, 1086, 639); // Set bounds for the scroll pane (optional)
//        scrollPane.setMaximumSize(new Dimension(5000, 2000));
//        add(scrollPane); // Add the scroll pane to the container
//    }
//
//    private void loadDataToTable(String jsonDroneTypes){
//        List<DroneTypes> droneTypesList = ParserJson.parseJsonToDroneTypes(jsonDroneTypes);
//
//        // Clear old data
//        tableModel.setRowCount(0);
//
//        for (DroneTypes drone : droneTypesList){
//            Object[] row = new Object[]{
//                    drone.getId(),
//                    drone.getManufacturer(),
//                    drone.getTypename(),
//                    drone.getWeight(),
//                    drone.getMax_speed(),
//                    drone.getBattery_capacity(),
//                    drone.getControl_range(),
//                    drone.getMax_carriage()
//            };
//            tableModel.addRow(row);
//        }
//
//        // Notify about data change
//        tableModel.fireTableDataChanged();
//    }
//
//
//    public void updateView(String jsonDroneTypes){
//        loadDataToTable(jsonDroneTypes);
//    }
//}

public class DroneTypesView extends AbstractTableView {
    public DroneTypesView(String jsonDroneTypes){
        super(jsonDroneTypes);
    }

    @Override
    protected void loadDataToTable(String jsonDroneTypes) {
        List<DroneTypes> droneTypesList = ParserJson.parseJsonToDroneTypes(jsonDroneTypes);

        // Clear old data
        tableModel.setRowCount(0);

        for (DroneTypes drone : droneTypesList){
            Object[] row = new Object[]{
                    drone.getId(),
                    drone.getManufacturer(),
                    drone.getTypename(),
                    drone.getWeight(),
                    drone.getMax_speed(),
                    drone.getBattery_capacity(),
                    drone.getControl_range(),
                    drone.getMax_carriage()
            };
            tableModel.addRow(row);
        }
        // Notify about data change
        tableModel.fireTableDataChanged();
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"ID", "Manufacturer", "Typename", "Weight",
                "Maximum Speed", "Battery Capacity", "Control Range", "Maximum Carriage"};
    }
}
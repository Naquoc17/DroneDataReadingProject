package components;

import dataFunction.DroneTypes;
import dataFunction.ParserJson;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class DroneTypesView extends JPanel {
    private JTable table;

    public DroneTypesView(String jsonDroneTypes) {
        setBackground(Color.WHITE);
        setLayout(null);

        String[] columns = {"ID", "Manufacturer", "Typename", "Weight", "Maximum Speed", "Battery Capacity", "Control Range", "Maximum Carriage"};
        Object[][] data = {
                {"test1", "test1", "test1", "test1", "test1", "test1", "test1", "test1"},
                {"test2", "test2", "test2", "test2", "test2", "test2", "test2", "test2"},
        }; //TODO data hinzufuegen

        // =================== Push Data ========================== //
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        List<DroneTypes> droneTypesList = ParserJson.parseJsonToDroneTypes(jsonDroneTypes);
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

        table = new JTable(tableModel);
        table.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        table.setBackground(Color.WHITE);
        table.setRowSelectionAllowed(true);
        table.setLocation(187, 0);
        table.setBounds(187, 0, 1086, 639);
        add(table);
//click event
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && SwingUtilities.isLeftMouseButton(e)) { // click
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //Getting data from the selected cell
                    Object value = target.getValueAt(row, column);
                    //Open a new window with information about the selected object
                    new InfoWindow();
                }
            }
        });
        // Customizing column header appearance
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.LIGHT_GRAY); // Header background color
        tableHeader.setForeground(new Color(58, 140, 37)); // Header foreground (text) color
        tableHeader.setFont(new Font("Arial", Font.BOLD, 12)); // Header font

        JScrollPane scrollPane = new JScrollPane(table); // Place the table in a JScrollPane
        scrollPane.setBounds(187, 0, 1086, 639); // Set bounds for the scroll pane (optional)
        scrollPane.setMaximumSize(new Dimension(5000, 2000));
        add(scrollPane); // Add the scroll pane to the container

    }
}

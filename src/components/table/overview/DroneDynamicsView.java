package components.table.overview;
import dataFunction.DroneDynamics;
import dataFunction.ParserJson;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;


public class DroneDynamicsView extends AbstractTableView{
    public DroneDynamicsView(String jsonDroneDynamics) {
        super(jsonDroneDynamics);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && SwingUtilities.isLeftMouseButton(e)) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    // Getting data from the selected row
                    Object[] rowData = new Object[table.getColumnCount()];
                    for (int i = 0; i < rowData.length; i++) {
                        rowData[i] = target.getValueAt(row, i);
                    }
                    // Open a new window with information about the selected drone
                    new InfoDroneDynamics(rowData);
                }
            }
        });
    }

    @Override
    protected void loadDataToTable(String jsonDroneDynamics) {
        int n = 86831;
        List<DroneDynamics> droneDynamicsList = ParserJson.parseJsonToDroneDynamics(jsonDroneDynamics);

        tableModel.setRowCount(0);

        for (DroneDynamics drone : droneDynamicsList){
            Object[] row = new Object[]{
                    n++,
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

        tableModel.fireTableDataChanged();
    }

    @Override
    protected String[] getColumnNames() {
        return new String[] {"ID", "Timestamp", "Drone", "Speed", "Alignm. Roll",
                "Control Range", "Alignm. Yaw", "Longitude", "Latitude", "Battery Status",
                "Last Seen", "Status"};
    }
}

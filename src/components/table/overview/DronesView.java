package components.table.overview;

import components.table.details.DroneDetailsView;
import dataFunction.DroneData;
import dataFunction.ParserJson;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DronesView extends AbstractTableView {
    public DronesView(String jsonDroneData){
        super(jsonDroneData);

        //click event
//        table.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                if (e.getClickCount() == 1 && SwingUtilities.isLeftMouseButton(e)) { // click
//                    JTable target = (JTable)e.getSource();
//                    int row = target.getSelectedRow();
//                    int column = target.getSelectedColumn();
//                    //Getting data from the selected cell
//                    Object[] rowData = new Object[table.getColumnCount()];
//                    for (int i = 0; i < rowData.length; i++) {
//                        rowData[i] = target.getValueAt(row, i);
//                    }
//                    //Open a new window with information about the selected object
//                    new InfoDroneData(rowData);
//                }
//            }
//        });

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String getSerial;
                if (e.getClickCount() == 1 && SwingUtilities.isLeftMouseButton(e)) { // click
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    //Getting data from the selected cell
                    Object rowData = target.getValueAt(row, 3);
                    System.out.println(rowData);
                    getSerial = rowData.toString();
                } else {
                    getSerial = "abcdmnpq";
                }
                System.out.println(getSerial);
                new DroneDetailsView(getSerial);
            }
        });
    }

    @Override
    protected void loadDataToTable(String jsonDroneData) {
        List<DroneData> droneDataList = ParserJson.parseJsonToDroneData(jsonDroneData);

        tableModel.setRowCount(0);

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

        tableModel.fireTableDataChanged();
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"ID", "DroneType", "Created",
                "Serialnumber", "Carriage Weight", "Carriage Type"};
    }
}


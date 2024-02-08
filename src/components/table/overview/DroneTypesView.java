package components.table.overview;

import dataFunction.DroneTypes;
import dataFunction.ParserJson;
import java.util.List;


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
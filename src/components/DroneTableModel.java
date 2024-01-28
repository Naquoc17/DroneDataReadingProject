//package components;
//
//import DataFunction.DroneData;
//
//import javax.swing.table.AbstractTableModel;
//import java.util.List;
//
//public class DroneTableModel extends AbstractTableModel {
//    private final List<DroneData> droneDataList;
//    private final String[] columnNames = {"ID", "Drone Type URL", "Created", "Serial Number", "Carriage Weight", "Carriage Type"};
//
//    public DroneTableModel(List<DroneData> drones){
//        this.droneDataList = drones;
//    }
//
//    @Override
//    public int getRowCount(){
//        return droneDataList.size();
//    }
//
//    @Override
//    public int getColumnCount(){
//        return columnNames.length;
//    }
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex){
//        DroneData drone = droneDataList.get(rowIndex);
//        switch (columnIndex){
//            case 0: return drone.getId();
//            case 1: return drone.getDronetype();
//            case 2: return drone.getCreated();
//            case 3: return drone.getSerialnumber();
//            case 4: return drone.getCarriage_weight();
//            case 5: return drone.getCarriage_type();
//            default: return null;
//        }
//    }
//
//    @Override
//    public String getColumnName(int column){
//        return columnNames[column];
//    }
//
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        return false;
//    }
//
//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        return getValueAt(0, columnIndex).getClass();
//    }
//}

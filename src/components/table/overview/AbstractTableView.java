package components.table.overview;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public abstract class AbstractTableView extends JPanel {
    protected JTable table;
    protected DefaultTableModel tableModel;
    public AbstractTableView(String jsonData){
        tableModel = new DefaultTableModel(getColumnNames(), 0);
        loadDataToTable(jsonData);
        initTable();
    }
    protected abstract String[] getColumnNames();

    protected void initTable(){
        setBackground(Color.WHITE);
        setLayout(null);
        table = new JTable(tableModel);
        table.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        table.setBackground(Color.WHITE);
        table.setRowSelectionAllowed(true);
        table.setLocation(187, 0);
        table.setBounds(187, 0, 1086, 639);

        // Customizing column header appearance
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.LIGHT_GRAY); // Header background color
        tableHeader.setForeground(new Color(58, 140, 37)); // Header foreground (text) color
        tableHeader.setFont(new Font("Arial", Font.BOLD, 12)); // Header font
        add(table);

        JScrollPane scrollPane = new JScrollPane(table); // Place the table in a JScrollPane
        scrollPane.setBounds(187, 0, 1086, 639); // Set bounds for the scroll pane (optional)
        scrollPane.setMaximumSize(new Dimension(5000, 2000));
        add(scrollPane); // Add the scroll pane to the container
    }

    protected abstract void loadDataToTable(String jsonData);

    public void updateView(String jsonData){
        loadDataToTable(jsonData);
    }
}

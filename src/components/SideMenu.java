package components;

import app.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SideMenu extends JPanel {
    private JButton menuItem_1;
    private JButton menuItem_2;
    private JButton menuItem_3;
    private JButton menuItem_4;
    private JLabel jLFeatures;
    private MainWindow mainWindow;

    public SideMenu(MainWindow mainWindow) {

        this.mainWindow = mainWindow;
        //create side panel
        setBackground(Color.gray);
        setBounds(0, 0, 187, 1100);
        setLayout(null);
        //create label Features
        jLFeatures = new JLabel("Features");
        jLFeatures.setFont(new Font("Malayalam MN", Font.PLAIN, 12));
        jLFeatures.setBounds(33, 77, 59, 16);
        add(jLFeatures);
        //create start button
        menuItem_1 = new JButton("Start");
        menuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                mainWindow.changeContentPane(0); //0 start -> main pane
            }
        });
        ImageIcon JHome = new ImageIcon(SideMenu.class.getResource("/icons/Graphicloads-Colorful-Long-Shadow-Home.32.png"));
        menuItem_1.setIcon(JHome);
        menuItem_1.setHorizontalAlignment(SwingConstants.LEADING);
        menuItem_1.setForeground(Color.BLACK);
        menuItem_1.setBackground(new Color(61, 61, 61));
        menuItem_1.setBounds(0, 20, 187, 45);
        add(menuItem_1);

        //create drones button
        menuItem_2 = new JButton("Drones");
        menuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                mainWindow.changeContentPane(2); //2  drones -> CatalogView Panel
            }
        });
        ImageIcon JIconDrone = new ImageIcon(SideMenu.class.getResource("/icons/Iconoir-Team-Iconoir-Drone.32.png"));
        menuItem_2.setIcon(JIconDrone);
        menuItem_2.setHorizontalAlignment(SwingConstants.LEADING);
        menuItem_2.setHorizontalAlignment(SwingConstants.LEADING);
        menuItem_2.setForeground(Color.BLACK);
        menuItem_2.setBackground(new Color(61, 61, 61));
        menuItem_2.setBounds(0, 104, 187, 45);
        add(menuItem_2);

        //create droneDynamics button
        menuItem_3 = new JButton("DroneDynamics");
        menuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                mainWindow.changeContentPane(3); // 3 -> DroneDynamics panel
            }
        });
        menuItem_3.setIcon(new ImageIcon(SideMenu.class.getResource("/icons/Rokey-The-Last-Order-Control-panel.32.png")));
        menuItem_3.setHorizontalAlignment(SwingConstants.LEADING);
        menuItem_3.setForeground(Color.BLACK);
        menuItem_3.setBackground(new Color(61, 61, 61));
        menuItem_3.setBounds(0, 147, 187, 45);
        add(menuItem_3);

        menuItem_4 = new JButton("DroneTypes");
        menuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                mainWindow.changeContentPane(4); //4 drone types -> DroneTypes Panel
            }
        });
        ImageIcon JIconDroneType = new ImageIcon(SideMenu.class.getResource("/icons/Wilnichols-Alumin-Folders-IOS-Icons-Black-Folder.32.png"));
        menuItem_4.setIcon(JIconDroneType);
        menuItem_4.setHorizontalAlignment(SwingConstants.LEADING);
        menuItem_4.setHorizontalAlignment(SwingConstants.LEADING);
        menuItem_4.setForeground(Color.BLACK);
        menuItem_4.setBackground(new Color(61, 61, 61));
        menuItem_4.setBounds(0, 187, 187, 45);
        add(menuItem_4);

    }
}

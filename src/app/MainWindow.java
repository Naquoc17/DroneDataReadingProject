package app;

import javax.swing.*;
import javax.swing.text.View;

import components.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static JPanel mainPane;
    private static JPanel contentPane;
    private static JPanel catalogView;
    private static TopMenu topMenu;
    private static JPanel droneDynamicsView;

    private static DroneTypesView droneTypesView;

    public MainWindow(String jsonDroneData, String jsonDroneDynamics, String jsonDroneTypes)
    {
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setMinimumSize(new Dimension(0, 0));
        contentPane.setMaximumSize(new Dimension(5000, 2000));
        setContentPane(contentPane);                //add a panel to the main frame

        mainPane = new JPanel();
        mainPane.setBackground(Color.WHITE);
        mainPane.setLayout(null);
        mainPane.setMinimumSize(new Dimension(0, 0));
        mainPane.setMaximumSize(new Dimension(5000, 2000));

        JLabel JDroneLabel = new JLabel("");
        ImageIcon droneIcon = new ImageIcon(MainWindow.class.getResource("/icons/drone.png"));
        JDroneLabel.setIcon(droneIcon);
        JDroneLabel.setBounds(400, 78, 439, 250);
        mainPane.add(JDroneLabel);

        JLabel JLabel_Group = new JLabel("GROUP 5");
        JLabel_Group.setFont(new Font("Malayalam MN", Font.PLAIN, 20));
        JLabel_Group.setBounds(950, 78, 261, 30);
        mainPane.add(JLabel_Group);

        JLabel JLabel_Autors = new JLabel("Created by:");
        JLabel_Autors.setFont(new Font("Malayalam MN", Font.PLAIN, 15));
        JLabel_Autors.setBounds(950, 110, 261, 30);
        mainPane.add(JLabel_Autors);
        JLabel JLabel_Autors1 = new JLabel("Tuan Dung Pham");
        JLabel_Autors1.setFont(new Font("Malayalam MN", Font.PLAIN, 12));
        JLabel_Autors1.setBounds(950, 125, 261, 30);
        mainPane.add(JLabel_Autors1);
        JLabel JLabel_Autors2 = new JLabel("Zaynab Elyan");
        JLabel_Autors2.setFont(new Font("Malayalam MN", Font.PLAIN, 12));
        JLabel_Autors2.setBounds(950, 140, 261, 30);
        mainPane.add(JLabel_Autors2);
        JLabel JLabel_Autors3 = new JLabel("Anh Quoc Nguyen");
        JLabel_Autors3.setFont(new Font("Malayalam MN", Font.PLAIN, 12));
        JLabel_Autors3.setBounds(950, 155, 261, 30);
        mainPane.add(JLabel_Autors3);
        JLabel JLabel_Autors4 = new JLabel("Iryna Vynarchuk");
        JLabel_Autors4.setFont(new Font("Malayalam MN", Font.PLAIN, 12));
        JLabel_Autors4.setBounds(950, 170, 261, 30);
        mainPane.add(JLabel_Autors4);
        JLabel JLabel_Autors5 = new JLabel("Sina (Theo) Adam");
        JLabel_Autors5.setFont(new Font("Malayalam MN", Font.PLAIN, 12));
        JLabel_Autors5.setBounds(950, 185, 261, 30);
        mainPane.add(JLabel_Autors5);

        catalogView = new CatalogView(jsonDroneData);
        droneDynamicsView = new DroneDynamicsView(jsonDroneDynamics);
        droneTypesView = new DroneTypesView(jsonDroneTypes);

        topMenu = new TopMenu(this);
        topMenu.setAlignmentY(Component.TOP_ALIGNMENT);
        topMenu.setMaximumSize(new Dimension(5000, 50));
        topMenu.setMinimumSize(new Dimension(0, 0));
        topMenu.setPreferredSize(new Dimension(4000, 50));

        //the order of addition in BoxLayout
        contentPane.add(topMenu);
        contentPane.add(mainPane);
    }

//    public void loadData(){
//        TestJson droneData = new TestJson();
//        String jsonDroneData = droneData.fetchJsonData("ENDPOINT_DRONES");
//        String jsonDroneDynamics = droneData.fetchJsonData("ENDPOINT_DRONEDYNAMICS");
//        String jsonDroneTypes = droneData.fetchJsonData("ENDPOINT_DRONETYPES");
//        System.out.println("Reloaded DroneAPI: " + jsonDroneData);
//        System.out.println("Reloaded DroneDynamics: " + jsonDroneDynamics);
//        System.out.println("Reloaded DroneDynamics: " + jsonDroneTypes);
//    }

    // ======== Test Loading Button ============ //
    public void loadData(){
        TestJson droneData = new TestJson();
        String jsonDroneData = droneData.fetchJsonData("NEXT_PAGE_DRONES");
        String jsonDroneDynamics = droneData.fetchJsonData("NEXT_PAGE_DRONEDYNAMICS");
        String jsonDroneTypes = droneData.fetchJsonData("NEXT_PAGE_DRONETYPES");
        System.out.println("Reloaded DroneAPI: " + jsonDroneData);
        System.out.println("Reloaded DroneDynamics: " + jsonDroneDynamics);
        System.out.println("Reloaded DroneDynamics: " + jsonDroneTypes);

//        catalogView.updateView(jsonDroneData);
//        droneDynamics.updateView(jsonDroneDynamics);
        droneTypesView.updateView(jsonDroneTypes);

        contentPane.revalidate();
        contentPane.repaint();
    }


    public JPanel getCurrentPane() {return (JPanel) contentPane.getComponent(1);} //get the current content panel, (main panel)
    public void changeContentPane(int panelNr) {
        contentPane.remove(1);
        switch(panelNr) {
            case 0:
                contentPane.add(mainPane);
                break;

            case 2:
                contentPane.add(catalogView);
                break;

            case 3:
                contentPane.add(droneDynamicsView);
                break;

            case 4:
                contentPane.add(droneTypesView);
                break;

            default:
                break;
        }

        topMenu.setNewPanel(contentPane);
        setContentPane(contentPane);
        contentPane.revalidate();
        contentPane.repaint();

        //test System.out.println("change window");
    }

    public static void main(String[] args){
        TestJson droneData = new TestJson();
        String jsonDroneData = droneData.fetchJsonData("ENDPOINT_DRONES");
        String jsonDroneDynamics = droneData.fetchJsonData("ENDPOINT_DRONEDYNAMICS");
        String jsonDroneTypes = droneData.fetchJsonData("ENDPOINT_DRONETYPES");
        System.out.println("Check DroneAPI: " + jsonDroneData);
        System.out.println("Check DroneDynamics: " + jsonDroneDynamics);
        System.out.println("Check DroneDynamics: " + jsonDroneTypes);

        MainWindow frame = new MainWindow(jsonDroneData, jsonDroneDynamics, jsonDroneTypes);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Java Application with Drone Simulation Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 1380, 820);
    }

}
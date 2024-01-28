package app;

import javax.swing.*;

import components.*;

import java.awt.*;


public class MainWindow extends JFrame
{

    private static JPanel mainPane;
    private static JPanel contentPane;
    private static JPanel catalogView;
    private static TopMenu topMenu;
    private static JPanel droneDynamics;

    public MainWindow(String jsonDroneData, String jsonDroneDynamics)
    {
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        setContentPane(contentPane);                //add a panel to the main frame

        mainPane = new JPanel();
        mainPane.setBackground(new Color(244, 244, 244));
        mainPane.setLayout(null);


        JLabel JDroneLabel = new JLabel("");
        ImageIcon droneIcon = new ImageIcon(MainWindow.class.getResource("/icons/drone.png"));
        JDroneLabel.setIcon(droneIcon);
        JDroneLabel.setBounds(424, 78, 439, 250);
        mainPane.add(JDroneLabel);

        JLabel JLabel_Welcomme = new JLabel("Welcome to the JAVA Project");
        JLabel_Welcomme.setFont(new Font("Malayalam MN", Font.PLAIN, 20));
        JLabel_Welcomme.setBounds(527, 368, 261, 30);
        mainPane.add(JLabel_Welcomme);

        catalogView = new CatalogView(jsonDroneData);
        droneDynamics = new DroneDynamicsView(jsonDroneDynamics);

        topMenu = new TopMenu(this);
        topMenu.setAlignmentY(Component.TOP_ALIGNMENT);
        topMenu.setMaximumSize(new Dimension(3000, 50));
        topMenu.setMinimumSize(new Dimension(0, 0));
        topMenu.setPreferredSize(new Dimension(2000, 50));

        //the order of addition in BoxLayout
        contentPane.add(topMenu);
        contentPane.add(mainPane);
    }
    public JPanel getCurrentPane() {
        return (JPanel) contentPane.getComponent(1);
    }
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
                contentPane.add(droneDynamics);
                break;

            default:
                break;
        }

        topMenu.setNewPanel(contentPane);
        setContentPane(contentPane);
        contentPane.revalidate();
        contentPane.repaint();

        //System.out.println("change window");
    }



    public static void main(String[] args){
        TestJson droneData = new TestJson();
        String jsonDroneData = droneData.fetchJsonData("ENDPOINT_DRONES");
        String jsonDroneDynamics = droneData.fetchJsonData("ENDPOINT_DRONEDYNAMICS");
        System.out.println("URL DroneAPI: " + jsonDroneData);
        System.out.println("URL DroneDynamics: " + jsonDroneDynamics);
        MainWindow frame = new MainWindow(jsonDroneData, jsonDroneDynamics);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Java Application with Drone Simulation Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 1280, 720);
    }

}
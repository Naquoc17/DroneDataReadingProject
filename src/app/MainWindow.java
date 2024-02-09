package app;

import javax.swing.*;

import components.table.overview.DronesView;
import components.table.overview.DroneDynamicsView;
import components.table.overview.DroneTypesView;
import components.table.overview.TopMenu;

import java.awt.*;
import java.io.File;


public class MainWindow extends JFrame {
    private static JPanel mainPane;
    private static JPanel contentPane;
    private static TopMenu topMenu;
    private static DronesView dronesView;
    private static DroneDynamicsView droneDynamicsView;
    private static DroneTypesView droneTypesView;

    // dataload variable
    private static TestJson droneData = new TestJson();
    private int pageLimit = 5;


    // json Variable
    private String jsonDroneData;
    private String jsonDroneTypes;
    private String jsonDroneDynamics;


    public MainWindow() {
        try {
            if (!checkEnvFileExistence()) {
                throw new MissingEnvFileException();
            }

            for (int i = 0; i < 2; i++) {
                loadData();
                System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t=================== Data loaded ===================");
                System.out.println("\t\t\t\t\t\t\t\t\t\t=================== Application is ready ==========\n");
                initializeUI();
                teammemberLabels();
            }

            runUIThread();

        } catch (MissingEnvFileException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private void initializeUI() {
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

        dronesView = new DronesView(jsonDroneData);
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

        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Java Application with Drone Simulation Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1380, 820);
    }

    private void teammemberLabels() {
        String[] authors = {"Anh Quoc Nguyen", "Tuan Dung Pham", "Zaynab Elyan", "Iryna Vynarchuk", "Sina (Theo) Adam"};

        JLabel JLabel_Group = new JLabel("GROUP 5");
        JLabel_Group.setFont(new Font("Malayalam MN", Font.PLAIN, 20));
        JLabel_Group.setBounds(950, 78, 261, 30);
        mainPane.add(JLabel_Group);

        JLabel JLabel_Autors = new JLabel("Created by:");
        JLabel_Autors.setFont(new Font("Malayalam MN", Font.PLAIN, 15));
        JLabel_Autors.setBounds(950, 110, 261, 30);
        mainPane.add(JLabel_Autors);

        int y = 125;
        for (String author : authors) {
            JLabel authorLabel = new JLabel(author);
            authorLabel.setFont(new Font("Malayalam MN", Font.PLAIN, 12));
            authorLabel.setBounds(950, y, 261, 30);
            mainPane.add(authorLabel);
            y += 15;
        }
    }


    public void loadData() {
        this.jsonDroneData = droneData.fetchJsonData("ENDPOINT_DRONES", pageLimit);
        this.jsonDroneDynamics = droneData.fetchJsonData("ENDPOINT_DRONEDYNAMICS", pageLimit);
        this.jsonDroneTypes = droneData.fetchJsonData("ENDPOINT_DRONETYPES", pageLimit);
        this.pageLimit += 50;
    }

    public void updateUI() {
        dronesView.updateView(jsonDroneData);
        droneDynamicsView.updateView(jsonDroneDynamics);
        droneTypesView.updateView(jsonDroneTypes);

        contentPane.revalidate();
        contentPane.repaint();
        System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t=================== Data reloaded ===================");
    }


    public JPanel getCurrentPane() {
        return (JPanel) contentPane.getComponent(1);
    } //get the current content panel, (main panel)

    public void changeContentPane(int panelNr) {
        contentPane.remove(1);
        switch (panelNr) {
            case 0:
                contentPane.add(mainPane);
                break;

            case 2:
                contentPane.add(dronesView);
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
    }

    private boolean checkEnvFileExistence() {
        File envFile = new File(".env");
        return envFile.exists();
    }

    private void runUIThread() {
        UpdateUIRunnable updateUIRunnable = new UpdateUIRunnable();
        Thread updateUIThread = new Thread(updateUIRunnable);
        updateUIThread.start();
    }

    class UpdateUIRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(60000);
                    loadData();
                    updateUI();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
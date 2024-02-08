package components.table.details;

import javax.swing.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;


public class DroneDetailsView extends JFrame {
    public DroneDetailsView(String serialNumber){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JFrame setWindows = new JFrame();
        JFXPanel embed = new JFXPanel();
        Platform.runLater(() -> initJavaFXScene(embed, serialNumber));
        setWindows.getContentPane().add(embed);
        setWindows.setTitle("Drone Model");
        setWindows.setSize(1000, 1000);
        setWindows.setVisible(true);
    }

    public static void initJavaFXScene(JFXPanel jfxPanel, String serialNumber){
        FullDroneDetails present = new FullDroneDetails();
        jfxPanel.setScene(present.setSegments(serialNumber));
    }
}

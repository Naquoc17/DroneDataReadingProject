package components.table.details;


import app.TestJson;
import dataFunction.DroneData;
import dataFunction.DroneDynamics;
import dataFunction.DroneTypes;
import dataFunction.ParserJson;

import java.io.InputStream;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;


// ClassPresent
public class FullDroneDetails {

    //Class caller
    static Drone3dSegment Get3D = new Drone3dSegment();
    //Some local variable which create
    private static javafx.scene.image.ImageView setIcon = new javafx.scene.image.ImageView();
    private static Group setFigure = Get3D.DroneFigure();



    //data's varibles from other class
    static TestJson droneData = new TestJson();
    private static String[] strHistory = new String[100];
    private static String var_Status = "ON";

    private static int var_BatteryStatus = 2500;
    private static double var_Longitude = 8.678137129d;
    private static double var_Latitude = 50.107668121d;
    private static double var_AlignmentYaw = 42.00d;
    private static String var_ID = "Drone_ID";
    private static String var_Serial = "Serial_NUMBER";
    private static String var_TypeName = "Type_NAME";
    private static String var_CarriageType = "Carriage_TYPE";
    private static String var_CreatedDate = "Created_DATE";
    private static double var_AlignmentRoll = 0.00d;
    private static double var_ControlRange = 0.00d;
    private static String var_LastSeen = "Last_SEEN";
    private static int var_CarriageWeight = 4096;
    private static String var_Manufacturer = "Manufacturer_NAME";
    //didn't get data yet
    private static int var_MaxCarriage = 0;
    private static int var_Speed = 0;
    private static int var_Battery = 10000;
    private static String var_Name = "Drone_NAME";
    private static String var_LastUpdate = "Last_UPDATE";
    //set up enviroment
    public static Scene setSegments(String Serial){
        //Todo: Setup main theme, so just add this in other class in order to call
        // Default of Scene is now 1000x1000, can change that at the return
        //Set up data
        getDroneData(Serial);
        getDynamicDrone(Serial);
        getDroneTypes();


        BorderPane BPane = new BorderPane();
        HBox hpane = new HBox(50);
        hpane.getChildren().addAll(History(), Card());
        hpane.setPadding(new Insets(0,50,0,0));
        VBox vpane = new VBox(50);
        vpane.getChildren().addAll(info(),get3DPane());
        vpane.setPadding(new Insets(50,50,50 ,50));
        BPane.setLeft(vpane);
        BPane.setRight(hpane);
        BPane.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {Get3D.Rotation(setFigure, keyEvent.getCode());});
        Scene scene = new Scene(BPane, 1000, 1000);
        scene.setCamera(new PerspectiveCamera());
        return scene;
    }


    private static StackPane get3DPane(){
        StackPane pane = new StackPane();
        setFigure.prefHeight(400);
        setFigure.prefHeight(400);
        Get3D.aroundRotation(setFigure);
        pane.getChildren().add(setFigure);
        pane.setPrefSize(400,400);
        pane.setMaxSize(400,400);
        pane.setMinSize(400,400);
        return pane;
    }
    private static GridPane info() {
        //Todo: Show drone's information as Text
        // Name, ID and the Serial number of the drone
        // Manufacturer installation (Manufacture, Type name, Created date, Carriage Weight,
        GridPane PaneTopLeft = new GridPane();
//        PaneTopLeft.setStyle("-fx-font-size: 20;");


        Label Name = new Label("Drone Name: ");
        Label str_Name = new Label(var_Name);
        Label ID = new Label("ID: ");
        Label str_ID = new Label(var_ID);
        Label Serial = new Label("Serial Number: ");
        Label str_Serial = new Label(var_Serial);
        Label Manufacturer = new Label("Manufacturer: ");
        Label str_Manufacturer = new Label(var_Manufacturer);
        Label Type_Name = new Label("Typename: ");
        Label str_TypeName = new Label(var_TypeName);
        Label Carriage_Weight = new Label("Carriage Weight: ");
        Label str_CarriageWeight = new Label(Integer.toString(var_CarriageWeight));
        Label Carriage_Type = new Label("Carriage Type: ");
        Label str_CarriageType = new Label(var_CarriageType);
        Label Created_Date = new Label("Created Date: ");
        Label str_CreatedDate = new Label(var_CreatedDate);


        PaneTopLeft.addRow(0, Name, str_Name);
        PaneTopLeft.addRow(1, ID, str_ID);
        PaneTopLeft.addRow(2, Serial, str_Serial);
        PaneTopLeft.addRow(3, Manufacturer, str_Manufacturer);
        PaneTopLeft.addRow(4, Type_Name, str_TypeName);
        PaneTopLeft.addRow(5, Carriage_Weight, str_CarriageWeight);
        PaneTopLeft.addRow(6, Carriage_Type, str_CarriageType);
        PaneTopLeft.addRow(7, Created_Date, str_CreatedDate);
        PaneTopLeft.setPrefSize(400,200);
        PaneTopLeft.setMaxSize(400,200);
        PaneTopLeft.setMinSize(400,200);

        return PaneTopLeft;
    }

    private static VBox History(){
        //todo: this method show a history of drone with a choice box
        VBox setBox = new VBox(10);
        ScrollPane setScroll = new ScrollPane();
        VBox setHistory = new VBox(10);
        setScroll.setContent(setHistory);
        Label Drone_History = new Label("Drone's history");
        Label Choose = new Label("Choose number of recent history:");
        ChoiceBox<Integer> chooseNumber = new ChoiceBox<>(FXCollections.observableArrayList(10, 20, 50, 100));

        // Handle the choice change event
        chooseNumber.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            setHistory.getChildren().clear();
            for (int i = 0; i < newValue; i++) {
                setHistory.getChildren().add(new Label(Integer.toString(i) +": "+ strHistory[i]));
            }
        });
        setBox.getChildren().addAll(Drone_History, Choose, chooseNumber, setScroll);
        chooseNumber.setPrefSize(510,50);
        setScroll.setPrefSize(510, 700);
        setBox.setStyle("-fx-font-size: 15;-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 10px;");
        setBox.setPrefSize(510,930);
        setBox.setMaxSize(510,930);
        setBox.setMinSize(510,930);
        setBox.setAlignment(Pos.CENTER);

        return setBox;
    }

    private static VBox Card() {
        //Todo: this method will show a visualization of dynamic information
        // 3 main show: PieChart Battery, GridPane Status and GriPane Location

        VBox BoxCenter = new VBox(10);

        BoxCenter.getChildren().addAll(BatteryLeft(), Location(), Status());
        BoxCenter.setPrefSize(510,930);
        BoxCenter.setMaxSize(510,930);
        BoxCenter.setMinSize(510,930);
        BoxCenter.setAlignment(Pos.CENTER);


        return BoxCenter;

    }
    private static HBox BatteryLeft(){
        //Todo this method will show a pie diagram as BattPercentage of battery left
        // if pie diagramm will change color due to percent left
        // Add a title with name "battery left" and show also the percentage as a number
        double BattPercentage = (double) var_BatteryStatus/(double) var_Battery;
        PieChart.Data Now = new PieChart.Data("Battery", BattPercentage);
        PieChart.Data Lost = new PieChart.Data("Battery Left", 1-BattPercentage);
        PieChart setChart = new PieChart();
        setChart.getData().addAll(Now, Lost);
        setChart.setLegendVisible(false);
        setChart.setLabelsVisible(false);
        setChart.setStartAngle(90);

        Lost.getNode().setStyle("-fx-pie-color: transparent;");
        if (BattPercentage>0.30) Now.getNode().setStyle("-fx-pie-color: white;");
        else if (BattPercentage > 0.15) Now.getNode().setStyle("-fx-pie-color: yellow;");
        else Now.getNode().setStyle("-fx-pie-color: red;");
        String titel = "Battery left: " + Integer.toString((int) (BattPercentage*100)) +"%";

        Label setTitel = new Label(titel);
        Label Battery_Status = new Label("Battery Status: ");
        Label str_BatteryStatus = new Label(var_BatteryStatus + "/" + var_Battery);

        setChart.setPrefSize(200,200);
        setChart.setMaxSize(200,200);
        setChart.setMinSize(200,200);

        GridPane setPane = new GridPane();
        setPane.setStyle("-fx-font-size: 15;");
        setPane.addRow(7,setTitel);
        setPane.addRow(6, Battery_Status, str_BatteryStatus);
        setPane.setPrefSize(300,200);
        setPane.setMaxSize(300,200);
        setPane.setMinSize(300,200);

        HBox setBox = new HBox(10);
        setBox.getChildren().addAll(setChart, setPane);
        setBox.setFillHeight(true);
        setBox.setStyle("-fx-font-size: 15;-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 10px;-fx-alignment: center;");
        setBox.setPrefSize(550,300);
        setBox.setMaxSize(550,300);
        setBox.setMinSize(550,300);
        return setBox;
    }
    private static HBox Location() {
        //Todo: this method will show coordinate of the drone as number and also actual speed of drone

        String path = "/icons/location_icon.png";
        try {
            InputStream input = FullDroneDetails.class.getResourceAsStream(path);
            assert input != null;
            Image icon = new Image(input);
            setIcon = new ImageView(icon);
        } catch (NullPointerException e) {
            System.err.println("File not found: " + path);
            e. printStackTrace();
        }

        Label Speed = new Label("Speed: ");
        Label str_Speed = new Label(Integer.toString(var_Speed));
        Label Longitude = new Label("Longitude: ");
        Label str_Longitude = new Label(Double.toString(var_Longitude));
        Label Latitude = new Label("Latitude: ");
        Label str_Latitude = new Label(Double.toString(var_Latitude));
        Label Alignment_Yaw = new Label("Alignment Yaw: ");
        Label str_AlignmentYaw = new Label(Double.toString(var_AlignmentYaw));
        Label Alignment_Roll = new Label("Alignment Roll");
        Label str_AlignmentRoll = new Label(Double.toString(var_AlignmentRoll));
        Label Control_Range = new Label("Control Range");
        Label str_ControlRange = new Label(Double.toString(var_ControlRange));

        GridPane setPane = new GridPane();
        setPane.addRow(13, Speed, str_Speed);
        setPane.addRow(14, Longitude, str_Longitude);
        setPane.addRow(15, Latitude, str_Latitude);
        setPane.addRow(16, Alignment_Yaw, str_AlignmentYaw);
        setPane.addRow(17, Alignment_Roll, str_AlignmentRoll);
        setPane.addRow(18, Control_Range, str_ControlRange);

        return gethBox( setPane, false);
    }
    private static HBox Status() {
        //Todo: this will show situation of a drone
        // A background with 4 color represent statuses (Light green: ON, Gray: OF, Red: IS, Yellow: unknown)
        // This show also status as words
        // Last seen should also be shown
        String path = "/icons/drone_icon.png";
        try {
            InputStream input = FullDroneDetails.class.getResourceAsStream(path);
            assert input != null;
            Image icon = new Image(input);
            setIcon = new javafx.scene.image.ImageView(icon);
        } catch (NullPointerException e) {
            System.err.println("File not found: " + path);
            e. printStackTrace();
        }

        Label Status = new Label("Status: ");
        Label str_Status = new Label(var_Status);
        Label Last_Seen = new Label("Last Seen: ");
        Label str_LastSeen = new Label(var_LastSeen);

        Label str_LastUpdate = new Label(var_LastUpdate);
        Label Last_Update = new Label("Last Update: ");
        GridPane setPane = new GridPane();
        setPane.addRow(13, Status, str_Status);
        setPane.addRow(14, Last_Seen, str_LastSeen);
        setPane.addRow(15, Last_Update, str_LastUpdate);

        return gethBox( setPane, true);
    }

    //Small Component setting
    private static HBox gethBox( GridPane setPane, Boolean BGC) {
        //todo: this method is use to creat a template for 2 boxes location and drone


        setIcon.setFitWidth(200);
        setIcon.setFitHeight(200);
        setIcon.setPreserveRatio(true);

        setPane.setStyle("-fx-font-size: 15;");
        setPane.setPrefSize(300,200);
        setPane.setMaxSize(300,200);
        setPane.setMinSize(300,200);

        HBox setBox = new HBox(10);
        setBox.getChildren().addAll(setIcon, setPane);
        setBox.setFillHeight(true);
        setBox.setPrefSize(550,300);
        setBox.setMaxSize(550,300);
        setBox.setMinSize(550,300);
        setBox.setStyle("-fx-font-size: 15;-fx-border-color: black; -fx-border-width: 2px; -fx-padding: 10px;-fx-alignment: center;");
        if (BGC) {
            Background background = getBackground();
            setBox.setBackground(background);
        }
        return setBox;
    }

    private static Background getBackground() {
        //Todo: this method will set background color of status pane
        Color Background_Color;
        switch (FullDroneDetails.var_Status) {
            case "ON": {
                Background_Color = Color.LIGHTGREEN;
            }
            break;
            case "OF": {
                Background_Color = Color.GRAY;
            }
            break;
            case "IS": {
                Background_Color = Color.RED;
            }
            break;
            default: {
                Background_Color = Color.YELLOW;
            }
        }
        return new Background(new BackgroundFill(Background_Color,null, null));
    }

    //Data getter
    public static void getDroneData(String Serial) {
        List<DroneData> droneDataList = ParserJson.parseJsonToDroneData(droneData.fetchJsonData("ENDPOINT_DRONES"));
        var_Serial = Serial;
        for (DroneData drone : droneDataList) {
            if (Serial.equals(drone.getSerialnumber())) {
                var_ID = String.valueOf(drone.getId());
                var_Name=drone.getDronetype();
                var_CarriageWeight = drone.getCarriage_weight();
                var_CarriageType = drone.getCarriage_type();
                var_CreatedDate = drone.getCreated();
                break;
            }
        }
    }


    public static void getDynamicDrone(String Serial) {
        int i=0;
        List<DroneDynamics> droneDynamicsList = ParserJson.parseJsonToDroneDynamics(droneData.fetchJsonData("ENDPOINT_DRONEDYNAMICS"));
        for (DroneDynamics drone : droneDynamicsList) {
            if (drone.getDrone().contains(var_ID /*This should be Serial*/ )) {
                var_Status = drone.getStatus();
                System.out.println(var_Status);
                var_BatteryStatus = drone.getBatteryStatus();
                var_Longitude = drone.getLongitude();
                var_Latitude = drone.getLatitude();
                var_AlignmentYaw = drone.getAlignmentYaw();
                var_AlignmentRoll = drone.getAlignmentRoll();
                var_ControlRange = drone.getControlRange();
                var_LastSeen = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm").format(drone.getLastSeen());
                var_Speed = drone.getSpeed();
                break;
            }
        }

        //Todo: I need to convert these link into right form, then this code should normal function
        String[] strHistory = new String[100];
        for (DroneDynamics drone : droneDynamicsList) {
            if (drone.getDrone().contains(Serial)) {
                strHistory[i] = String.valueOf(drone.getLastSeen());
            }
        }
    }
    public static void getDroneTypes() {
        List<DroneTypes> droneTypesList = ParserJson.parseJsonToDroneTypes(droneData.fetchJsonData("ENDPOINT_DRONETYPES"));
        for (DroneTypes drone : droneTypesList) {
            if (var_Name.contains(Integer.toString(drone.getId()))) { //this also should be changed
                var_Manufacturer = drone.getManufacturer();
                var_MaxCarriage = drone.getMax_carriage();
                var_Battery = drone.getBattery_capacity();
                var_TypeName = drone.getTypename();
                break;
            }
        }
    }

}

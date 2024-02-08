package components.table.details;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.scene.transform.Rotate;

public class Drone3dSegment {
    private PhongMaterial createMaterial(Color color) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(color);
        return material;
    }

    private Box createBody(PhongMaterial material) {
        Box body = new Box(100, 50, 30);
        body.setTranslateX(200);
        body.setTranslateY(200);
        body.setTranslateZ(-80);
        body.setMaterial(material);
        return body;
    }

    private Cylinder createArm(PhongMaterial material, double translateX) {
        Cylinder arm = new Cylinder(2, 100);
        arm.setTranslateX(translateX);
        arm.setTranslateY(200);
        arm.setTranslateZ(-80);
        arm.setMaterial(material);
        return arm;
    }

    private Circle createRotor(PhongMaterial material, double translateX, double translateY) {
        Circle rotor = new Circle(30);
        rotor.setFill(material.getDiffuseColor());
        rotor.setTranslateX(translateX);
        rotor.setTranslateY(translateY);
        rotor.setTranslateZ(-80);
        return rotor;
    }

    public Group DroneFigure() {
        PhongMaterial BodyColour = createMaterial(Color.AZURE);
        PhongMaterial ArmColour = createMaterial(Color.GRAY);
        PhongMaterial RotorColour = createMaterial(Color.SILVER);

        Box body = createBody(BodyColour);
        Cylinder arm1 = createArm(ArmColour, 170);
        Cylinder arm2 = createArm(ArmColour, 230);
        Circle rotor1 = createRotor(RotorColour, 170, 140);
        Circle rotor2 = createRotor(RotorColour, 231, 140);
        Circle rotor3 = createRotor(RotorColour, 170, 260);
        Circle rotor4 = createRotor(RotorColour, 231, 260);

        Group group = new Group();
        group.getChildren().addAll(body, arm1, arm2, rotor1, rotor2, rotor3, rotor4);

        return group;
    }

    public void Rotation(Group group, KeyCode keyEvent) {
        //Todo: Set Rotation as pressing key, but i didn't use it
        //This was made with chatgpt, cause life hates me
        //chatgpt only made rotationX tho, cause I needed the syntax and google was no help
        Rotate rotationX = new Rotate(10, Rotate.X_AXIS);
        Rotate rotateX2 = new Rotate(-10, Rotate.X_AXIS);
        Rotate rotateY2 = new Rotate(-10, Rotate.Y_AXIS);
        Rotate rotationY = new Rotate(10, Rotate.Y_AXIS);
        Rotate rotationZ = new Rotate(10, Rotate.Z_AXIS);
        Rotate rotateZ2 = new Rotate(-10, Rotate.Z_AXIS);


        switch (keyEvent) {
            //To Zoom in press the W key
            case W:
                group.translateZProperty().set(group.getTranslateZ() + 100);
                break;
            //to Zoom out press the S key
            case S:
                group.translateZProperty().set(group.getTranslateZ() - 100);
                break;
            case D:
                group.translateZProperty().set(group.getTranslateX() + 100);
                break;
            case A:
                group.translateZProperty().set(group.getTranslateX() - 100);
                break;
            //Press the keys Q, E and R so rotate the drone
            case Q:
                group.getTransforms().add(rotationX);
                break;
            case Y:
                group.getTransforms().add(rotateX2);
            case E:
                group.getTransforms().add(rotationY);
                break;
            case X:
                group.getTransforms().add(rotateY2);
            case R:
                group.getTransforms().add(rotationZ);
                break;
            case C:
                group.getTransforms().add(rotateZ2);
        };
    }

    public void aroundRotation(Group group){
        //todo: automatically rotate object. I did use that for tranformation
        // Create a Timeline for animation
        RotateTransition rotate = new RotateTransition(Duration.seconds(5), group);
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setAxis(Rotate.X_AXIS);
        rotate.setFromAngle(0);
        rotate.setToAngle(360);
        rotate.play();

    }
}
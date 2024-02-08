package dataFunction;

import java.time.ZonedDateTime;

public class DroneDynamics {
    private ZonedDateTime timestamp;
    private String drone;
    private int speed;
    private double alignmentRoll;
    private double controlRange;
    private double alignmentYaw;
    private double longitude;
    private double latitude;
    private int batteryStatus;
    private ZonedDateTime lastSeen;
    private String status;



    // Constructor


    public DroneDynamics(ZonedDateTime timestamp, String drone, int speed, double alignmentRoll, double controlRange, double alignmentYaw, double longitude, double latitude, int batteryStatus, ZonedDateTime lastSeen, String status) {

        this.timestamp = timestamp;
        this.drone = drone;
        this.speed = speed;
        this.alignmentRoll = alignmentRoll;
        this.controlRange = controlRange;
        this.alignmentYaw = alignmentYaw;
        this.longitude = longitude;
        this.latitude = latitude;
        this.batteryStatus = batteryStatus;
        this.lastSeen = lastSeen;
        this.status = status;
    }



    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDrone() {
        return drone;
    }

    public void setDrone(String drone) {
        this.drone = drone;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getAlignmentRoll() {
        return alignmentRoll;
    }

    public void setAlignmentRoll(double alignmentRoll) {
        this.alignmentRoll = alignmentRoll;
    }

    public double getControlRange() {
        return controlRange;
    }

    public void setControlRange(double controlRange) {
        this.controlRange = controlRange;
    }

    public double getAlignmentYaw() {
        return alignmentYaw;
    }

    public void setAlignmentYaw(double alignmentYaw) {
        this.alignmentYaw = alignmentYaw;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(int batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    public ZonedDateTime getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(ZonedDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.pluralsight;

public class Vehicle {

    private Long vehicleId;
    private String makeModel;
    private String color;
    private int odometerReading;
    private double price;
    private int year;

    public Vehicle(Long vehicleId, int year, String makeModel, String color, int odometerReading, double price) {
        this.vehicleId = vehicleId;
        this.makeModel = makeModel;
        this.color = color;
        this.odometerReading = odometerReading;
        this.price = price;
        this.year = year;
    }

    public Vehicle() {

    }

    Vehicle(String makeModel, String color, int odometerReading, double price) {
        this.makeModel = makeModel;
        this.color = color;
        this.odometerReading = odometerReading;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Car: %d , %d , %s , Color: %s , Odometer: %,d , Price: $%.2f",
                vehicleId, year, makeModel, color, odometerReading, price);
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}

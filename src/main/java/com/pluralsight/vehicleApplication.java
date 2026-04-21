package com.pluralsight;


import java.util.Scanner;

public class vehicleApplication {
    //private Vehicle vehicle;
    static Scanner userInput = new Scanner(System.in);
    static Vehicle[] inventory = new Vehicle[20];
    static int userOption;
    static Long nextId = 101126L;


    public static void main(String[] args) {

        do {
            mainMenu();
            displayUserOption();

        } while (userOption != 6);

    }

    static void mainMenu() {

        System.out.print("""
                Welcome to Mucci Vehicle Application!
                This is an inventory for used cars.
                
                Pick from the following options:
                1 - List all vehicles
                2 - Search by make/model
                3 - Search by price range
                4 - Search by color
                5 - Add a new vehicle
                6 - Quit
                """);

    }

    static void searchByMakeModel() {

        System.out.print("Enter the make/model of the vehicle you're looking for: ");
        String makeModel = userInput.nextLine();

        System.out.println("\n--- Search Results ---");
        boolean found = false;
        for (Vehicle car : inventory) {
            if (car != null && car.getMakeModel().toLowerCase().contains(makeModel.toLowerCase())) {
                System.out.println(car);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found matching: " + makeModel);
        }
        System.out.println("----------------------\n");

    }

    static void searchByPriceRange() {

        System.out.print("Enter the minimum price: ");
        double minPrice = userInput.nextDouble();
        System.out.print("Enter the maximum price: ");
        double maxPrice = userInput.nextDouble();
        userInput.nextLine();

        System.out.println("\n--- Search Results ---");
        boolean found = false;
        for (Vehicle car : inventory) {
            if (car != null && car.getPrice() >= minPrice && car.getPrice() <= maxPrice) {
                System.out.println(car);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found in price range: $" + minPrice + " - $" + maxPrice);
        }
        System.out.println("----------------------\n");

    }

    static void searchByColor() {

        System.out.print("Enter the color of the vehicle you're looking for: ");
        String color = userInput.nextLine();

        System.out.println("\n--- Search Results ---");
        boolean found = false;
        for (Vehicle car : inventory) {
            if (car != null && car.getColor().equalsIgnoreCase(color)) {
                System.out.println(car);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles found with color: " + color);
        }
        System.out.println("----------------------\n");

    }

    static void addVehicle() {
        System.out.println("Enter the make/model of the vehicle you want to add: ");
        String makeModel = userInput.nextLine();

        System.out.println("Enter the year of the vehicle: ");
        int year = userInput.nextInt();
        userInput.nextLine();

        System.out.println("Enter the color of the vehicle: ");
        String color = userInput.nextLine();

        System.out.println("Enter the odometer reading of the vehicle: ");
        int odometerReading = userInput.nextInt();
        userInput.nextLine();

        System.out.println("Enter the price of the vehicle: ");
        double price = userInput.nextDouble();
        userInput.nextLine();

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = new Vehicle(generateId(), year, makeModel, color, odometerReading, price);
                System.out.println("Vehicle added successfully!");
                return;
            }
        }
        System.out.println("Inventory is full!");
    }

    private static Long generateId() {

        return nextId++;

    }

    static void listAllVehicles() {

        // Option 1: Simple loop with null check
        System.out.println("\n--- Current Inventory ---");
        boolean hasVehicles = false;
        for (Vehicle car : inventory) {
            if (car != null) {
                System.out.println(car);
                hasVehicles = true;
            }
        }
        if (!hasVehicles) {
            System.out.println("No vehicles in inventory.");
        }
        System.out.println("-------------------------\n");

    }

    static void displayUserOption() {

        System.out.print("Enter your option (1-6): ");
        if (!userInput.hasNextInt()) {
            userInput.nextLine();
            System.out.println("Invalid option. Please enter a number between 1 and 6.");
            return;
        }
        userOption = userInput.nextInt();
        userInput.nextLine();

        if (userOption == 1) {
            myInventory();
            listAllVehicles();
        } else if (userOption == 2) {
            searchByMakeModel();
        } else if (userOption == 3) {
            searchByPriceRange();
        } else if (userOption == 4) {
            searchByColor();
        } else if (userOption == 5) {
            addVehicle();
        } else if (userOption == 6) {
            System.out.println("Exiting the application. Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Invalid option. Please enter a number between 1 and 6.");
        }
    }
    static void myInventory() {

        inventory[0] = new Vehicle(101121L, 1997, "Ford: F-150", "Red", 2015, 95000);
        inventory[1] = new Vehicle(101122L, 2000, "Chevy: Camaro", "Blue", 2018, 100000);
        inventory[2] = new Vehicle(101123L, 2002, "Toyota: Corolla", "Black", 2020, 120000);
        inventory[3] = new Vehicle(101124L, 2004, "Honda: Civic", "White", 2010, 150000);
        inventory[4] = new Vehicle(101125L, 2006, "Nissan: Leaf", "Green", 2012, 180000);

    }

}

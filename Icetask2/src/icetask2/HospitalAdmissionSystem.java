package Icetask2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main Class for the Hospital Admission System
public class HospitalAdmissionSystem {
    // List to hold patient records
    private static List<IceTask2> patients = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in); // Scanner for user input

    public static void main(String[] args) {
        // Mock Data for testing the application
        patients.add(new Female("Samantha", 16));
        patients.add(new Male("Johnny", 19, true));
        patients.add(new Male("Sam", 18, false));
        patients.add(new Male("Ricky", 20, false));
        patients.add(new Male("Brock", 16, false));
        patients.add(new Female("Julia", 15));
        patients.add(new Female("Tricksi", 20));
        patients.add(new Female("Stephanie", 21));

        // Check for successful login
        if (login()) {
            int choice;
            // Menu loop for user interaction
            do {
                System.out.println("\n----- St. City Hospital Admission System -----");
                System.out.println("1. Search Patient by Name");
                System.out.println("2. Display All Patients");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                
                // Read user choice
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                // Handle user choice
                switch (choice) {
                    case 1:
                        searchPatientByName();
                        break;
                    case 2:
                        displayAllPatients();
                        break;
                    case 3:
                        System.out.println("Exiting... Thank you!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                }
            } while (choice != 3); // Continue until user chooses to exit
        }
    }

    // Login method to validate user credentials
    private static boolean login() {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine(); // Read username
        System.out.print("Enter Password: ");
        String password = scanner.nextLine(); // Read password

        // Check if the credentials match the expected username and password
        if (username.equals("Admin") && password.equals("St@a77")) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }

    // Method to search for a patient by name
    private static void searchPatientByName() {
        System.out.print("Enter Patient Name to Search: ");
        String name = scanner.nextLine(); // Read patient name to search
        boolean found = false; // Flag to check if patient is found
        
        // Iterate through the patient list
        for (IceTask2 patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) { // Check for matching name
                System.out.println(patient); // Display patient information
                System.out.println("Eligibility: " + patient.checkEligibility()); // Display eligibility status
                found = true; // Set found flag to true
                break; // Exit loop after finding the patient
            }
        }
        
        // If patient not found, display a message
        if (!found) {
            System.out.println("Patient record not found.");
        }
    }

    // Method to display all patient records
    private static void displayAllPatients() {
        // Loop through all patients and display their information
        for (IceTask2 patient : patients) {
            System.out.println(patient); // Display patient information
            System.out.println("Eligibility: " + patient.checkEligibility()); // Display eligibility status
            System.out.println("-------------------------------------------"); // Separator for clarity
        }
    }
}

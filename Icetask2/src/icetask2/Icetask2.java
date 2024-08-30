//Katelyn Narain Ice Task 2
package Icetask2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base class Patient that holds common properties of a patient
class IceTask2 {
    private String name;
    private int age;
    private String gender;

    // Constructor to initialize a patient with name, age, and gender
    public IceTask2(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Getter method for age
    public int getAge() {
        return age;
    }

    // Getter method for gender
    public String getGender() {
        return gender;
    }

    // Method to check eligibility for treatment, to be overridden by subclasses
    public String checkEligibility() {
        return "Eligibility criteria not specified.";
    }

    // Overriding toString() method to provide a string representation of the patient object
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }
}

// Subclass Female which extends Patient and provides specific eligibility criteria for female patients
class Female extends IceTask2 {
    // Constructor to initialize a female patient with name and age
    public Female(String name, int age) {
        super(name, age, "Female"); // Calls the superclass (Patient) constructor
    }

    // Overriding the checkEligibility() method to provide specific logic for female patients
    @Override
    public String checkEligibility() {
        if (getAge() < 18) { // If age is below 18, not eligible for treatment
            return "Not eligible for treatment at the emergency room.";
        } else { // If age is 18 or above, eligible for treatment at Durban Hospital
            return "Eligible for treatment at Durban (DBN) Hospital.";
        }
    }
}

// Subclass Male which extends Patient and provides specific eligibility criteria for male patients
class Male extends IceTask2 {
    private boolean hasChronicDisorder; // Additional property for male patients to check if they have a chronic disorder

    // Constructor to initialize a male patient with name, age, and chronic disorder status
    public Male(String name, int age, boolean hasChronicDisorder) {
        super(name, age, "Male"); // Calls the superclass (Patient) constructor
        this.hasChronicDisorder = hasChronicDisorder; // Sets the chronic disorder status
    }

    // Overriding the checkEligibility() method to provide specific logic for male patients
    @Override
    public String checkEligibility() {
        if (getAge() > 18) { // If age is above 18
            if (hasChronicDisorder) { // If the patient has a chronic disorder
                return "Transferred to Johannesburg (JHB) Hospital for specialized care.";
            } else { // If no chronic disorder, eligible for treatment at Durban Hospital
                return "Eligible for treatment at Durban (DBN) Hospital.";
            }
        } else { // If age is 18 or below, not eligible for treatment
            return "Not eligible for treatment at the emergency room.";
        }
    }
}

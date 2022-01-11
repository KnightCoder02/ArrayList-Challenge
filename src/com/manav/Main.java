package com.manav;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0123456789");
    public static void main(String[] args) {

//        Create a program that implements a simple mobile phone with the following capabilities.
//        Able to search, modify, remove and query contact names.
//        You will want to create a separate class for contacts (name and phone number).
//        Create a master class (MobilePhone) that holds the ArrayList of contacts
//        The MobilePhone class has the functionality listed above.
//        Add a menu of options that are available.
//        Options: Quit, print list of contacts, add new contact, update existing contact, remove contact
//        and search/find contact.
//        When adding or updating be sure to check if the contact already exists (use name).
//        Be sure not to expose the inner workings of the ArrayList to MobilePhone.
//        e.g. no ints, no.get(i) etc.
//        MobilePhone should be everything with Contact objects only.

        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("\nEnter action: (6 - To Show Available Actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("\nShutting Down....");
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;

                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void addNewContact(){
        System.out.println("Enter new Contact Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Phone Number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New Contact Added: name -> " + name + ", phone -> " + phone);
        }
        else{
            System.out.println("Cannot Add, " + name + " already on file.");
        }
    }

    private static void updateContact(){
        System.out.println("Enter Existing Contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord =  mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not Found.");
            return;
        }
        System.out.print("Enter New Contact Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter New Contact Phone Number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("Successfully Updated Record.");
        }
        else{
            System.out.println("Error Updated Record.");
        }
    }

    private static void removeContact() {
        System.out.println("Enter Existing Contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not Found.");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("Succesfully Deleted.");
        }
        else{
            System.out.println("Error Deleting Contact.");
        }
    }

    private static void queryContact() {
        System.out.println("Enter Existing Contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not Found.");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());
    }

    private static void startPhone(){
        System.out.println("Starting Phone....");
    }

    private static void printActions(){
        System.out.println("\nAvailable Actions:\nPress");
        System.out.println( "0 - To Shutdown\n" +
                            "1 - To Print Contacts\n" +
                            "2 - To Add New Contact\n" +
                            "3 - To Update an Existing Contact\n" +
                            "4 - To Remove an Existing Contact\n" +
                            "5 - Query if an Existing Contact Exists\n" +
                            "6 - To Print A List Of Available Actions.");
        System.out.println("Choose your Action: ");
    }
}
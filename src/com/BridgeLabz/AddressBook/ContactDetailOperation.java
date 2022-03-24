package com.BridgeLabz.AddressBook;

import java.util.*;
import java.util.stream.Collectors;

public class ContactDetailOperation {
    public static ArrayList<ContactPerson> contact = new ArrayList<ContactPerson>();
    static Scanner scan = new Scanner(System.in);
    //----Adding contact---//
    public void addContact() {
        //taking Contact details from user
        System.out.println("First name");
        String first_name = scan.next();
        System.out.println("Last Name");
        String last_name = scan.next();
        System.out.println("Address");
        String address = scan.next();
        System.out.println("State");
        String state = scan.next();
        System.out.println("city");
        String city = scan.next();
        System.out.println("Zip");
        int zip = scan.nextInt();
        System.out.println("PhoneNo");
        long phone_number = scan.nextLong();
        System.out.println("Email");
        String email = scan.next();

        //parameterized constructor calling of Contact person class
        ContactPerson person = new ContactPerson(first_name, last_name, address, city, state, zip, phone_number, email);
        //Adding object element in arrayList
        contact.add(person);
    }
    //show contact details
    public void showDetails(){
        for(int i=0;i<contact.size();i++){
            System.out.println(contact.get(i));
        }
    }
    ////edit contact///
    public void editContact() {
        System.out.println("Enter Name You Want To Edit:-");
        String enteredName = scan.next();
        boolean flag = false;
        for (ContactPerson person : contact) {
            if (person.first_name.equals(enteredName)) {
                flag = true;
                System.out.println("1. First Name\n" + "2.Last Name\n" + "3.Address\n" + "4.city\n" + "5.State\n" + "6.zip\n" + "7.phoneNumber\n" + "8.email");
                int choice = scan.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("Enter First Name:-");
                        String firstname = scan.next();
                        person.first_name = firstname;
                        break;
                    case 2:
                        System.out.println("Enter First Name : ");
                        String lastName = scan.next();
                        person.last_name = lastName;
                        break;
                    case 3:
                        System.out.println("Enter Address : ");
                        String newAddress = scan.next();
                        person.address = newAddress;
                        break;
                    case 4:
                        System.out.println("Enter city : ");
                        String newCity = scan.next();
                        person.city = newCity;
                        break;
                    case 5:
                        System.out.println("Enter city : ");
                        String newState = scan.next();
                        person.state = newState;
                        break;
                    case 6:
                        System.out.println("Enter zip : ");
                        int newZip = scan.nextInt();
                        person.zip = newZip;
                        break;
                    case 7:
                        System.out.println("Enter phone Number : ");
                        long new_phoneNumber = scan.nextLong();
                        person.phone_number = new_phoneNumber;
                        break;
                    case 8:
                        System.out.println("Enter email : ");
                        String new_email = scan.next();
                        person.email = new_email;
                        break;
                    default:
                        System.out.println("invalid choice");
                }
                break;
            }
        }
        if (flag == false) {
            System.out.println(enteredName + " Not Found!");
        }
    }

    public void deleteContact() {
        System.out.println("Enter name wants to delete:");
        String firstName = scan.next();
        boolean flag = false;
        for (ContactPerson personDetail : contact) {
            if (personDetail.first_name.equals(firstName)) {
                contact.remove(personDetail);
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Name not found");
        }else {
            System.out.println("Contact deleted successfully");
        }
    }

    /**
     * check duplicates in adress book
     */
    public static void checkDuplicate(){
        Set<String> ContactSet=new HashSet<>();
        Set<ContactPerson>newSet=contact.stream().filter(n -> !ContactSet.add(n.getFirst_name())).collect(Collectors.toSet());
        for (ContactPerson contact:newSet){
            System.out.println("The Duplicate contact is : "+contact.getFirst_name()+ " "+ contact.getLast_name());
        }
    }
    //---Adding address book--//
    public void addAddressBook(){
        boolean isFlag=true;
        while(isFlag){
            System.out.println("Address Book Menu");
            System.out.println("1.Add contact. \n 2.edit contact. \n 3.Delete contact. \n 4.Exit");//choices for operation
            System.out.print("Enter Choice:");
            int option=scan.nextInt();
            switch (option){
                case 1:
                    addContact();
                    showDetails();
                    System.out.println("Contact added successFully");
                    System.out.println("---------------------------");
                    break;
                case 2:
                    editContact();
                    showDetails();
                    System.out.println("Contact Edited Successfully");
                    System.out.println("---------------------------");
                    break;
                case 3:
                    deleteContact();
                    showDetails();
                    System.out.println("Contact deleted successfully");
                    System.out.println("-----------------------------");
                    break;
                case 4:
                    isFlag=false;
                    System.out.println("Exit");
                default:
                System.out.println("Please enter valid choice");
            }
        }
    }
}


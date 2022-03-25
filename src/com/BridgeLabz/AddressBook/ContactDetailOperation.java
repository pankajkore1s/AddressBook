package com.BridgeLabz.AddressBook;

import java.util.*;
import java.util.stream.Collectors;

import static com.BridgeLabz.AddressBook.AddressBookMain.addAddressBook;
import static com.BridgeLabz.AddressBook.AddressBookMain.addressBookDetail;

public class ContactDetailOperation {
    public static ArrayList<ContactPerson> contact = new ArrayList<ContactPerson>();
    static Scanner scan = new Scanner(System.in);
    public HashMap<String,ArrayList<ContactPerson>> personByState;
    public HashMap<String,ArrayList<ContactPerson>> personByCity;

    public ContactDetailOperation(){
        personByCity=new HashMap<String,ArrayList<ContactPerson>>();
        personByState=new HashMap<String,ArrayList<ContactPerson>>();
    }
    //----Adding contact---//
    public ArrayList<ContactPerson> addContact() {
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

        if(!personByState.containsKey(state)){
            personByState.put(state,new ArrayList<ContactPerson>());
        }
        personByState.get(state).add(person);
        if(!personByCity.containsKey(city)){
            personByCity.put(city,new ArrayList<ContactPerson>());
        }
        personByCity.get(city).add(person);
        return contact;
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
        }else {
            System.out.println("Contact edited successfully");
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
                break;
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

    public void getPersonNameByCity(String cityName) {
        List<ContactPerson> list = contact.stream().filter(person -> person.getCity().equals(cityName)).collect(Collectors.toList());
        for (ContactPerson contact : list) {
            System.out.println("First Name: " + contact.getFirst_name());
            System.out.println("Last Name: " + contact.getLast_name());
        }
    }

    public void getPersonNameByState(String stateName) {
        List<ContactPerson> list = contact.stream().filter(person -> person.getState().equals(stateName)).collect(Collectors.toList());
        for (ContactPerson contact : list) {
            System.out.println("First Name: " + contact.getFirst_name());
            System.out.println("Last Name: " + contact.getLast_name());
        }
    }

    /**
     * search person by city
     */
    public void searchPersonByCity(String cityName){
        for(Map.Entry<String,ContactDetailOperation>entry: addressBookDetail.entrySet()){
            ContactDetailOperation value=entry.getValue();
            System.out.println("The Address Book: "+entry.getKey());
            value.getPersonNameByState(cityName);
        //getPersonByCity//
        }
    }

    //search person by state//
    public void searchPersonByState(String stateName){
        for (Map.Entry<String,ContactDetailOperation>entry: addressBookDetail.entrySet()){
            ContactDetailOperation value=entry.getValue();
            System.out.println("The Address book : "+entry.getKey());
            value.getPersonNameByCity(stateName);
        }
    }
    public void viewPersonByCity(String cityName){
        for(Map.Entry<String,ContactDetailOperation>entry : addressBookDetail.entrySet()){
            ContactDetailOperation value=entry.getValue();
            ArrayList<ContactPerson> contacts =value.personByCity.entrySet().stream()
                    .filter(findCity -> findCity.getKey().equals(cityName))
                    .map(Map.Entry::getValue).findFirst().orElse(null);
            for(ContactPerson contact : contacts){
                System.out.println("First Name: " + contact.getFirst_name() + " Last Name: " + contact.getLast_name());
            }
        }
    }

    public void viewPersonByState(String stateName){
        for (Map.Entry<String, ContactDetailOperation> entry : addressBookDetail.entrySet()){
            ContactDetailOperation value =entry.getValue();
            ArrayList<ContactPerson> contacts = value.personByState.entrySet().stream()
                    .filter(findState -> findState.getKey().equals(stateName))
                    .map(Map.Entry::getValue).findFirst().orElse(null);
            for(ContactPerson contact : contacts){
                System.out.println("First Name: " + contact.getFirst_name() + " Last Name: " + contact.getLast_name());
            }
        }
    }
}


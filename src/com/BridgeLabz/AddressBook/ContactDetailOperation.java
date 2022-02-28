package com.BridgeLabz.AddressBook;
import java.util.*;
import java.util.ArrayList;
public class ContactDetailOperation {
    ArrayList contact;
    Scanner scan = new Scanner(System.in);

    ContactDetailOperation(){
        contact= new ArrayList();
    }
    public void addContact() {
        //taking Contact details from user
        System.out.println("First name");
        String First_name = scan.nextLine();
        System.out.println("Last Name");
        String last_name = scan.nextLine();
        System.out.println("Address");
        String address = scan.nextLine();
        System.out.println("State");
        String state = scan.nextLine();
        System.out.println("city");
        String city = scan.nextLine();
        System.out.println("Zip");
        int zip = scan.nextInt();
        System.out.println("PhoneNo");
        long phone_number = scan.nextLong();
        System.out.println("Email");
        String email = scan.next();

        //parameterized constructor calling of Contact person class
        ContactPerson person=new ContactPerson(First_name,last_name,address,city,state,zip, phone_number,email);
        //Adding object element in arrayList
        contact.add(person);

        //displaying ArrayList Content
        for(int i=0;i<contact.size();i++){
            System.out.println(contact.get(i));
        }


    }
}

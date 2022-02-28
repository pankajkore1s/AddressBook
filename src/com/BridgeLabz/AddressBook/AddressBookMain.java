package com.BridgeLabz.AddressBook;
import java.util.*;
import java.util.ArrayList;
public class AddressBookMain {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String args[]) {
        ContactDetailOperation contactDetail = new ContactDetailOperation();//object of ContactDetailOperation class is created
        System.out.println("Address Book Menu!!");
        while (true) {
            System.out.println("1.Add contact. \n 2.Edit contact. \n 3.delete contact");//choices for operation
            System.out.print("enter choice:");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    contactDetail.addContact();
                    System.out.println("Contact Added Successfully!");
                    break;
                case 2:
                    contactDetail.editContact();
                    System.out.println("Contact edited Successfully");
                    break;
                case 3:
                    contactDetail.deleteContact();
                    System.out.println("Contact deleted Successfully");
                    break;
                default:System.out.println("Please Enter Valid Choice:");
                break;
            }
        }
    }
}

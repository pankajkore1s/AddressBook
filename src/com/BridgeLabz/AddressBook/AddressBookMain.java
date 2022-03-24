package com.BridgeLabz.AddressBook;
import java.util.*;
import java.util.ArrayList;
import static com.BridgeLabz.AddressBook.ContactDetailOperation.contact;
public class AddressBookMain {
    public static Map<String,ArrayList<ContactPerson>> addressBookDetail=new HashMap<String,ArrayList<ContactPerson>>();
    static ContactDetailOperation contactDetail=new ContactDetailOperation();
    public static Scanner scan = new Scanner(System.in);
//--main method--//
    public static void main(String args[]) {
        System.out.println("Address Book System!!");
        boolean flag=true;
        while (flag) {
            System.out.println("1.Add contact. \n 2.Exit");
            System.out.print("enter choice:");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name Of Address Book");
                    String addBookName=scan.next();
                    if(addressBookDetail.containsKey(addBookName)){
                        System.out.println("AddressBook Already Exist");
                    }else{
                        addressBookDetail.put(addBookName,contact);
                        contactDetail.addAddressBook();
                        for (Map.Entry<String,ArrayList<ContactPerson>>Entry:addressBookDetail.entrySet()){
                            System.out.println("AddressBook Name:>"+Entry.getKey()+"==>"+"Contact Details:>"+ Entry.getValue() + "==>");
                        }
                        break;
                    }
                case 2:
                    flag=false;
                    System.out.println("Exit");
            }
        }
    }
}

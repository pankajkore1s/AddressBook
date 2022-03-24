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
            System.out.println("1.Add new Address Book \n 2.Check Duplicate Entry \n 3.Search person by city \n 4. Search Person by State \n 5.Exit");
            System.out.print("enter choice:");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name Of Address Book");
                    String addBookName=scan.next();
                    if(addressBookDetail.containsKey(addBookName)){
                        System.out.println("AddressBook Already Exist");
                    }else{
                        ///addressBookDetail.put(addBookName,contact);
                        addAddressBook(addBookName);
                        break;
                    }
                case 2:
                    for (Map.Entry<String, ArrayList<ContactPerson>> entry : addressBookDetail.entrySet()) {
                        ArrayList<ContactPerson> value = entry.getValue();
                        System.out.println("Address Book Name: " + entry.getKey());
                        contactDetail.checkDuplicate();
                    }
                    break;
                case 3:
                    System.out.println("Enter name of city: ");
                    String cityName=scan.next();
                    contactDetail.searchPersonByCity(cityName);
                break;
                case 4:
                    System.out.println("enter name of state");
                    String stateName=scan.next();
                    contactDetail.searchPersonByState(stateName);
                break;
                case 5:
                    flag=false;
                    System.out.println("Exit");
                break;
            }
        }
    }
    public static void addAddressBook(String addBookName){
        boolean isFlag=true;
        while (isFlag){
            System.out.println("Address Book Menu");
            System.out.println("1.Add contact. \\n 2.Edit contact. \\n 3.Delete Contact \\n 4.Exit");
            System.out.println("enter choice:");
            int option=scan.nextInt();
            switch (option){
                case 1:
                    contactDetail.addContact();
                    contactDetail.showDetails();
                    System.out.println("Contact added successfully");
                    System.out.println("---------------------------");
                    break;
                case 2:
                    contactDetail.editContact();
                    contactDetail.showDetails();
                    System.out.println("contact edited successfully");
                    System.out.println("----------------------------");
                    break;
                case 3:
                    contactDetail.deleteContact();
                    contactDetail.showDetails();
                    System.out.println("Contact deleted successfully");
                    System.out.println("-----------------------------");
                    break;
                case 4:
                    isFlag=false;
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Please enter valid choice");
                    break;
            }
        }
        addressBookDetail.put(addBookName,contact);
        System.out.println(addBookName+" =>"+"Address Book Added Successfully");
    }
}

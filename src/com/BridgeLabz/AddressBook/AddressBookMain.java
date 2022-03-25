package com.BridgeLabz.AddressBook;
import java.util.*;

public class AddressBookMain {
    public static Map<String, ContactDetailOperation> addressBookDetail=new HashMap<String, ContactDetailOperation>();
    static ContactDetailOperation contactDetail=new ContactDetailOperation();
    public static Scanner scan = new Scanner(System.in);
//--main method--//
    public static void main(String args[]) {
        System.out.println("Address Book System!!");
        boolean flag=true;
        while (flag) {
            System.out.println("1.Add new Address Book \n 2.Check Duplicate Entry \n 3.Search person by city \n 4. Search Person by State \n 5.View person by state \n 6.view person by city \n 7.count people by city \n 8.count people by state \n 9.exit");
            System.out.print("enter choice:");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name Of Address Book");
                    String addBookName=scan.next();
                    if (addressBookDetail.containsKey(addBookName)){
                        System.out.println("AddressBook Already Exist");
                        break;
                    }else{
                        addAddressBook(addBookName);
                        for (Map.Entry<String,ContactDetailOperation> entry: addressBookDetail.entrySet()){
                            System.out.println("Address Book Name:>"+ entry.getKey() +"==>"+"Contact Details:>"+entry.getValue());
                        }
                        break;
                    }
                case 2:
                    for (Map.Entry<String, ContactDetailOperation> entry : addressBookDetail.entrySet()) {
                        ContactDetailOperation value = entry.getValue();
                        System.out.println(value);
                        System.out.println("Address Book Name: " + entry.getKey());
                        value.checkDuplicate();
                        break;
                    }
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
                    System.out.println("Enter name of state: ");
                    String state_Name=scan.next();
                    contactDetail.viewPersonByState(state_Name);
                break;
                case 6:
                    System.out.println("Enter the name of city: ");
                    String city_Name=scan.next();
                    contactDetail.viewPersonByCity(city_Name);
                    break;
                case 7:
                    System.out.println("Enter the name of city");
                    String city=scan.next();
                    contactDetail.countByCity(city);
                    break;
                case 8:
                    System.out.println("Enter the name of State");
                    String state=scan.next();
                    contactDetail.countByState(state);
                case 9:
                    System.out.println("Exit");
                    flag=false;
                    break;
            }
        }
    }
    public static void addAddressBook(String addBookName){
        boolean isFlag=true;
        while (isFlag){
            System.out.println("Address Book Menu");
            System.out.println("1.Add contact. \n 2.Edit contact. \n 3.Delete Contact \n 4.Exit");
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
                    System.out.println("----------------------------");
                    break;
                case 3:
                    contactDetail.deleteContact();
                    contactDetail.showDetails();
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
        addressBookDetail.put(addBookName,contactDetail);
        System.out.println(addBookName+" =>"+"Address Book Added Successfully");
    }
}

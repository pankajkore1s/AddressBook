package com.BridgeLabz.AddressBook;

public class ContactPerson {
    public String first_name;
    public String last_name;
    public String address;
    public String city;
    public String state;
    public int zip;
    public long phone_number;
    public String email;

    public ContactPerson(String first_name, String last_name, String address, String city, String state, int zip, long phone_number, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone_number = phone_number;
        this.email = email;
    }
    public String toString() {
        return "ContactPerson{"+"first_name='" + first_name + '\'' + ", last_name='" + last_name + '\'' + ", address='" + address + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", zip=" + zip + ", phone_number=" + phone_number + ", email='" + email + '\'' + '}';
    }
}

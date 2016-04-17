package controller;
import ui.ConsoleIO;
import dao.AddressBookV2Impl;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddressBookV2_Controller {

    static ConsoleIO ui = new ConsoleIO();

    public void run() {

        AddressBookV2Impl Impl = new AddressBookV2Impl();

        int menuChoice;

        do {
            ui.write("\nPlease select the operation you wish to perform:\n");
            ui.write("1) Add an address\n"
                    + "2) Remove an address\n"
                    + "3) Find address by last name\n"
                    + "4) Find address by City\n"
                    + "5) Find address by State\n"
                    + "6) Find address by Zip Code\n"
                    + "7) Return count of addresses in book\n"
                    + "8) Return all addresses in address book\n"
                    + "9) Edit Address\n"
                    + "10) Exit\n"
                    + ": ");
            menuChoice = ui.readInteger("", 1, 10);

            switch (menuChoice) {
                case 1:
                    String fName, lName, street, city, state, zip;
                    fName = ui.readString("\nPlease Enter First name: ");
                    lName = ui.readString("Please Enter Last Name: ");
                    street = ui.readString("Please Enter Street Address: ");
                    city = ui.readString("Please Enter City: ");
                    state = ui.readString("Please Enter State: ");
                    zip = ui.readString("Please Enter Zip: ");
                    Impl.addAddress(fName, lName, street, city, state, zip);
                    break;
                    
                case 2:
                    boolean result;
                    lName = ui.readString("\nEnter the Last Name of the address you want to delete: ");
                    fName = ui.readString("\nEnter the First Name of the address you want to delete: ");
                    
                    result = Impl.removeAddress(fName,lName);
                    
                    if(result == true) {
                        ui.write("\n Address deleted");
                    } else {
                        ui.write("\n Address not found");
                    }

                    break;
                    
                case 3:
                    String Name = ui.readString("\nLast Name: ");
                    List lastName = Impl.findAddressName(Name);
                    if (lastName.isEmpty()) {
                        ui.write("Last Name " + Name + " not found.\n");
                    } else {
                        lastName.forEach(e -> ui.write(e.toString() + "\n"));
                    }
                    break;
                    
                case 4:
                    String findCity = ui.readString("\n What City are you trying to find: ");
                    Impl.searchCity(findCity);
                    break;
                case 5:
                    String findState = ui.readString("\n What State are you trying to find: ");
                    Map groupByCity = Impl.searchState(findState);
                    Set<String> keys = groupByCity.keySet();
                    for (String k : keys) {
                        ui.write(k + "\n" + groupByCity.get(k) + "\n\n");
                    }
                    break;
                case 6:
                    String findZip = ui.readString("\n What Zip Code are you trying to find: ");
                    Impl.searchZip(findZip);
                    break;
                case 7:
                    int count = Impl.findAddressCount();
                    ui.write(count + "\n");
                    break;
                    
                case 8:
                    Impl.viewAddress();
                    ui.write("");
                    break;
                    
                case 9:
                    Impl.viewAddress();
                    lName = ui.readString("\nEnter the Last Name of the address you want to edit: ");
                    fName = ui.readString("\nEnter the First Name of the address you want to edit: ");
                    street = ui.readString("\nEnter the street address you want to edit: ");
                    
                    result = Impl.editAddress(fName, lName, street);
                    
                    if(result == true) {
                        
                    fName = ui.readString("\nPlease Enter First name: ");
                    lName = ui.readString("Please Enter Last Name: ");
                    street = ui.readString("Please Enter Street Address: ");
                    city = ui.readString("Please Enter City: ");
                    state = ui.readString("Please Enter State: ");
                    zip = ui.readString("Please Enter Zip: ");
                    Impl.addAddress(fName, lName, street, city, state, zip);
                    
                    } else {
                        ui.write("\n Address not found");
                    }
                    
                    break;
                case 10:

                    try {
                        Impl.writeToDisk(Impl.filename);
                    } catch (IOException e) {
                        ui.write("Updates failed to write\n");
                        ui.write("Goodbye!\n");
                    }
            }
        }
            while (menuChoice != 10);

        }
}

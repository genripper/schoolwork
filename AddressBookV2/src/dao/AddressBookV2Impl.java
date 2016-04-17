/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import dto.AddressBookV2_DTO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import ui.ConsoleIO;

/**
 *
 * @author apprentice
 */
public class AddressBookV2Impl implements AddressBookV2_Interface {
  

    ConsoleIO ui = new ConsoleIO();
    
    public ArrayList<AddressBookV2_DTO> addressList = new ArrayList<>();
    
    public String filename = "AddressBookV2.txt";
 
    public AddressBookV2Impl() {
                    try {
            addressList.addAll(readFromDisk(filename));
        } catch (FileNotFoundException e) {
            addressList = new ArrayList<>();
        }
    }
    
    public AddressBookV2Impl(ArrayList<AddressBookV2_DTO> addressList){
            this.addressList = addressList;
    }



  
    @Override
    public String addAddress(String fname, String lname,String street, String city, String state, String zip) {

        addressList.add(new AddressBookV2_DTO(fname, lname, street, city, state, zip));
        String value = "\nAddress Added.\n";
        return value;
    }


    @Override
    public boolean removeAddress(String fName, String lName) {
        List<AddressBookV2_DTO> lastName = addressList
                .stream()
                .filter(s -> s.getlName().equalsIgnoreCase(lName))
                .filter(s -> s.getfName().equalsIgnoreCase(fName))
                .collect(Collectors.toList());
        if(lastName.size() > 0) {
            for(AddressBookV2_DTO s : lastName) {
            addressList.remove(s);
            }
            return true;
        } else {
            return false;
        }
               

    }
    

  
    @Override
    public List findAddressName(String name) {
        List<AddressBookV2_DTO> lastName = addressList
                .stream()
                .filter(s -> s.getlName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        return lastName;

    }


    @Override
    public int findAddressCount() {
        int addCount = addressList.size();
        return addCount;
    }

    @Override
    public void viewAddress() {
        
        for(int i = 0; i < addressList.size(); i ++) {
            ui.write(addressList.get(i).toString());
        }
    }


    @Override
    public Boolean editAddress(String fName, String lName, String street) {
        List<AddressBookV2_DTO> lastName = addressList
                .stream()
                .filter(s -> s.getlName().equalsIgnoreCase(lName))
                .filter(s -> s.getfName().equalsIgnoreCase(fName))
                .filter(s -> s.getStreet().equalsIgnoreCase(street))
                .collect(Collectors.toList());
                if(lastName.size() > 0) {
                    for(AddressBookV2_DTO s : lastName) {
                    addressList.remove(s);
                    }
                    return true;
                } else {
                    return false;
                }
    
    }
    
    @Override
    public void searchCity(String findCity) {
        addressList
                .stream()
                .filter(s -> s.getCity().equalsIgnoreCase(findCity))
                .forEach(e -> ui.write(e.toString() + "\n"));
        
        long count = addressList
                .stream()
                .filter(s -> s.getCity().equalsIgnoreCase(findCity))
                .count();
        
                if(count == 0) {
                    ui.write("\n Address not found.\n");
                    
                }
    }
    
    @Override
    public Map searchState(String findState) {
        Map<String, List<AddressBookV2_DTO>> groupByCity = addressList
                .stream()
                .filter(s -> s.getState().equalsIgnoreCase(findState))
                .collect(Collectors.groupingBy(AddressBookV2_DTO::getCity));
        
   


        
        long count = addressList
                .stream()
                .filter(s -> s.getState().equalsIgnoreCase(findState))
                .count();
        
                if(count == 0) {
                    ui.write("\n Address not found.\n");
                    
                }
                return groupByCity;
    }
    
    @Override
    public void searchZip(String findZip) {
        addressList
                .stream()
                .filter(s -> s.getZip().equalsIgnoreCase(findZip))
                .forEach(e -> ui.write(e.toString() + "\n"));
        
        long count = addressList
                .stream()
                .filter(s -> s.getZip().equalsIgnoreCase(findZip))
                .count();
        
                if(count == 0) {
                    ui.write("\n Address not found.\n");
                    
                }
    }


    @Override
    public void writeToDisk(String filename) throws IOException {

        PrintWriter out = new PrintWriter(new FileWriter(filename));
        for (AddressBookV2_DTO s : addressList) {
            String addr = s.getfName()
                    + "::" + s.getlName()
                    + "::" + s.getStreet()
                    + "::" + s.getCity()
                    + "::" + s.getState()
                    + "::" + s.getZip()
                    + "::" + "End";
            out.println(addr);
        }
        out.flush();
        out.close();
    }

  
    @Override
    public ArrayList<AddressBookV2_DTO> readFromDisk(String filename) throws FileNotFoundException {

        ArrayList<AddressBookV2_DTO> newAddressBook = new ArrayList<>();

        Scanner in = new Scanner(new BufferedReader(new FileReader(filename)));

        AddressBookV2_DTO currentAddress;
        String inString;
        String[] inArray;

        while (in.hasNextLine()) {
            inString = in.nextLine();
            inArray = inString.split("::");
            currentAddress = new AddressBookV2_DTO(inArray[0], inArray[1], inArray[2], inArray[3], inArray[4], inArray[5]);
            newAddressBook.add(currentAddress);
        }
        return newAddressBook;
    }

}

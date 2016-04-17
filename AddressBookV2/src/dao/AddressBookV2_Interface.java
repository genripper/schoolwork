/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import dto.AddressBookV2_DTO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author apprentice
 */
public interface AddressBookV2_Interface {
    
    public void writeToDisk(String filename) throws IOException;
    
    public ArrayList<AddressBookV2_DTO> readFromDisk(String filename) throws FileNotFoundException;
    
    public String addAddress(String fname, String lname,String street, String city, String state, String zip);
    
    public boolean removeAddress(String fName, String lName);
    
    public List findAddressName(String name);
    
    public int findAddressCount();
    
    public void viewAddress();
    
    public Boolean editAddress(String fName2, String lName2, String street2);
    
    public void searchCity(String findCity);
    
    public Map searchState(String findState);
    
    public void searchZip(String findZip);
    
    
    
    
    
}

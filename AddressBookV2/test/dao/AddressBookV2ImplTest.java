/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AddressBookV2_DTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class AddressBookV2ImplTest {
    
    static ArrayList<AddressBookV2_DTO> addressList = new ArrayList<>();
    
    public AddressBookV2ImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        AddressBookV2_DTO one = new AddressBookV2_DTO("Joe", "Smith",
                "Dennis St", "San Diego", "CA", "91910");
        addressList.add(one);
        
        one = new AddressBookV2_DTO("James", "Jones",
                "Garrett St", "San Diego", "WA", "91910");
        addressList.add(one);
        
        one = new AddressBookV2_DTO("Jane", "Sm",
                "Dennis St", "Plymouth", "MN", "92007");
        addressList.add(one);
        
        one = new AddressBookV2_DTO("John", "Spy",
                "Lee St", "San Diego", "OR", "80129");
        addressList.add(one);
        
        one = new AddressBookV2_DTO("Jim", "Baker",
                "Den St", "Denver", "CO", "91910");
        addressList.add(one);
     
        
        
    }
    
    @After
    public void tearDown() {
        addressList.clear();
    }

    /**
     * Test of addAddress method, of class AddressBookV2Impl.
     */
    @Test
    public void testAddAddress() {
        System.out.println("addAddress");
        AddressBookV2Impl instance = new AddressBookV2Impl(addressList);
        instance.addAddress("Jim", "Johnson", "3 Elm St", "Pueblo", "CO", "87547");
        
        int count = instance.findAddressCount();
        assertEquals(6, count);

    }

    /**
     * Test of removeAddress method, of class AddressBookV2Impl.
     * @return 
     */
    @Test
    public void testRemoveAddress() {
        System.out.println("removeAddress");
        AddressBookV2Impl instance = new AddressBookV2Impl(addressList);
        int iniCount = instance.findAddressCount();
        instance.removeAddress("Joe","Smith");
        
        int count = instance.findAddressCount();
        assertEquals(iniCount - 1, count);

    }

    /**
     * Test of findAddressName method, of class AddressBookV2Impl.
     */
    @Test
    public void testFindAddressName() {
        System.out.println("findAddressName");
        AddressBookV2Impl instance = new AddressBookV2Impl(addressList);
        List lastName = instance.findAddressName("Spy");
        
        boolean result;
        
        if (lastName.isEmpty()) {
                        result = true;
                    } else {
                        result = false;
                    }
        
        assertEquals(false,result);

    }

    /**
     * Test of findAddressCount method, of class AddressBookV2Impl.
     * @return 
     */
    @Test
    public void testFindAddressCount() {
        

        
        System.out.println("findAddressCount");
        AddressBookV2Impl instance = new AddressBookV2Impl(addressList);
        
        int count = instance.findAddressCount();
        
        assertEquals(5,count);
        

    }

    /**
     * Test of editAddress method, of class AddressBookV2Impl.
     */
    @Test
    public void testEditAddress() {
        System.out.println("editAddress");
        
        AddressBookV2Impl instance = new AddressBookV2Impl(addressList);
        
        boolean result = instance.editAddress("Joe", "Smith", "Dennis St");
        
        assertEquals(true,result);

    }


    /**
     * Test of writeToDisk method, of class AddressBookV2Impl.
     */
    @Test
    public void testWriteToDisk() throws Exception {
        
        System.out.println("writeToDisk");
         
        AddressBookV2Impl instance = new AddressBookV2Impl(addressList);
        instance.writeToDisk("AddressBookV2WriteTest.txt");
        
        ArrayList<AddressBookV2_DTO> b = instance.readFromDisk("AddressBookV2WriteTest.txt");
      
        assertEquals("Joe", b.get(0).getfName());
        assertEquals("San Diego", b.get(1).getCity());
        assertEquals("OR", b.get(3).getState());

    }

    /**
     * Test of readFromDisk method, of class AddressBookV2Impl.
     */
    @Test
    public void testReadFromDisk() throws Exception {
        System.out.println("readFromDisk");

        AddressBookV2Impl instance = new AddressBookV2Impl(addressList);
        
        ArrayList<AddressBookV2_DTO> b = instance.readFromDisk("AddressBookV2test.txt");
      
        assertEquals("Joe", b.get(0).getfName());
        assertEquals("San Marcos", b.get(1).getCity());
        assertEquals("WA", b.get(3).getState());

    }
    
}

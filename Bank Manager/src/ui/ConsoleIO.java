package ui;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author parallels
 */
public class ConsoleIO {
    Scanner kb = new Scanner(System.in);
    public int getInt(String p) {
        boolean failed;
        int ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextInt();
                kb.nextLine();
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be an integer."); 
               failed = true;
               kb.nextLine();
            }
        }while (failed);
        return ret;
    }
    
    public int getInt(String p, int min, int max) {
        boolean failed;
        int ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextInt();
                kb.nextLine();
                if(ret < min || ret > max) {
                    System.out.println("Value must be between " + min 
                            + " and " + max + ".");
                    failed = true;
                }
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be an integer."); 
               failed = true;
               kb.nextLine();
            }
        }while (failed);
        
        return ret;
    }
    
    public String getString(String p) {
        System.out.print(p);
        return kb.nextLine();
    }
    
    public float getFloat(String p) {
        boolean failed;
        float ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextFloat();
                kb.nextLine();
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be a number."); 
               failed = true;
               kb.nextLine();
            }
        }while (failed);
        return ret;
    }  
    
    public float getFloat(String p, float min, float max) {
        boolean failed;
        float ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextFloat();
                kb.nextLine();
                if(ret < min || ret > max) {
                    System.out.println("Value must be between " + min 
                            + " and " + max + ".");
                    failed = true;
                }
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be a number."); 
               failed = true;
               kb.nextLine();
            }
        }while (failed);
        
        return ret;
    }
    
    public double getDouble(String p) {
        boolean failed;
        double ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextDouble();
                kb.nextLine();
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be a number."); 
               failed = true;
               kb.nextLine();
            }
        }while (failed);
        return ret;
    }
    
    public double getDouble(String p, double min, double max) {
        boolean failed;
        double ret = 0;
        do {
            failed = false;
            System.out.print(p);
            try {
                ret = kb.nextDouble();
                kb.nextLine();
                if(ret < min || ret > max) {
                    System.out.println("Value must be between " + min 
                            + " and " + max + ".");
                    failed = true;
                }
            } 
            catch (InputMismatchException e) {
               System.out.println("Input must be a number."); 
               failed = true;
               kb.nextLine();
            }
        }while (failed);
        
        return ret;
    }
    
    public void print(String p) {
        System.out.print(p);
    }
    
    public void printNewLine(String p) {
        System.out.println(p);
    }
    
    public void printDouble(double p) {
        System.out.println(p);
    }
}

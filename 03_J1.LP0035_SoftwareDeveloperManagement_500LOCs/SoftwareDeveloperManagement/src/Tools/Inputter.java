/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author Bui_Hai_Dang
 */
public class Inputter {

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("(dd/mm/yy): ");

    public String getString(String mess) {
        System.out.print(mess);
        return sc.nextLine();
    }

    public Double getDouble(String mess) {
        System.out.print(mess);
        return sc.nextDouble();
    }

    public String inputAndLoop(String mess, String pattern) {
        String m = "";
        boolean isTrue = false;
        do {
            m = getString(mess);
            isTrue = Acceptable.isValid(m, pattern);
             if (!isTrue) {
                System.out.println("Data is invalid. Please re-enter!");
            }
        } while (!isTrue);
        return m.trim();
    }
    
    public int IntAndLoop(String mess, String pattern) {
        String m = "";
        boolean isTrue = false;
        do {
            m = getString(mess);
            isTrue = Acceptable.isValid(m, pattern);
             if (!isTrue) {
                System.out.println("Data is invalid. Please re-enter!");
            }
        } while (!isTrue);
        return Integer.parseInt(m) ;
    }
}

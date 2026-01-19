/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tool;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author Bui_Hai_Dang
 */
public class Inputter {

    private Scanner sc;

    public Inputter() {
        sc = new Scanner(System.in);
    }

    public String getString(String mess) {
        System.out.print(mess);
        return sc.nextLine();
    }

    public int IntAndLoop(String mess, String pattern) {
        String temp = "";
        boolean isTrue = true;
        do {
            temp = getString(mess);
            isTrue = !Acceptable.isValid(temp, pattern);
            if (isTrue) {
                System.out.println("Data is invalid. Please re-enter!");
            }
        } while (isTrue);
        return Integer.parseInt(temp);
    }

    public String inputAndLoop(String mess, String pattern) {
        String res = "";
        boolean isTrue = true;
        do {
            res = getString(mess);
            isTrue = !Acceptable.isValid(res, pattern);
            if (isTrue) {
                System.out.println("Data is invalid. Please re-enter!");
            }
        } while (isTrue);
        return res.trim();
    }

    public Date getDate(String mess) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        while(true){
            String input = getString(mess + "(dd/MM/yyyy): ");
            if(input.isEmpty()) return null;
            try {
                return (Date) sdf.parse(input);
            } catch (ParseException e) {
                System.out.println("Date is inValid, please redo: ");
            }
        }
    }

}

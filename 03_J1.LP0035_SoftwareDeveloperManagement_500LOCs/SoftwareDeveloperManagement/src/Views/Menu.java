/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import Tools.Acceptable;
import Tools.Inputter;
import java.util.ArrayList;

/**
 *
 * @author Bui_Hai_Dang
 */
public class Menu extends ArrayList<String> {

    public Menu() {
        super();
    }
    
    public void addMenuItem(String e){
        this.add(e);
    }
    
    public int getUserChoice(){
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + ". " + this.get(i));
        }
        System.out.println("0. Exit");
        Inputter inputter = new Inputter();
        return inputter.IntAndLoop("Select your option: ",Acceptable.CHOICE_VALID);
    }
    
}

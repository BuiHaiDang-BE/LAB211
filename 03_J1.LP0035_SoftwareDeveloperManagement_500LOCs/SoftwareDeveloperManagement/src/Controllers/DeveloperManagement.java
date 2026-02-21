/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Bussiness.Developers;
import Bussiness.Projects;
import Tools.Acceptable;
import Tools.Inputter;

/**
 *
 * @author Bui_Hai_Dang
 */
public class DeveloperManagement {
    Developers listDev = new Developers();
    Projects listPro = new Projects();
    Inputter inputter = new Inputter();
    
    public void listAllDev(){
        listDev.showAll();
    }
    
    public void addNewDev(){
        String newID = inputter.inputAndLoop("Enter new idDev", Acceptable.ID_VALID);
        listDev.searchById(id);
        listDev.addNew(x);
    }
}

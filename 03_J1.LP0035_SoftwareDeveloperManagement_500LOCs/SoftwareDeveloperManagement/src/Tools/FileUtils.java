/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bui_Hai_Dang
 */
public class FileUtils {
    
    public static <T> List<T> readFile(String pathFile) {
        List<T> result = new ArrayList<>();
        File f = new File(pathFile);
        if (!f.exists()) {
            return result;
        }
        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                try {
                    T o = (T) ois.readObject();
                    result.add(o);
                } catch (EOFException o) {
                    System.out.println("Cannot read file");
                    break;
                }
            }
            
        } catch (Exception e) {
        }
        return result;
    }
    
    public static <T> void saveToFile(List<T> temp, String pathFile) {
        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathFile))) {
            for (T t : temp) {
                oos.writeObject(t);
            }
        } catch (Exception e) {
        }
    }
}

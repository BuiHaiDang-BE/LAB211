/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tool;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bui_Hai_Dang
 */
public class FileUtils {
    
    public static <T> List<T> readFile(String filePath) {
        List<T> result = new ArrayList<>();
        File f = new File(filePath);
        if (!f.exists()) return result;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                try {
                    T x = (T) ois.readObject();
                    result.add(x);
                } catch (EOFException e) {
                    break; 
                }
            }
        } catch (Exception e) {
            
        }
        return result;
    }
    
    
    
    public static <T> void saveToFile(List<T> li, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (T item : li) {
                oos.writeObject(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

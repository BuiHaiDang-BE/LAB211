/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business;

/**
 *
 * @author Bui_Hai_Dang
 */
import java.util.List;

public interface Workable<T> {

    void addNew(T x); // Thêm mới một đối tượng 

    void update(T x); // Cập nhật thông tin đối tượng 

    T searchById(String id);

    void showAll();
}

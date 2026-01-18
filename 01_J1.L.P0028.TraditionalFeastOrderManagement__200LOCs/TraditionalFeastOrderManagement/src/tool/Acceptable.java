/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tool;

/**
 *
 * @author Bui_Hai_Dang
 */
public interface Acceptable {
    public final String CUS_ID_VALID = "^[CcGgKk]\\d{4}$";
    public final String NAME_VALID = "^.{2,25}$";
    public final String PHONE_VALID = "^(03[2-9]|05[6|8|9]|07[0|6-9]|08[1-6|8|9]|09[0-9])\\d{7}$";
    public final String EMAIL_VALID = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    public final String POSITIVE_INT_VALID = "^[1-9]\\d*$";
    public final String CHOICE_VALID = "^[0-9]\\d*$";
    
    public static boolean isValid (String dataa, String pattern){
        return dataa!= null && dataa.matches(pattern);
    }
}

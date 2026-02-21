/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

/**
 *
 * @author Bui_Hai_Dang
 */
public interface Acceptable {

    public final String ID_VALID = "^DEV\\d{3}$";
    public final String NAME_VALID = "^[^\\s]+(\\s+[^\\s]+)+$";
    public final String PHONE_VALID = "^(03[2-9]|05[6|8|9]|07[0|6-9]|08[1-6|8|9]|09[0-9])\\d{7}$";
    public final String SALARY_VALID = "^[1-9]\\d{3,}$";
    public final String DURATION_VALID = "^[1-9]\\d*$";
    public final String CHOICE_VALID = "^[0-9]\\d*$";

    public static boolean isValid(String dataa, String pattern) {
        return dataa != null && dataa.matches(pattern);
    }
   
}

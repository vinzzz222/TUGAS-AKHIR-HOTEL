package controller;
import model.Hotel;
import entity.Staff;
public class Login {
    public static Staff staffLogged = null;


    public static boolean login(String kodeadmin, String password) {
        for (Staff staff : Hotel.daftarStaff) {
            if ((staff.kodeadmin.equals(kodeadmin)) && (staff.password.equals(password))) {
                staffLogged = staff;
                return true;
            }
        }
        return false;
    }

}

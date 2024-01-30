import gui.LoginFrame;
import model.Hotel;

public class App {
    public static void main(String[] args) {
        Hotel.initialData();
        new LoginFrame();

    }
}

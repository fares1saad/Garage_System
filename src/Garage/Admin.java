package Garage;
import java.lang.String.*;

public class Admin {
    private String name="fares";
    private String passWord ="1234";

    public Admin(){name = "fares";
    passWord="1234";}

    public boolean logIn(String em, String pass){
        if (name.equals(em) && passWord.equals(pass)){
            return true;
        }
        return false;
    }

}

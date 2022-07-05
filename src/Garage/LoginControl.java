package Garage;

public class LoginControl {
    private Admin admin;
    public LoginControl(){

        admin=new Admin();

    }

    public boolean adminMenu(String e,String p){
        return admin.logIn(e,p);}
}


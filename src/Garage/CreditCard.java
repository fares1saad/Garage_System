package Garage;

public class CreditCard {
    private final String Id ;
   private double balance;

    public CreditCard(String i,double b){
        Id=i;
        balance=b;
    }

    public boolean pay(double fee){
        if(fee<balance){
            balance-=fee;
            return true;
        }
        return false;

    }

    public String getId() {
        return Id;
    }

    public double getBalance() {
        return balance;
    }
}

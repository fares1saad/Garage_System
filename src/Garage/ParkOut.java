package Garage;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ParkOut {

    private double hourlyRate =5.0;
    private CardCompany company;

    public ParkOut(){
        company =new CardCompany();
        hourlyRate =5.0;
    }
    public double calculateFees(LocalTime time){
        LocalTime departure_time = LocalTime.now();
        return hourlyRate * (ChronoUnit.HOURS.between(time, departure_time) + 1);
    }

    public boolean checkout(double fee , String cardID){
       return company.Pay(cardID,fee);
    }



    public double getFee(){
        return hourlyRate;
    }

    public void setFee(double a) {
        hourlyRate = a;
    }

    public double getbalance(String id){
       return company.getBalance(id);
    }


}

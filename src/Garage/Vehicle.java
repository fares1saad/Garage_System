package Garage;

public class Vehicle {
    private String number;
    private double width;
    private double length;
    Dimensions dim;

   public Vehicle(String num,Dimensions d){
       number=num;
       dim=d;
   }
   public Vehicle(){}

    public Dimensions getDim(){
       return dim;
   }

    public String getNumber() {
        return number;
    }
}

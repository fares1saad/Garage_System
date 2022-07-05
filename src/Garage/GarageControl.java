package Garage;

import java.util.List;
import java.util.List;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
public class GarageControl {
    private ParkinGarage Garage;

    public GarageControl() {
        Garage = ParkinGarage.getInstance();
    }

    public void setMax(int a) {
        Garage.setMax(a);
    }

    public int getMax() {
        return Garage.getMax();
    }

    public List<Slot> getSlots() {
        return Garage.getSlots();
    }


    public void pickSlot(int id, Vehicle v, LocalTime time) {
        Garage.setSlotbyId(id, v, time);
    }

    public void setSlots(Dimensions dim, int n) {
        int c = n;
        while (c > 0) {
            if (!Garage.setSlots(dim))
                break;
            c--;
        }
        n = n - c;
        if (c == 0)
            System.out.println("Slots added successfully.");
        else
            System.out.println("only " + n + " have been added");
    }


    public LocalTime getTime(int id) {
        return Garage.getSlot(id).getTime();
    }

    public void free(int id) {
        Garage.getSlot(id).setState(false);
    }

    public Slot getSlot(int id) {
        return Garage.getSlot(id);
    }


    public void addToTotal(double fee) {
        Garage.addToTotal(fee);
    }
    public double getTotal(){
        return Garage.getTotal();
    }


}
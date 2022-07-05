package Garage;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ParkinGarage {

    private static ParkinGarage fes;
    private List<Slot> slots;
    private double totalIncome;
    private int MaxNumSlots;

    private ParkinGarage() {
        slots = new ArrayList<Slot>();
        MaxNumSlots = 0;
        totalIncome = 0;
    }

    public void setMax(int a) {
        MaxNumSlots = a;
        System.out.println("Max slots now " + MaxNumSlots);
    }


    public int getMax() {
        return MaxNumSlots;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public boolean setSlots(Dimensions dim) {
        if (slots.size() == MaxNumSlots) {
            return false;
        } else {
            Slot s = new Slot(dim);
            slots.add(s);
            return true;
        }
    }

//    public boolean searchVehicle(Vehicle v) {
//        return parkin.parkinCheck(v, slots);
//    }

    public void setSlotbyId(int id, Vehicle v, LocalTime time) {
        for (ListIterator<Slot> i = slots.listIterator(); i.hasNext(); ) {
            Slot searchSlot = i.next();
            if (id == searchSlot.getId()) {
                searchSlot.setVehicle(v);
                searchSlot.setState(true);
                searchSlot.setTime(time);
                i.set(searchSlot);
            }
        }
    }

    public Slot getSlot(int id) {
        for (ListIterator<Slot> i = slots.listIterator(); i.hasNext(); ) {
            Slot searchSlot = i.next();
            if (id == searchSlot.getId()) {
                return searchSlot;
            }
        }
        return null;
    }


    public void addToTotal(double fee) {
        totalIncome += fee;
    }

    public double getTotal() {
        return totalIncome;
    }


    public static ParkinGarage getInstance(){
        if(fes==null){
            return fes= new ParkinGarage();
        }
        else
            return fes;
    }



}
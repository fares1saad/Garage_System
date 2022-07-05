package Garage;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
public class Slot {
    static private int count =0;
    private boolean state;
    private Vehicle vehicle;

    private Dimensions dim;
    private LocalTime time;

    private final int Id;

    public Slot(boolean a, Vehicle v,Dimensions d) {
        state = a;
        vehicle = new Vehicle();
        vehicle = v;
        dim=d;
        Id=count;
        count++;

    }

    public Slot(Dimensions d) {
        dim =d;
        vehicle = new Vehicle();
        Id=count;
        count++;
    }




    public boolean isState() {
        return state;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isBigger(Dimensions d){

        return dim.CompareAll(d);
    }

    public boolean isSmaller(Dimensions d){

        return d.CompareAll(dim);
    }


    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getId() {
        return Id;
    }

    public LocalTime getTime() {
        return time;
    }

    public Dimensions getDim() {
        return dim;
    }

    public boolean  isAreaSmaller(Dimensions dim){
        return dim.CompareArea(this.dim);
    }


}

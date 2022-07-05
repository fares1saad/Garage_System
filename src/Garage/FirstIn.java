package Garage;

import java.util.List;

public class FirstIn implements Parkin {


    private Parkintype method;




    public int parkinCheck(Vehicle v, List<Slot> slots) {
        int id = -1;
        // for the first in first serve method
        for (Slot searchSlot : slots) {
            if (!searchSlot.isState()) {

                if (searchSlot.isBigger(v.getDim())) {
                    id = searchSlot.getId();
                    System.out.println("your slot ID is " + id + "\nGate is  Opening !!!  ");
                    //i.set(searchSlot);
                    return id;
                }

            }
        }
        System.out.println("there is no availabe slots" + "\nGate Opening !!!  ");
        return id;

    }


}

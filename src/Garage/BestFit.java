package Garage;

import java.util.List;
import java.util.ListIterator;

public class BestFit implements Parkin {

    private Parkintype method;

    public BestFit() {
        method = Parkintype.values()[0];
    }

    public void setMethod(int a) {
        method = Parkintype.values()[a - 1];
    }


    public int parkinCheck(Vehicle v, List<Slot> slots) {
        int id = -1;
        Dimensions mDim = new Dimensions(1000, 1000);
        for (Slot searchSlot : slots) {
            if (!searchSlot.isState()) {
                if (searchSlot.isBigger(v.getDim())) {
                    if (searchSlot.isSmaller(mDim)) {
                        mDim = searchSlot.getDim();
                        id = searchSlot.getId();
                    } else if (searchSlot.isAreaSmaller(mDim)) {
                        mDim = searchSlot.getDim();
                        id = searchSlot.getId();
                    }
                }

            }
        }

        if (id != -1)
            System.out.println("your slot ID is " + id + "\nGate Opening !!!  ");
        if (id == -1)
            System.out.println("there is no availabe slots \nthe Gate is still closed !! ");
        return id;
    }



}


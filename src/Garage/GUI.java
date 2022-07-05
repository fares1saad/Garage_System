package Garage;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
public class GUI {
    private final LoginControl log;
    private final GarageControl control;

    private Parkin park;

    private final ParkOut leave;

    public GUI() {
        control = new GarageControl();
        log = new LoginControl();
        park = new FirstIn();
        leave = new ParkOut();

    }


    public void defualtMenu(){
        Scanner in = new Scanner(System.in);
        String myString;
        String myString2;

        System.out.println("Enter your selection:\n1 for Admin Options\n2 for Parking Options\n3 exit");
        int option = in.nextInt();

        if(option==1) {
            boolean x;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your EMAIL");
            myString = input.next();
            System.out.println("Enter your password");
            myString2 = input.next();
            x= log.adminMenu(myString,myString2);


            if(x){
                this.adminMenu();
            }
            else {
                System.out.println("Wrong email or password ");
                this.defualtMenu();
            }
        }

        else if (option==2){
            this.parkingOptions();
        }

    }

                    //Admin menu
    private void adminMenu() {
        Scanner in = new Scanner(System.in);
        Scanner dim = new Scanner(System.in);
        Scanner fee = new Scanner(System.in);


        boolean i = true;
        while (i) {
            System.out.println("""
                    Enter your selection:
                    1 to set max number of slots
                    2 for choose Parking method
                    3 to view slots\s
                    4 to add slots dimensions\s
                    5 to set the hourly rate \s
                    6 to get the total income
                    7 exit""");
            int adminOption = in.nextInt();


            if (adminOption == 1) {
                System.out.print("enter the max number of slots : ");
                int max = in.nextInt();
                control.setMax(max);
            }


            else if (adminOption == 2) {
                System.out.println("1 for first in first serve\n2 for best slot\nany number to start over");
                int method = in.nextInt();

                if (method == 1) {
                    park=new FirstIn();
                }
                else if(method==2){
                    park=new BestFit();
                }

            }
            else if (adminOption == 3) {
                List<Slot> listSlots = control.getSlots();
                int p = 1;

                if (listSlots.isEmpty()) {
                    System.out.println("No slots have been added to the Garage.");
                } else {
                    for (Iterator k = listSlots.iterator(); k.hasNext(); ) {
                        Slot slot = (Slot) k.next();
                        System.out.print(p + ". " +
                                slot.getDim().getLength() + " x " + slot.getDim().getWidth() + "  " +
                                slot.isState() + " \t");
                        p++;
                        if ((p-1) % 5 == 0) {
                            System.out.println(" ");
                        }
                    }
                    System.out.println(" ");
                }

            } else if (adminOption == 4) {


                System.out.println("enter the slot length ");
                double l = dim.nextDouble();
                System.out.println("enter the slot width ");
                double w = dim.nextDouble();
                System.out.println("number off slots u like to add ");
                int numberSlots = in.nextInt();
                Dimensions sDim= new Dimensions(l,w);
                control.setSlots(sDim, numberSlots);


            }
            else if (adminOption == 5) {
                System.out.println("enter your desired hourly rate ");
                double rate = fee.nextDouble();
                leave.setFee(rate);
            }
            else if (adminOption == 6) {
                System.out.println("the Total income is "+ control.getTotal());

            }
            else
                i = false;


        }
        this.defualtMenu();

    }

    public void parkingOptions() {

        Scanner in = new Scanner(System.in);
        Scanner dim = new Scanner(System.in);
        Scanner id = new Scanner(System.in);



        System.out.println("""
                Enter your selection:
                1 to Park in
                2 to Park out
                any number to exit""");
        int function = in.nextInt();

        if (function == 1) {
            System.out.println("enter the vehicle length ");
            double l = dim.nextDouble();
            System.out.println("enter the vehicle width ");
            double w = dim.nextDouble();
            System.out.println("enter the vehicle number ");
            String n = dim.next();
            Dimensions vDim = new Dimensions(l,w);
            Vehicle costumerVehicle= new Vehicle(n,vDim);

            int ID =park.parkinCheck(costumerVehicle ,control.getSlots());
            if(ID != -1) {
                LocalTime arrival_time;
                arrival_time = LocalTime.now();
                control.pickSlot(ID, costumerVehicle, arrival_time);
                System.out.println("YOU CAN PASS !!");

            }

            this.defualtMenu();
        }
        else if(function == 2){
            System.out.println("enter the Slot number ");
            int Id = id.nextInt();
            if(control.getSlot(Id).isState() && control.getSlot(Id)!=null) {
                double fee = leave.calculateFees(control.getTime(Id));
                System.out.println("your total fee is " + fee);
                System.out.println("enter your card number");
                String cardNum = id.next();
                if (leave.checkout(fee, cardNum)) {
                    System.out.println("Transaction completed");
                    System.out.println(leave.getbalance(cardNum));
                    control.free(Id);
                    System.out.println("YOU Can Open the Gate!!");
                    control.addToTotal(fee);


                }
                else {
                    System.out.println("the Card declined ");
                    System.out.println("GATE IS STILL CLOSED Sorry u Cant pass !!! ");
                }
            }
            else{
                System.out.println("Slot is empty or don't exist!!! ");

            }

            this.defualtMenu();

        }
        else
            this.defualtMenu();


    }
}

package Garage;
enum Parkintype{
    FIRSTIN,BESTSLOT;

    @Override
    public String toString() {
        switch (this){
            case FIRSTIN :return "firstin";
            case BESTSLOT:return "bestslot";
            default:return "";
        }
    }
}

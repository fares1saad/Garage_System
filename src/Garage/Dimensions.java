package Garage;

public class Dimensions {
    private double length ;
    private double width;

    public Dimensions(double l,double w){
        length=l;
        width=w;
    }

    public double getLength() {
        return length;
    }

    public double getWidth(){
        return width;
    }

    public boolean CompareAll(Dimensions a){
        return (this.length >= a.length) && (this.width >= a.width) ;
    }

    public boolean Compareone(Dimensions a){
        return (this.length >= a.length) || (this.width >= a.width) ;
    }

    public boolean CompareArea(Dimensions a){
        return (this.length * this.width) >= (a.width * a.length) ;
    }

}

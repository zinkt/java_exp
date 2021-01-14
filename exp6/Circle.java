package exp6;

public class Circle extends GeometricObj{
    private int id=0;
    private double radius=0;
    public Circle(int id,double r){
        this.id=id;
        radius=r;
    }
    @Override
    public double getArea(){return Math.PI*radius*radius;}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public String toString() {
        String intro = ""+getId()+", Circle, "+getArea();
        return intro;
    }

}

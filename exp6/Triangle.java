package exp6;

public class Triangle extends GeometricObj {
    private int id;
    private double a;
    private double b;
    private double c;
    public Triangle(int id,double a,double b,double c){
        this.id=id;
        this.a=a;
        this.b=b;
        this.c=c;
    }
    @Override
    public double getArea() {
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    public int getId() {
        return id;
    }
    public void setA(double a) {
        this.a = a;
    }
    public void setB(double b) {
        this.b = b;
    }
    public void setC(double c) {
        this.c = c;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return ""+getId()+", Triangle, "+getArea();
    }

}

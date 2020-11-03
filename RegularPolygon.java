public class RegularPolygon
{
    //data
    private int n = 3;
    private double sideLength = 1;
    private double x = 0,y = 0;
    //constructor
    public RegularPolygon(){};
    public RegularPolygon(int n,double sideLength)
    {
        this.n = n;
        this.sideLength = sideLength;
    }
    public RegularPolygon(int n,double sideLength,double x,double y)
    {
        this.n = n;
        this.sideLength = sideLength;
        this.x = x;
        this.y = y;
    }
    //******func******

    //accessor and mutator
    public int getN(){return n;}
    public void setN(int n){this.n = n;}
    public double getSideLength(){return sideLength;}
    public void setSideLength(double sideLength){this.sideLength = sideLength;}
    public double getX(){return x;}
    public double getY(){return y;}
    public void setX(double x){this.x = x;}
    public void setY(double y){this.y = y;}
    //other
    public double getPerimeter(){return n*sideLength;}
    public double getArea(){return n*getSideLength()*getSideLength()/(4*Math.tan((Math.PI/n)));}

    public static void main(String[] args)
    {
        RegularPolygon rp1 = new RegularPolygon();
        RegularPolygon rp2 = new RegularPolygon(6,2.0);
        RegularPolygon rp3 = new RegularPolygon(4,3.0,1,1);
        System.out.printf("The perimeter and the area of the"+
        "first polygon are %4.2f and %4.2f\n",rp1.getPerimeter(),rp1.getArea());
        System.out.printf("The perimeter and the area of the"+
        "second polygon are %4.2f and %4.2f\n",rp2.getPerimeter(),rp2.getArea());
        System.out.printf("The perimeter and the area of the"+
        "third polygon are %4.2f and %4.2f\n",rp3.getPerimeter(),rp3.getArea());
        
    }
}

package exp5;

import java.util.Scanner;

public class Triangle {
    double side1 = 1.0;
    double side2 = 1.0;
    double side3 = 1.0;

    public Triangle() {
    };

    public Triangle(double s1, double s2, double s3) throws IllegalTriangleException {
        if (s1 + s2 <= s3) {
            throw new IllegalTriangleException("side1 + side2 <= side3");
        } else if (s1 + s3 <= s2) {
            throw new IllegalTriangleException("side1 + side3 <= side2");
        } else if (s2 + s3 <= s1) {
            throw new IllegalTriangleException("side2 + side3 <= side1");
        } else {
            side1 = s1;
            side2 = s2;
            side3 = s3;
        }
    }

    public double getArea() {
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }
    
    public double getside1(){return side1;}    
    public double getside2(){return side2;}    
    public double getside3(){return side3;}    
    public void setside1(double s1){side1 = s1;}    
    public void setside2(double s2){side2 = s2;}    
    public void setside3(double s3){side3 = s3;}
    public String toString()
    {
        return "Triangle: ["+side1+", "+side2+", "+side3+"]; Perimeter: "+(getside1()+getside2()+getside3())+ "; Area: "+getArea();
    }    
    
    //为什么这里的static的main函数可以调用不是静态的构造函数
    public static void main(String[] args) throws IllegalTriangleException{
        Scanner input = new Scanner(System.in);
        System.out.print("Please input side1 of the triangle:");
        double a = input.nextDouble();
        System.out.print("Please input side2 of the triangle:");
        double b = input.nextDouble();
        System.out.print("Please input side3 of the triangle:");
        double c = input.nextDouble();
        Triangle tri = new Triangle(a,b,c);
        System.out.println(tri.toString());
        input.close();
    }
}

class IllegalTriangleException extends Exception {
    private static final long serialVersionUID = 1L;

    public IllegalTriangleException(String msg) {
        super(msg);
    }
}
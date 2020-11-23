package exp5;
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

}

class IllegalTriangleException extends Exception {
    private static final long serialVersionUID = 1L;

    public IllegalTriangleException(String msg) {
        super(msg);
    }
}
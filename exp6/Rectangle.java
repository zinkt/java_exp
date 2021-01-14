package exp6;

public class Rectangle extends GeometricObj {
    private int id;
    private double width;
    private double height;

    public Rectangle(int id, double w, double h) {
        this.id = id;
        width = w;
        height = h;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    public int getId() {
        return id;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        String intro = ""+getId() + ", Rectangle, " + getArea();
        return intro;
    }

}

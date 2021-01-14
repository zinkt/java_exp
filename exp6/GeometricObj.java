package exp6;

public abstract class GeometricObj implements Comparable<GeometricObj> {
    public abstract double getArea();
    @Override
    public int compareTo(GeometricObj g) {
        if (this.getArea() < g.getArea())
            return -1;
        else if (this.getArea() == g.getArea())
            return 0;
        else
            return 1;
    }
}

public class Triangle extends Shape {

    private Coordinates pointB;
    private Coordinates pointC;

    public Triangle(Coordinates pointA, Coordinates pointB, Coordinates pointC) {
        super(3, pointA);
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public double getArea() {
        double a = position.distance(pointB);
        double b = pointB.distance(pointC);
        double c = pointC.distance(position);
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double getPerimeter() {
        double a = position.distance(pointB);
        double b = pointB.distance(pointC);
        double c = pointC.distance(position);
        return a + b + c;
    }

    public void translate(int dx, int dy) {
        position.translate(dx, dy);
        pointB.translate(dx, dy);
        pointC.translate(dx, dy);
    }

    public void scale(int factor, boolean sign) {
        position.scale(factor, sign);
        pointB.scale(factor, sign);
        pointC.scale(factor, sign);
    }

    public String display() {
        return "Triangle vertices:\n" +
                "A: " + position.display() + "\n" +
                "B: " + pointB.display() + "\n" +
                "C: " + pointC.display();
    }
}

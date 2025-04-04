public class Circle extends Shape {

    private double radius;

    public Circle(Coordinates position, double radius) {
        super(0, position);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public void scale(int factor, boolean sign) {
        if (sign) {
            radius = radius * factor;
        } else {
            radius = radius / factor;
        }
    }

    public String display() {
        return "Circle at " + position.display() + ", Radius = " + radius;
    }
}

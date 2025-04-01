public class Square extends Shape {
    private int side;

    // Constructor
    public Square(Coordinates coord, int side) {
        super(4, coord); // A square always has 4 sides
        this.side = side;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) {
            this.side *= factor;
        } else {
            this.side /= factor;
        }
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String display() {
        return "Square at " + position.display() + ", Side: " + side;
    }
}
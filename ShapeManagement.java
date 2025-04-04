import java.util.Scanner;

public class ShapeManagement {

    private final Scanner scanner;
    private final ShapeList shapeList;

    public ShapeManagement() {
        scanner = new Scanner(System.in);
        shapeList = new ShapeList();

        shapeList.addShape(new Rectangle(new Coordinates(10, 20), 5, 8));
        shapeList.addShape(new Square(new Coordinates(30, 30), 10));
        shapeList.addShape(new Circle(new Coordinates(50, 50), 12));
        shapeList.addShape(new Triangle(
                new Coordinates(0, 0),
                new Coordinates(0, 10),
                new Coordinates(10, 0)
        ));
    }

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addShape();
                case 2 -> removeShape();
                case 3 -> showShapeInfo();
                case 4 -> showAreaAndPerimeter();
                case 5 -> displayAll();
                case 6 -> translateShapes();
                case 7 -> scaleShapes();
                case 8 -> setCoordinates();
                case 0 -> running = false;
            }
        }
    }

    private void printMenu() {
        System.out.println("\n1. Add shape");
        System.out.println("2. Remove shape");
        System.out.println("3. View shape");
        System.out.println("4. Area and perimeter");
        System.out.println("5. Display all");
        System.out.println("6. Translate all");
        System.out.println("7. Scale all");
        System.out.println("8. Set shape coordinates");
        System.out.println("0. Exit");
        System.out.print("Select: ");
    }

    private void addShape() {
        System.out.println("1-Rectangle 2-Square 3-Circle 4-Triangle");
        int type = scanner.nextInt();

        System.out.print("X: ");
        int x = scanner.nextInt();
        System.out.print("Y: ");
        int y = scanner.nextInt();

        switch (type) {
            case 1 -> {
                int w = scanner.nextInt();
                int h = scanner.nextInt();
                shapeList.addShape(new Rectangle(new Coordinates(x, y), w, h));
            }
            case 2 -> {
                int s = scanner.nextInt();
                shapeList.addShape(new Square(new Coordinates(x, y), s));
            }
            case 3 -> {
                double r = scanner.nextDouble();
                shapeList.addShape(new Circle(new Coordinates(x, y), r));
            }
            case 4 -> {
                int x2 = scanner.nextInt(), y2 = scanner.nextInt();
                int x3 = scanner.nextInt(), y3 = scanner.nextInt();
                shapeList.addShape(new Triangle(
                        new Coordinates(x, y),
                        new Coordinates(x2, y2),
                        new Coordinates(x3, y3)
                ));
            }
        }
    }

    private void removeShape() {
        int i = scanner.nextInt();
        shapeList.removeShape(i);
    }

    private void showShapeInfo() {
        int i = scanner.nextInt();
        Shape s = shapeList.getShape(i);
        if (s != null) System.out.println(s.display());
    }

    private void showAreaAndPerimeter() {
        int i = scanner.nextInt();
        System.out.println("Area: " + shapeList.area(i));
        System.out.println("Perimeter: " + shapeList.perimeter(i));
    }

    private void displayAll() {
        System.out.println(shapeList.display());
    }

    private void translateShapes() {
        int dx = scanner.nextInt();
        int dy = scanner.nextInt();
        shapeList.translateShapes(dx, dy);
    }

    private void scaleShapes() {
        int factor = scanner.nextInt();
        boolean sign = scanner.nextBoolean();
        shapeList.scale(factor, sign);
    }

    private void setCoordinates() {
        int index = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Shape s = shapeList.getShape(index);
        if (s != null) {
            s.setCoordinates(new Coordinates(x, y));
        }
    }
}

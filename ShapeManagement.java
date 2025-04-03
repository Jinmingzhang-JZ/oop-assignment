import java.util.Scanner;

public class ShapeManagement {

    private final Scanner scanner;
    private final ShapeList shapeList;

    public ShapeManagement() {
        scanner = new Scanner(System.in);
        shapeList = new ShapeList();
    }

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (option) {
                case 1 -> addShape();
                case 2 -> removeShape();
                case 3 -> showShapeInfo();
                case 4 -> showAreaAndPerimeter();
                case 5 -> displayAll();
                case 6 -> translateShapes();
                case 7 -> scaleShapes();
                case 0 -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }

        System.out.println("Program ended.");
    }

    private void printMenu() {
        System.out.println("\n-- Shape Management --");
        System.out.println("1. Add shape");
        System.out.println("2. Remove shape");
        System.out.println("3. View shape");
        System.out.println("4. Area and perimeter");
        System.out.println("5. Display all shapes");
        System.out.println("6. Translate shapes");
        System.out.println("7. Scale shapes");
        System.out.println("0. Exit");
        System.out.print("Select: ");
    }

    private void addShape() {
        System.out.println("1-Rectangle  2-Square  3-Circle  4-Triangle");
        int type = scanner.nextInt();

        System.out.print("X: ");
        int x = scanner.nextInt();
        System.out.print("Y: ");
        int y = scanner.nextInt();

        switch (type) {
            case 1 -> {
                System.out.print("Width: ");
                int w = scanner.nextInt();
                System.out.print("Height: ");
                int h = scanner.nextInt();
                shapeList.addShape(new Rectangle(new Coordinates(x, y), w, h));
            }
            case 2 -> {
                System.out.print("Side: ");
                int s = scanner.nextInt();
                shapeList.addShape(new Square(new Coordinates(x, y), s));
            }
            case 3 -> {
                System.out.print("Radius: ");
                double r = scanner.nextDouble();
                shapeList.addShape(new Circle(new Coordinates(x, y), r));
            }
            case 4 -> {
                System.out.print("X2 Y2: ");
                int x2 = scanner.nextInt(), y2 = scanner.nextInt();
                System.out.print("X3 Y3: ");
                int x3 = scanner.nextInt(), y3 = scanner.nextInt();
                shapeList.addShape(new Triangle(
                        new Coordinates(x, y),
                        new Coordinates(x2, y2),
                        new Coordinates(x3, y3)
                ));
            }
            default -> System.out.println("Invalid shape type.");
        }
    }

    private void removeShape() {
        System.out.print("Index to remove: ");
        int idx = scanner.nextInt();
        shapeList.removeShape(idx);
    }

    private void showShapeInfo() {
        System.out.print("Shape index: ");
        int idx = scanner.nextInt();
        Shape s = shapeList.getShape(idx);
        if (s != null) {
            System.out.println(s.display());
        } else {
            System.out.println("Not found.");
        }
    }

    private void showAreaAndPerimeter() {
        System.out.print("Shape index: ");
        int idx = scanner.nextInt();
        System.out.println("Area: " + shapeList.area(idx));
        System.out.println("Perimeter: " + shapeList.perimeter(idx));
    }

    private void displayAll() {
        System.out.println(shapeList.display());
    }

    private void translateShapes() {
        System.out.print("dx: ");
        int dx = scanner.nextInt();
        System.out.print("dy: ");
        int dy = scanner.nextInt();
        shapeList.translateShapes(dx, dy);
    }

    private void scaleShapes() {
        System.out.print("Factor: ");
        int factor = scanner.nextInt();
        System.out.print("Scale up? (true/false): ");
        boolean sign = scanner.nextBoolean();
        shapeList.scale(factor, sign);
    }
}

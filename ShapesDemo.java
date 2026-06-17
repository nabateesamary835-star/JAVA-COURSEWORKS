package Shapes;

/**
 * Driver class to demonstrate the Shape hierarchy.
 * Shows polymorphism, dynamic binding, and exception handling.
 */
public class ShapesDemo {

    /**
     * Prints the area of each shape through the superclass reference (dynamic binding).
     * @param shapes array of Shape objects
     */
    public static void printAreas(Shape[] shapes) {
        System.out.println("===== Shape Areas =====");
        for (Shape shape : shapes) {
            String type = shape.getClass().getSimpleName();
            System.out.println(type + " area = " + String.format("%.2f", shape.getArea()));
        }
    }

    /**
     * Finds and returns the shape with the largest area.
     * @param shapes array of Shape objects
     * @return the shape with the largest area
     */
    public static Shape largest(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) {
            return null;
        }
        Shape biggest = shapes[0];
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > biggest.getArea()) {
                biggest = shapes[i];
            }
        }
        return biggest;
    }

    public static void main(String[] args) {
        try {
            // Create shapes
            Circle circle = new Circle(5.0, "red", true);
            Rectangle rect = new Rectangle(4.0, 6.0, "blue", false);
            Triangle tri = new Triangle(3.0, 4.0, 5.0, "green", true);

            Shape[] shapes = {circle, rect, tri};

            // Print areas using dynamic binding
            printAreas(shapes);

            // Find the largest shape
            Shape maxShape = largest(shapes);
            System.out.println("\nLargest shape: " + maxShape);
            System.out.println("Largest area: " + String.format("%.2f", maxShape.getArea()));

            // Demonstrate resize
            System.out.println("\n===== After Resizing (factor=2) =====");
            circle.resize(2.0);
            rect.resize(2.0);
            tri.resize(2.0);
            printAreas(shapes);

            // Demonstrate exception handling
            System.out.println("\n===== Exception Handling Demo =====");
            try {
                Triangle badTriangle = new Triangle(1.0, 2.0, 10.0);
            } catch (InvalidShapeException e) {
                System.out.println("Caught: " + e.getMessage());
            }

            try {
                Circle badCircle = new Circle(-3.0);
            } catch (InvalidShapeException e) {
                System.out.println("Caught: " + e.getMessage());
            }

            try {
                circle.resize(-1.0);
            } catch (InvalidShapeException e) {
                System.out.println("Caught: " + e.getMessage());
            }

        } catch (InvalidShapeException e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}

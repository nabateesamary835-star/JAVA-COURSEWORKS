package Shapes;

/**
 * Represents a triangle, a subclass of Shape.
 * Validates that three sides satisfy the triangle inequality.
 */
public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    /**
     * Creates a triangle with three sides.
     * @param side1 first side (must be positive)
     * @param side2 second side (must be positive)
     * @param side3 third side (must be positive)
     * @throws InvalidShapeException if any side is non-positive or triangle inequality is violated
     */
    public Triangle(double side1, double side2, double side3) {
        super();
        validateAndSet(side1, side2, side3);
    }

    /**
     * Creates a triangle with three sides, color, and filled status.
     * @param side1 first side
     * @param side2 second side
     * @param side3 third side
     * @param color the color
     * @param filled whether filled
     * @throws InvalidShapeException if any side is non-positive or triangle inequality is violated
     */
    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        validateAndSet(side1, side2, side3);
    }

    /**
     * Validates sides and sets them if valid.
     */
    private void validateAndSet(double s1, double s2, double s3) {
        if (s1 <= 0) {
            throw new InvalidShapeException("Side 1 must be positive. Got: " + s1);
        }
        if (s2 <= 0) {
            throw new InvalidShapeException("Side 2 must be positive. Got: " + s2);
        }
        if (s3 <= 0) {
            throw new InvalidShapeException("Side 3 must be positive. Got: " + s3);
        }
        if (s1 + s2 <= s3 || s1 + s3 <= s2 || s2 + s3 <= s1) {
            throw new InvalidShapeException("Triangle inequality violated: sides " + s1 + ", " + s2 + ", " + s3 + " cannot form a triangle");
        }
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }

    public double getSide1() { return side1; }
    public void setSide1(double side1) { this.side1 = side1; }

    public double getSide2() { return side2; }
    public void setSide2(double side2) { this.side2 = side2; }

    public double getSide3() { return side3; }
    public void setSide3(double side3) { this.side3 = side3; }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive. Got: " + factor);
        }
        this.side1 *= factor;
        this.side2 *= factor;
        this.side3 *= factor;
    }

    @Override
    public String toString() {
        return "Triangle [Sides=(" + side1 + ", " + side2 + ", " + side3 + "), " + super.toString() + "]";
    }
}

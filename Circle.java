package Shapes;

/**
 * Represents a circle, a subclass of Shape.
 */
public class Circle extends Shape {
    private double radius;

    /**
     * Creates a circle with the given radius.
     * @param radius the radius of the circle (must be positive)
     * @throws InvalidShapeException if radius is non-positive
     */
    public Circle(double radius) {
        super();
        if (radius <= 0) {
            throw new InvalidShapeException("Radius must be positive. Got: " + radius);
        }
        this.radius = radius;
    }

    /**
     * Creates a circle with radius, color, and filled status.
     * @param radius the radius
     * @param color the color
     * @param filled whether filled
     * @throws InvalidShapeException if radius is non-positive
     */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        if (radius <= 0) {
            throw new InvalidShapeException("Radius must be positive. Got: " + radius);
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive. Got: " + factor);
        }
        this.radius *= factor;
    }

    @Override
    public String toString() {
        return "Circle [Radius=" + radius + ", " + super.toString() + "]";
    }
}

package Shapes;

/**
 * Represents a rectangle, a subclass of Shape.
 */
public class Rectangle extends Shape {
    private double width;
    private double height;

    /**
     * Creates a rectangle with the given width and height.
     * @param width the width (must be positive)
     * @param height the height (must be positive)
     * @throws InvalidShapeException if width or height is non-positive
     */
    public Rectangle(double width, double height) {
        super();
        if (width <= 0) {
            throw new InvalidShapeException("Width must be positive. Got: " + width);
        }
        if (height <= 0) {
            throw new InvalidShapeException("Height must be positive. Got: " + height);
        }
        this.width = width;
        this.height = height;
    }

    /**
     * Creates a rectangle with dimensions, color, and filled status.
     * @param width the width
     * @param height the height
     * @param color the color
     * @param filled whether filled
     * @throws InvalidShapeException if width or height is non-positive
     */
    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        if (width <= 0) {
            throw new InvalidShapeException("Width must be positive. Got: " + width);
        }
        if (height <= 0) {
            throw new InvalidShapeException("Height must be positive. Got: " + height);
        }
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive. Got: " + factor);
        }
        this.width *= factor;
        this.height *= factor;
    }

    @Override
    public String toString() {
        return "Rectangle [Width=" + width + ", Height=" + height + ", " + super.toString() + "]";
    }
}

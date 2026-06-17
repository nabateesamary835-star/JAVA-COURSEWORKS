package Shapes;

/**
 * Abstract class representing a geometric shape.
 * Demonstrates abstraction and polymorphism through abstract methods.
 */
public abstract class Shape {
    protected String color;
    protected boolean filled;

    /**
     * Default constructor - white and unfilled.
     */
    public Shape() {
        this.color = "white";
        this.filled = false;
    }

    /**
     * Constructor with color and filled status.
     * @param color the color of the shape
     * @param filled whether the shape is filled
     */
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /**
     * Calculates the area of the shape.
     * @return the area
     */
    public abstract double getArea();

    /**
     * Calculates the perimeter of the shape.
     * @return the perimeter
     */
    public abstract double getPerimeter();

    /**
     * Resizes the shape by scaling its dimensions by the given factor.
     * @param factor the scale factor (must be positive)
     * @throws InvalidShapeException if the factor is not positive
     */
    public abstract void resize(double factor);

    // Getters and Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Shape [Color=" + color + ", Filled=" + filled + "]";
    }
}

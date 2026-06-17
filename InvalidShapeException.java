package Shapes;

/**
 * Custom exception thrown when a shape has invalid dimensions.
 * This is an unchecked (runtime) exception because invalid shape creation
 * is a programming error that should be caught during development.
 */
public class InvalidShapeException extends RuntimeException {
    /**
     * Creates an InvalidShapeException with the given message.
     * @param message description of the invalid dimension
     */
    public InvalidShapeException(String message) {
        super(message);
    }
}

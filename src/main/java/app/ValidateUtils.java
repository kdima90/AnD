package app;

import static java.lang.String.format;

/**
 * This class is responsible for validation.
 * */
public final class ValidateUtils {
    private ValidateUtils() {}

    /**
     * <p>This method will validate the given value. If invalid {@code IllegalArgumentException} will be thrown.</p>
     *
     * @param value to be validated
     * @exception IllegalArgumentException if {@code value} is invalid
     * */
    public static void isGreaterThanOne(int value){
        if(value < 1){
            throw new IllegalArgumentException(
                    format("Size should greater then zero! I have currently '%d' ", value));
        }
    }
}

package com.maeruiz.uagrmapp.Exceptions;

/**
 * Created by maelyruiz on 5/22/17.
 */

public class MoodleRestException extends Exception {

    public static final String NO_LEGACY="There is no legacy call for this webservice";

    public static final String AUTH_NULL="No credential provided";

    public static final String REQUIRED_PARAMETER="Parameter is required";

    public static final String PARAMETER_RANGE="Parameter in not within an accepted range";

    public static final String PARAMETER_CANNOT_BE_NULL="Parameter cannot be null";

    public MoodleRestException() {}

    public MoodleRestException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

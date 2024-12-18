package com.maeruiz.uagrmapp.Exceptions;

import java.io.Serializable;

/**
 * Created by maelyruiz on 5/22/17.
 */

public class MoodleRestCourseException extends MoodleRestException implements Serializable {
    public static final String NO_LEGACY_CALL="No legacy call";

    public MoodleRestCourseException() {}

    MoodleRestCourseException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

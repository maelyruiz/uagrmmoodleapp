package com.maeruiz.uagrmapp.Formats;

import java.io.Serializable;

/**
 * Created by maelyruiz on 5/22/17.
 */

public enum DescriptionFormat implements Serializable {
    MOODLE(0),
    HTML(1),
    PLAIN(2),
    MARKDOWN(4);

    private Integer value;

    private DescriptionFormat(Integer value) {
        this.value=value;
    }

    public Integer toInt() {
        return value;
    }
}

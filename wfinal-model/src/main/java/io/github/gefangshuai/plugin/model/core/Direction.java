package io.github.gefangshuai.plugin.model.core;

/**
 * Created by gefangshuai on 2015/7/7.
 */
public enum Direction {
    DESC("desc"), ASC("asc");

    private String direction;

    public String getDirection() {
        return direction;
    }

    Direction(String direction) {
        this.direction = direction;
    }
}

package fr.amani.entities;

import lombok.Getter;

@Getter
public enum Orientation {
    NORTH("N", "W", "E"),
    SOUTH("S", "E", "W"),
    EAST("E", "N", "S"),
    WEST("W", "S", "N");
    private final String basic;
    private final String left;
    private final String right;

    Orientation(String basic, String left, String right) {
        this.basic = basic;
        this.left = left;
        this.right = right;
    }

    public Orientation getRightOrientation() {
        return getOrientationValue(right);
    }

    public Orientation getLeftOrientation() {
        return getOrientationValue(left);
    }

    public static Orientation getOrientationValue(String basic) {
        for (Orientation orientation : Orientation.values()) {
            if (basic.equals(orientation.getBasic())) {
                return orientation;
            }
        }
        return null;
    }
}

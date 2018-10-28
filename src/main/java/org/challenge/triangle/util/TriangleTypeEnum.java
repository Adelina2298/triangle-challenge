package org.challenge.triangle.util;

public enum TriangleTypeEnum {
    EQUILATERAL("Ecquilateral"),
    ISOSCELES("Isosceles"),
    SCALENE("Scalene");

    private String value;

    TriangleTypeEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}

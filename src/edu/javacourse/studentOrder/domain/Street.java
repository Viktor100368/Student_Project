package edu.javacourse.studentOrder.domain;

public class Street {
    private long streetCode;
    private String streetName;

    public Street() {
    }

    public Street(long streetCode, String streetName) {
        this.streetCode = streetCode;
        this.streetName = streetName;
    }

    public long getStreetCode() {
        return streetCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetCode(int streetCode) {
        this.streetCode = streetCode;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}

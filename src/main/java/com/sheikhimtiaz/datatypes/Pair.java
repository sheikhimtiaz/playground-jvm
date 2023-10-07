package com.sheikhimtiaz.datatypes;

public class Pair {
    public int x;
    public int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "X: " + this.x + ", Y: " + this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Pair)) {
            return false;
        }

        Pair c = (Pair) obj;

        return x == c.x && y == c.y;
    }
}

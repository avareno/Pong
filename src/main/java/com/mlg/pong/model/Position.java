package com.mlg.pong.model;

public class Position {
    private int x;
    private int y;


    public Position() {
        this.x = 10;
        this.y = 10;
    }
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return x == p.getX() && y == p.getY();
    }

    public int compareTo(Position position) {
        if (x > position.getX()) {
            return 1;
        } else if (x < position.getX()) {
            return -1;
        } else if (y > position.getY()) {
            return 1;
        } else if (y < position.getY()) {
            return -1;
        } else {
            return 0;
        }
    }
}

package com.inheri;

public class Bicycle {
    int speed;
    int gear;

    public Bicycle(int startspeed, int startgear) {
        speed = startspeed;
        gear = startgear;
    }

    private void applyBreak(int breakvalue) {

        speed -= breakvalue;
        speedUp(8);
    }

    private void speedUp(int speedvalue) {
        System.out.println("Speed: " + speedvalue);
        speed += speedvalue;

    }

    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle(5, 5);
        bicycle.speedUp(5);
    }
}

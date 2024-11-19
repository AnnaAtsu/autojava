package org.example;

public class Main {
    public static void main(String[] args) {
        Triangle perimetr = new Triangle(5.0, 5.0, 5.0);
        System.out.println("Triangle perimetr is " + perimetr.getPerimetr());
        System.out.println("Triangle area is " + perimetr.getArea());
    }
}
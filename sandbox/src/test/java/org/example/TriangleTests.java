package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTests {

    @Test
    void Calculateperiment() {
        Triangle triangle = new Triangle(5, 5, 5);
        double result = triangle.getPerimetr();
        assertEquals(15, result);
    }

    @Test
    void Calculatesquare() {
        Triangle triangle = new Triangle(5, 5, 5);
        var area = triangle.getArea();
        Assertions.assertEquals(10.825317547305483, area);
    }

    @Test
    void TriangleWithNegativeSide() {
        try {
            new Triangle(5, -5, 5);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("One of the side is negative!!");
        }
    }

    @Test
    void TriangleSumIsLessThanThirdSide() {
        try {
            new Triangle(2, 1, 4);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("The sum is less than the third triangle side!");
        }
    }

    @Test
    void TriangleEquality() {
        var s1 = new Triangle(5, 5, 5);
        var s2 = new Triangle(5, 5, 5);
        Assertions.assertTrue(s1.equals(s2));
    }
    @Test
    void TriangleNotEquality() {
        var s1 = new Triangle(5, 4, 5);
        var s2 = new Triangle(4, 5, 5);
        Assertions.assertEquals(s1, s2);
    }
}
package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTests {

    @Test
    void Calculateperiment() {
        Triangle triangle = new Triangle(5,5,5);
       double result = triangle.getPerimetr();
      assertEquals(15, result);
    }

    @Test
   void Calculatesquare() {
        Triangle triangle = new Triangle(5, 5,5);
        var area = triangle.getArea();
    Assertions.assertEquals(10.825317547305483, area);
    }
}

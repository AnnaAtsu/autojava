package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTests {

    @Test
    void Calculateperiment() {
        Triangle triangle = new Triangle();
       double result = triangle.calculatePerimeter();
      assertEquals(15, result);
    }

    @Test
   void Calculatesquare() {
        Triangle triangle = new Triangle();
        var area = triangle.calculateArea();
    Assertions.assertEquals(10.825317547305483, area);
    }
}

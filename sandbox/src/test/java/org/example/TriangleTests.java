package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void Calculateperiment() {
        int result = Triangle.getAnInt(10, 10, 10);
        Assertions.assertEquals(30, result);
    }

    @Test
    void Calculatesquare() {
        var area = Triangle.getTriangleArea(5, 5, 5);
        Assertions.assertEquals(10.825317547305483, area);
    }

}

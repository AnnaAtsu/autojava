package org.example;


public class Triangle {
    public double a, b, c;
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Triangle can not have a negative side");
        }
        if (((a + b) < c) || ((b + c) < a) || ((a + c)< b)) {
            throw new IllegalArgumentException("Triangle is wrong!");

        }
    }


    public double getPerimetr() {
        return a + b + c;
    }
    public double getArea() {
        double p = getPerimetr()/2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Triangle triangle = (Triangle)o;
            return Double.compare(triangle.a, this.a) == 0 && Double.compare(triangle.b, this.b) == 0 && Double.compare(triangle.c, this.c) == 0
            || Double.compare(triangle.a, this.b) == 0 && Double.compare(triangle.b, this.c) == 0 && Double.compare(triangle.c, this.a) == 0
            || Double.compare(triangle.a, this.c) == 0 && Double.compare(triangle.b, this.a) == 0 && Double.compare(triangle.c, this.b) == 0
            || Double.compare(triangle.a, this.a) == 0 && Double.compare(triangle.b, this.c) == 0 && Double.compare(triangle.c, this.b) == 0
            || Double.compare(triangle.a, this.c) == 0 && Double.compare(triangle.b, this.b) == 0 && Double.compare(triangle.c, this.a) == 0
                    || Double.compare(triangle.a, this.b) == 0 && Double.compare(triangle.b, this.a) == 0 && Double.compare(triangle.c, this.c) == 0;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
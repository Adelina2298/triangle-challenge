package org.challenge.triangle.service.impl;

import org.challenge.triangle.exception.BadRequestException;
import org.challenge.triangle.model.Triangle;
import org.challenge.triangle.service.TriangleService;
import org.springframework.stereotype.Service;

import static org.challenge.triangle.util.TriangleTypeEnum.*;

@Service
public class TriangleServiceImpl implements TriangleService {

    public String getType(Triangle triangle) {
        if (!isValid(triangle)) {
            throw new BadRequestException("Not a valid triangle");
        }

        if (isEquilateral(triangle.getSideA(), triangle.getSideB(), triangle.getSideC())) {
            return EQUILATERAL.value();
        } else if (isIsosceles(triangle.getSideA(), triangle.getSideB(), triangle.getSideC())) {
            return ISOSCELES.value();
        } else {
            return SCALENE.value();
        }

    }

    private boolean isValid(Triangle triangle) {
        if (triangle == null) {
            return false;
        }

        Integer a = triangle.getSideA();
        Integer b = triangle.getSideB();
        Integer c = triangle.getSideC();

        if (a == null || b == null || c == null) {
            return false;
        }

        return a + b > c && a + c > b && b + c > a;
    }

    private boolean isEquilateral(int a, int b, int c) {
        return a == b && b == c;
    }

    private boolean isIsosceles(int a, int b, int c) {
        return a == b || a == c || b == c;
    }

}

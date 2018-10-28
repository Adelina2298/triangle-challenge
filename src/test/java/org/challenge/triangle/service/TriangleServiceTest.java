package org.challenge.triangle.service;

import org.challenge.triangle.exception.BadRequestException;
import org.challenge.triangle.model.Triangle;
import org.challenge.triangle.service.impl.TriangleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.challenge.triangle.util.TriangleTypeEnum.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TriangleServiceTest {

    @InjectMocks
    private TriangleServiceImpl triangleService;

    @Test
    public void shouldReturnEquilateralType() {
        // given
        Triangle triangle = new Triangle();
        triangle.setSideA(4);
        triangle.setSideB(4);
        triangle.setSideC(4);

        // when
        String type = triangleService.getType(triangle);

        // then
        assertEquals(type, EQUILATERAL.value());
    }

    @Test
    public void shouldReturnIsoscelesType() {
        // given
        Triangle triangle = new Triangle();
        triangle.setSideA(4);
        triangle.setSideB(5);
        triangle.setSideC(5);

        // when
        String type = triangleService.getType(triangle);

        // then
        assertEquals(type, ISOSCELES.value());
    }

    @Test
    public void shouldReturnScaleneType() {
        // given
        Triangle triangle = new Triangle();
        triangle.setSideA(4);
        triangle.setSideB(5);
        triangle.setSideC(6);

        // when
        String type = triangleService.getType(triangle);

        // then
        assertEquals(type, SCALENE.value());
    }

    @Test(expected = BadRequestException.class)
    public void shouldThrowExceptionBecauseOfInvalidSides() {
        Triangle triangle = new Triangle();
        triangle.setSideA(3);
        triangle.setSideB(5);
        triangle.setSideC(8);

        triangleService.getType(triangle);
    }

    @Test(expected = BadRequestException.class)
    public void shouldThrowExceptionBecauseOfNullSides() {
        Triangle triangle = new Triangle();
        triangle.setSideA(3);
        triangle.setSideB(5);
        triangle.setSideC(null);

        triangleService.getType(triangle);
    }

    @Test(expected = BadRequestException.class)
    public void shouldThrowExceptionBecauseOfNullObject() {
        triangleService.getType(null);
    }
}

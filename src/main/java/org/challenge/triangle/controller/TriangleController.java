package org.challenge.triangle.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.challenge.triangle.model.Triangle;
import org.challenge.triangle.service.TriangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(description = "Operations pertaining to triangles")
@RestController
@RequestMapping(value = "/triangle")
public class TriangleController {

    @Autowired
    private TriangleService triangleService;

    @ApiOperation(value = "Returns type of triangle based on its sides")
    @PostMapping
    public String getType(@RequestBody @Valid Triangle triangle) {
        return triangleService.getType(triangle);
    }
}

package org.challenge.triangle.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.challenge.triangle.exception.BadRequestException;
import org.challenge.triangle.model.Triangle;
import org.challenge.triangle.service.TriangleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.challenge.triangle.util.TriangleTypeEnum.SCALENE;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TriangleController.class)
public class TriangleControllerTest {

    @MockBean
    private TriangleService triangleService;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldReturnStatusOk() throws Exception {
        Triangle triangle = new Triangle();
        triangle.setSideA(4);
        triangle.setSideB(5);
        triangle.setSideC(6);

        when(triangleService.getType(any(Triangle.class))).thenReturn(SCALENE.value());

        mockMvc.perform(post("/triangle")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(triangle)))
                .andExpect(status().isOk());

    }

    @Test
    public void shouldReturnBadRequest() throws Exception {
        when(triangleService.getType(any(Triangle.class))).thenThrow(BadRequestException.class);

        mockMvc.perform(post("/triangle")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new Triangle())))
                .andExpect(status().isBadRequest());
    }
}

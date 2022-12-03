package org.sojuton.skeleton;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class SkeletonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void skeleton() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/skeleton"))
                .andDo(print());

    }


}

package org.sojuton.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.sojuton.users.jwt.JwtTokenProvider;
import org.sojuton.users.model.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Test
    void signUpTest() throws Exception {
        UsersDto usersDto = new UsersDto();
        usersDto.setUserId("tester1");
        usersDto.setNickName("하이");
        usersDto.setPassWord("1234");
        mockMvc.perform(MockMvcRequestBuilders.post("/users/signUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usersDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void badSignUpTest() throws Exception {
        UsersDto usersDto = new UsersDto();
        usersDto.setUserId("tester");
        usersDto.setNickName("하이");
        usersDto.setPassWord("1234");
        mockMvc.perform(MockMvcRequestBuilders.post("/users/signUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usersDto)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    @Test
    void signInTest() throws Exception {
        UsersDto usersDto = new UsersDto();
        usersDto.setUserId("tester");
        usersDto.setPassWord("1234");
        mockMvc.perform(MockMvcRequestBuilders.post("/users/signIn")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usersDto)))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void badSignInTest() throws Exception {
        UsersDto usersDto = new UsersDto();
        usersDto.setUserId("tester");
        usersDto.setPassWord("123411");
        mockMvc.perform(MockMvcRequestBuilders.post("/users/signIn")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usersDto)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void duplicateCheckTest() throws Exception {
        UsersDto usersDto = new UsersDto();
        usersDto.setUserId("tester");
        usersDto.setPassWord("1234");
        mockMvc.perform(MockMvcRequestBuilders.get("/users/duplicateCheck")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usersDto)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }



    @Test
    void getUserInfoTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .header("Authorization", jwtTokenProvider.createToken(1L, "tester", "닉네")))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void badGetUserInfoTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwidXNlcklkIjoidGVzdGVyIiwibmlja05hbWUiOiLri4nrhKQiLCJpYXQiOjE2NzAwNTQ4OTIsImV4cCI6MTY3MDA1NDg5Mn0.NeHYI-PgHefupmWW0kOZzjD2fzzet-W-EO1DCDFzZ9Y"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}

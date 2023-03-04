package org.api.beacon.member.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemberApiControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void createMember() throws Exception {
        MemberRequestDto memberRequestDto = MemberRequestDto.builder()
                .name("Spring")
                .loginId("polymorph")
                .email("polymorph@gmail.com")
                .phoneNumber("01088887888")
                .company("code-beacon")
                .address("address1123")
                .build();

        mockMvc.perform(post("/api/member")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                        .content(objectMapper.writeValueAsString(memberRequestDto)))
                .andDo(print())
                .andExpect(status().isCreated());
    }
    @Test
    void retrieveMember() throws Exception {
        mockMvc.perform(get("/api/member").param("id", "1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
        ;
    }
}
package com.vaishu.IntegrationTesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserIntegrationTesting {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepo repo;

    @Test
    void createUser_shouldSaveUserInDatabase() throws Exception{
        Users savedUser = new Users("Vaishu", "v@gmail.com");
        String json = """
                {
                "name":"Vaishu",
                "email":"v@gmail.com"
                }
                """;
        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(status().isOk());

        Users result = repo.findAll().getFirst();

        assertNotNull(result.getId());

        assertEquals("Vaishu", result.getName());
        assertEquals("v@gmail.com", result.getEmail());

    }

    @Test
    void getAllUsers_ShouldReturnUsersFromDatabase() throws Exception{
        Users users = new Users("Sravan", "s@gmail.com");
        repo.save(users);
        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Sravan"))
                .andExpect(jsonPath("$[0].email").value("s@gmail.com"));


    }
}

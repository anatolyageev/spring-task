package com.spring.advance.task.springtask.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.advance.task.springtask.domain.User;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Helper {
    private UserService userService;

    public Helper(UserService userService) {
        this.userService = userService;
    }

    public void importFileData(InputStream is) {
        // read JSON and load json
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
        };
//        InputStream inputStream = TypeReference.class.getResourceAsStream(file);
//        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
        try {
            List<User> users = mapper.readValue(is, typeReference);
            userService.save(users);
            System.out.println("Users Saved!");
        } catch (IOException e) {
            System.out.println("Unable to save users: " + e.getMessage());
        }
    }
}

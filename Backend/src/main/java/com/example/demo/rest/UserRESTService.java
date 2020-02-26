package com.example.demo.rest;

import com.example.demo.dao.UserDAO;
import com.example.demo.dto.GenericResponseDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.pojo.UserPOJO;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableResourceServer
@Api(value = "User Controller", description = "REST API for User", tags = { "User Controller"})
public class UserRESTService {

    @Autowired
    UserDAO userDAO;

    Gson gson = new Gson();

    @RequestMapping(value = "user/login", method = RequestMethod.POST)
    @ApiOperation("Check login (username = admin pass = password, username = user pass = password)")
    public ResponseEntity<GenericResponseDTO> checkLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        UserDTO userDTO = null;
        try {
            String role = userDAO.checkLogin(username, password);
            if (role != null){
                userDTO = new UserDTO(username, role);
            }
        } catch (Exception e){
            return ResponseEntity.ok(new GenericResponseDTO(e.getMessage()));
        }

        if (userDTO == null){
            return ResponseEntity.ok(new GenericResponseDTO("Wrong username and password"));
        }

        return ResponseEntity.ok(new GenericResponseDTO("Success logged in", new UserPOJO(userDTO.getUsername(), userDTO.getRole())));
    }

}

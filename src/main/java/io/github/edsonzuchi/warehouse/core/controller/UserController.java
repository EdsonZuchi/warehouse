package io.github.edsonzuchi.warehouse.core.controller;

import io.github.edsonzuchi.warehouse.core.usecase.UserService;
import io.github.edsonzuchi.warehouse.core.dto.UserDto;
import io.github.edsonzuchi.warehouse.util.UseCaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    private ResponseEntity<Object> createUser(@RequestBody UserDto user){
        try {
            return ResponseEntity.ok(userService.newUser(user));
        }catch (UseCaseException usExc){
            return ResponseEntity.unprocessableEntity().body(usExc.getMessage());
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}

package com.eq.epharma.controller.rest;

import com.eq.epharma.config.User;
import com.eq.epharma.dto.MessageDto;
import com.eq.epharma.dto.UsersDto;
import com.eq.epharma.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/")
public class UsersRestController {


    @Autowired
    UsersService us;

    @PostMapping("/user-login")
    public @ResponseBody ResponseEntity<User> login(@RequestBody UsersDto ud){
         return us.performLogin(ud)?ResponseEntity.ok().body(us.getByUsername(ud).get()):ResponseEntity.badRequest().build();
    }

    @GetMapping("/test-jwt")
    public @ResponseBody ResponseEntity<Object> testJwt(){
        return ResponseEntity.ok().body("{'message':'K chha'}");
    }

    @PostMapping("/users")
    public ResponseEntity<MessageDto> addUser(@RequestBody UsersDto usersDto) {
        MessageDto response = us.addUsers(usersDto);
        if (response.isStatus()) {
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<UsersDto>> getUsers() {
        Optional<List<UsersDto>> users = us.getAllUsers();
        return ResponseEntity.ok().body(users.get());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UsersDto> getUserById(@PathVariable int id) {
        UsersDto user = us.findByUserId(id);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping ("/users/{id}")
    public ResponseEntity<MessageDto> updateUser(@PathVariable int id, @RequestBody UsersDto usersDto){
        usersDto.setUserId(id);
        MessageDto response = us.updateUser(usersDto);
        if (response.isStatus()) {
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

}




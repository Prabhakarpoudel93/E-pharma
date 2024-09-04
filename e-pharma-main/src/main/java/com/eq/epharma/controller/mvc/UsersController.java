package com.eq.epharma.controller.mvc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eq.epharma.dto.MessageDto;
import com.eq.epharma.dto.UsersDto;
import com.eq.epharma.service.UsersService;

@Controller
public class UsersController {

    @Autowired
    UsersService us;

    @GetMapping("/users")
    public String getUsersPage(Model model) {
        UsersDto usersDto = new UsersDto();
        List<UsersDto> usersDtoList = us.getAllUsers().get();

        model.addAttribute("usersDtoList", usersDtoList);
        model.addAttribute("usersDto", usersDto);
        return "users.html";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("usersDto") UsersDto usersDto, Model model) {
        System.out.println(usersDto);
        MessageDto messageDto = us.addUsers(usersDto);
        model.addAttribute("messageDto", messageDto);
        return "result.html";
    }

    @RequestMapping("/getUserById/{id}")
    public @ResponseBody UsersDto getUserById(@PathVariable int id) {
        UsersDto users = us.findByUserId(id);
        return users;
    }

    @PostMapping("/updateUser")
    public String updateUser(UsersDto usersDtoUpdate, Model model) {
        System.out.println(usersDtoUpdate);
        us.updateUser(usersDtoUpdate);
        List<UsersDto> usersDtoList = us.getAllUsers().get();
        UsersDto usersDto = new UsersDto();
        model.addAttribute("usersDtoList", usersDtoList);
        model.addAttribute("usersDto", usersDto);
        return "users.html";

    }
}

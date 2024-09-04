package com.eq.epharma.service;

import java.util.List;
import java.util.Optional;

import com.eq.epharma.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eq.epharma.dto.MessageDto;
import com.eq.epharma.dto.UsersDto;
import com.eq.epharma.repo.UsersRepo;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepo ur;

    @Autowired
    PasswordEncoder pe;

    @Override
    public boolean performLogin(UsersDto usersDto){
        User user=getByUsername(usersDto).get();
        if(user!=null){
            return pe.matches(usersDto.getPassword(),user.getPassword());
        }else{
            return false;
        }
    }

    @Override
    public Optional<User> getByUsername(UsersDto usersDto) {
        return ur.getByUsername(usersDto.getUsername());
    }

    @Override
    public MessageDto addUsers(UsersDto usersDto) {

        usersDto.setUserId(ur.getMaxUserId() + 1);

        usersDto.setPassword(pe.encode(usersDto.getPassword()));

        int result = 0;

        Optional<User> existingUser = ur.getByUsername(usersDto.getUsername());
        MessageDto md = new MessageDto("Failed", false);
        if (existingUser.isEmpty()) {
            result = ur.addUser(usersDto);
        } else {
            md.setMessage("User Already Exists");
            md.setStatus(false);
        }

        if (result > 0) {
            md.setMessage("User Added Successfully");
            md.setStatus(true);
        }

        return md;
    }

    @Override
    public Optional<List<UsersDto>> getAllUsers() {

        return ur.getAllUserList();
    }

    @Override
    public UsersDto findByUserId(int id) {
        return ur.findByUserId(id);
    }

    @Override
    public MessageDto updateUser(UsersDto usersDto) {
        int flag = 0;
        MessageDto md = new MessageDto("failed", false);
        usersDto.setPassword(pe.encode(usersDto.getPassword()));
        flag = ur.updateUser(usersDto);
        if (flag > 0) {
            md.setMessage("User Updated Successfully");
            md.setStatus(true);
        }
        return md;
    }

}

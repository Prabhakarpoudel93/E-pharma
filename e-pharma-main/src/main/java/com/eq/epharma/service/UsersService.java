package com.eq.epharma.service;

import java.util.List;
import java.util.Optional;

import com.eq.epharma.config.User;
import com.eq.epharma.dto.MessageDto;
import com.eq.epharma.dto.UsersDto;

public interface UsersService {
    public boolean performLogin(UsersDto usersDto);

    public Optional<User> getByUsername(UsersDto usersDto);

    public MessageDto addUsers(UsersDto usersDto);

    public Optional<List<UsersDto>> getAllUsers();

    public UsersDto findByUserId(int id);

    public MessageDto updateUser(UsersDto usersDto);

}

package com.eq.epharma.repo;

import java.util.List;
import java.util.Optional;

import com.eq.epharma.config.User;
import com.eq.epharma.dto.UsersDto;

public interface UsersRepo {
    public Optional<User> getByUsername(String u);

    public Optional<UsersDto> getByUsernameAndPassword(String u, String p);

    public int addUser(UsersDto users);

    public int getMaxUserId();

    public Optional<List<UsersDto>> getAllUserList();

    public UsersDto findByUserId(int id);

    public int updateUser(UsersDto usersDto);
}

package com.eq.epharma.repo;

import java.util.List;
import java.util.Optional;

import com.eq.epharma.config.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.eq.epharma.dto.UsersDto;

@Repository
public class UsersRepoImpl implements UsersRepo {

    private final JdbcTemplate jt;
    private final PasswordEncoder pe;

    public UsersRepoImpl(JdbcTemplate jt, PasswordEncoder pe) {
        this.jt = jt;
        this.pe = pe;
    }

    @Override
    public Optional<User> getByUsername(String u) {
        String sql = "SELECT * FROM Users where username=?";
        Optional<User> user;
        try {
             user=Optional.ofNullable(
                    this.jt.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), u));
        } catch (Exception e) {
            return Optional.empty();
        }
        return user;
    }

    @Override
    public Optional<UsersDto> getByUsernameAndPassword(String u, String p) {
        String sql = "SELECT * FROM Users where userName=? and userPassword=?";
        try {
            return Optional.ofNullable(this.jt.queryForObject(sql, BeanPropertyRowMapper.newInstance(UsersDto.class),
                    new Object[] { u, p }));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public int getMaxUserId() {
        int maxUserId = 0;
        String sql = "select max(userid)from users";
        try {
            maxUserId = this.jt.queryForObject(sql, Integer.class);
        } catch (Exception e) {

        }
        return maxUserId;
    }

    @Override
    public int addUser(UsersDto users) {
        int flag = 0;
        String sql = "insert into users (userID,userName, password,role) values (?,?,?,?)";
        try {
            flag = this.jt.update(sql, users.getUserId(), users.getUsername(), pe.encode(users.getPassword()),
                    users.getRole());

        } catch (Exception e) {
            flag = 0;

        }

        return flag;
    }

    @Override
    public Optional<List<UsersDto>> getAllUserList() {
        String sql = "SELECT * FROM users";
        try {

            return Optional.ofNullable(this.jt.query(sql, BeanPropertyRowMapper.newInstance(UsersDto.class)));

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public UsersDto findByUserId(int id) {
        String sql = "SELECT * FROM Users where userId=?";

        try {
            return this.jt.queryForObject(sql, BeanPropertyRowMapper.newInstance(UsersDto.class), id);
        } catch (Exception e) {
            return new UsersDto();
        }
    }

    @Override
    public int updateUser(UsersDto usersDto) {
        int flag = 0;
        String sql = "UPDATE users SET username=?,password=?,role=? WHERE userId=?";
        try {
            flag = this.jt.update(sql, usersDto.getUsername(), usersDto.getPassword(), usersDto.getRole(),
                    usersDto.getUserId());
        } catch (Exception e) {
            flag = 0;
        }
        return flag;
    }

}

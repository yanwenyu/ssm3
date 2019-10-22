package com.duyi.hrb.dao;

import com.duyi.hrb.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User findByName(@Param("username") String username);
    void insertUser(User user);
    void del(@Param("id") int id);
    void update(User user);
    User findById(@Param("id") int id);
}

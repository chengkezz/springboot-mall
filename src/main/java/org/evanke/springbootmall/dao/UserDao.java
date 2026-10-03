package org.evanke.springbootmall.dao;

import org.evanke.springbootmall.dto.UserRegisterRequest;
import org.evanke.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}

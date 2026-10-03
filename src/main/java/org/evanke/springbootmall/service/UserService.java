package org.evanke.springbootmall.service;

import org.evanke.springbootmall.dto.UserLoginRequest;
import org.evanke.springbootmall.dto.UserRegisterRequest;
import org.evanke.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}

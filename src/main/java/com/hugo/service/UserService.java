package com.hugo.service;

import com.hugo.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create(User userToCreate);

}

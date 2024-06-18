package com.hugo.service.impl;

import com.hugo.domain.model.User;
import com.hugo.domain.repository.UserRepository;
import com.hugo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository){
        this.userRepository=userRepository;


    }
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists");
        }
        return userRepository.save(userToCreate);
    }
}

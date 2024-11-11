package com.unibague.gradework.orionserver.service;

import com.unibague.gradework.orionserver.model.User;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUserById(Long id);
    User updateUser(Long id, User userDetails);
    void deleteUser(Long id);
}

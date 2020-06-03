package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    List<User> findAllUsers();
    void addUser(User user);
    void deleteUser(Long id);
    void updateUser(User user);

}

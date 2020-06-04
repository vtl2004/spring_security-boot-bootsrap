package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;
@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    @Transactional
    @Override
    public void addUser(User user) {
            userRepository.save(user);
    }
    @Transactional
    @Override
    public void deleteUser(Long id) {
            userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {

        userRepository.save(user);
    }
}

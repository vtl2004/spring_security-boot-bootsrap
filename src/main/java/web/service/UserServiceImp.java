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
    User user1 = userRepository.findUserById(user.getId());
    user1.setUsername(user.getUsername());
    user1.setPassword(user.getPassword());
    user1.setFirst_name(user.getFirst_name());
    user1.setLast_name(user.getLast_name());
    user1.setEmail(user.getEmail());
    user1.setRoles(user.getRoles());

        userRepository.save(user1);
    }
}

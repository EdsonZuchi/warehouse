package io.github.edsonzuchi.warehouse.usecase;

import io.github.edsonzuchi.warehouse.dto.UserDto;
import io.github.edsonzuchi.warehouse.entity.User;
import io.github.edsonzuchi.warehouse.repository.UserRepository;
import io.github.edsonzuchi.warehouse.util.UseCaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User newUser(UserDto dto) throws UseCaseException {
        if (dto.name().isBlank()){
            throw new UseCaseException("name is blank");
        }
        if (dto.email().isBlank()){
            throw new UseCaseException("email is blank");
        }

        User user = new User();
        user.setActive(true);
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setCreated(LocalDateTime.now());

        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void inactiveUser(Long id) throws UseCaseException {
        var user = userRepository.findById(id).orElse(null);
        if (user == null){
            throw new UseCaseException("User not found");
        }
        user.setActive(false);
        userRepository.save(user);
    }

    public void reactiveUser(Long id) throws UseCaseException {
        var user = userRepository.findById(id).orElse(null);
        if (user == null){
            throw new UseCaseException("User not found");
        }
        user.setActive(true);
        userRepository.save(user);
    }

}
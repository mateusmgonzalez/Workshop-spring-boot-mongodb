package com.company.demo.services;

import com.company.demo.domain.User;
import com.company.demo.dto.UserDTO;
import com.company.demo.repository.UserRepository;
import com.company.demo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findBYId(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(),userDTO.getEmail());
    }

    public User insert(User user){
        return  userRepository.insert(user);
    }

    public void delete(String id){
        userRepository.deleteById(id);
    }

    public User update(User user){
        User newUser = findBYId(user.getId());
        updateData(newUser,user);
        return userRepository.save(newUser);
    }

    public void updateData(User newUser, User user){
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }


}

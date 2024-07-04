package com.example.jpastart2.service;

import com.example.jpastart2.dto.UserDto;
import com.example.jpastart2.entity.User;
import com.example.jpastart2.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void join(UserDto userDto) {
        userRepository.save(userDto.toEntity());
    }
    public boolean login(String id, String password, HttpSession session) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) { // 유저 옵셔널이 존재한다면.
            User user = userOptional.get(); // 유저 옵셔널에 값을 user 에저장해줌
            if (user.getPassword().equals(password)) {
                session.setAttribute("user", user); // 세션에 사용자 정보 저장
                return true;
            }
        }
        return false;
    }


}

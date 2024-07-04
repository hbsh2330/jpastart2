package com.example.jpastart2.service;

import com.example.jpastart2.dto.WriteDto;
import com.example.jpastart2.entity.User;
import com.example.jpastart2.entity.Write;
import com.example.jpastart2.repository.WriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WriteService {

    @Autowired
    private WriteRepository writeRepository;
    public void write(WriteDto writeDto, User user) {
        Write write = Write.builder()
                .title(writeDto.getTitle())
                .content(writeDto.getContent())
                .regdate(writeDto.getRegdate())
                .writer(user)
                .build();
        writeRepository.save(write);
    }

}

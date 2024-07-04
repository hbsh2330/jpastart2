package com.example.jpastart2.dto;

import com.example.jpastart2.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
public class UserDto {
    private String id;
    private String password;
    private String name;
    private String addr;

    public User toEntity(){
        return User.builder()
                .id(id)
                .password(password)
                .name(name)
                .addr(addr)
                .build();
    }
    //Entity를 Dto로 변환시키는 로직
    public UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .password(user.getPassword())
                .name(user.getName())
                .addr(user.getAddr())
                .build();
    }

}

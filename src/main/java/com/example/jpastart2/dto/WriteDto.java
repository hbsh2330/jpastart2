package com.example.jpastart2.dto;

import com.example.jpastart2.entity.User;
import com.example.jpastart2.entity.Write;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
public class WriteDto {
    private String title;
    private User writer;
    private String content;
    private LocalDateTime regdate;

    public Write toEntity(){
        return Write.builder()
                .title(title)
                .writer(writer)
                .content(content)
                .regdate(regdate)
                .build();
    }
    //Entity를 Dto로 변환시키는 로직
    public WriteDto toDto(Write write){
        return WriteDto.builder()
                .title(write.getTitle())
                .writer(write.getWriter())
                .content(write.getContent())
                .regdate(write.getRegdate())
                .build();
    }
}

package com.example.jpastart2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "write_Tbl")
public class Write {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "writer", foreignKey = @ForeignKey(name="fk_write_Tbl_user_id", foreignKeyDefinition = "FOREIGN KEY (writer) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE"))
    private User writer;
    private String content;
    private LocalDateTime regdate;
}

package pl.oskarpolak.bloxo.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "user_id")
    private int userId; //todo mapowanie jeden do wielu
    private String title;
    private String context;
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
}

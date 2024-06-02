package bg.softuni.pathfinder.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Boolean approved;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(columnDefinition = "TEXT",name = "text_content",nullable = false)
    private String textContent;



    @ManyToOne(optional = false)
    private User author;


    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Route route;
}



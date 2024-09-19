package fr.cda.botteprintemps.entity.redditish;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    private Comment commentFrom;

    @OneToMany(mappedBy = "commentFrom")
    private List<Comment> responses = new ArrayList<>();

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserRedditish writer;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Thread thread;

    @OneToMany(mappedBy = "comment")
    private List<Reaction> reactions = new ArrayList<>();

}
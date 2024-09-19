package fr.cda.botteprintemps.entity.redditish;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private boolean isLiked;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserRedditish user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Comment comment;

}
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
public class UserRedditish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120, nullable = false)
    private String email;

    @Column(length = 120, nullable = false)
    private String nickname;

    @Column(length = 120, nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime registeredAt;

    @Column(length = 120, nullable = false)
    private String slug;

    @OneToMany(mappedBy = "user")
    private List<UserFavoriteCategory> favorites = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Follow> follows = new ArrayList<>();

    @OneToMany(mappedBy = "writer")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Reaction> reactions = new ArrayList<>();

}
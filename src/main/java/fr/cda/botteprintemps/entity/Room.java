package fr.cda.botteprintemps.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String translationKey;

    @Column(nullable = false)
    private String type;

    @ManyToMany(mappedBy = "rooms")
    private List<Lodging> lodgings = new ArrayList<>();

}
package fr.cda.trainingharrypotter.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.cda.trainingharrypotter.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class OffenseList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView(JsonViews.StudentShowView.class)
    private LocalDateTime createdAt;

    @JsonView(JsonViews.StudentShowView.class)
    private int offenseSeriousness;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonView(JsonViews.StudentShowView.class)
    private Offense offense;

}

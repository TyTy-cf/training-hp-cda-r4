package fr.cda.trainingharrypotter.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.cda.trainingharrypotter.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class TypeOfClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @JsonView(JsonViews.StudentShowView.class)
    private int yearTaught;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonView(JsonViews.StudentShowView.class)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonView(JsonViews.StudentShowView.class)
    private Subject subject;

    @ManyToMany(mappedBy = "typeOfClasses")
    private List<Student> students = new ArrayList<>();

}

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
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.StudentShowView.class)
    private Integer id;

    @Column(nullable = false)
    @JsonView(JsonViews.StudentShowView.class)
    private String name;

    @OneToMany(mappedBy = "teacher")
    private List<TypeOfClass> typeOfClasses = new ArrayList<>();

}

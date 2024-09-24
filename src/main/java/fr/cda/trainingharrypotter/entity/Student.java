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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.HouseShowView.class)
    private Integer id;

    @Column(nullable = false)
    @JsonView(JsonViews.HouseShowView.class)
    private String name;

    @Column(nullable = false)
    private int yearOfBirth;

    @Column(nullable = false)
    @JsonView(JsonViews.HouseShowView.class)
    private Boolean isAlive;

    @ManyToOne
    @JoinColumn(nullable = false)
    private House house;

    @ManyToMany
    @JoinTable(
        name = "student_type_of_class",
        inverseJoinColumns = @JoinColumn(name = "type_of_class_id"),
        joinColumns = @JoinColumn(name = "student_id")
    )
    private List<TypeOfClass> typeOfClasses = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<OffenseList> offenseLists = new ArrayList<>();

}

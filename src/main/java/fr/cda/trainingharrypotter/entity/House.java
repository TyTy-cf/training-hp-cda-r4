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
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({JsonViews.HouseMinimalView.class, JsonViews.StudentMinimalView.class})
    private Integer id;

    @Column(nullable = false)
    @JsonView({JsonViews.HouseMinimalView.class, JsonViews.StudentMinimalView.class})
    private String houseName;

    @Column(nullable = false)
    @JsonView(JsonViews.HouseMinimalView.class)
    private String founderFirstName;

    @Column(nullable = false)
    @JsonView(JsonViews.HouseMinimalView.class)
    private String founderLastName;

    @OneToMany(mappedBy = "house")
    @JsonView(JsonViews.HouseShowView.class)
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "house")
    @JsonView(JsonViews.HouseShowView.class)
    private List<HousePoint> housePoints = new ArrayList<>();

    @JsonView(JsonViews.HouseListView.class)
    public int getStudentQuantity() {
        return students.size();
    }

}

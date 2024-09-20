package fr.cda.trainingharrypotter.entity;

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
    private Integer id;

    @Column(nullable = false)
    private String houseName;

    @Column(nullable = false)
    private String founderFirstName;

    @Column(nullable = false)
    private String founderLastName;

    @OneToMany(mappedBy = "house")
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "house")
    private List<HousePoint> housePoints = new ArrayList<>();

}

package fr.cda.trainingharrypotter.entity;

import fr.cda.trainingharrypotter.slugger.SluggerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Subject implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String subjectName;

    @Column(nullable = false)
    private String slug;

    @Override
    public String getField() {
        return subjectName;
    }
}

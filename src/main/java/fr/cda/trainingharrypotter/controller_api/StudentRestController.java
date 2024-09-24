package fr.cda.trainingharrypotter.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.cda.trainingharrypotter.dto.StudentDTO;
import fr.cda.trainingharrypotter.entity.Student;
import fr.cda.trainingharrypotter.json_views.JsonViews;
import fr.cda.trainingharrypotter.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/student")
public class StudentRestController {

    private StudentService studentService;

    @GetMapping
    @JsonView(JsonViews.StudentListView.class)
    public List<Student> list() {
        return studentService.list();
    }

    @PostMapping
    public Student create(@Valid @RequestBody StudentDTO dto) {
        return studentService.create(dto);
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.StudentShowView.class)
    public Student search(@PathVariable Integer id) {
        return studentService.findOneById(id);
    }

    @PutMapping("/{id}")
    public Student update(@Valid @RequestBody StudentDTO dto, @PathVariable Integer id) {
        return studentService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        studentService.delete(id);
        return true;
    }

}
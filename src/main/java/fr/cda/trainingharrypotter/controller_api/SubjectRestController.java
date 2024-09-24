package fr.cda.trainingharrypotter.controller_api;

import fr.cda.trainingharrypotter.dto.SubjectDTO;
import fr.cda.trainingharrypotter.entity.Subject;
import fr.cda.trainingharrypotter.service.SubjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/subject")
public class SubjectRestController {

    private SubjectService subjectService;

    @GetMapping
    public List<Subject> list() {
        return subjectService.list();
    }

    @PostMapping
    public Subject create(@Valid @RequestBody SubjectDTO dto) {
        return subjectService.create(dto);
    }

    @GetMapping("/{id}")
    public Subject show(@PathVariable String id) {
        return subjectService.findOneById(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    public Subject update(@Valid @RequestBody SubjectDTO dto, @PathVariable Integer id) {
        return subjectService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        subjectService.delete(id);
        return true;
    }

}
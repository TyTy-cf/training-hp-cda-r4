package fr.cda.trainingharrypotter.controller_api;

import fr.cda.trainingharrypotter.dto.SubjectDTO;
import fr.cda.trainingharrypotter.entity.Subject;
import fr.cda.trainingharrypotter.service.SubjectService;
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
    public Subject create(@RequestBody SubjectDTO dto) {
        return subjectService.create(dto);
    }

    @GetMapping("/{id}")
    public Subject show(@PathVariable Integer id) {
        return subjectService.findOneById(id);
    }

    @PutMapping("/{id}")
    public Subject update(@RequestBody SubjectDTO dto, @PathVariable Integer id) {
        return subjectService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        subjectService.delete(id);
        return true;
    }

}
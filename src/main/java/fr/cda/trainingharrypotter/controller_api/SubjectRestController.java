package fr.cda.trainingharrypotter.controller_api;

import fr.cda.trainingharrypotter.dto.SubjectDTO;
import fr.cda.trainingharrypotter.entity.Subject;
import fr.cda.trainingharrypotter.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/subject")
public class SubjectRestController {

    private SubjectService subjectService;

    @PutMapping("/{id}")
    public Subject update(@RequestBody SubjectDTO dto, @PathVariable Integer id) {
        return subjectService.update(dto, id);
    }

}
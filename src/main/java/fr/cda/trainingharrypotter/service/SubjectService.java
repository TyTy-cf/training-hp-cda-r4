package fr.cda.trainingharrypotter.service;

import fr.cda.trainingharrypotter.dto.SubjectDTO;
import fr.cda.trainingharrypotter.entity.Subject;
import fr.cda.trainingharrypotter.repository.SubjectRepository;
import fr.cda.trainingharrypotter.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService implements
        ServiceListInterface<Subject, Integer, SubjectDTO, SubjectDTO> {

    private SubjectRepository subjectRepository;

    @Override
    public Subject create(SubjectDTO o) {
        Subject subject = new Subject();
        subject.setSubjectName(o.getName());
        subjectRepository.saveAndFlush(subject);
        return subject;
    }

    @Override
    public Subject update(SubjectDTO o, Integer id) {
        Subject subject = findOneById(id);
        subject.setSubjectName(o.getName());
        subjectRepository.flush();
        return subject;
    }

    @Override
    public void delete(Subject o) {
        if (o != null) {
            subjectRepository.delete(o);
        }
    }

    @Override
    public Subject findOneById(Integer id) {
        return subjectRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Subject> list() {
        return subjectRepository.findAll();
    }
}

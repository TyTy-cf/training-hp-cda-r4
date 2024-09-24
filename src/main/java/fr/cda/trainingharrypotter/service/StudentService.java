package fr.cda.trainingharrypotter.service;

import fr.cda.trainingharrypotter.dto.StudentDTO;
import fr.cda.trainingharrypotter.entity.Student;
import fr.cda.trainingharrypotter.repository.StudentRepository;
import fr.cda.trainingharrypotter.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService implements
        ServiceListInterface<Student, Integer, StudentDTO, StudentDTO> {

    private StudentRepository studentRepository;
    private HouseService houseService;

    @Override
    public Student create(StudentDTO o) {
        Student student = new Student();
        student.setAlive(o.isAlive());
        student.setName(o.getName());
        student.setYearOfBirth(o.getYearOfBirth());
        student.setHouse(houseService.findOneById(o.getHouseId()));
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public Student update(StudentDTO o, Integer id) {
        Student student = findOneById(id);
        student.setAlive(o.isAlive());
        student.setName(o.getName());
        student.setYearOfBirth(o.getYearOfBirth());
        student.setHouse(houseService.findOneById(o.getHouseId()));
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findOneById(Integer id) {
        return studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Student> list() {
        return studentRepository.findAll();
    }
}

package fr.cda.trainingharrypotter;

import fr.cda.trainingharrypotter.dto.SubjectDTO;
import fr.cda.trainingharrypotter.entity.Subject;
import fr.cda.trainingharrypotter.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingHarryPotterApplication {

//	private static SubjectService subjectService;
//
//	@Autowired
//	public TrainingHarryPotterApplication(SubjectService subjectService) {
//		TrainingHarryPotterApplication.subjectService = subjectService;
//	}

	public static void main(String[] args) {
		SpringApplication.run(TrainingHarryPotterApplication.class, args);
//
//		// Test ajout
//		System.out.println(TrainingHarryPotterApplication.subjectService.list());
	}

}

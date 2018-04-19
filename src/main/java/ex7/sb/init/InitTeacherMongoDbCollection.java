/**
 * 
 */
package ex7.sb.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ex7.sb.teacher.mongodb.model.Teacher;
import ex7.sb.teacher.mongodb.repo.TeacherRepository;

/**
 * @author ilker
 *
 */
@Component
public class InitTeacherMongoDbCollection implements CommandLineRunner {

	private TeacherRepository teacherRepository;
	
	public InitTeacherMongoDbCollection(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		Teacher t1 = new Teacher("1", "ilker", "kiris", "adjunct", 20, false);
		Teacher t2 = new Teacher("2", "Ali", "Veli", "adjunct", 201, false);
		
		// add our teachers to DB
		List<Teacher> teachers = Arrays.asList(t1,t2);
		teacherRepository.saveAll(teachers);
	}

}

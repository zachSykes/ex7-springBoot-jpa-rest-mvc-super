/**
 * 
 */
package ex7.sb.init;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

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
		Teacher t3 = new Teacher("3", "John", "Wayne", "prof", 19, true);
		Teacher t4 = new Teacher("4", "JohnTop", "Wayne", "assocProf", 20, true);
		Teacher t5 = new Teacher("5", "AllenJohn", "Wayne", "assProf", 18, true);
		Teacher t6 = new Teacher("6", "AllenJohnTop", "Wayne", "adjunct", 30, false);
		Teacher t7 = new Teacher("7", "Allen", "Nova", "adjunct", 31, false);
		
		// add our teachers to DB
		List<Teacher> teachers = Arrays.asList(t1,t2,t3,t4,t5,t6,t7);
		teacherRepository.saveAll(teachers);
	}
	
	// TODO ilker find a better solution than below attempt, which somehow didn't work
/*
	private static TeacherRepository teacherRepositoryStatic;
	@PostConstruct
	public void initTeacherRepositoryStatic() {
		teacherRepositoryStatic = teacherRepository;
	}

	public static void main(String[] args) {
		insertMoreTeachers(args);
	}
		
	public static void insertMoreTeachers(String[] args) {
		Teacher t1 = new Teacher("11", "ilker", "kiris", "adjunct", 20, false);
		Teacher t2 = new Teacher("12", "Ali", "Veli", "adjunct", 201, false);
		Teacher t3 = new Teacher("13", "John", "Wayne", "prof", 19, true);
		Teacher t4 = new Teacher("14", "JohnTop", "Wayne", "assocProf", 20, true);
		Teacher t5 = new Teacher("15", "AllenJohn", "Wayne", "assProf", 18, true);
		Teacher t6 = new Teacher("16", "AllenJohnTop", "Wayne", "adjunct", 30, false);
		Teacher t7 = new Teacher("17", "Allen", "Nova", "adjunct", 31, false);
		
		// add our teachers to DB
		List<Teacher> teachers = Arrays.asList(t1,t2,t3,t4,t5,t6,t7);
		teacherRepositoryStatic.saveAll(teachers);
	}
*/
}

/**
 * 
 */
package ex7.sb.mvc.thymeleaf.student.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ex7.sb.mvc.thymeleaf.student.jpa.model.StudentEntity;
import ex7.sb.mvc.thymeleaf.student.jpa.repo.StudentRepository;

/**
 * Used as an alternate way to data.sql and data-h2.sql files to init the DB
 * The run method of any class that implements Spring's CommandLineRunner will be executed by Spring right after app is UP
 * 
 * @author ilker
 *
 */
@Component
public class InitStudentDbTable implements CommandLineRunner {

	private StudentRepository studentRepsitory;
	// NOTE ilker above line together with below constructor and @Autowired is doing Spring's "Constructor dependency injection"
	@Autowired
	public InitStudentDbTable(StudentRepository studentRepsitory) {
		super();
		this.studentRepsitory = studentRepsitory;
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		StudentEntity studentUno = new StudentEntity("ilker", "kiris", "lise3", 18, true, "04/17/2018");
		StudentEntity savedStudentUno = studentRepsitory.save(studentUno);
		System.out.println("-----> ILKER ----> Saved studentUno");
	}

}

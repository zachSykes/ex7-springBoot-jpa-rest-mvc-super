/**
 * 
 */
package ex7.sb.student.jpa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ex7.sb.student.jpa.model.Student;

/**
 * @author ilker
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
	public Optional<List<Student>> findByName(String name);
}

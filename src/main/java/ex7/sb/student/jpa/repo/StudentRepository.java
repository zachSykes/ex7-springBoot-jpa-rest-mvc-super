/**
 * 
 */
package ex7.sb.mvc.thymeleaf.student.jpa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ex7.sb.mvc.thymeleaf.student.jpa.model.StudentEntity;

/**
 * @author ilker
 *
 */
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	public Optional<List<StudentEntity>> findByName(String name);
}

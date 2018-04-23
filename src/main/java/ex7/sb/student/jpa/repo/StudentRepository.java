/**
 * 
 */
package ex7.sb.student.jpa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ex7.sb.student.jpa.model.Student;

/**
 * Couple of example native queries
 *   @Query("select s from Student s where lower(s.name) = lower(:studentName)")
 *   public Country findByNameIgnoreCaseQuery(@Param("studentName") String studentName);
 * 
 *   @Query("select s from Student s where c.name = ?1")
 *   public Country findByNameQueryPositionalParam(String studentName);
 * 
 * @author ilker
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
	public Optional<List<Student>> findByName(String name);
}

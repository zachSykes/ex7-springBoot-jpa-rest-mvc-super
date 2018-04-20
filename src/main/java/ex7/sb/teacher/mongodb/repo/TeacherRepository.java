/**
 * 
 */
package ex7.sb.teacher.mongodb.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ex7.sb.teacher.mongodb.model.Teacher;

/**
 * Some doc and examples of queries
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
 * https://lishman.io/spring-data-jpa-repository-queries
 * 
 * @author ilker
 *
 */
@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {
	public Optional<List<Teacher>> findByTeacherId(String teacherId);
	public Optional<List<Teacher>> findByAgeLessThan(int age);
	public Optional<List<Teacher>> findByNameOrLastnameOrderByAgeDesc(String name, String lastname);
	public Optional<List<Teacher>> findFirst3ByTitle(String title);
	public Optional<List<Teacher>> findByNameStartingWith(String name);
	public void deleteByTeacherId(String teacherId);
	
}

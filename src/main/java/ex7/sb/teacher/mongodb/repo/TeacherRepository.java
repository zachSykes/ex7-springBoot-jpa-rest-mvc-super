/**
 * 
 */
package ex7.sb.teacher.mongodb.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ex7.sb.teacher.mongodb.model.Teacher;

/**
 * @author ilker
 *
 */
@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {

}

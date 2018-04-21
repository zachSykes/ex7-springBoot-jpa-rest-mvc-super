package ex7.sb.teacher.mongodb.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import ex7.sb.teacher.mongodb.model.Teacher;

/**
 * Some doc and examples of queries
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
 * https://lishman.io/spring-data-jpa-repository-queries
 * 
 * Some example mongodb native queries that can be run in robomongo
 * db.getCollection('Teachers').find({'name':{$regex:'Top$'}})
 *  
 * @author ilker
 *
 */
@Repository
//public interface TeacherRepository extends MongoRepository<Teacher, String>, QuerydslPredicateExecutor<Teacher> {
public interface TeacherRepository extends MongoRepository<Teacher, String> {
	// NOTE ilker, below are examples of using "Generated Query Methods" following convention of Spring Data (same thing with Spring Data JPA)
	public Optional<List<Teacher>> findByTeacherId(String teacherId);
	public Optional<List<Teacher>> findByAgeLessThan(int age);
	public Optional<List<Teacher>> findByNameOrLastnameOrderByAgeDesc(String name, String lastname);
	public Optional<List<Teacher>> findFirst3ByTitle(String title);
	public Optional<List<Teacher>> findByNameStartingWith(String name);
	public void deleteByTeacherId(String teacherId);
	
	// NOTE ilker below are examples of using "JSON Query Methods" which are basically native MongoDb queries
	@Query("{}")
	public List<Teacher> findMyAll();
	@Query("{'name': ?0}")
	public List<Teacher> findMyByName(String name);
	@Query("{'name': {$regex: ?0}}")
	public List<Teacher> findMyByNameRegexp(String regexp);
	@Query("{'age': {$gt: ?0, $lt: ?1}}")
	public List<Teacher> findMyByAgeBetween(int ageGT, int ageLT);
	
}

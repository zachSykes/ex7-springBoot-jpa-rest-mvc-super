/**
 * 
 */
package ex7.sb.student.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ex7.sb.student.jpa.model.StudentEntity;
import ex7.sb.student.jpa.repo.StudentRepository;

/**
 * @author ilker
 *
 */
@RestController
@RequestMapping("rest/v1/students")
public class StudentRestController {
	@Autowired StudentRepository studentRepository;

//	@RequestMapping(value="/echoMessage", method=RequestMethod.GET)
	@RequestMapping("/echoMessage") // NOTE ilker, equivalent to above line since default is GET
//	@GetMapping("/echoMessage")		// NOTE ilker, equivalent to above line as well
	/**
	 * http://localhost:8888/rest/v1/students/echoMessage?msg=Hi
	 */
	public String echoMessage(@RequestParam(value="msg", defaultValue="Hello ilker") String message) {
		return "echoMessage echoed: " + message;
	}

	@GetMapping("")
	public Page<StudentEntity> findAll(@RequestParam(defaultValue="0") int page, @RequestParam(value="rowsPerPage", defaultValue="5") int size) {
		Page<StudentEntity> studentsPage = studentRepository.findAll(new PageRequest(page, size));
		return studentsPage;
	}

	@GetMapping("/all")
	public  List<StudentEntity> findAll() {
		List<StudentEntity> students = studentRepository.findAll();
		return students;
	}

	@PostMapping("")
	public  Optional<StudentEntity> save(@RequestBody final StudentEntity student) {
		StudentEntity savedStudent = studentRepository.save(student);
		return studentRepository.findById(savedStudent.getStudentId());
	}
	
	
}

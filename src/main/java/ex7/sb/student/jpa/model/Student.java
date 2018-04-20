/**
 * 
 */
package ex7.sb.student.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author ilker
 *
 */
@Entity(name="STUDENT")	// NOTE ilker, if name is not specified class name camel cased to table name in DB, like STUDENT_ENTITY
public class Student {
	@Id
	// NOTE ilker, GenerationType.AUTO means h2 will create a sequence that starts with 0 value and use that for studentId values
	@GeneratedValue		// NOTE ilker GenerationType.AUTO is the default strategy, so this line is equivalent to below one.
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer studentId;
	private String name;
//	@Column(name="last_name")
	private String lastname;
	private String grade;
	private Integer age;
	private Boolean isFullTime;
//	@Temporal(TemporalType.DATE)
//	private Date updatedOn;
	private String updatedOn;
	
	public Student() { }

//	public StudentEntity(String name, String lastname, String grade, Integer age, Boolean isFullTime, Date updatedOn) {
	public Student(String name, String lastname, String grade, Integer age, Boolean isFullTime, String updatedOn) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.grade = grade;
		this.age = age;
		this.isFullTime = isFullTime;
		this.updatedOn = updatedOn;
	}
	
//	public StudentEntity(Integer studentId, String name, String lastname, String grade, Integer age, Boolean isFullTime, Date updatedOn) {
	public Student(Integer studentId, String name, String lastname, String grade, Integer age, Boolean isFullTime, String updatedOn) {
		this(name, lastname, grade, age, isFullTime, updatedOn);
		this.studentId = studentId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getIsFullTime() {
		return isFullTime;
	}

	public void setIsFullTime(Boolean isFullTime) {
		this.isFullTime = isFullTime;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", name=" + name + ", lastname=" + lastname + ", grade="
				+ grade + ", age=" + age + ", isFullTime=" + isFullTime + ", updatedOn=" + updatedOn + "]";
	}	
}

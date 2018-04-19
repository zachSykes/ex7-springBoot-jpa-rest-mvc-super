/**
 * 
 */
package ex7.sb.teacher.mongodb.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ilker
 *
 */
@Document(collection="Teachers")
public class Teacher {
	@Id
	private String id;	// NOTE ilker this is mongodb specific "objectId"
	private String teacherId;
	@Indexed(direction=IndexDirection.ASCENDING)
	private String name;
	private String lastname;
	private String title;
	private int age;
//	private Date updatedOn;
	private boolean isFullTime;
	public Teacher() {
		super();
	}
	public Teacher(String teacherId, String name, String lastname, String title, int age, boolean isFullTime) {
		super();
		this.teacherId = teacherId;
		this.name = name;
		this.lastname = lastname;
		this.title = title;
		this.age = age;
		this.isFullTime = isFullTime;
	}
	public String getId() {
		return id;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public String getName() {
		return name;
	}
	public String getLastname() {
		return lastname;
	}
	public String getTitle() {
		return title;
	}
	public int getAge() {
		return age;
	}
	public boolean isFullTime() {
		return isFullTime;
	}
}

package myproject.manytomany.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student4")
public class Student {

	@Id
	@Column(length = 5)
	private String sid;
	@Column(length = 10)
	private String sname;
	@Column(length = 10)
	private String saddr;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student4_course_4",joinColumns = {@JoinColumn(name="sid")}, inverseJoinColumns = {@JoinColumn(name="cid")})
	
	private Set<Course> courses;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	
}

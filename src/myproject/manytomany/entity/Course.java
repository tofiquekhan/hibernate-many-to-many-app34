package myproject.manytomany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course4")

public class Course {

	@Id
	@Column(length = 5)
	private String cid;
	@Column(length = 10)
	private String cname;
	@Column(length = 5)
	private int ccost;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCcost() {
		return ccost;
	}
	public void setCcost(int ccost) {
		this.ccost = ccost;
	}
	
	
}

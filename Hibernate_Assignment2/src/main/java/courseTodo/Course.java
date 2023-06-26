package courseTodo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="course_master")
public class Course {
	@Id
	@Column(name="course_id")
	private int courseId;
	@Column(name="course_title")
	private String title;
	@Column(name="course_duration")
	private int duration;
	@Column(name="course_provider")
	private String provider;
	@Column(name="course_cost")
	private double cost;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int courseId, String title, int duration, String provider, double cost) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.duration = duration;
		this.provider = provider;
		this.cost = cost;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + ", duration=" + duration + ", provider=" + provider
				+ ", cost=" + cost + "]";
	}
	
	
	
}

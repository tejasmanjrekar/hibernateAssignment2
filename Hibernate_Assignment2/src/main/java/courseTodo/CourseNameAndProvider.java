package courseTodo;

public class CourseNameAndProvider {
	private String courseTitle;
	private String courseProvider;
	
	public CourseNameAndProvider() {

	}

	public CourseNameAndProvider(String courseTitle, String courseProvider) {
		this.courseTitle = courseTitle;
		this.courseProvider = courseProvider;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseProvider() {
		return courseProvider;
	}

	public void setCourseProvider(String courseProvider) {
		this.courseProvider = courseProvider;
	}

	@Override
	public String toString() {
		return "CourseNameAndProvider [courseTitle=" + courseTitle + ", courseProvider=" + courseProvider + "]";}
}

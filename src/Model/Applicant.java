package Model;

public class Applicant {
	
	private String name;
	private String currentTitle;
	private double desiredSalary;
	private String educationLevel;
	private String workHistory;
	
	public Applicant(String name, String currentTitle, double desiredSalary, String educationLevel,
			String workHistory) {
		super();
		this.name = name;
		this.currentTitle = currentTitle;
		this.desiredSalary = desiredSalary;
		this.educationLevel = educationLevel;
		this.workHistory = workHistory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrentTitle() {
		return currentTitle;
	}

	public void setCurrentTitle(String currentTitle) {
		this.currentTitle = currentTitle;
	}

	public double getDesiredSalary() {
		return desiredSalary;
	}

	public void setDesiredSalary(double desiredSalary) {
		this.desiredSalary = desiredSalary;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getWorkHistory() {
		return workHistory;
	}

	public void setWorkHistory(String workHistory) {
		this.workHistory = workHistory;
	}

}

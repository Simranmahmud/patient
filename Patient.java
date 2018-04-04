import java.util.Date;

public class Patient {


private String name;
private String patientIdNum;
private String address;
private int height;
private double weight;
private Date DOB;
private Date InitialVisit;
private Date LastVisit;

public Patient (String name, String patientIdNum, String address, int height, double weight, Date DOB, 
		Date InitialVisit, Date LastVisit) {
	this.name = name;
	this.patientIdNum = patientIdNum;
	this.address = address;
	this.height = height;
	this.weight = weight;
	this.DOB = DOB;
	this.InitialVisit = InitialVisit;
	this.LastVisit = LastVisit;
		}

	public String getName() {
		return name;
	}
	
	public String getPatientIdNum() {
		return patientIdNum;
	}
	public String getAddress() {
		return address;
	}
	public int getHeight(){
		return height;
	}
	public double getWeight(){
		return weight;
	}
	public Date getDOB(){
		return DOB;
	}
	public Date getInitialVisit(){
		return InitialVisit;
	}
	public Date getLastVisit(){
		return LastVisit;
	}
	public int getAge(){
		return 2017 - DOB.getYear();
	}
	public int getTimeAsPatient(){
		return 2017 - InitialVisit.getYear();
	}
	public int getTimeSinceLastVisit(){
		return 2017 - LastVisit.getYear();
	}


}
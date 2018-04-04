import java.util.Date;
import java.io.*;
import java.util.Scanner;
public class PatientMain {
	
	
	
	public static String getInfo(List a, String ID){
		if (!a.contains(ID))
			return "Error: Patient does not exist";
		Patient p = a.find(ID);
		return "Name: " + p.getName() + "\n" + 
				"ID: " + p.getPatientIdNum() + "\n" +
				"Address: " + p.getAddress() + "\n" +
				"Height: " + (p.getHeight()/12) + "Ft. " + (p.getHeight()%12) + "in. " + "\n" +
				"Weight: " + p.getWeight() + "\n" +
				"Age: " + p.getAge() + "\n" + 
				"Number of years as a patient: " + p.getTimeAsPatient() + "\n" +
				"Number of years since last visit: " + p.getTimeSinceLastVisit() + "\n" +
				(p.getTimeSinceLastVisit() >= 3 ? "Patient is overdue for a visit" : "");
				}
	
	public static String remove(List a, String ID) {
	if (!a.contains(ID))
		return "Error: Patient does not exist";
	 a.remove(ID);
	 return "Patient has been removed";
	}
	public static String AverageAge(List a) {
		double AverageAge = 0;
		while (a.getCurrent() != null) {
			AverageAge += a.getCurrent().getAge();
			a.getNext();
		}
		a.reset();
		return "Average age is: " + Math.round(AverageAge/a.size())/1.0;
		
	}
	public static String GetYoungestPatient(List a) {
		Patient min = a.getCurrent();
		while (a.hasNext()) {
			a.getNext();
			if (a.getCurrent().getAge() < min.getAge())
			min = a.getCurrent();
		}
		a.reset();
		return getInfo(a, min.getPatientIdNum());
	}
	public static String GetOverduePatients(List a) {
		List overdue = new List();
				while (a.hasNext()) {
					if (a.getCurrent().getTimeSinceLastVisit() >= 3) 
						overdue.add(a.getCurrent());
					a.getNext();
				}
		a.reset();
		return overdue.toString();
	}
	public static void main(String[] args) {
	
		List visit = new List ();	
		Scanner input = new Scanner (System.in);
		
		
		try {
			String fileName = ""; 
			String line = "";
			System.out.print("Write a file name: ");
			fileName = input.nextLine();
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			while ((line = br.readLine())!=null) {
				String name = line;
				line = br.readLine();
				String ID = line;
				line = br.readLine();
				String address = line;
				line = br.readLine();
				int height = Integer.parseInt(line);
				line = br.readLine();
				double weight = Double.parseDouble(line);
				line = br.readLine();
				String DOBs = line;
				Date DOB = new Date(Integer.parseInt(DOBs.substring(6)), Integer.parseInt(DOBs.substring(0, 2)), Integer.parseInt(DOBs.substring(3, 5)));
				line = br.readLine();
				String IVDs = line;
				Date IVD = new Date(Integer.parseInt(IVDs.substring(6)), Integer.parseInt(IVDs.substring(0, 2)), Integer.parseInt(IVDs.substring(3, 5)));
				line = br.readLine();
				String LVDs = line;
				Date LVD = new Date(Integer.parseInt(LVDs.substring(6)), Integer.parseInt(LVDs.substring(0, 2)), Integer.parseInt(LVDs.substring(3, 5)));
				Patient p = new Patient(name, ID, address, height, weight, DOB, IVD, LVD);
				visit.add(p);
			}
			br.close();
		
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("1. Display list \n" +
				"2. Add new patient \n" +
				"3. Show information for a patient \n" +
				"4. Delete patient \n" +
				"5. Show average patient age \n" +
				"6. Show information for the youngest patient \n" +
				"7. Show notification list \n" +
				"8. Quit\n");
		System.out.println("Enter an option (1-8): ");
		int option = input.nextInt();
		
		while (option != 8) {
			switch (option) {
			case 1:
				System.out.println(visit);
				break;
			case 2:
				input.nextLine();
				System.out.print("Enter patient name: ");
				String name = input.nextLine();
				System.out.print("Enter patient ID: ");
				String ID = input.nextLine();
				System.out.print("Enter patient address: ");
				String address = input.nextLine();
				System.out.print("Enter patient height(in inches): ");
				int Height = input.nextInt();
				input.nextLine();
				System.out.print("Enter patient weight: ");
				double Weight = input.nextDouble();
				input.nextLine();
				System.out.print("Enter patient DOB(mm/dd/yyyy): ");
				String DOBs = input.nextLine();
				Date DOB = new Date(Integer.parseInt(DOBs.substring(6)), Integer.parseInt(DOBs.substring(0, 2)), Integer.parseInt(DOBs.substring(3, 5)));
				System.out.print("Enter patient initial visit date(mm/dd/yyyy): ");
				String IVDs = input.nextLine();
				Date IVD = new Date(Integer.parseInt(IVDs.substring(6)), Integer.parseInt(IVDs.substring(0, 2)), Integer.parseInt(IVDs.substring(3, 5)));
				System.out.print("Enter patient last visit date(mm/dd/yyyy): ");
				String LVDs = input.nextLine();
				Date LVD = new Date(Integer.parseInt(LVDs.substring(6)), Integer.parseInt(LVDs.substring(0, 2)), Integer.parseInt(LVDs.substring(3, 5)));
				Patient p = new Patient(name, ID, address, Height, Weight, DOB, IVD, LVD);
				visit.add(p);
				break;
			case 3:
				input.nextLine();
				System.out.print("Enter Patient ID: ");
				String patientInfo = input.nextLine();
				System.out.println(getInfo (visit, patientInfo));
				break;
			case 4:
				input.nextLine();
				System.out.print("Enter Patient ID: ");
				String patientInfo2 = input.nextLine();
				System.out.println(remove (visit, patientInfo2));
				break;
			case 5:
				System.out.println(AverageAge(visit));
				break;
			case 6: 
				System.out.println(GetYoungestPatient(visit));
				break;
			case 7:
				System.out.println(GetOverduePatients(visit));
				break;
			default: 
				System.out.println("Error: Not a valid option.");
			
			}
			System.out.println();
		System.out.println("1. Display list \n" +
				"2. Add new patient \n" +
				"3. Show information for a patient \n" +
				"4. Delete patient \n" +
				"5. Show average patient age \n" +
				"6. Show information for the youngest patient \n" +
				"7. Show notification list \n" +
				"8. Quit\n");
		
		System.out.println("Enter an option (1-8): ");
		option = input.nextInt();
	}
		input.nextLine();
		System.out.print("Save the current list to a file (y/n)");
		String opt = input.nextLine();
		if (opt.equals("y")) {
		System.out.print("Enter the name of the file: ");
		String fileName = input.nextLine();
		
		try { 
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		
		while (visit.hasNext()) {
			Patient p = visit.getCurrent();

			bw.write(p.getName());
			bw.newLine();
			bw.write(p.getPatientIdNum());
			bw.newLine();
			bw.write(p.getAddress());
			bw.newLine();
			bw.write(p.getHeight());
			bw.newLine();
			bw.write("" + p.getWeight());
			bw.newLine();
			bw.write("" + p.getDOB());
			bw.newLine();
			bw.write("" + p.getInitialVisit());
			bw.newLine();
			bw.write("" + p.getLastVisit());
			bw.newLine();
			
			visit.getNext();
		}
		bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
			
}

}
}

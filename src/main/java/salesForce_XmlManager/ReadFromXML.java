	package salesForce_XmlManager;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.InputStream;
	import java.io.OutputStream;
	import java.util.Iterator;
	import java.util.Map;
	import java.util.Properties;
	import java.util.Set;
	
	public class ReadFromXML {
		Properties prop = new Properties();
		String projectPath = System.getProperty("user.dir");
		//String fileName="/Registration.xml";
		String fileName="/src/main/resources/config/Registration.xml";
		String fullPath=projectPath+fileName;
		InputStream input;
	
		private void getProperties() {
			try {
				input = new FileInputStream(fullPath);		
				prop.loadFromXML(input);
				// to print all the info from the file.
				Set set = prop.entrySet();
				Iterator itr = set.iterator();
				while (itr.hasNext()) {
					Map.Entry string = (Map.Entry) itr.next();
					System.out.println(string.getKey() + ": " + string.getValue());
				}
	
			} catch (Exception exp) {		}
	
		}
	
	
		public  void setProperties() {
			OutputStream os = null;
			try {
				os = new FileOutputStream(fullPath);
				prop.setProperty("Country", "US");
				prop.storeToXML(os, "Personal info change by Faruq");
			} catch (Exception e) {
	
			}
		}
	
		public  String getfirstName() {
			String firstName=null;
			try {
				input = new FileInputStream(fullPath);
				prop.loadFromXML(input);
				firstName = prop.getProperty("firstName");
				//System.out.println(firstName);
			} catch (Exception exp) {		}		
			return firstName ;
		}
	
		public String getlastName() {
			String lastName=null;
			try {
				input = new FileInputStream(fullPath);
				prop.loadFromXML(input);
				lastName = prop.getProperty("lastName");
				//System.out.println(lastName);
			} catch (Exception exp) {		}
			return lastName ;
		}
	
		public String getjobTitle() {
			String jobTitle=null;
			try {
				input = new FileInputStream(fullPath);
				prop.loadFromXML(input);
				jobTitle = prop.getProperty("jobTitle");
				//System.out.println(jobTitle);
			} catch (Exception exp) {		}
			return jobTitle ;
		}
	
		public String getemail() {
			String email=null;
			try {
				input = new FileInputStream(fullPath);
				prop.loadFromXML(input);
				email = prop.getProperty("email");
				//System.out.println(email);
			} catch (Exception exp) {		}
			return email ;
		}
	
		public String getphone() {
			String phone=null;
			try {
				input = new FileInputStream(fullPath);
				prop.loadFromXML(input);
				phone = prop.getProperty("email");
				//System.out.println(phone);
			} catch (Exception exp) {		}
			return phone ;
		}
	
		public String getemployees() {
			String employees=null;
			try {
				input = new FileInputStream(fullPath);
				prop.loadFromXML(input);
				employees = prop.getProperty("employees");
				//System.out.println(employees);
			} catch (Exception exp) {		}
			return employees ;
		}
	
		public String getCompany() {
			String Company=null;
			try {
				input = new FileInputStream(fullPath);
				prop.loadFromXML(input);
				Company = prop.getProperty("Company");
				//System.out.println(Company);
			} catch (Exception exp) {		}
			return Company ;
		}
	
		public String getCounty() {
			String County=null;
			try {
				input = new FileInputStream(fullPath);
				prop.loadFromXML(input);
				County = prop.getProperty("County");
				//System.out.println(County);
			} catch (Exception exp) {		}
			return County ;
		}
		

		public static void main(String[] args) {
			ReadFromXML xml= new ReadFromXML();
			System.out.println(xml.getfirstName());
			xml.getlastName();
			//xml.setProperties();
			xml.getProperties();
		}
	
	
	}
	

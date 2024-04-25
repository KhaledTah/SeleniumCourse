package utils;

public class Connection{

	private String firstName;	
	private String lastName;
	private String sex;
	private String email;			
	private String telephone;
	private String company;
	private String ssu;
	private String seniority;
	private String addInfo;


	public Connection(String firstName, String lastName, String sex, String email, String telephone, String company, String SSU, String seniority) {
		this.firstName= firstName;
		this.lastName =  lastName;
		this.sex = sex; 
		this.email = email;
		this.telephone= telephone;
		this.company= company;
		this.ssu = SSU;
		this.seniority=seniority;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return sex;
	}

	public void setGender(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSsu() {
		return ssu;
	}

	public void setSsu(String ssu) {
		this.ssu = ssu;
	}

	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

	public String getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}



}
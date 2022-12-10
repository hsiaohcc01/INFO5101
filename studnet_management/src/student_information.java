public class student_information{
	private String stuID;
	private String name;
	private String gender;
    private String age;
    private String phone;
    private String address;
    private String identityID;

    public student_information(){
    }

    public student_information(String stuID,String name,String gender,String age,String phone,String address,String identityID) {
    	this.stuID = stuID;
    	this.name = name;
    	this.gender = gender;
    	this.age = age;
    	this.phone = phone;
    	this.address = address;
    	this.identityID = identityID;
    }
    public String getStuID() {
    	return this.stuID;
    }
    public void setStuID(String stuID) {
    	this.stuID = stuID;
    }
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public String getGender() {
    	return this.gender;
    }
    public void setGender(String gender) {
    	this.gender = gender;
    }
    public String getAge() {
    	return this.age;
    }
    public void setAge(String age) {
    	this.age = age;
    }
    public String getPhone() {
    	return this.phone;
    }
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    public String getAddress() {
    	return this.address;
    }
    public void setAddress(String address) {
    	this.address = address;
    }
    public String getIdentityID() {
    	return this.identityID;
    }
    public void setIdentityID(String identityID) {
    	this.identityID = identityID;
    }
    public String fileString()
	{
		return stuID+" "+name+" "+gender+" "+age+"  "+phone+"  "+address+"  "+identityID;
	}
}

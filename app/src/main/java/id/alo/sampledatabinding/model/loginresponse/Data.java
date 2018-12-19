package id.alo.sampledatabinding.model.loginresponse;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("birthday")
	private String birthday;

	@SerializedName("firstname")
	private String firstname;

	@SerializedName("gender")
	private String gender;

	@SerializedName("city")
	private City city;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("is_asking")
	private boolean isAsking;

	@SerializedName("status_insurance")
	private int statusInsurance;

	@SerializedName("lastname")
	private String lastname;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_picture")
	private String userPicture;

	@SerializedName("phone")
	private String phone;

	@SerializedName("device_token")
	private String deviceToken;

	@SerializedName("id")
	private String id;

	@SerializedName("fb_token")
	private String fbToken;

	@SerializedName("auth_token")
	private String authToken;

	@SerializedName("age")
	private int age;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

	public String getBirthday(){
		return birthday;
	}

	public void setFirstname(String firstname){
		this.firstname = firstname;
	}

	public String getFirstname(){
		return firstname;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setCity(City city){
		this.city = city;
	}

	public City getCity(){
		return city;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setIsAsking(boolean isAsking){
		this.isAsking = isAsking;
	}

	public boolean isIsAsking(){
		return isAsking;
	}

	public void setStatusInsurance(int statusInsurance){
		this.statusInsurance = statusInsurance;
	}

	public int getStatusInsurance(){
		return statusInsurance;
	}

	public void setLastname(String lastname){
		this.lastname = lastname;
	}

	public String getLastname(){
		return lastname;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserPicture(String userPicture){
		this.userPicture = userPicture;
	}

	public String getUserPicture(){
		return userPicture;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setDeviceToken(String deviceToken){
		this.deviceToken = deviceToken;
	}

	public String getDeviceToken(){
		return deviceToken;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setFbToken(String fbToken){
		this.fbToken = fbToken;
	}

	public String getFbToken(){
		return fbToken;
	}

	public void setAuthToken(String authToken){
		this.authToken = authToken;
	}

	public String getAuthToken(){
		return authToken;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}
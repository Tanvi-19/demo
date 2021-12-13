package com.marketplace.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private long id;
	
	@Column(name="username",nullable=false)
	private String username;
	
	@Column(name="password",nullable=false)
	private String password;
	
	private String role;
	
	@Column(name="email")
	private String userEmail;
	
	@Column(name="contactNo")
	private long userMobileNo;
	
	@Column(name="address")
	private String userAddress;
	
	@Column(name="pincode")
	private long userPincod;
	
	@Column(name="gstNo")
	private long gstNum;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(long userMobileNo) {
		this.userMobileNo = userMobileNo;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public long getUserPincod() {
		return userPincod;
	}

	public void setUserPincod(long userPincod) {
		this.userPincod = userPincod;
	}

	public long getGstNum() {
		return gstNum;
	}

	public void setGstNum(long gstNum) {
		this.gstNum = gstNum;
	}

	public User(long id, String username, String password, String role, String userEmail, long userMobileNo,
			String userAddress, long userPincod, long gstNum) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.userEmail = userEmail;
		this.userMobileNo = userMobileNo;
		this.userAddress = userAddress;
		this.userPincod = userPincod;
		this.gstNum = gstNum;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", userEmail=" + userEmail + ", userMobileNo=" + userMobileNo + ", userAddress=" + userAddress
				+ ", userPincod=" + userPincod + ", gstNum=" + gstNum + "]";
	}

	
}

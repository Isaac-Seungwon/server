package com.test.ajax.model;

//DB의 테이블 1개당 DTO를 1개 만드는 게 일반적이다.
//즉, 테이블에 대응해서 DTO를 만든다.
//컬럼 이름을 멤버 변수로 사용하는 게 가독성이 높기 떄문이다.
public class AddressDTO {

	private String seq;
	private String name;
	private String age;
	private String gender;
	private String address;
	private String regdate;
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}

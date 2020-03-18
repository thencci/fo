package peo;

public class Peo {
	private String id;  //编号
	private String name;  //姓名
	private String sex;  //性别
	private String college;  //学院
	private String address;  //地址
	private String suspect;  //疑似
	private String confirm;  //确认
	private String contact;  //是否接触
	private String time;  //时间
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getCollege() {
		return college;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}
	public String getSuspect() {
		return suspect;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContact() {
		return contact;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTime() {
		return time;
	}
	public Peo() {
        super();
        // TODO Auto-generated constructor stub
      }
	
	public Peo(String id, String name, String sex,String college, String address, String suspect,String confirm, String contact, String time) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.college = college;
        this.address = address;
        this.suspect = suspect;
        this.confirm = confirm;
        this.contact = contact;
        this.time = time;
     }
}

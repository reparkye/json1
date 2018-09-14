package json;

public class Person {
	private String name;
	private String id;
	private String password;
	private String trans;
	
	public Person() {}
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", password=" + password + ", trans=" + trans + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getTrans() {
		return trans;
	}


	public void setTrans(String trans) {
		this.trans = trans;
	}


	public Person(String name, String id, String password, String trans) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.trans = trans;
	}	
}

package vo;

public class UserInfo {

private String id;
private String pwd;
private String name;
private Integer age;
private Integer class_num;

public UserInfo() {}

@Override
public String toString() {
	return "UserInfo [id=" + id + ", pwd=" + pwd + ", name=" + name + ", age=" + age + ", class_num=" + class_num + "]";
}

public UserInfo(String id, String pwd, String name, Integer age, Integer class_num) {
	super();
	this.id = id;
	this.pwd = pwd;
	this.name = name;
	this.age = age;
	this.class_num = class_num;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}

public Integer getClass_num() {
	return class_num;
}

public void setClass_num(Integer class_num) {
	this.class_num = class_num;
}



}

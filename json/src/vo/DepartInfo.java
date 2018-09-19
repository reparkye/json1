package vo;

public class DepartInfo {


private Integer dinum;
private String dicode;
private String diname;
private String didesc;

public DepartInfo() {}


public Integer getDinum() {
	return dinum;
}
public void setDinum(Integer dinum) {
	this.dinum = dinum;
}
public String getDicode() {
	return dicode;
}
public void setDicode(String dicode) {
	this.dicode = dicode;
}
public String getDiname() {
	return diname;
}
public void setDiname(String diname) {
	this.diname = diname;
}
public String getDidesc() {
	return didesc;
}
public void setDidesc(String didesc) {
	this.didesc = didesc;
}
@Override
public String toString() {
	return "DepartInfo [dinum=" + dinum + ", dicode=" + dicode + ", diname=" + diname + ", didesc=" + didesc + "]";
}
public DepartInfo(Integer dinum, String dicode, String diname, String didesc) {
	super();
	this.dinum = dinum;
	this.dicode = dicode;
	this.diname = diname;
	this.didesc = didesc;
}



	
}

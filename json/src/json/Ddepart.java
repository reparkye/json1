package json;

public class Ddepart {

	private int dinum;
	private String diname;
	private String ditype;
	
	public Ddepart() {}

	@Override
	public String toString() {
		return "Ddepart [dinum=" + dinum + ", diname=" + diname + ", ditype=" + ditype + "]";
	}

	public Ddepart(int dinum, String diname, String ditype) {
		super();
		this.dinum = dinum;
		this.diname = diname;
		this.ditype = ditype;
	}

	public int getDinum() {
		return dinum;
	}

	public void setDinum(int dinum) {
		this.dinum = dinum;
	}

	public String getDiname() {
		return diname;
	}

	public void setDiname(String diname) {
		this.diname = diname;
	}

	public String getDitype() {
		return ditype;
	}

	public void setDitype(String ditype) {
		this.ditype = ditype;
	}

	
	
}
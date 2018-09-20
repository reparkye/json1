package vo;

public class TestInfo {

	private int tinum;
	private String tiname;
	private String titext;
	private String tiid;
	
	TestInfo()	{}

	@Override
	public String toString() {
		return "TestInfo [tinum=" + tinum + ", tiname=" + tiname + ", titext=" + titext + ", tiid=" + tiid + "]";
	}

	public TestInfo(int tinum, String tiname, String titext, String tiid) {
		super();
		this.tinum = tinum;
		this.tiname = tiname;
		this.titext = titext;
		this.tiid = tiid;
	}

	public int getTinum() {
		return tinum;
	}

	public void setTinum(int tinum) {
		this.tinum = tinum;
	}

	public String getTiname() {
		return tiname;
	}

	public void setTiname(String tiname) {
		this.tiname = tiname;
	}

	public String getTitext() {
		return titext;
	}

	public void setTitext(String titext) {
		this.titext = titext;
	}

	public String getTiid() {
		return tiid;
	}

	public void setTiid(String tiid) {
		this.tiid = tiid;
	}
	
	
	
}

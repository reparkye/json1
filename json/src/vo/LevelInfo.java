package vo;

public class LevelInfo {

	private int linum;
	private int lilevel;
	private String liname;
	private String lidesc;
	
	public LevelInfo()	{}

	public LevelInfo(int linum, int lilevel, String liname, String lidesc) {
		super();
		this.linum = linum;
		this.lilevel = lilevel;
		this.liname = liname;
		this.lidesc = lidesc;
	}

	@Override
	public String toString() {
		return "LevelInfo [linum=" + linum + ", lilevel=" + lilevel + ", liname=" + liname + ", lidesc=" + lidesc + "]";
	}

	public int getLinum() {
		return linum;
	}

	public void setLinum(int linum) {
		this.linum = linum;
	}

	public int getLilevel() {
		return lilevel;
	}

	public void setLilevel(int lilevel) {
		this.lilevel = lilevel;
	}

	public String getLiname() {
		return liname;
	}

	public void setLiname(String liname) {
		this.liname = liname;
	}

	public String getLidesc() {
		return lidesc;
	}

	public void setLidesc(String lidesc) {
		this.lidesc = lidesc;
	}
	
	
	
}

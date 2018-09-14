package json;

public class DepartIn {
		
		private int dinum;
		private String dicode;
		private String diname;
		private String didesc;
		
		public DepartIn() {}

		public int getDinum() {
			return dinum;
		}

		public void setDinum(int dinum) {
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

		public DepartIn(int dinum, String dicode, String diname, String didesc) {
			super();
			this.dinum = dinum;
			this.dicode = dicode;
			this.diname = diname;
			this.didesc = didesc;
		}

		@Override
		public String toString() {
			return "DepartInfo [dinum=" + dinum + ", dicode=" + dicode + ", diname=" + diname + ", didesc=" + didesc + "]";
		}
		
		
		
		
	}

	


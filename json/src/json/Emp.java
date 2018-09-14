package json;

public class Emp {

	private int empno;
	private String empname;
	private String empjob;
	private int empmgr;
	private int hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	public Emp() {}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", empname=" + empname + ", empjob=" + empjob + ", empmgr=" + empmgr
				+ ", hiredate=" + hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpjob() {
		return empjob;
	}

	public void setEmpjob(String empjob) {
		this.empjob = empjob;
	}

	public int getEmpmgr() {
		return empmgr;
	}

	public void setEmpmgr(int empmgr) {
		this.empmgr = empmgr;
	}

	public int getHiredate() {
		return hiredate;
	}

	public void setHiredate(int hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public Emp(int empno, String empname, String empjob, int empmgr, int hiredate, int sal, int comm, int deptno) {
		super();
		this.empno = empno;
		this.empname = empname;
		this.empjob = empjob;
		this.empmgr = empmgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	
	
	
}

package atm.com.Bo;

public class MiniStatement {

	public MiniStatement() {
		// TODO Auto-generated constructor stub
	}
	private double damount;
	private double wamount;
	private String dtime;
	private String transaction;
	public double getDamount() {
		return damount;
	}
	public void setDamount(double damount) {
		this.damount = damount;
	}
	public double getWamount() {
		return wamount;
	}
	public void setWamount(double wamount) {
		this.wamount = wamount;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String wtime) {
		this.transaction = wtime;
	}
	public MiniStatement(double damount, double wamount, String dtime,
			String transation) {
		super();
		this.damount = damount;
		this.wamount = wamount;
		this.dtime = dtime;
		this.transaction = transation;
	}
	
	

}

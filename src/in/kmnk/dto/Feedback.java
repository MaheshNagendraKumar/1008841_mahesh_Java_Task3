package in.kmnk.dto;

public class Feedback {
	
	private int fid;
	private String fdescreption;
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFdescreption() {
		return fdescreption;
	}
	public void setFdescreption(String fdescreption) {
		this.fdescreption = fdescreption;
	}
	
	@Override
	public String toString() {
		return "Feedback [fid=" + fid + ", fdescreption=" + fdescreption + ", customer=" + customer + "]";
	}
	
	
	
		
}

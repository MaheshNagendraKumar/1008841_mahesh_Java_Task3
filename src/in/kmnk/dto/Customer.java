package in.kmnk.dto;

public class Customer {
	
	private int cid;
	private String cnmae;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCnmae() {
		return cnmae;
	}
	public void setCnmae(String cnmae) {
		this.cnmae = cnmae;
	}
	
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cnmae=" + cnmae + "]";
	}
	
	
	
	
	
}

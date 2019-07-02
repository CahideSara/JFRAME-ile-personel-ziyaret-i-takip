package entity;

public class ziyaret_et {
	
	private String z_no;
	 private String p_no;
	 private String giris;
	 private String cikis;
	 
	
	public ziyaret_et() {
		
		this.z_no=null;
		 this.p_no=null;
		 this.giris=null;
		 this.cikis=null;
		
		
	}
	public String getZ_no() {
		return z_no;
	}
	public void setZ_no(String z_no) {
		this.z_no = z_no;
	}
	public String getP_no() {
		return p_no;
	}
	public void setP_no(String p_no) {
		this.p_no = p_no;
	}
	public String getGiris() {
		return giris;
	}
	public void setGiris(String giris) {
		this.giris = giris;
	}
	public String getCikis() {
		return cikis;
	}
	public void setCikis(String cikis) {
		this.cikis = cikis;
	}
	@Override
	public String toString() {
		return "ziyaret_et [z_no=" + z_no + ", p_no=" + p_no + ", giris=" + giris + ", cikis=" + cikis + "]";
	}
	 
	

}

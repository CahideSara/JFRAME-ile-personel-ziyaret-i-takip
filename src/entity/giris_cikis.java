package entity;



public class giris_cikis {

	 private String personel_no;
	 private String giris_t;
	 private String cikis_t;
	 
	 
	 public giris_cikis() {
		  personel_no=null;
		  giris_t=null;
		 cikis_t=null;
	}
	 
	public String getPersonel_no() {
		return personel_no;
	}
	public void setPersonel_no(String personel_no) {
		this.personel_no = personel_no;
	}
	public String getGiris_t() {
		return giris_t;
	}
	public void setGiris_t(String giris_t) {
		this.giris_t = giris_t;
	}
	public String getCikis_t() {
		return cikis_t;
	}
	public void setCikis_t(String cikis_t) {
		this.cikis_t = cikis_t;
	}
	
	 
	
}

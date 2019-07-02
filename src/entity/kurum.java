package entity;

import java.util.Date;

public class kurum {
	
   private String k_no;
   private String sehri;
   private String ad;
   private String telefon;
   private String yýlý;
   private String yöneticp_no;
   
   
   public kurum() {
		
		this.k_no = null;
		this.sehri = null;
		this.ad = null;
		this.telefon = null;
		this.yýlý = null;
		this.yöneticp_no = null;
	}  
   
   public kurum(String k_no) {

		this.k_no = k_no;
		
	}
public kurum(String k_no, String sehri, String ad, String telefon, String yýlý, String yöneticp_no) {

	this.k_no = k_no;
	this.sehri = sehri;
	this.ad = ad;
	this.telefon = telefon;
	this.yýlý = yýlý;
	this.yöneticp_no = yöneticp_no;
}
public String getK_no() {
	return this.k_no;
}
public void setK_no(String k_no) {
	this.k_no = k_no;
}
public String getSehri() {
	return sehri;
}
public void setSehri(String sehri) {
	this.sehri = sehri;
}
public String getAd() {
	return ad;
}
public void setAd(String ad) {
	this.ad = ad;
}
public String getTelefon() {
	return telefon;
}
public void setTelefon(String telefon) {
	this.telefon = telefon;
}
public String getYýlý() {
	return yýlý;
}
public void setYýlý(String yýlý) {
	this.yýlý = yýlý;
}
public String getYöneticp_no() {
	return yöneticp_no;
}
public void setYöneticp_no(String yöneticp_no) {
	this.yöneticp_no = yöneticp_no;
}

@Override
public String toString() {
	return "kurum [k_no=" + k_no + ", sehri=" + sehri + ", ad=" + ad + ", telefon=" + telefon + ", yýlý=" + yýlý
			+ ", yöneticp_no=" + yöneticp_no + "]";
}
   
   
}

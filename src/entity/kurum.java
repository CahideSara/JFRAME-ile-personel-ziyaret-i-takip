package entity;

import java.util.Date;

public class kurum {
	
   private String k_no;
   private String sehri;
   private String ad;
   private String telefon;
   private String y�l�;
   private String y�neticp_no;
   
   
   public kurum() {
		
		this.k_no = null;
		this.sehri = null;
		this.ad = null;
		this.telefon = null;
		this.y�l� = null;
		this.y�neticp_no = null;
	}  
   
   public kurum(String k_no) {

		this.k_no = k_no;
		
	}
public kurum(String k_no, String sehri, String ad, String telefon, String y�l�, String y�neticp_no) {

	this.k_no = k_no;
	this.sehri = sehri;
	this.ad = ad;
	this.telefon = telefon;
	this.y�l� = y�l�;
	this.y�neticp_no = y�neticp_no;
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
public String getY�l�() {
	return y�l�;
}
public void setY�l�(String y�l�) {
	this.y�l� = y�l�;
}
public String getY�neticp_no() {
	return y�neticp_no;
}
public void setY�neticp_no(String y�neticp_no) {
	this.y�neticp_no = y�neticp_no;
}

@Override
public String toString() {
	return "kurum [k_no=" + k_no + ", sehri=" + sehri + ", ad=" + ad + ", telefon=" + telefon + ", y�l�=" + y�l�
			+ ", y�neticp_no=" + y�neticp_no + "]";
}
   
   
}

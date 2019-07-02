package entity;

public class ziyaretci extends kisiler {
 private String ziy_no;

 
 public ziyaretci() {
     this.ziy_no = null;
     super.setAd(null);
     super.setSoyad(null);
     super.setYas(null);
     
 }

 
 
 public ziyaretci(String ziy_no,String yas,String ad,String soyad) {
     this.ziy_no = ziy_no;
     super.setAd(ad);
     super.setSoyad(soyad);
     super.setYas(yas);
     
 }

 
 
public String getZiy_no() {
	return ziy_no;
}

public void setZiy_no(String ziy_no) {
	this.ziy_no = ziy_no;
}
 
}

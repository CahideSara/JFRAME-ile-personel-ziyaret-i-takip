package entity;

public class personell extends kisiler{
	
	 private String personel_no;
	    private String meslek;
	    private String cinsiyet;
	    private String calýstýgý_kat;
	    private String k_no;

	    public personell() {
	        this.personel_no = null;
	        super.setAd(null);
	        super.setSoyad(null);
	        super.setYas(null);
	        this.meslek = null;
	        this.cinsiyet = null;
	        this.calýstýgý_kat = null;
	        this.k_no = null;
	    }

	    
	    
	    
	    public personell(String personel_no,String yas,String ad,String soyad, String meslek, String cinsiyet, String calýstýgý_kat, String k_no) {
	        this.personel_no = personel_no;
	        super.setAd(ad);
	        super.setSoyad(soyad);
	        super.setYas(yas);
	        this.meslek = meslek;
	        this.cinsiyet = cinsiyet;
	        this.calýstýgý_kat = calýstýgý_kat;
	        this.k_no = k_no;
	    }

	    
	    
	    public String getPersonel_no() {
	        return personel_no;
	    }

	    public void setPersonel_no(String personel_no) {
	        this.personel_no = personel_no;
	    }

	    public String getMeslek() {
	        return meslek;
	    }

	    public void setMeslek(String meslek) {
	        this.meslek = meslek;
	    }

	    public String getCinsiyet() {
	        return cinsiyet;
	    }

	    public void setCinsiyet(String cinsiyet) {
	        this.cinsiyet = cinsiyet;
	    }

	    public String getCalýstýgý_kat() {
	        return calýstýgý_kat;
	    }

	    public void setCalýstýgý_kat(String calýstýgý_kat) {
	        this.calýstýgý_kat = calýstýgý_kat;
	    }

	    public String getK_no() {
	        return k_no;
	    }

	    public void setK_no(String k_no) {
	        this.k_no = k_no;
	    }
	    
	    

}

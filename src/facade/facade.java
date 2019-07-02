package facade;
import java.sql.Date;
public class facade {
	private kayýtEtme kayýt;
	private kayýtGüncelle güncelle;
	private kayýtSil sil;	
	public facade() {
		kayýt=new kayýtEtme();
		güncelle=new kayýtGüncelle();
		sil=new kayýtSil();		
	}	
	public void personelIslem(String personel_no,String yas,String ad,String soyad, String meslek, String cinsiyet, String calýstýgý_kat, String k_no,String islem) 
	{
		if(islem=="ekle") {
			kayýt.ekleme(personel_no, yas, ad, soyad, meslek, cinsiyet, calýstýgý_kat, k_no);
		}
		else if(islem=="sil") {
			sil.personelSil(personel_no);
		}
		else if(islem=="güncelle")
		{
			güncelle.güncelleme(personel_no, yas, ad, soyad, meslek, cinsiyet, calýstýgý_kat, k_no);
		}
	}	
	public void ziyaretcilIslem(String ziy_no,String yas,String ad,String soyad,String islem) 
	{
		if(islem=="ekle") {
			kayýt.ekleme(ziy_no, yas, ad, soyad);
		}
		else if(islem=="sil") {
			sil.ziyaretciSil(ziy_no);
		}
		else if(islem=="güncelle")
		{
			güncelle.güncelleme(ziy_no, yas, ad, soyad);
		}
	}
	public void kurumlIslem(String kurum_no,String sehir,String ad,String telefon,String tarih,String yp_no,String islem) 
	{
		if(islem=="ekle") {
			kayýt.ekleme( kurum_no,sehir,ad,telefon,tarih,yp_no);
		}
		else if(islem=="sil") {
			sil.kurumSil(kurum_no);
		}
		else if(islem=="güncelle")
		{
			güncelle.güncelleme(kurum_no, sehir, ad, telefon, tarih, yp_no);
		}		
	}	
}


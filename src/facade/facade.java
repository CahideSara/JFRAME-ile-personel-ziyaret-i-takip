package facade;
import java.sql.Date;
public class facade {
	private kay�tEtme kay�t;
	private kay�tG�ncelle g�ncelle;
	private kay�tSil sil;	
	public facade() {
		kay�t=new kay�tEtme();
		g�ncelle=new kay�tG�ncelle();
		sil=new kay�tSil();		
	}	
	public void personelIslem(String personel_no,String yas,String ad,String soyad, String meslek, String cinsiyet, String cal�st�g�_kat, String k_no,String islem) 
	{
		if(islem=="ekle") {
			kay�t.ekleme(personel_no, yas, ad, soyad, meslek, cinsiyet, cal�st�g�_kat, k_no);
		}
		else if(islem=="sil") {
			sil.personelSil(personel_no);
		}
		else if(islem=="g�ncelle")
		{
			g�ncelle.g�ncelleme(personel_no, yas, ad, soyad, meslek, cinsiyet, cal�st�g�_kat, k_no);
		}
	}	
	public void ziyaretcilIslem(String ziy_no,String yas,String ad,String soyad,String islem) 
	{
		if(islem=="ekle") {
			kay�t.ekleme(ziy_no, yas, ad, soyad);
		}
		else if(islem=="sil") {
			sil.ziyaretciSil(ziy_no);
		}
		else if(islem=="g�ncelle")
		{
			g�ncelle.g�ncelleme(ziy_no, yas, ad, soyad);
		}
	}
	public void kurumlIslem(String kurum_no,String sehir,String ad,String telefon,String tarih,String yp_no,String islem) 
	{
		if(islem=="ekle") {
			kay�t.ekleme( kurum_no,sehir,ad,telefon,tarih,yp_no);
		}
		else if(islem=="sil") {
			sil.kurumSil(kurum_no);
		}
		else if(islem=="g�ncelle")
		{
			g�ncelle.g�ncelleme(kurum_no, sehir, ad, telefon, tarih, yp_no);
		}		
	}	
}


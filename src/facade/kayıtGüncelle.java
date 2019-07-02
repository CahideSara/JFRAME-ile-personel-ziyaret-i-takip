package facade;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import entity.*;
import utility.DatabaseConnection;
public class kayýtGüncelle {	
	public void güncelleme(String personel_no,String yas,String ad,String soyad, String meslek, String cinsiyet, String calýstýgý_kat, String k_no){
		try{
			Connection con =DatabaseConnection.connectDatabase();
	        Statement st =con.createStatement();
	        if(personel_no!=null && ad!=null && soyad!=null && meslek!=null ) {
	    personell p=new personell();
		p.setPersonel_no(personel_no);
		p.setYas(yas);
		p.setAd(ad);
		p.setSoyad(soyad);
		p.setMeslek(meslek);
		p.setCinsiyet(cinsiyet);
		p.setCalýstýgý_kat(calýstýgý_kat);
		p.setK_no(k_no);		
		  st.executeUpdate("update  personel set  ad='"+p.getAd()+"',soyad='"+p.getSoyad()
	            +"',meslek='"+p.getMeslek()+"',cinsiyet='"+p.getCinsiyet()+"',c_kat='"+p.getCalýstýgý_kat()+"',yas='"+p.getYas()+"',k_no='"+p.getK_no()
	            +"' where per_no="+p.getPersonel_no());
	            System.out.println("PERSONEL güncelledi");
	            JOptionPane.showMessageDialog(null,"KAYIT GÜNCELLENDÝ");
	        }   
	        }
	        catch(SQLException ex){
	            System.out.println(ex.getMessage());	            
	        }}	
	public void güncelleme(String ziy_no,String yas,String ad,String soyad){
		try{
			Connection con =DatabaseConnection.connectDatabase();
	        Statement st =con.createStatement();
	        
	    ziyaretci z=new ziyaretci();
		z.setZiy_no(ziy_no);
		z.setAd(ad);
		z.setSoyad(soyad);
		z.setYas(yas);
			
		  st.executeUpdate("update  ziyaretci set  ad='"+z.getAd()+"',soyad='"+z.getSoyad()+"',yas='"+z.getYas()+"' where ziy_no="+z.getZiy_no());
	            System.out.println("ziyaretci güncelledi");
	            
	        }
	        catch(SQLException ex){
	            System.out.println(ex.getMessage());
	            
	        }
}
	public void güncelleme(String kurum_no,String sehir,String ad,String telefon,String tarih,String yp_no){
		try {

			Connection con = DatabaseConnection.connectDatabase();
			Statement st = con.createStatement();
			if (kurum_no != null && ad != null && sehir != null && telefon != null && tarih != null && yp_no != null) {
				kurum k = new kurum();
				k.setK_no(kurum_no);
				k.setSehri(sehir);
				k.setAd(ad);
				k.setTelefon(telefon);
				k.setYýlý(tarih);
				k.setYöneticp_no(yp_no);
				

				String sorgu = "select per_no from personel where meslek='YÖNETÝCÝ' and per_no=" + k.getYöneticp_no()
						+ "";
                  
				
				try {

					ResultSet rs;
					rs = st.executeQuery(sorgu);
					personell p=new personell();
					
					int l = 0;
					while (rs.next()) {
				l=1;
					}
                  
					st.executeUpdate("update personel set meslek='ÝÞÇÝ' where per_no in (select yöneticip_no from  kurum  where k_no="+k.getK_no()+")");

					if (l == 1) {
						JOptionPane.showMessageDialog(null, "PERSONEL BAÞKA KURUMUN YÖNETÝCÝSÝDÝR");
					} else {


						  st.executeUpdate("update  kurum set  ad='"+k.getAd()+"',bulundugu_s='"+k.getSehri()
					            +"',telefon='"+k.getTelefon()+"',kurulus_y='"+k.getYýlý()+"',yöneticip_no='"+k.getYöneticp_no()+"' where k_no="+k.getK_no());
					            System.out.println("PERSONEL güncelledi");
					            JOptionPane.showMessageDialog(null,"KAYIT GÜNCELLENDÝ");
								st.executeUpdate("update personel set meslek='YÖNETÝCÝ' ,k_no="+k.getK_no()+" where per_no in (select yöneticip_no from  kurum  where k_no="+k.getK_no()+")");


					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}  }
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
     
	}
	}

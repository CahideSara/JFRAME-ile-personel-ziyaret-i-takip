package facade;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import entity.*;
import utility.DatabaseConnection;
public class kay�tG�ncelle {	
	public void g�ncelleme(String personel_no,String yas,String ad,String soyad, String meslek, String cinsiyet, String cal�st�g�_kat, String k_no){
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
		p.setCal�st�g�_kat(cal�st�g�_kat);
		p.setK_no(k_no);		
		  st.executeUpdate("update  personel set  ad='"+p.getAd()+"',soyad='"+p.getSoyad()
	            +"',meslek='"+p.getMeslek()+"',cinsiyet='"+p.getCinsiyet()+"',c_kat='"+p.getCal�st�g�_kat()+"',yas='"+p.getYas()+"',k_no='"+p.getK_no()
	            +"' where per_no="+p.getPersonel_no());
	            System.out.println("PERSONEL g�ncelledi");
	            JOptionPane.showMessageDialog(null,"KAYIT G�NCELLEND�");
	        }   
	        }
	        catch(SQLException ex){
	            System.out.println(ex.getMessage());	            
	        }}	
	public void g�ncelleme(String ziy_no,String yas,String ad,String soyad){
		try{
			Connection con =DatabaseConnection.connectDatabase();
	        Statement st =con.createStatement();
	        
	    ziyaretci z=new ziyaretci();
		z.setZiy_no(ziy_no);
		z.setAd(ad);
		z.setSoyad(soyad);
		z.setYas(yas);
			
		  st.executeUpdate("update  ziyaretci set  ad='"+z.getAd()+"',soyad='"+z.getSoyad()+"',yas='"+z.getYas()+"' where ziy_no="+z.getZiy_no());
	            System.out.println("ziyaretci g�ncelledi");
	            
	        }
	        catch(SQLException ex){
	            System.out.println(ex.getMessage());
	            
	        }
}
	public void g�ncelleme(String kurum_no,String sehir,String ad,String telefon,String tarih,String yp_no){
		try {

			Connection con = DatabaseConnection.connectDatabase();
			Statement st = con.createStatement();
			if (kurum_no != null && ad != null && sehir != null && telefon != null && tarih != null && yp_no != null) {
				kurum k = new kurum();
				k.setK_no(kurum_no);
				k.setSehri(sehir);
				k.setAd(ad);
				k.setTelefon(telefon);
				k.setY�l�(tarih);
				k.setY�neticp_no(yp_no);
				

				String sorgu = "select per_no from personel where meslek='Y�NET�C�' and per_no=" + k.getY�neticp_no()
						+ "";
                  
				
				try {

					ResultSet rs;
					rs = st.executeQuery(sorgu);
					personell p=new personell();
					
					int l = 0;
					while (rs.next()) {
				l=1;
					}
                  
					st.executeUpdate("update personel set meslek='����' where per_no in (select y�neticip_no from  kurum  where k_no="+k.getK_no()+")");

					if (l == 1) {
						JOptionPane.showMessageDialog(null, "PERSONEL BA�KA KURUMUN Y�NET�C�S�D�R");
					} else {


						  st.executeUpdate("update  kurum set  ad='"+k.getAd()+"',bulundugu_s='"+k.getSehri()
					            +"',telefon='"+k.getTelefon()+"',kurulus_y='"+k.getY�l�()+"',y�neticip_no='"+k.getY�neticp_no()+"' where k_no="+k.getK_no());
					            System.out.println("PERSONEL g�ncelledi");
					            JOptionPane.showMessageDialog(null,"KAYIT G�NCELLEND�");
								st.executeUpdate("update personel set meslek='Y�NET�C�' ,k_no="+k.getK_no()+" where per_no in (select y�neticip_no from  kurum  where k_no="+k.getK_no()+")");


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

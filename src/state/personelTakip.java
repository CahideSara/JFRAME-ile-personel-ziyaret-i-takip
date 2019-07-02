package state;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.giris_cikis;
import form_.baslangýc;
import utility.DatabaseConnection;

public class personelTakip implements takipDurumu{
	
	
baslangýc b = baslangýc.instance();
	
	
	  @Override
	  public void giris(String p_no,String sorgu) {

      

			Connection con =DatabaseConnection.connectDatabase();
			 String sorgu1="select per_no from personel where k_no="+b.k_no+" and per_no="+p_no;
	        try {
				Statement st =con.createStatement();
				ResultSet rs;
				rs=st.executeQuery(sorgu1);
				int l=0;
				 while(rs.next()) {
		              l=1;
					Statement st1 =con.createStatement();
					ResultSet rs1;
					rs1=st1.executeQuery(sorgu);
					giris_cikis gc =new giris_cikis();
					gc.setPersonel_no(p_no);
					
					 int k=0;
					   while(rs1.next()) {
						   gc.setCikis_t(rs1.getString("cikis_t"));
						   
						   if(gc.getCikis_t()==null) {
							   k=1;
						   }

					           }
					   
					   if(k==1) {
							JOptionPane.showMessageDialog(null,"ÇIKIÞ YAPMADAN GÝRÝÞ YAPAMAZSINIZ");

					   }
					   else {
						   Date now = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
							
						    
						   st1.executeUpdate("insert into giris_cikis(p_no,giris_t) values ("+gc.getPersonel_no()+",'"+ sdf.format(now)+"')");
							JOptionPane.showMessageDialog(null," GÝRÝÞ YAPILDI");

					   }	
				 }
				 if(l==0) {
						System.out.println("burda2");
						JOptionPane.showMessageDialog(null,"KURUMA KAYITLI BÖYLE BÝR PERSONEL YOKTUR");
					}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		  
		  
		  
	  }

	  @Override
	  public void cikis(String p_no,String sorgu) {
	  
		  
		  
		  
			Connection con =DatabaseConnection.connectDatabase();
			 String sorgu1="select per_no from personel where k_no="+b.k_no+" and per_no="+p_no;
	        try {
				Statement st =con.createStatement();
				ResultSet rs;
				rs=st.executeQuery(sorgu1);
				int l=0;
				 while(rs.next()) {
		              l=1;
					Statement st1 =con.createStatement();
					ResultSet rs1;
					rs1=st1.executeQuery(sorgu);
					giris_cikis gc =new giris_cikis();
					gc.setPersonel_no(p_no);
					
					 int k=0;
					 
					   while(rs1.next()) {
						   gc.setCikis_t(rs1.getString("cikis_t"));
						   gc.setGiris_t(rs1.getString("giris_t"));
						   
						   if(gc.getCikis_t()==null && gc.getGiris_t()!=null ) {
							 
						   Date now = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
											    
						   st1.executeUpdate("update giris_cikis set cikis_t='"+ sdf.format(now)+"' where giris_t='"+gc.getGiris_t()+"' and p_no="+gc.getPersonel_no());
							JOptionPane.showMessageDialog(null," ÇIKIÞ YAPILDI");
							break;
						   }
						
						  

					           }
					   
					  // if(k==1)
						//	JOptionPane.showMessageDialog(null," GÝRÝÞ YAPMADAN ÇIKIÞ YAPAMAZSINIZ");

				 }
				 if(l==0) {
						System.out.println("burda2");
						JOptionPane.showMessageDialog(null,"KURUMA KAYITLI BÖYLE BÝR PERSONEL YOKTUR");
					}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		  
		  
		  
	  }

}

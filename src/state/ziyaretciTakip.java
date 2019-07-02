package state;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


import entity.ziyaret_et;
import form_.baslangýc;
import utility.DatabaseConnection;

public class ziyaretciTakip implements takipDurumu {

	baslangýc b = baslangýc.instance();

	@Override
	public void cikis( String z_no,String sorgu) {

		  
		  
		Connection con =DatabaseConnection.connectDatabase();
		 String sorgu1="select ziy_no from ziyaretci where ziy_no="+z_no;
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
				ziyaret_et ze=new ziyaret_et();
				ze.setZ_no(z_no);
				
			
				 
				   while(rs1.next()) {
					   ze.setCikis(rs1.getString("cikis"));
					   ze.setGiris(rs1.getString("giris"));
					   
					   if(ze.getCikis()==null && ze.getGiris()!=null ) {
						 
					   Date now = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
										    
					   st1.executeUpdate("update ziyaret_et set cikis='"+ sdf.format(now)+"' where giris='"+ze.getGiris()+"' and z_no="+ze.getZ_no());
						JOptionPane.showMessageDialog(null," ÇIKIÞ YAPILDI");
						break;
					   }
					
					  

				           }
				   
				  // if(k==1)
					//	JOptionPane.showMessageDialog(null," GÝRÝÞ YAPMADAN ÇIKIÞ YAPAMAZSINIZ");

			 }
			 if(l==0) {
					System.out.println("burda2");
					JOptionPane.showMessageDialog(null,"GÝRÝÞ YAPMIÞ BÖYLE BÝR ZÝYARETÇÝ YOKTUR");
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	  
		
	}

	@Override
	public void giris(String p_no, String z_no) {

		Connection con = DatabaseConnection.connectDatabase();
		String sorgu = "select * from ziyaret_et  where z_no=" + z_no;
		String sorgu1 = "select per_no from personel where k_no=" + b.k_no + " and per_no=" + p_no;
		String sorgu2 = "select ziy_no from ziyaretci where ziy_no=" + z_no;
     
		ResultSet rs,rs1,rs2;
		
		try {

			Statement st = con.createStatement();
			
			ziyaret_et ze = new ziyaret_et();
			ze.setZ_no(z_no);
			ze.setP_no(p_no);

			int l = 0;
			int k = 0;
			 rs = st.executeQuery(sorgu1);
			while (rs.next()) {
				l = 1;
				Statement st1 = con.createStatement();
				rs1 = st1.executeQuery(sorgu2);
				while (rs1.next()) {
					k = 1;

				}

			}

			if (l == 0) {
				System.out.println("burda2");
				JOptionPane.showMessageDialog(null, "KURUMA KAYITLI BÖYLE BÝR PERSONEL YOKTUR");

			} else {

				if (k == 0) {
					System.out.println("burda2");
					JOptionPane.showMessageDialog(null, " BÖYLE BÝR ZÝYATERÇÝ YOKTUR");

				} else {

					int m = 0;
					Statement st2 = con.createStatement();
					 rs2 = st2.executeQuery(sorgu);
					while (rs2.next()) {
						ze.setCikis(rs2.getString("cikis"));

						if (ze.getCikis() == null) {
							m = 1;
						}

					}

					if (m == 1) {
						JOptionPane.showMessageDialog(null, "ÇIKIÞ YAPMADAN GÝRÝÞ YAPAMAZSINIZ");

					} else {

						Date now = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
						st.executeUpdate("insert into ziyaret_et(z_no,p_no,giris) values (" + z_no + "," + p_no + ",'"
								+ sdf.format(now) + "')");
						JOptionPane.showMessageDialog(null, " ZÝYARETÇÝ GÝRÝÞÝ YAPILDI");

					}

				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

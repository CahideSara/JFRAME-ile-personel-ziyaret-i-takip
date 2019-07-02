package facade;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import entity.*;
import utility.DatabaseConnection;
public class kayýtSil {
	public void personelSil(String personel_no){
		try{
			if(personel_no!=null) {
			Connection con =DatabaseConnection.connectDatabase();
	        Statement st =con.createStatement();
	 	    personell p=new personell();
		p.setPersonel_no(personel_no);		
		  st.executeUpdate("delete from  personel  where per_no="+p.getPersonel_no());
	            System.out.println("PERSONEL silindi");
	            JOptionPane.showMessageDialog(null,"KAYIT SÝLÝNDÝ");	            
	        }}
	        catch(SQLException ex){
	            System.out.println(ex.getMessage());	            
	        }
}
	public void ziyaretciSil(String ziy_no){
		try{
			Connection con =DatabaseConnection.connectDatabase();
	        Statement st =con.createStatement();	        
	    ziyaretci p=new ziyaretci();
		p.setZiy_no(ziy_no);		
		  st.executeUpdate("delete from  ziyaretci  where ziy_no="+p.getZiy_no());
	            System.out.println("ziyaretci silindi");	            
	        }
	        catch(SQLException ex){
	            System.out.println(ex.getMessage());	            
	        }
}	
	public void kurumSil(String k_no){
		try{
			Connection con =DatabaseConnection.connectDatabase();
	        Statement st =con.createStatement();
	        
	    kurum k=new kurum();
		k.setK_no(k_no);
	
		st.executeUpdate("delete from  giris_cikis   where p_no = (select yöneticip_no from kurum where k_no="+k.getK_no()+")");
		 Statement st1 =con.createStatement();
		st1.executeUpdate("delete from  ziyaret_et   where p_no =(select yöneticip_no from kurum where k_no="+k.getK_no()+")");
		 Statement st2 =con.createStatement();
		st2.executeUpdate("delete from  personel  where per_no = (select yöneticip_no from kurum where k_no="+k.getK_no()+")");
		 Statement st3 =con.createStatement();
		  st3.executeUpdate("delete from  kurum   where k_no="+k.getK_no());
		  JOptionPane.showMessageDialog(null, "KAYIT SÝLÝNDÝ");
	            System.out.println("ziyaretci silindi");
	            
	        }
	        catch(SQLException ex){
	            System.out.println(ex.getMessage());
	            
	        }
}
	
		
	
}

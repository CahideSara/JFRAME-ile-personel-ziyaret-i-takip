package form_;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import entity.kurum;
import entity.personell;
import utility.DatabaseConnection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class baslangýc extends JFrame {
	private JPanel contentPane;
	private JTextField textAd;
	private JTextField textNo;
	private JTextField textKN;

    public static String k_no;

	private static baslangýc ac; 
	private  static Object kilit=new Object();
 
	private baslangýc()
	{	
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
		setBounds(100, 100, 559, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel GÝRÝÞ = new JPanel();
		GÝRÝÞ.setBackground(new Color(205, 133, 63));
		GÝRÝÞ.setForeground(new Color(184, 134, 11));
		GÝRÝÞ.setBorder(new TitledBorder(null, "KURUM G\u0130R\u0130\u015E\u0130", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		GÝRÝÞ.setBounds(126, 74, 317, 311);
		contentPane.add(GÝRÝÞ);
		GÝRÝÞ.setLayout(null);
		
		JLabel lblYneticPersonel = new JLabel("Y\u00D6NET\u0130C\u0130 PERSONEL");
		lblYneticPersonel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYneticPersonel.setForeground(new Color(0, 0, 139));
		lblYneticPersonel.setBounds(79, 37, 137, 14);
		GÝRÝÞ.add(lblYneticPersonel);
		
		JLabel lblAd = new JLabel("ADI");
		lblAd.setBounds(26, 75, 38, 14);
		GÝRÝÞ.add(lblAd);
		
		textAd = new JTextField();
		textAd.setBounds(112, 72, 121, 20);
		GÝRÝÞ.add(textAd);
		textAd.setColumns(10);
		
		JLabel lblNosu = new JLabel("NOSU");
		lblNosu.setBounds(26, 114, 46, 14);
		GÝRÝÞ.add(lblNosu);
		
		textNo = new JTextField();
		textNo.setBounds(112, 111, 121, 20);
		GÝRÝÞ.add(textNo);
		textNo.setColumns(10);
		
		JButton btnGiri = new JButton("G\u0130R\u0130\u015E");
		btnGiri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
		        try{ 
		        	Connection con =DatabaseConnection.connectDatabase();
		          	String m="YÖNETÝCÝ";
		            Statement st =con.createStatement();
		            ResultSet rs= st.executeQuery("SELECT * FROM personel where meslek='"+m+"' and k_no='"+Integer.parseInt(textKN.getText())+"'");
		            rs.next();
		            personell p=new personell();
		            p.setAd(textAd.getText());
		            p.setPersonel_no(textNo.getText());
		            System.out.println(rs.getString("ad"));
		            kurum k=new kurum();
		            k.setK_no(textKN.getText());
		           
		            
		            if(p.getAd().equals(rs.getString("ad")) && p.getPersonel_no().equals(rs.getString("per_no"))){
		            	
		                
                       giris g=new giris();
                       
		            	g.show();
		                dispose();
		            }
		            else{
		           	 JOptionPane.showMessageDialog(null,"BÖYLE BÝR YÖNETÝCÝ BULUNMAMAKTADIR!!!");

		            }
		        }
		        catch(SQLException ex){
		            System.out.println(ex.getMessage());
		            
		        }
				
		        
			}
		});
		btnGiri.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGiri.setBounds(112, 203, 121, 42);
		GÝRÝÞ.add(btnGiri);
		
		JLabel lblKurumNo = new JLabel("KURUM NO");
		lblKurumNo.setBounds(26, 153, 81, 14);
		GÝRÝÞ.add(lblKurumNo);
		
		textKN = new JTextField();
		textKN.setBounds(112, 153, 121, 20);
		GÝRÝÞ.add(textKN);
		textKN.setColumns(10);
	}

	public static baslangýc instance () {

		if(ac==null)
		{
			synchronized(kilit) {
				
				ac=new baslangýc();
				 k_no=ac.textKN.getText();
			}
			
		}
		else
		{
			 k_no=ac.textKN.getText();	
		}
		return  ac;
	}
	


}

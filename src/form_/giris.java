package form_;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import net.proteanit.sql.DbUtils;
import state.takip;
import state.ziyaretciTakip;
import utility.DatabaseConnection;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class giris extends JFrame {

	private JPanel contentPane;

	private JTextField textPno;
	
	private JTable table_2;
	private JTable table_1;
	private JTextField zno;
	private JTextField perno;
	 
	baslangýc b= baslangýc.instance();
      
      takip t = new takip();
	 public void listeleme(String sorgu,JTable tab){
			Connection con =DatabaseConnection.connectDatabase();
 
	        try {
				Statement st =con.createStatement();
				ResultSet rs=st.executeQuery(sorgu);
				tab.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		 
	 }
	 

	public giris() {
		setTitle("ANA SAYFA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1110, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 235, 523, 369);
		contentPane.add(scrollPane);
		
		
		
		
		JLabel lblPersonelGirik = new JLabel("PERSONEL G\u0130R\u0130\u015E \u00C7IKI\u015E TABLOSU\r\n");
		lblPersonelGirik.setBounds(34, 202, 260, 34);
		lblPersonelGirik.setForeground(new Color(128, 0, 0));
		lblPersonelGirik.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPersonelGirik);
		
		JLabel lblPersonelNo = new JLabel("PERSONEL NO");
		lblPersonelNo.setBounds(36, 55, 105, 14);
		contentPane.add(lblPersonelNo);
		
		textPno = new JTextField();
		textPno.setBounds(133, 52, 143, 20);
		contentPane.add(textPno);
		textPno.setColumns(10);
		
		
		
		
		JButton btnGiris = new JButton("G\u0130R\u0130\u015E");
		btnGiris.setToolTipText("");
		btnGiris.setBounds(33, 103, 89, 47);
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 String sorgu="select g.p_no,p.ad,p.soyad,g.giris_t,g.cikis_t from giris_cikis g ,personel p where  g.p_no in ( select p.per_no from personel p where p.k_no="+b.k_no+") and p.per_no=g.p_no ";
				 String sorgu1="select * from giris_cikis g where g.p_no in ( select p.per_no from personel p where p.k_no="+b.k_no+" and p.per_no="+textPno.getText()+") ";

				 
				    t.giris(textPno.getText(), sorgu1);

				
				listeleme(sorgu,table_2);
				
				
			}
		});
		btnGiris.setBackground(new Color(0, 128, 0));
		btnGiris.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGiris.setForeground(new Color(0, 0, 0));
		contentPane.add(btnGiris);
		
		table_1 = new JTable();
		table_1.setBounds(991, 346, -125, -153);
		contentPane.add(table_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table_2.setBounds(629, 244, 237, 135);
		scrollPane.setViewportView(table_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(588, 235, 469, 369);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_1.setBounds(750, 343, 240, 134);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblZiyaretiKontrol = new JLabel("Z\u0130YARET\u00C7\u0130 KONTROL\u00DC");
		lblZiyaretiKontrol.setForeground(new Color(128, 0, 0));
		lblZiyaretiKontrol.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblZiyaretiKontrol.setBackground(new Color(128, 0, 0));
		lblZiyaretiKontrol.setBounds(588, 208, 143, 26);
		contentPane.add(lblZiyaretiKontrol);
		
		JButton kayýt = new JButton("\r\n\u0130\u015ELEMLER\r\n");
		kayýt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				islemler k=new islemler();
				k.show();
			}
		});
		kayýt.setForeground(new Color(204, 204, 153));
		kayýt.setBackground(new Color(0, 102, 102));
		kayýt.setFont(new Font("Tahoma", Font.BOLD, 12));
		kayýt.setBounds(906, 75, 149, 103);
		contentPane.add(kayýt);
		
		JLabel lblZiyaretiNo = new JLabel("Z\u0130YARET\u00C7\u0130 NO");
		lblZiyaretiNo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZiyaretiNo.setBounds(588, 78, 105, 14);
		contentPane.add(lblZiyaretiNo);
		
		zno = new JTextField();
		zno.setBounds(695, 75, 143, 20);
		contentPane.add(zno);
		zno.setColumns(10);
		
		JLabel lblPersonelNo_1 = new JLabel("PERSONEL NO");
		lblPersonelNo_1.setBounds(588, 122, 105, 14);
		contentPane.add(lblPersonelNo_1);
		
		perno = new JTextField();
		perno.setBounds(695, 119, 143, 20);
		contentPane.add(perno);
		perno.setColumns(10);
		
		JButton zgiris = new JButton("Z\u0130YARETC\u0130 G\u0130R\u0130\u015E");
		zgiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				t.durumDeðiþtir( new ziyaretciTakip());
				t.giris(perno.getText(), zno.getText());

		
				
				
				String sorgu="select ze.z_no,z.ad,z.soyad,ze.p_no,ze.giris,ze.cikis from ziyaret_et ze,ziyaretci z where p_no  in ( select p.per_no from personel p where p.k_no="+b.k_no+") and z.ziy_no=ze.z_no";
				listeleme(sorgu, table_1);
			}
		});
		zgiris.setFont(new Font("Tahoma", Font.BOLD, 12));
		zgiris.setBackground(new Color(51, 255, 51));
		zgiris.setBounds(695, 150, 143, 26);
		contentPane.add(zgiris);
		
		JButton cks = new JButton("\u00C7IKI\u015E");
		cks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String sorgu="select g.p_no,p.ad,p.soyad,g.giris_t,g.cikis_t from giris_cikis g ,personel p where  g.p_no in ( select p.per_no from personel p where p.k_no="+b.k_no+") and p.per_no=g.p_no ";
				 String sorgu1="select * from giris_cikis g where  g.p_no in ( select p.per_no from personel p where p.k_no="+b.k_no+" and p.per_no="+textPno.getText()+") ";
				 takip t = new takip();
				 t.cikis(textPno.getText(), sorgu1);
				 listeleme(sorgu,table_2);
			}
		});
		cks.setBackground(Color.RED);
		cks.setBounds(186, 104, 90, 47);
		contentPane.add(cks);
		
		JButton zcikis = new JButton("Z\u0130YARETC\u0130 \u00C7IKI\u015E");
		zcikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		 String sorgu1="select * from ziyaret_et  where  z_no ="+zno.getText()+" and p_no  in ( select p.per_no from personel p where p.k_no="+b.k_no+") ";

				
				t.durumDeðiþtir( new ziyaretciTakip());
				t.cikis( zno.getText(),sorgu1);	
				
				
				String sorgu="select ze.z_no,z.ad,z.soyad,ze.p_no,ze.giris,ze.cikis from ziyaret_et ze,ziyaretci z where p_no  in ( select p.per_no from personel p where p.k_no="+b.k_no+") and z.ziy_no=ze.z_no";
				listeleme(sorgu, table_1);
				
			
				
				
				
			}
		});
		zcikis.setBackground(Color.RED);
		zcikis.setFont(new Font("Tahoma", Font.BOLD, 11));
		zcikis.setBounds(695, 178, 143, 23);
		contentPane.add(zcikis);
		//contentPane.add(table_1);
		//contentPane.add(table);
		this.setLocationRelativeTo(null);
	}
}

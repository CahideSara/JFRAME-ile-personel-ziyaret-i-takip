package form_;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.kurum;
import facade.facade;

import net.proteanit.sql.DbUtils;
import utility.DatabaseConnection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.event.ActionEvent;

public class personelFORM extends JFrame {

	private JPanel contentPane;
	private JTextField perno;
	private JTextField ad;
	private JTable table;
	private JLabel lblSoyad;
	private JLabel lblMeslek;
	private JLabel lblKat;
	private JLabel lblYa;
	private JLabel lblCinsiyet;
	private JTextField soyad;
	private JLabel lblKurumNo;
	private JScrollPane scrollPane_1;
	private JTextField k_no;

	/**
	 * Launch the application.
	 */
	
	baslangýc b= baslangýc.instance();
	 public void listeleme(){
			Connection con =DatabaseConnection.connectDatabase();
			String sorgu="select*from personel";
	        try {
				Statement st =con.createStatement();
				ResultSet rs=st.executeQuery(sorgu);
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		 
	 }

	public personelFORM() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1095, 528);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblPersonelNo = new JLabel("PERSONEL NO");
		lblPersonelNo.setBounds(42, 41, 92, 14);
		lblPersonelNo.setForeground(new Color(102, 255, 255));
		contentPane.add(lblPersonelNo);
		
		perno = new JTextField();
		perno.setBounds(134, 35, 140, 20);
		contentPane.add(perno);
		perno.setColumns(10);
		
		JLabel lblAd = new JLabel("AD");
		lblAd.setBounds(42, 78, 67, 14);
		lblAd.setForeground(new Color(102, 255, 255));
		contentPane.add(lblAd);
		
		ad = new JTextField();
		ad.setBounds(134, 72, 140, 20);
		contentPane.add(ad);
		ad.setColumns(10);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(395, 11, 674, 467);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PERSONEL NO", "AD", "SOYAD", "MESLEK", "CÝNSÝYET", "KATI", "YAÞI","KURUM NO"
			}
		));
		table.setBounds(544, 146, 129, 79);
		scrollPane.setViewportView(table);
		
		JComboBox meslek = new JComboBox();
		meslek.setModel(new DefaultComboBoxModel(new String[] {"SEKRETER", "BAKICI", "MUHASEBEC\u0130", "\u0130\u015E\u00C7\u0130", "SUCU", "\u0130TFA\u0130YE", "KUAF\u00D6R", "A\u015E\u00C7I", "B\u0130L.M\u00DCH", "MAK\u0130NE M\u00DCH."}));
		meslek.setBounds(134, 155, 140, 20);
		contentPane.add(meslek);
		//contentPane.add(table);
		this.setLocationRelativeTo(null);
		
		lblSoyad = new JLabel("SOYAD");
		lblSoyad.setBounds(42, 114, 82, 14);
		lblSoyad.setForeground(new Color(102, 255, 255));
		contentPane.add(lblSoyad);
		
		lblMeslek = new JLabel("MESLEK");
		lblMeslek.setBounds(42, 158, 82, 14);
		lblMeslek.setForeground(new Color(102, 255, 255));
		contentPane.add(lblMeslek);
		
		lblKat = new JLabel("KATI");
		lblKat.setBounds(42, 239, 82, 14);
		lblKat.setForeground(new Color(102, 255, 255));
		contentPane.add(lblKat);
		
		lblYa = new JLabel("YA\u015E");
		lblYa.setBounds(42, 275, 82, 14);
		lblYa.setForeground(new Color(102, 255, 255));
		contentPane.add(lblYa);
		
		lblCinsiyet = new JLabel("C\u0130NS\u0130YET");
		lblCinsiyet.setBounds(42, 199, 82, 14);
		lblCinsiyet.setForeground(new Color(102, 255, 255));
		contentPane.add(lblCinsiyet);
		
		soyad = new JTextField();
		soyad.setBounds(134, 111, 140, 20);
		contentPane.add(soyad);
		soyad.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(134, 196, 140, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"KADIN", "ERKEK"}));
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(134, 236, 140, 20);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(134, 272, 140, 20);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"18", "19", "20", "21", "22", "23", "24", "25",
				"26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41",
				"42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		contentPane.add(comboBox_2);
		
		JButton ekle = new JButton("EKLE");
		ekle.setBounds(27, 346, 97, 34);
		ekle.addActionListener(new ActionListener() {
			kurum l;
			public void actionPerformed(ActionEvent e) {
				
				facade f=new facade();
			
				f.personelIslem(perno.getText(),(String)comboBox_2.getModel().getSelectedItem(), ad.getText(), soyad.getText(), (String)meslek.getModel().getSelectedItem()
						, (String)comboBox.getModel().getSelectedItem(), (String)comboBox_1.getModel().getSelectedItem()
						,k_no.getText(),"ekle");
				
				
				
				listeleme();
			
			}
		});
		ekle.setBackground(new Color(102, 204, 51));
		ekle.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(ekle);
		
		JButton btnSil = new JButton("S\u0130L");
		btnSil.setBounds(144, 346, 97, 34);
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facade f=new facade();
				
				f.personelIslem(perno.getText(),(String)comboBox_2.getModel().getSelectedItem(), ad.getText(), soyad.getText(),(String)meslek.getModel().getSelectedItem()
						, (String)comboBox.getModel().getSelectedItem(), (String)comboBox_1.getModel().getSelectedItem()
						,k_no.getText(),"sil");
				
				
				listeleme();
			}
		});
		
		
		
		
		btnSil.setBackground(new Color(153, 0, 0));
		btnSil.setForeground(new Color(0, 0, 0));
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnSil);
		
		JButton btnGncelle = new JButton("G\u00DCNCELLE");
		btnGncelle.setBounds(265, 347, 97, 34);
		btnGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facade f=new facade();
				
				f.personelIslem(perno.getText(),(String)comboBox_2.getModel().getSelectedItem(), ad.getText(), soyad.getText(), (String)meslek.getModel().getSelectedItem()
						, (String)comboBox.getModel().getSelectedItem(), (String)comboBox_1.getModel().getSelectedItem()
						,k_no.getText(),"güncelle");
				
				listeleme();
				
			}
		});
		btnGncelle.setBackground(new Color(204, 255, 0));
		contentPane.add(btnGncelle);
		
		JButton btnListele = new JButton("L\u0130STELE");
		btnListele.setBounds(134, 426, 140, 41);
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listeleme();
		        

			}
		});
		
		
		
	
		
		
		
		
		
		btnListele.setBackground(new Color(204, 102, 0));
		btnListele.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnListele);
		
		lblKurumNo = new JLabel("KURUM NO");
		lblKurumNo.setBounds(42, 310, 92, 14);
		lblKurumNo.setForeground(new Color(102, 255, 255));
		lblKurumNo.setBackground(new Color(153, 255, 255));
		contentPane.add(lblKurumNo);
		
		k_no = new JTextField();
		k_no.setText(b.k_no);
		k_no.setBounds(134, 303, 140, 20);
		contentPane.add(k_no);
		k_no.setColumns(10);
		
		
	}
}

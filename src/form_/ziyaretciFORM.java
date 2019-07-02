package form_;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import facade.facade;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


import net.proteanit.sql.DbUtils;
import utility.DatabaseConnection;
public class ziyaretciFORM extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField zno;
	private JTextField zad;
	private JTextField zsoyad;
	private JTextField zyas;

	
	 public void listeleme(){
			Connection con =DatabaseConnection.connectDatabase();
			String sorgu="select*from ziyaretci";
	        try {
				Statement st =con.createStatement();
				ResultSet rs=st.executeQuery(sorgu);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		 
	 }

	
	
	
	public ziyaretciFORM() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 825, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(382, 11, 402, 386);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblZiyaretiNo = new JLabel("Z\u0130YARET\u00C7\u0130 NO");
		lblZiyaretiNo.setForeground(new Color(51, 255, 255));
		lblZiyaretiNo.setBounds(41, 38, 106, 14);
		contentPane.add(lblZiyaretiNo);
		
		zno = new JTextField();
		zno.setBounds(145, 32, 126, 20);
		contentPane.add(zno);
		zno.setColumns(10);
		
		JLabel lblAd = new JLabel("AD");
		lblAd.setForeground(new Color(51, 255, 255));
		lblAd.setBounds(41, 80, 46, 14);
		contentPane.add(lblAd);
		
		zad = new JTextField();
		zad.setBounds(145, 74, 126, 20);
		contentPane.add(zad);
		zad.setColumns(10);
		
		JLabel lblSoyad = new JLabel("SOYAD");
		lblSoyad.setForeground(new Color(51, 255, 255));
		lblSoyad.setBounds(41, 122, 79, 14);
		contentPane.add(lblSoyad);
		
		zsoyad = new JTextField();
		zsoyad.setBounds(145, 116, 126, 20);
		contentPane.add(zsoyad);
		zsoyad.setColumns(10);
		
		JLabel lblYa = new JLabel("YA\u015E");
		lblYa.setForeground(new Color(51, 255, 255));
		lblYa.setBounds(41, 163, 46, 14);
		contentPane.add(lblYa);
		
		zyas = new JTextField();
		zyas.setBounds(145, 157, 126, 20);
		contentPane.add(zyas);
		zyas.setColumns(10);
		
		JButton zekle = new JButton("EKLE");
		zekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				facade f=new facade();
				f.ziyaretcilIslem(zno.getText(), zyas.getText(), zad.getText(), zsoyad.getText(), "ekle");
				
				listeleme();
			}
		});
		zekle.setFont(new Font("Tahoma", Font.BOLD, 12));
		zekle.setBackground(new Color(51, 204, 51));
		zekle.setBounds(20, 229, 106, 38);
		contentPane.add(zekle);
		
		JButton zsil = new JButton("S\u0130L");
		zsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facade f=new facade();
				f.ziyaretcilIslem(zno.getText(), zyas.getText(), zad.getText(), zsoyad.getText(), "sil");
				listeleme();
			}
		});
		zsil.setFont(new Font("Tahoma", Font.BOLD, 12));
		zsil.setBackground(new Color(153, 0, 0));
		zsil.setBounds(136, 229, 106, 38);
		contentPane.add(zsil);
		
		JButton zgüncelle = new JButton("G\u00DCNCELLE");
		zgüncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facade f=new facade();
				f.ziyaretcilIslem(zno.getText(), zyas.getText(), zad.getText(), zsoyad.getText(), "güncelle");
				listeleme();
			}
		});
		zgüncelle.setFont(new Font("Tahoma", Font.BOLD, 12));
		zgüncelle.setBackground(new Color(153, 255, 0));
		zgüncelle.setBounds(249, 229, 106, 38);
		contentPane.add(zgüncelle);
		
		JButton btnListele = new JButton("L\u0130STELE");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listeleme();
			}
		});
		btnListele.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListele.setBackground(new Color(204, 102, 51));
		btnListele.setBounds(136, 312, 106, 46);
		contentPane.add(btnListele);
	}
}

package form_;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import facade.facade;
import net.proteanit.sql.DbUtils;
import utility.DatabaseConnection;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class kurumFORM extends JFrame {

	private JPanel contentPane;
	private JTextField sehir;
	private JTextField ad;
	private JTextField tel;
	private JTextField yp;
	private JTextField kno;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kurumFORM frame = new kurumFORM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	 public void listeleme(){
			Connection con =DatabaseConnection.connectDatabase();
			String sorgu="select*from kurum";
	        try {
				Statement st =con.createStatement();
				ResultSet rs=st.executeQuery(sorgu);
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		 
	 }
	
	
	
	public kurumFORM() {
		setTitle("KURUM KAYIT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 922, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		
		
		JLabel lblNewLabel = new JLabel("KURUM NO:");
		lblNewLabel.setBounds(37, 37, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BULUNDU\u011EU \u015EEH\u0130R:");
		lblNewLabel_1.setBounds(37, 86, 141, 14);
		contentPane.add(lblNewLabel_1);
		
		sehir = new JTextField();
		sehir.setBackground(new Color(255, 204, 255));
		sehir.setBounds(188, 83, 116, 20);
		contentPane.add(sehir);
		sehir.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u015E\u0130RKET ADI:");
		lblNewLabel_2.setBounds(37, 135, 109, 14);
		contentPane.add(lblNewLabel_2);
		
		ad = new JTextField();
		ad.setBackground(new Color(255, 204, 255));
		ad.setBounds(188, 132, 116, 20);
		contentPane.add(ad);
		ad.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("TELEFON:");
		lblNewLabel_3.setBounds(37, 185, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		tel = new JTextField();
		tel.setBackground(new Color(255, 204, 255));
		tel.setBounds(188, 182, 116, 20);
		contentPane.add(tel);
		tel.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("KURULU\u015E YILI:");
		lblNewLabel_4.setBounds(37, 229, 96, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Y\u00D6NET\u0130C\u0130 PERSONEL\u0130:");
		lblNewLabel_5.setBounds(37, 271, 141, 14);
		contentPane.add(lblNewLabel_5);
		
		yp = new JTextField();
		yp.setBackground(new Color(255, 204, 255));
		yp.setBounds(188, 268, 116, 20);
		contentPane.add(yp);
		yp.setColumns(10);
		
		kno = new JTextField();
		kno.setBackground(new Color(255, 204, 255));
		kno.setBounds(188, 34, 116, 20);
		contentPane.add(kno);
		kno.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBackground(new Color(255, 204, 255));
		dateChooser.setBounds(188, 223, 116, 20);
		contentPane.add(dateChooser);
		
		JButton ekle = new JButton("EKLE");
		ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				facade f=new facade();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				f.kurumlIslem(kno.getText(), sehir.getText(), ad.getText(), tel.getText(), sdf.format(dateChooser.getDate()), yp.getText(), "ekle");
				
				listeleme();
			}
		});
		ekle.setBackground(Color.GREEN);
		ekle.setForeground(Color.BLACK);
		ekle.setBounds(21, 330, 89, 35);
		contentPane.add(ekle);
		
		JButton sil = new JButton("S\u0130L");
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				facade f=new facade();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				f.kurumlIslem(kno.getText(),null,null, null, null, null, "sil");
				
				listeleme();
			}
		});
		sil.setBackground(Color.RED);
		sil.setBounds(120, 330, 89, 35);
		contentPane.add(sil);
		
		JButton güncelle = new JButton("G\u00DCNCELLE");
		güncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				facade f=new facade();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
				f.kurumlIslem(kno.getText(), sehir.getText(), ad.getText(), tel.getText(), sdf.format(dateChooser.getDate()), yp.getText(), "güncelle");
				
				
				listeleme();

			}
		});
		güncelle.setBackground(Color.ORANGE);
		güncelle.setBounds(219, 330, 96, 35);
		contentPane.add(güncelle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(356, 36, 540, 328);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnListele = new JButton("L\u0130STELE");
		btnListele.setForeground(new Color(204, 255, 204));
		btnListele.setBackground(new Color(0, 51, 0));
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listeleme();
			}
		});
		btnListele.setBounds(120, 376, 116, 31);
		contentPane.add(btnListele);
	}
}

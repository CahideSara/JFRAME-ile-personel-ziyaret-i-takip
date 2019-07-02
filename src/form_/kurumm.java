package form_;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;
import utility.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import java.awt.Color;

public class kurumm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kurumm frame = new kurumm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	 public void listeleme(Date bt,Date bitis){
		 
		 Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
		 Connection con =DatabaseConnection.connectDatabase();
		 
	     String sorgu="select ze.p_no,count(ge.giris_t) ,count(ze.p_no) from giris_cikis ge,ziyaret_et ze where ge.giris_t between '"
		+bt+"' and '"+bitis+"' and ze.giris  between '"+sdf.format(bt)+"' and '"+sdf.format(bitis)+"'  group by ge.giris_t,ze.p_no  ;";
		      
	     
	     
	     String sorgu2="select giris_cikis.p_no,count(giris_cikis.p_no) from giris_cikis  where giris_cikis.giris_t between '"	+bt+"' and '"+bitis+"' group by giris_cikis.p_no  ";
	     
	     String sorgu12="select giris_cikis.p_no,count(giris_cikis.p_no),personel.ad,personel.soyad  from giris_cikis inner join personel on personel.per_no=giris_cikis.p_no group by giris_cikis.p_no having giris_cikis.giris_t between '"
	    			+bt+"' and '"+bitis+"' ";
	     
	     
	     String sorgu1="select personel.ad,personel.soyad,ziyaret_et.p_no,count(ziyaret_et.p_no) from   giris_cikis inner join  personel  on personel.per_no=giris_cikis.p_no group by giris_cikis.p_no inner join ziyaret_et  on ziyaret_et.p_no=personel.per_no group by ziyaret_et.p_no";

	     String sorgu8="select ze.p_no,count(ge.giris_t) ,count(ze.p_no) from giris_cikis ge,ziyaret_et ze where ge.giris_t between '"
	    			+bt+"' and '"+bitis+"' and ze.giris  between '"+sdf.format(bt)+"' and '"+sdf.format(bitis)+"'  group by ge.giris_t,ze.p_no;";
	    			      
	     
	     
	     try {
					Statement st =con.createStatement();
					ResultSet rs=st.executeQuery(sorgu2);
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					System.out.println("bu");	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("b");
					e.printStackTrace();
				}
	
	       
	   	        
	 }
	
	
	
	
	

	
	public kurumm() {
		setTitle("KURUM \u0130\u015ELEM");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 618, 413);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setLocationRelativeTo(null);
		
		
		table = new JTable();
		table.setBounds(547, 280, -268, -244);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(252, 36, 328, 303);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JDateChooser dateBas = new JDateChooser();
		dateBas.setBackground(new Color(255, 255, 204));
		dateBas.setDateFormatString("yyyy.MM.dd hh:mm:ss");
		dateBas.setBounds(48, 67, 156, 20);
		contentPane.add(dateBas);
		
		JLabel lblRaporBaslangcTarihi = new JLabel("Rapor baslang\u0131c tarihi");
		lblRaporBaslangcTarihi.setBounds(10, 36, 198, 20);
		contentPane.add(lblRaporBaslangcTarihi);
		
		JLabel lblRaporBitiTarihi = new JLabel("Rapor biti\u015F tarihi");
		lblRaporBitiTarihi.setBounds(10, 98, 208, 32);
		contentPane.add(lblRaporBitiTarihi);
		
		JDateChooser dateBit = new JDateChooser();
		dateBit.setBackground(new Color(255, 255, 204));
		dateBit.setDateFormatString("yyyy.MM.dd hh:mm:ss");
		dateBit.setBounds(48, 141, 156, 20);
		contentPane.add(dateBit);
		
		JButton raporla = new JButton("RAPOR \u00C7IKAR\r\n");
		raporla.setBackground(new Color(204, 102, 153));
		raporla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				
				listeleme(dateBas.getDate(), dateBit.getDate());
			}

			
			
		
			
			
		   });
		raporla.setBounds(69, 182, 101, 37);
		contentPane.add(raporla);
		
		JButton krm = new JButton("KURUM KAYIT\r\n");
		krm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				kurumFORM zf=new kurumFORM();
				zf.show();
			    dispose();
				
			}
		});
		krm.setBounds(10, 291, 128, 48);
		contentPane.add(krm);
		
	
	}
}

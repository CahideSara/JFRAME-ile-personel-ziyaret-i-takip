package form_;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class islemler extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public islemler() {
		setBackground(new Color(204, 153, 102));
		setTitle("\u0130\u015ELEMLER");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton pkayýt = new JButton("PERSONEL KAYIT");
		pkayýt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personelFORM pf=new personelFORM();
				pf.show();
			    dispose();
			}
		});
		pkayýt.setForeground(new Color(204, 153, 102));
		pkayýt.setBackground(new Color(0, 0, 0));
		pkayýt.setFont(new Font("Tahoma", Font.BOLD, 13));
		pkayýt.setBounds(136, 70, 198, 56);
		contentPane.add(pkayýt);
		
		JButton zkayýt = new JButton("Z\u0130YARET\u00C7\u0130 KAYIT");
		zkayýt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ziyaretciFORM zf=new ziyaretciFORM();
				zf.show();
			    dispose();
				
			}
		});
		zkayýt.setFont(new Font("Tahoma", Font.BOLD, 13));
		zkayýt.setForeground(new Color(204, 153, 102));
		zkayýt.setBackground(new Color(0, 0, 0));
		zkayýt.setBounds(136, 182, 198, 56);
		contentPane.add(zkayýt);
		
		JButton btnKurumKayt = new JButton("KURUM \u0130\u015ELEMLER\u0130");
		btnKurumKayt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				kurumm zf=new kurumm();
				zf.show();
			    dispose();
			}
		});
		btnKurumKayt.setForeground(new Color(204, 153, 102));
		btnKurumKayt.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnKurumKayt.setBackground(new Color(0, 0, 0));
		btnKurumKayt.setBounds(136, 293, 198, 56);
		contentPane.add(btnKurumKayt);
		this.setLocationRelativeTo(null);
	}

}

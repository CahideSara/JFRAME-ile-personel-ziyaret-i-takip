package facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.*;
import utility.DatabaseConnection;

public class kayýtEtme {
	public void ekleme(String personel_no, String yas, String ad, String soyad, String meslek, String cinsiyet,
			String calýstýgý_kat, String k_no) {
		try {
			Connection con = DatabaseConnection.connectDatabase();
			Statement st = con.createStatement();
			if (personel_no != null && ad != null && soyad != null && meslek != null) {
				personell p = new personell();
				p.setPersonel_no(personel_no);
				p.setYas(yas);
				p.setAd(ad);
				p.setSoyad(soyad);
				p.setMeslek(meslek);
				p.setCinsiyet(cinsiyet);
				p.setCalýstýgý_kat(calýstýgý_kat);
				p.setK_no(k_no);
				st.executeUpdate("insert into personel(ad,soyad,meslek,per_no,cinsiyet,c_kat,yas,k_no) values ('"
						+ p.getAd() + "','" + p.getSoyad() + "','" + p.getMeslek() + "','" + p.getPersonel_no() + "','"
						+ p.getCinsiyet() + "','" + p.getCalýstýgý_kat() + "','" + p.getYas() + "','" + p.getK_no()
						+ "')");
				System.out.println("PERSONEL ekledi");
				JOptionPane.showMessageDialog(null, "KAYIT EKLENDÝ");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void ekleme(String ziy_no, String yas, String ad, String soyad) {
		try {
			Connection con = DatabaseConnection.connectDatabase();
			Statement st = con.createStatement();

			ziyaretci z = new ziyaretci();
			z.setZiy_no(ziy_no);
			z.setYas(yas);
			z.setAd(ad);
			z.setSoyad(soyad);

			st.executeUpdate("insert into ziyaretci(ad,soyad,ziy_no,yas) values ('" + z.getAd() + "','" + z.getSoyad()
					+ "','" + z.getZiy_no() + "','" + z.getYas() + "')");
			System.out.println("ziyaretci ekledi");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void ekleme(String kurum_no, String sehir, String ad, String telefon, String tarih, String yp_no) {
		try {
			Connection con = DatabaseConnection.connectDatabase();
			Statement st = con.createStatement();
			if (kurum_no != null && ad != null && sehir != null && telefon != null && tarih != null && yp_no != null) {
				kurum k = new kurum();
				k.setK_no(kurum_no);
				k.setSehri(sehir);
				k.setAd(ad);
				k.setTelefon(telefon);
				k.setYýlý(tarih);
				k.setYöneticp_no(yp_no);
				String sorgu = "select per_no from personel where meslek='YÖNETÝCÝ' and per_no=" + k.getYöneticp_no()
						+ "";
				try {
					ResultSet rs;
					rs = st.executeQuery(sorgu);
					int l = 0;
					while (rs.next()) {
						l = 1;
					}
					if (l == 1) {
						JOptionPane.showMessageDialog(null, "PERSONEL BAÞKA KURUMUN YÖNETÝCÝSÝDÝR");
					} else {

						st.executeUpdate(
								"insert into kurum(k_no,bulundugu_s,ad,telefon,kurulus_y,yöneticip_no) values ('"
										+ k.getK_no() + "','" + k.getSehri() + "','" + k.getAd() + "','"
										+ k.getTelefon() + "','" + k.getYýlý() + "','" + k.getYöneticp_no() + "')");
						System.out.println("PERSONEL ekledi");
						JOptionPane.showMessageDialog(null, "KURUM EKLENDÝ");
						st.executeUpdate("update personel set meslek='YÖNETÝCÝ',k_no=" + k.getK_no() + " where per_no="
								+ k.getYöneticp_no() + "");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());

		}

	}

}

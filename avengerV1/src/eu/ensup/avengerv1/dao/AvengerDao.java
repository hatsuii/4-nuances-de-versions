package eu.ensup.avengerv1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import eu.ensup.avengerv1.domaine.Avenger;

public class AvengerDao {

	private Statement st = null;
	private ConnectionDao connex;

	public void createAvenger(Avenger avenger) {

		connex = new ConnectionDao();
		Connection con = connex.getInstance();
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "INSERT INTO `membre` (`age`,`nom`,`costume`,`pouvoir`) VALUES ('" + avenger.age + "','"
				+ avenger.name + "','" + avenger.costume + "','" + avenger.pouvoir + "')";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateAvenger(Avenger avenger) {

		connex = new ConnectionDao();
		try {
			st = connex.getInstance().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "UPDATE `membre` (`age`,`nom`,`costume`,`pouvoir`) SET age='" + avenger.age + "', nom'"
				+ avenger.name + "', costume='" + avenger.costume + "',pouvoir='" + avenger.pouvoir + "' WHERE nom='"
				+ avenger.name + "'";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteAvenger(Avenger avenger) {

		connex = new ConnectionDao();
		try {
			st = connex.getInstance().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "DELETE FROM `membre` WHERE nom= '" + avenger.name + "'";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Avenger readAvenger(String nomav) {

		int age;
		String nom;
		String costume;
		String pouvoir;
		Avenger avengerRes;
		ResultSet rs;

		connex = new ConnectionDao();
		try {
			st = connex.getInstance().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT * FROM membre WHERE nom = '" + nomav + "'";

		try {
			rs = st.executeQuery(sql);
			age = rs.getInt("age");
			nom = rs.getString("nom");
			costume = rs.getString("costume");
			pouvoir = rs.getString("pouvoir");
			avengerRes = new Avenger(age, nom, costume, pouvoir);
			return avengerRes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Avenger> getAll() {

		String url = "jdbc:mysql://localhost/avenger";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		int age;
		String nom;
		String costume;
		String pouvoir;

		Avenger avengerRes;
		ArrayList<Avenger> listeAv = new ArrayList<Avenger>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT * FROM membre";
			rs = st.executeQuery(sql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			while (rs.next()) {

				age = rs.getInt("age");
				nom = rs.getString("nom");
				costume = rs.getString("costume");
				pouvoir = rs.getString("pouvoir");

				avengerRes = new Avenger(age, nom, costume, pouvoir);
				listeAv.add(avengerRes);
				cn.close();
				st.close();
				return listeAv;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

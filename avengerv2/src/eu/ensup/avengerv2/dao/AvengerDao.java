package eu.ensup.avengerv2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import eu.ensup.avengerv2.domaine.Avenger;

public class AvengerDao{

	private Statement st = null;
	private ConnectionDao connex;


	public void createAvenger(Avenger avenger) throws ExceptionDao {

		try {
			connex = new ConnectionDao();
			Connection con = connex.getInstance();
			st = con.createStatement();
			String sql = "INSERT INTO `membre` (`age`,`nom`,`costume`,`pouvoir`) VALUES ('" + avenger.age + "','"
					+ avenger.name + "','" + avenger.costume + "','" + avenger.pouvoir + "')";
			st.executeUpdate(sql);

		} catch (SQLException e) {
			new ExceptionDao("pb creation avenger");
		} finally {
			try {
				// st.close();
				connex.deco();
			} catch (SQLException e) {
				new ExceptionDao("pb deconnexion crea");
			}
		}
	}

	
	public void updateAvenger(Avenger avenger) throws ExceptionDao {

		try {
			connex = new ConnectionDao();
			st = connex.getInstance().createStatement();
			String sql = "UPDATE `membre` (`age`,`nom`,`costume`,`pouvoir`) SET age='" + avenger.age + "', nom'"
					+ avenger.name + "', costume='" + avenger.costume + "',pouvoir='" + avenger.pouvoir
					+ "' WHERE nom='" + avenger.name + "'";
			st.executeUpdate(sql);

		} catch (SQLException e) {
			new ExceptionDao("pd maj anvenger");
		} finally {
			try {
				st.close();
				connex.deco();
			} catch (SQLException e) {
				new ExceptionDao("pb deconnexion maj");
			}
		}
	}


	public void deleteAvenger(Avenger avenger) throws ExceptionDao {

		try {
			connex = new ConnectionDao();
			st = connex.getInstance().createStatement();
			String sql = "DELETE FROM `membre` WHERE nom= '" + avenger.name + "'";
			st.executeUpdate(sql);

		} catch (SQLException e) {
			new ExceptionDao("pb tuer avenger");
		} finally {
			try {

				st.close();
				connex.deco();
			} catch (SQLException e) {
				new ExceptionDao("pb deconnexion");
			}
		}

	}


	public Avenger readAvenger(String nomav) throws ExceptionDao {

		int age;
		String nom;
		String costume;
		String pouvoir;
		Avenger avengerRes;
		ResultSet rs;
		try {
			connex = new ConnectionDao();
			st = connex.getInstance().createStatement();
			String sql = "SELECT * FROM membre WHERE nom = '" + nomav + "'";
			rs = st.executeQuery(sql);

			age = rs.getInt("age");
			nom = rs.getString("nom");
			costume = rs.getString("costume");
			pouvoir = rs.getString("pouvoir");

			avengerRes = new Avenger(age, nom, costume, pouvoir);
			return avengerRes;

		} catch (SQLException e) {
			new ExceptionDao("pb getavenger");

		} finally {
			try {
				st.close();
				connex.deco();
			} catch (SQLException e) {
				new ExceptionDao("pb deco");
			}
		}

		return null;
	}

	public ArrayList<Avenger> getAll() throws ExceptionDao {

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

			while (rs.next()) {

				age = rs.getInt("age");
				nom = rs.getString("nom");
				costume = rs.getString("costume");
				pouvoir = rs.getString("pouvoir");

				avengerRes = new Avenger(age, nom, costume, pouvoir);
				listeAv.add(avengerRes);

			}
		} catch (SQLException e) {
			new ExceptionDao("pb listing de avenger");

		} catch (ClassNotFoundException e) {
			new ExceptionDao("pb chargement driver");

		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				new ExceptionDao("pb deco");
			}
		}
		return listeAv;
	}

}

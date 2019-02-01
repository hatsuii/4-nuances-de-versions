package eu.ensup.avengerv4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import eu.ensup.avengerv4.domaine.Avenger;

public class AvengerDao extends AbstractAvengerDao {

	private Statement st = null;
	private AbstractAvengerDao connex;

	@Override
	public void createAvenger(Avenger avenger) throws ExceptionDao {

		try {
			st = getInstance().createStatement();
			String sql = "INSERT INTO `membre` (`age`,`nom`,`costume`,`pouvoir`) VALUES ('" + avenger.age + "','"
					+ avenger.name + "','" + avenger.costume + "','" + avenger.pouvoir + "')";
			st.executeUpdate(sql);

		} catch (SQLException e) {
			new ExceptionDao("pb creation avenger");
		} finally {
			try {
				deco();
			} catch (SQLException e) {
				new ExceptionDao("pb deconnexion crea");
			}
		}
	}

	@Override
	public void updateAvenger(Avenger avenger) throws ExceptionDao {

		try {
			st = getInstance().createStatement();
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

	@Override
	public void deleteAvenger(Avenger avenger) throws ExceptionDao {

		try {
			st = getInstance().createStatement();
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

	@Override
	public Avenger readAvenger(String nomav) throws ExceptionDao {

		int age;
		String nom;
		String costume;
		String pouvoir;
		Avenger avengerRes;
		ResultSet rs;
		try {
			st = getInstance().createStatement();
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

		ResultSet rs = null;
		int age;
		String nom;
		String costume;
		String pouvoir;

		Avenger avengerRes;
		ArrayList<Avenger> listeAv = new ArrayList<Avenger>();
		try {
			st = getInstance().createStatement();
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

		} finally {
			try {
				deco();
			} catch (SQLException e) {
				new ExceptionDao("pb deco");
			}
		}
		return listeAv;
	}

}

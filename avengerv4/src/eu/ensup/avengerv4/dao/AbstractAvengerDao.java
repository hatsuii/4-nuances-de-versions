package eu.ensup.avengerv4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractAvengerDao implements IAvengerDao {

	protected String url = "jdbc:mysql://localhost/avenger";
	protected String login = "root";
	protected String passwd = "";
	private Connection cn = null;
	private Statement st = null;

	public Connection getInstance() throws ExceptionDao {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
		} catch (ClassNotFoundException | SQLException e) {
			throw new ExceptionDao("hop hop hop, votre base de données n'a pas l'air de s'être réveillée...");
		}
		return cn;

	}

	public void deco() throws SQLException, ExceptionDao {
		if (!getInstance().isClosed()) {
			getInstance().close();
		}
	}

}

package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Trabalha conexÃ£o com o banco de dados
 */
public class ConectionFactory {

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	/**
	 * Armazena conexÃ£o com o banco
	 */
	private Connection conn = null;

	/**
	 * Cria uma conexÃ£o com o banco de dados
     * @return 
	 */
	protected Connection getConexao() {
		try {
			if (this.conn != null) {
				return this.conn;
			}

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String config = "jdbc:mysql://localhost:3306/padaria2";
			this.conn = DriverManager.getConnection(config);

		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
		}

		return this.conn;
	}

	/**
	 * Fecha a conexÃ£o aberta com o banco
	 */
	protected void fechaConexao() {
		try {
			if (this.conn != null) {
				this.conn.close();
			}
		} catch (SQLException e) {
		}
	}

}
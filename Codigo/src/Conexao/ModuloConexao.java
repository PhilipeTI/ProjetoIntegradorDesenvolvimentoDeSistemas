package Conexao;

import java.sql.*;
import javax.swing.JOptionPane;

public class ModuloConexao {
    // METODO RESPONSÁVEL PELA CONEXAO COM O BANCO
    public static Connection conector(){
        java.sql.Connection conexao = null;
        // A LINHA ABAIXO "CHAMA" O DRIVER
        String driver = "com.mysql.jdbc.Driver";
        // AMAZENANDO INFORMACOES REFERENTE AO BANCO
        String url = "jdbc:mysql://localhost:3306/dados";
        String user = "root";
        String password = "";
        // ESTABELECENDO A CONEXAO COM O BANCO
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            // A LINHA ABAIXO SERVE PARA INFORMAR O ERRO PARA A NAO CONEXAO
            //JOptionPane.showMessageDialog(null, "Erro de conexão com o banco" + e);
            System.out.println(e);
            return null;
        }
    }
}

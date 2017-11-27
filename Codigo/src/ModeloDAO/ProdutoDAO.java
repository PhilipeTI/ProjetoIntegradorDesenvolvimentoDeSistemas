/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Conexao.ConectionFactory;
import ModeloBeans.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ivani
 */
public class ProdutoDAO {
    
    public void create(Produto p){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO produto {IdProduto, Nome, Tipo, PrecoUnit, Descricao} VALUES(?,?,?,?,?)");
            stmt.setInt(1,p.getId());
            stmt.setString(2,p.getNome()); 
            stmt.setString(3,p.getTipo());
            stmt.setDouble(4,p.getPreco()); 
            stmt.setString(5,p.getDescricao());      
          
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar "+ex);
        }finally{
            ConectionFactory.closeConnection(con, stmt);
    }
    }
}

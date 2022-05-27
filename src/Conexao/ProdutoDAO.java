
package Conexao;

import Objetos.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ProdutoDAO {
    
    public void create(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement("CALL novoProduto(?,?,?,?,?)");
            stat.setString(1, p.getNome());
            stat.setString(2, p.getDescricao());
            stat.setFloat(3, p.getPreco_custo());
            stat.setFloat(4, p.getPreco_venda());
            stat.setString(5, p.getTamanho_camisa());
            
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.CloseConnection(con, stat);
        }
    }
}

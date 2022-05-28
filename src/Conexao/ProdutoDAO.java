
package Conexao;

import Objetos.Produto;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ProdutoDAO {
    
    public void create(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement("CALL novoProduto(?,?,?,?,?,?)");
            stat.setString(1, p.getNome());
            stat.setString(2, p.getDescricao());
            stat.setFloat(3, p.getValor_custo());
            stat.setFloat(4, p.getValor_venda());
            stat.setString(5, p.getTamanho_camisa());
            stat.setInt(6, p.getQuantidade());
            
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.CloseConnection(con, stat);
        }
    }
    
    public List<Produto> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new  ArrayLinkedList<>();
        
        try {
            stat = con.prepareStatement("SELECT * FROM Produto");
            rs = stat.executeQuery();
            
            while(rs.next()){
                
                Produto produto = new Produto();
                
                produto.setId_produto(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor_custo(rs.getFloat("valor_custo"));
                produto.setValor_venda(rs.getFloat("valor_venda"));
                produto.setTamanho_camisa(rs.getString("tamanho"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, stat, rs);
        }
        
        return produtos;
    }
}

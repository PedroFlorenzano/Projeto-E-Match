
package Conexao;

import Objetos.CadastroCliente;
import Objetos.Produto;
import Objetos.Usuario;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DAO {
    
    public void createProduto(Produto p){
        
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
            
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.CloseConnection(con, stat);
        }
    }
    
    public List<Produto> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Produto");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto produto = new Produto();
                
                produto.setId_produto(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor_custo(rs.getFloat("valor_custo"));
                produto.setValor_venda(rs.getFloat("valor_venda"));
                produto.setTamanho_camisa(rs.getString("tamanho"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, stmt, rs);
        }
        
        return produtos;
    }
    
    public List<Produto> readBusca(String nome){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Produto WHERE nome LIKE ?");
            stmt.setString(1, "%" + nome + "%"); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto produto = new Produto();
                
                produto.setId_produto(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor_custo(rs.getFloat("valor_custo"));
                produto.setValor_venda(rs.getFloat("valor_venda"));
                produto.setTamanho_camisa(rs.getString("tamanho"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, stmt, rs);
        }
        
        return produtos;
    }
    
    public void createCliente(CadastroCliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement("CALL novoCliente(?,?,?,?,?,?,?,?,?)");
            stat.setString(1, c.getNomeCompleto());
            stat.setString(2, c.getCpf());
            stat.setString(3, c.getTelefone());
            stat.setString(4, c.getDataNascimento());
            stat.setString(5, c.getSexo());
            stat.setString(6, c.getCep());
            stat.setString(7, c.getEndereco());
            stat.setString(8, c.getCidade());
            stat.setString(9, c.getEstado());
            
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.CloseConnection(con, stat);
        }
    }
    
    public void updateCliente(CadastroCliente c, String cpf){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement("CALL updateCliente(?,?,?,?,?,?,?,?,?)");
            stat.setString(1, c.getNomeCompleto());
            stat.setString(2, cpf);
            stat.setString(3, c.getTelefone());
            stat.setString(4, c.getDataNascimento());
            stat.setString(5, c.getSexo());
            stat.setString(6, c.getCep());
            stat.setString(7, c.getEndereco());
            stat.setString(8, c.getCidade());
            stat.setString(9, c.getEstado());
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.CloseConnection(con, stat);
        }
    }
    
    public void deleteCliente(CadastroCliente c, String cpf){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement("DELETE FROM Cliente WHERE cpf LIKE ?");
            stat.setString(1, "%" + cpf + "%"); 
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar " + ex);
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.CloseConnection(con, stat);
        }
    }
    
    public List<CadastroCliente> readBuscaCliente(String cpf){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<CadastroCliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente WHERE cpf LIKE ?");
            stmt.setString(1, "%" + cpf + "%"); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                CadastroCliente cliente = new CadastroCliente();
                
                cliente.setNomeCompleto(rs.getString("nome_completo"));
                cliente.setDataNascimento(rs.getString("data_nascimento"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                clientes.add(cliente);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, stmt, rs);
        }
        
        return clientes;
    }
    
    public void createUsuario(Usuario u){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement("CALL novoUsuario(?,?,?)");
            stat.setString(1, u.getNome());
            stat.setString(2, u.getSenha());
            stat.setString(3, u.getCpf());
            
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.CloseConnection(con, stat);
        }
    }
    
    public void updateUsuario(Usuario u, String cpf){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement("CALL updateUsuario(?,?,?)");
            stat.setString(1, u.getNome());
            stat.setString(2, u.getSenha());
            stat.setString(3, cpf);

            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar " + ex);
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.CloseConnection(con, stat);
        }
    }
    
    public void deleteUsuario(Usuario u, String cpf){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stat = null;
        
        try {
            stat = con.prepareStatement("DELETE FROM Usuario WHERE cpf LIKE ?");
            stat.setString(1, "%" + cpf + "%"); 
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar " + ex);
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.CloseConnection(con, stat);
        }
    }
    
    public List<Usuario> readBuscaUsuario(String cpf){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE cpf LIKE ?");
            stmt.setString(1, "%" + cpf + "%"); 
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Usuario usuario = new Usuario();
                
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));

                usuarios.add(usuario);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, stmt, rs);
        }
        
        return usuarios;
    }
    
    public boolean checkLogin(String nome, String senha){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Usuario WHERE nome = ? and senha = ?");
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if(rs.next())
               check = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, stmt, rs);
        }
        
        return check;
    }
    
    public boolean checkCpfCliente(String cpf){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT cpf FROM Cliente WHERE cpf LIKE ?");
            stmt.setString(1, "%" + cpf + "%"); 
            rs = stmt.executeQuery();
            
            if(rs.next())
               check = true;
           
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, stmt, rs);
        }
        
        return check;
    }
    
    public boolean checkCpfUsuario(String cpf){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT cpf FROM Usuario WHERE cpf LIKE ?");
            stmt.setString(1, "%" + cpf + "%"); 
            rs = stmt.executeQuery();
            
            if(rs.next())
               check = true;
           
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection(con, stmt, rs);
        }
        
        return check;
    }
}

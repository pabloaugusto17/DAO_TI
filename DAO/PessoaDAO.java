package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PessoaDAO {
    
    public static boolean insere_pessoa(String nome, long cpf, String senha, String endereco, long telefone, String email){

        String sql = "INSERT INTO pessoa(nome,cpf,senha,endereco,telefone,email) VALUES (?,?,?,?,?,?)";

        try(Connection con = TOOL.Conexao.pega_conexao()){

            try(PreparedStatement transacao = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){

               

                transacao.setString(1, nome);
                transacao.setLong(2, cpf);
                transacao.setString(3, senha);
                transacao.setString(4, endereco);
                transacao.setLong(5, telefone);
                transacao.setString(6, email);
                

                return true;

            }catch(Exception e){
                System.err.println(e);
                return false;
            }

            

        }catch(Exception e){
            System.err.println(e);
            return false;
        }

    }



}

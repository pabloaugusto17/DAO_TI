
package TOOL;

import java.sql.Connection;
import java.sql.DriverManager;

/*  Aqui é feito a conexão com o banco de dados como o proprio nome segure, ele 
    é a parte mais importante do projeto, já que é ele que dita todo processo
    de armazenamento.
*/

public class Conexao {
    
    //Declarada a função que realiza a conexão
    
    public static Connection pega_conexao(){
        
        /*  É usado o tratamento 'try-catch' para que não seja necessário fazer
            tratamentos de erros a partir de verificaçoes com 'if', em suma,
            o try-catch tenta realizar a conexão, caso dê certo aparece no
            console a mensagem de sucesso ao realizar a conexão caso não dê
            certo, é mostrado a mensagem de erro, junto ao erro (exception e)
        */
        
        try {
            
            /*  Na linha 36 é onde estabelecemos a conexão do mysql através do
                xampp, sendo esse um servidor local para armazenamentos de dados
                de aplicações simples. Para isso utilizamos da biblioteca para
                conexão que deve ser baixada na internet e através dela usamos
                o comando getConnection que conecta o servidor a máquina do
                usuário através da biblioteca :// porta / nome do banco de dados
                / usuario / senha
            */

            Class.forName("com.mysql.jbdc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/drunk_drink",
                    "root", ""); 
            System.out.println("Sucesso ao realizar conexão");
            
            // É retornado a conexão já que ele que nos permite fazer mudanças
            // no banco de dados
            
            return con;
            
        } catch (Exception e) {
            
            //Aqui é mostrado o erro e é retornado nulo para que o programa
            //não apresente mais nenhum erro
            
            System.out.println("Erro ao tentar realizar a conexão com o banco --" + e);
            return null;
            
        }
    }
    
}



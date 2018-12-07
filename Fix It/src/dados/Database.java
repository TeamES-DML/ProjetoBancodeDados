package dados;
import java.sql.*;

public class Database {
    public static final String driver = "org.mariadb.jdbc.Driver";
    public static final String usuario = "tester2";
    public static final String senha = "fixit";
    public static final String url = "jdbc:mariadb://localhost/javadb";
    private Connection conexao;
    private Statement statement;

    private void abrirConexao() throws Exception{
        Class.forName(driver);
        conexao = DriverManager.getConnection(url, usuario, senha);
        statement = conexao.createStatement();
    }

    private ResultSet executarComando(String sql) throws Exception{
        return statement.executeQuery(sql);
    }

    private void fecharConexao() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(conexao != null){
                conexao.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void testarConexao(){
        try{
            this.abrirConexao();
            String comando = "Create table if not exists funcionario(matricula VARCHAR(10), PRIMARY KEY(matricula))";
            this.executarComando(comando);
            this.fecharConexao();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

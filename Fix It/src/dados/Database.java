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

    public void iniciarBanco(){
        try{
            this.abrirConexao();
            String comando = "CREATE TABLE if not exists funcionario(cpf CHAR(11), nome VARCHAR(120) NOT NULL, escalao VARCHAR(11) NOT NULL, senha VARCHAR(50) NOT NULL, PRIMARY KEY(cpf))";
            this.executarComando(comando);
            comando = "CREATE TABLE if not exists produto(tipo VARCHAR(30), precoVenda DOUBLE NOT NULL, precoCompra DOUBLE NOT NULL, maoDeObra DOUBLE NOT NULL, id INT NOT NULL, ePeca BOOLEAN NOT NULL, precoReparo DOUBLE, modeloCarro VARCHAR(30), PRIMARY KEY(id))";
            this.executarComando(comando);
            comando = "CREATE TABLE if not exists veiculo(proprietario VARCHAR(120) NOT NULL, placa CHAR(7) NOT NULL, modelo VARCHAR(30) NOT NULL, PRIMARY KEY(placa))";
            this.executarComando(comando);
            comando = "CREATE TABLE if not exists servico(id INT, tipoOperacao VARCHAR(15) NOT NULL, data CHAR(10) NOT NULL, precoServico DOUBLE NOT NULL, placaVeiculo CHAR(7) NOT NULL, produtoID INT NOT NULL, FOREIGN KEY(produtoID) REFERENCES produto(id), FOREIGN KEY(placaVeiculo) REFERENCES veiculo(placa), PRIMARY KEY(id))";
            this.executarComando(comando);
            comando = "INSERT INTO funcionario(cpf,nome,escalao,senha) VALUES ('05801485481','Luis Filipe Santos Seixas','Gerente','lf123')";
            this.executarComando(comando);
            this.fecharConexao();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


package dados;
import java.sql.*;
import java.util.ArrayList;

import negocio.entidade.*;

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
            comando = "CREATE TABLE if not exists produto(tipo VARCHAR(30), precoVenda DOUBLE NOT NULL, precoCompra DOUBLE NOT NULL, maoDeObra DOUBLE, id INT NOT NULL, ePeca BOOLEAN NOT NULL, precoReparo DOUBLE, modeloCarro VARCHAR(30), PRIMARY KEY(id))";
            this.executarComando(comando);
            comando = "CREATE TABLE if not exists veiculo(proprietario VARCHAR(120) NOT NULL, placa CHAR(7) NOT NULL, modelo VARCHAR(30) NOT NULL, PRIMARY KEY(placa))";
            this.executarComando(comando);
            comando = "CREATE TABLE if not exists servico(id INT, tipoOperacao VARCHAR(15) NOT NULL, data CHAR(10) NOT NULL, precoServico DOUBLE NOT NULL, placaVeiculo CHAR(7) NOT NULL, produtoID INT NOT NULL, FOREIGN KEY(produtoID) REFERENCES produto(id), FOREIGN KEY(placaVeiculo) REFERENCES veiculo(placa), PRIMARY KEY(id))";
            this.executarComando(comando);
            comando = "INSERT INTO INTO funcionario(cpf,nome,escalao,senha) VALUES ('05801485481','Luis Filipe Santos Seixas','Gerente','lf123')";
            this.executarComando(comando);
            this.fecharConexao();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void adicionarFuncionario(Funcionario f){
        try{
            this.abrirConexao();
            String comando = String.format("INSERT INTO funcionario (cpf,nome,escalao,senha) VALUES('%s', '%s', '%s', '%s')", f.getCpf(), f.getNome(), f.getEscalao(), f.getSenha());
            this.executarComando(comando);
            this.fecharConexao();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //verificar peca
    public void adicionarProduto(Produto p){
        try {
            this.abrirConexao();
            boolean ispeca = p.getEPeca();
            double MaoDeObra = 0.0;
            double PrecoReparo = 0.0;
            String ModeloCarro = null;

            if(ispeca){
                MaoDeObra = ((Peca) p).getPrecoMaoDeObra();
                PrecoReparo = ((Peca) p).getPrecoReparo();
                ModeloCarro = ((Peca) p).getModeloCarro();
            }
            String comando = String.format("INSERT INTO produto (tipo,precoVenda,precoCompra,maoDeObra,id,ePeca,precoReparo,modeloCarro) VALUES('%s', %f, %f, %f, %d, %BOOLEAN, %f, '%s')", p.getTipo(), p.getPrecoVenda(), p.getPrecoCompra(), MaoDeObra, p.getId(), p.getEPeca(), PrecoReparo, ModeloCarro);
            this.executarComando(comando);
            this.fecharConexao();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void adicionarVeiculo(Veiculo v){
        try{
            this.abrirConexao();
            String comando = String.format("INSERT INTO veiculo (proprietario,placa,modelo) VALUES('%s', '%s', '%s')", v.getProprietario(), v.getPlaca(), v.getModelo());
            this.executarComando(comando);
            this.fecharConexao();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Funcionario> listarFuncionario() {
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        try{
            this.abrirConexao();
            String comando = String.format("SELECT * FROM funcionario");
            ResultSet rs = this.executarComando(comando);
            String cpf;
            String nome;
            String senha;
            String escalao;
            while (rs.next()){
                cpf = rs.getString("cpf");
                nome = rs.getString("nome");
                escalao = rs.getString("escalao");
                senha = rs.getString("senha");
                lista.add(new Funcionario(nome,cpf,senha,escalao));
            }
            this.fecharConexao();
            return lista;
        }catch (Exception e){
            e.printStackTrace();
            return lista;
        }
    }

    public void removerFuncionario(Funcionario funcionario){
        try{
            this.abrirConexao();
            String comando = String.format("DELETE FROM funcionario WHERE cpf='%s'",funcionario.getCpf());
            this.executarComando(comando);
            this.fecharConexao();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Produto> listarProdutos(){
        ArrayList<Produto> lista = new ArrayList<Produto>();
        try{
            this.abrirConexao();
            String comando = String.format("SELECT * FROM produto");
            ResultSet rs = this.executarComando(comando);
            String tipo;
            String modeloCarro;
            double precoVenda;
            double precoCompra;
            double maoDeObra;
            double precoReparo;
            int id;
            boolean ePeca;
            //tipo, precoVenda, precoCompra, maoDeObra, id, ePeca, precoReparo, modeloCarro
            while (rs.next()){
                tipo = rs.getString("tipo");
                modeloCarro = rs.getString("modeloCarro");
                precoVenda = rs.getDouble("precoVenda");
                precoCompra = rs.getDouble("precoCompra");
                precoReparo = rs.getDouble("precoReparo");
                maoDeObra = rs.getDouble("maoDeObra");
                id = rs.getInt("id");
                ePeca = rs.getBoolean("ePeca");
                if (ePeca){
                    lista.add(new Peca(tipo,modeloCarro,precoCompra,precoVenda,maoDeObra,precoReparo,id));
                }
                else{
                    lista.add(new Produto(tipo,precoCompra,precoVenda,id));
                }

            }

            this.fecharConexao();
            return lista;
        }catch (Exception e){
            e.printStackTrace();
            return lista;
        }
    }

    //public void adicionarServico
}


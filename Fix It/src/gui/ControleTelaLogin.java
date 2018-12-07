package gui;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import negocio.entidade.Funcionario;
import gui.excecao.FuncionarioNaoEncontradoException;
import negocio.excecao.SenhaIncorretaException;
import negocio.fachada.Fachada;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleTelaLogin implements Initializable{
    private Fachada fachada;
    public ControleTelaLogin(){
        fachada = fachada.getInstance();
    }


    @FXML
    private AnchorPane telaLogin;
    @FXML
    private Button login;
    @FXML
    private TextField cpfTf;
    @FXML
    private TextField senhaTf;
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;

    @Override
    public void initialize(URL url, ResourceBundle rs){
        //
    }
    public void fazerLogin(){
        try{
            String cpf = cpfTf.getText();
            String senha = senhaTf.getText();
            Funcionario f = fachada.getNegocioFuncionario().getRepositorio().procurarFuncionario(cpf);
            String escalao = fachada.getNegocioFuncionario().login(f, senha);
            if(escalao.equals("Gerente")){
                Main.janelaMenuNova("Gerente.fxml", "TelaGerente");
                fachada.setLogado(f);
                Stage telaLogin = (Stage) this.telaLogin.getScene().getWindow();
                telaLogin.close();
            }
            else{
                Main.janelaMenuNova("Padrao.fxml", "TelaPadrao");
                fachada.setLogado(f);
                Stage telaLogin = (Stage) this.telaLogin.getScene().getWindow();
                telaLogin.close();
            }
        } catch (FuncionarioNaoEncontradoException e) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Funcionario nao foi encontrado");
            alerta.showAndWait();
        } catch (SenhaIncorretaException e) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("senha incorreta");
            alerta.showAndWait();
        } catch (Exception e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Dados invalidos");
            alerta.showAndWait();
        }
    }
}

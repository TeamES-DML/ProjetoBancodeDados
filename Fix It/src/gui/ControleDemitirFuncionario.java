package gui;

import gui.excecao.CpfInvalidoException;
import gui.excecao.CpfNaoDeclaradoException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import negocio.entidade.Funcionario;
import negocio.excecao.AtualizacoesPropriaException;
import gui.excecao.FuncionarioNaoEncontradoException;
import negocio.fachada.Fachada;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleDemitirFuncionario implements Initializable{
    private Fachada fachada;
    public ControleDemitirFuncionario(){
        fachada = fachada.getInstance();
    }

    @FXML
    private Button demitir;
    @FXML
    private Label lb1;
    @FXML
    private TextField texto;
    @Override
    public void initialize(URL url, ResourceBundle rs){
        //
    }

    public void demitirFuncionario(){
        try{
            String cpf = texto.getText();
            Funcionario funcionario = fachada.getNegocioFuncionario().getRepositorio().procurarFuncionario(cpf);
            fachada.removerFuncionario(funcionario);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Demissao");
            alerta.setHeaderText("Confirmacao");
            alerta.setContentText("Funcionario Demitido");
            alerta.showAndWait();
        }
        catch (CpfInvalidoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Cpf nao tem 11 digitos");
            alerta.showAndWait();
        }
        catch(CpfNaoDeclaradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Cpf nao declarado");
            alerta.showAndWait();
        }
        catch (FuncionarioNaoEncontradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Funcionario nao foi encontrado");
            alerta.showAndWait();
        }
        catch (AtualizacoesPropriaException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Atualizacoes a si mesmo nao permitidas");
            alerta.showAndWait();
        }
        catch (Exception e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Cpf invalido");
            alerta.showAndWait();
        }
    }
}

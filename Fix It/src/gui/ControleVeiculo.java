package gui;

import gui.excecao.NomeNaoDeclaradoException;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import negocio.entidade.Veiculo;
import gui.excecao.ModeloNaoDeclaradoException;
import negocio.excecao.PlacaInvalidaException;
import gui.excecao.PlacaNaoDeclaradaException;
import negocio.excecao.VeiculoRepetidoException;
import negocio.fachada.Fachada;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleVeiculo implements Initializable{
    private Fachada fachada;
    public ControleVeiculo(){
        fachada = fachada.getInstance();
    }

    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Label lb3;
    @FXML
    private TextField proprietarioTF;
    @FXML
    private TextField placaTF;
    @FXML
    private TextField modeloTF;
    @FXML
    private Button salvar;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void addVeiculo(){
        try{
            String proprietario = proprietarioTF.getText();
            String placa = placaTF.getText();
            String modelo = modeloTF.getText();
            Veiculo veiculo = new Veiculo(proprietario, placa, modelo);
            fachada.adicionarVeiculo(veiculo);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Confirmacao");
            alerta.setHeaderText("Cadastro");
            alerta.setContentText("veiculo cadastrado");
            alerta.showAndWait();
        }
        catch (VeiculoRepetidoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Veiculo ja cadastrado");
            alerta.showAndWait();
        }
        catch (ModeloNaoDeclaradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Modelo nao declarado.");
            alerta.showAndWait();
        }
        catch (NomeNaoDeclaradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Nome nao declarado.");
            alerta.showAndWait();
        }
        catch (PlacaNaoDeclaradaException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Placa nao declarada");
            alerta.showAndWait();
        }
        catch (PlacaInvalidaException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Placa deve ter 7 caracteres");
            alerta.showAndWait();
        }
    }
}

package gui;

import gui.excecao.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import negocio.entidade.Funcionario;
import gui.excecao.EscalaoNaoDeclaradoException;
import negocio.excecao.FuncionarioRepetidoException;
import negocio.fachada.Fachada;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleFuncionario implements Initializable{
    ObservableList<String> escalaoCbLista = FXCollections.observableArrayList("Gerente", "Normal");

    @FXML
    private ChoiceBox escalaoCb;

    private Fachada fachada;

    public ControleFuncionario(){
        this.fachada = fachada.getInstance();
    }
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Label lb3;
    @FXML
    private Label lb4;
    @FXML
    private TextField nomeTF;
    @FXML
    private TextField CpfTF;
    @FXML
    private TextField senhaTF;
    @FXML
    private Button registrar;
    @FXML
    private Button sair;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        escalaoCb.setValue("Escalao");
        escalaoCb.setItems(escalaoCbLista);
    }
    public void addFuncionario(){
        try{
            String nome = nomeTF.getText();
            String cpf = CpfTF.getText();
            String escalao = (String) escalaoCb.getSelectionModel().getSelectedItem();
            String senha = senhaTF.getText();
            Funcionario f = new Funcionario(nome, cpf, senha, escalao);

            this.fachada.adicionarFuncionario(f);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Confirmacao");
            alerta.setHeaderText("Cadastro");
            alerta.setContentText("funcionario cadastrado");
            alerta.showAndWait();
        }
        catch (FuncionarioRepetidoException e) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Funcionario ja cadastrado");
            alerta.showAndWait();
        }
        catch(NomeNaoDeclaradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Nome nao declarado");
            alerta.showAndWait();
        }
        catch(CpfNaoDeclaradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Cpf nao declarado");
            alerta.showAndWait();
        }
        catch(SenhaNaoDeclaradaException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Senha nao declarado");
            alerta.showAndWait();
        }
        catch(CpfInvalidoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Cpf nao tem 11 digitos");
            alerta.showAndWait();
        }
        catch(EscalaoNaoDeclaradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Escalao nao declarado");
            alerta.showAndWait();
        }
        catch(Exception e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Dados formatados de forma incorretamente");
            alerta.showAndWait();
        }
    }



}


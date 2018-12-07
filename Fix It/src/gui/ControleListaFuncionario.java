package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.entidade.Funcionario;
import negocio.fachada.Fachada;

import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControleListaFuncionario implements Initializable{
    private Fachada fachada;
    public ControleListaFuncionario(){
        fachada = fachada.getInstance();
    }

    @FXML
    private Button sair;
    @FXML
    private TableView<Funcionario> table;

    private ObservableList<Funcionario> funcionarioList = FXCollections.observableArrayList();
    @FXML
    private TableColumn nomeCol;
    @FXML
    private TableColumn cpfCol;
    @FXML
    private TableColumn escalaoCol;

    @Override
    public void initialize(URL url, ResourceBundle rs){
        //po
        nomeCol.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
        cpfCol.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cpf"));
        escalaoCol.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("escalao"));
        if(fachada.getNegocioFuncionario().getRepositorio().getArray().size() != 0){
            for(int i = 0; i < fachada.getNegocioFuncionario().getRepositorio().getArray().size(); i++){
                funcionarioList.add(fachada.getNegocioFuncionario().getRepositorio().getArray().get(i));
            }
        }
        table.setItems(funcionarioList);
    }
}

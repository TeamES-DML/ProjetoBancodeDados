package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import negocio.excecao.AnoNaoDeclaradoException;
import gui.excecao.MesNaoDeclaradoException;
import negocio.fachada.Fachada;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleLucroMensal implements Initializable{
    private Fachada fachada;
    public ControleLucroMensal(){
        fachada = fachada.getInstance();
    }
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private TextField anoTf;
    @FXML
    private ChoiceBox mesCb;
    ObservableList<String> mesesCbList = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
    @FXML
    private Button calcular;
    @Override
    public void initialize(URL url, ResourceBundle rs){
        mesCb.setValue("Meses");
        mesCb.setItems(mesesCbList);
    }
    public void calcularLucroMensal(){
        try{
            int mes, ano;
            if((mesCb.getSelectionModel().getSelectedItem()).equals("Meses")){
                mes = 0;
            }
            else{
                mes = Integer.valueOf((String)mesCb.getSelectionModel().getSelectedItem());
            }
            if(anoTf.getText().equals("")){
                ano = 0;
            }
            else{
                ano = Integer.valueOf(anoTf.getText());
            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Lucro");
            alerta.setContentText(String.valueOf(fachada.lucroMensal(mes, ano)));
            alerta.setHeaderText("Lucro do mes: " + mesCb.getSelectionModel().getSelectedItem() + " do ano de: " + anoTf.getText());
            alerta.showAndWait();
        }
        catch (AnoNaoDeclaradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("ERRO");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Ano nao foi declarado");
            alerta.showAndWait();
        }
        catch (MesNaoDeclaradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("ERRO");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Mes nao foi declarado");
            alerta.showAndWait();
        }
        catch (Exception e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("ERRO");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Dados invalidos");
            alerta.showAndWait();
        }
    }
}

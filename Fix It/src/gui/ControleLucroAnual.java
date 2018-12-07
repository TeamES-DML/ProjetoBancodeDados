package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import negocio.excecao.AnoNaoDeclaradoException;
import negocio.fachada.Fachada;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleLucroAnual implements Initializable{
    private Fachada fachada;
    public ControleLucroAnual(){
        fachada = fachada.getInstance();
    }

    @FXML
    private Button calcular;
    @FXML
    private TextField anoTf;
    @FXML
    private Label lb1;

    public void initialize(URL url, ResourceBundle rs){
        //as
    }

    public void calcularLucroAnual(){
        try{
            int ano;
            if(anoTf.getText().equals("")){
                ano = 0;
            }
            else{
                ano = Integer.valueOf(anoTf.getText());
            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Lucro");
            alerta.setContentText(String.valueOf(fachada.lucroAnual(ano)));
            alerta.setHeaderText("Lucro do ano de: " + anoTf.getText());
            alerta.showAndWait();
        }
        catch (AnoNaoDeclaradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("ERRO");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Ano nao foi declarado");
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

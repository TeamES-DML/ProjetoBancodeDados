package gui;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.entidade.*;
import negocio.fachada.Fachada;
public class ControleServicosAndamento implements Initializable{
    private Fachada fachada;
    public ControleServicosAndamento(){
        fachada = fachada.getInstance();
    }
    @FXML
    private Label lb1;

    @FXML
    private Label lb2;

    @FXML
    private TableView<Produto> table;

    ObservableList<String> veiculosStatusList = FXCollections.observableArrayList();

    @FXML
    private TableColumn tipoColuna;

    @FXML
    private ChoiceBox veiculosCb;

    @FXML
    private Button buscar;

    private ArrayList<String> criarListaVeiculos(){
        ArrayList<String> listaVeiculos = new ArrayList<String>();
        if(fachada.getNegocioVeiculo().getRepositorio().getArray().size() != 0){
            for(int i = 0; i < fachada.getNegocioVeiculo().getRepositorio().getArray().size(); i++){
                listaVeiculos.add(fachada.getNegocioVeiculo().getRepositorio().getArray().get(i).getPlaca());
            }
        }

        return listaVeiculos;
    }
    @Override
    public void initialize(URL url, ResourceBundle rs){
        if(criarListaVeiculos().size() != 0){
            for(int i = 0; i < criarListaVeiculos().size(); i++){
                veiculosStatusList.add(criarListaVeiculos().get(i));
            }
        }
        veiculosCb.setValue("Veiculos");
        veiculosCb.setItems(veiculosStatusList);
    }

    public void buscar(){
        try {
            ObservableList<Produto> produtostatusList = FXCollections.observableArrayList();
            String placa = (String)veiculosCb.getSelectionModel().getSelectedItem();
            Veiculo veiculo = null;
            if(fachada.getNegocioVeiculo().getRepositorio().getArray().size() != 0){
                veiculo = fachada.getNegocioVeiculo().getRepositorio().procurarVeiculo(placa);
            }
            tipoColuna.setCellValueFactory(new PropertyValueFactory<Produto, String>("tipo"));
            if(fachada.getServicosNaoConcluidos(veiculo).size() != 0){
                if(fachada.getServicosNaoConcluidos(veiculo).size() != 0){ //####################
                    for(int i = 0; i < fachada.getServicosNaoConcluidos(veiculo).size(); i++){
                        if(!fachada.getServicosNaoConcluidos(veiculo).get(i).getConcluido()){
                            produtostatusList.add(fachada.getServicosNaoConcluidos(veiculo).get(i).getProduto());
                        }
                    }
                }
            }
            table.setItems(produtostatusList);
        }
        catch (Exception e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Veiculo nao escolhido");
            alerta.showAndWait();
        }
    }
}

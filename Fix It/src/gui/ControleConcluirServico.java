package gui;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import negocio.entidade.*;
import gui.excecao.ServicoAConcluirNaoEncontradoException;
import negocio.fachada.Fachada;
public class ControleConcluirServico implements Initializable {
    private Fachada fachada;
    public ControleConcluirServico(){
        fachada = fachada.getInstance();
    }

    ObservableList<String> veiculosStatusList = FXCollections.observableArrayList();

    @FXML
    private AnchorPane telaConcluirServico;
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Button selecionar;
    @FXML
    private Button concluir;
    @FXML
    private ChoiceBox veiculosCbox;
    @FXML
    private ChoiceBox servicosCbox;

    private ArrayList<String> criarListaVeiculos(){
        ArrayList<String> listaVeiculos = new ArrayList<String>();
        if(fachada.getNegocioVeiculo().getRepositorio().getArray().size() != 0){
            for(int i = 0; i < fachada.getNegocioVeiculo().getRepositorio().getArray().size(); i++){
                listaVeiculos.add(fachada.getNegocioVeiculo().getRepositorio().getArray().get(i).getPlaca());
            }
        }

        return listaVeiculos;
    }

    private ArrayList<String> criarListaServico(Veiculo veiculo){
        ArrayList<String> listaServico = new ArrayList<String>();
        if(fachada.getServicosNaoConcluidos(veiculo).size() != 0){
            String aux;
            for(int i = 0; i < fachada.getServicosNaoConcluidos(veiculo).size(); i++){
                aux = fachada.getServicosNaoConcluidos(veiculo).get(i).getProduto().getTipo() + "; " + fachada.getServicosNaoConcluidos(veiculo).get(i).getDescricao() + "; " + fachada.getServicosNaoConcluidos(veiculo).get(i).getTipoOperacao();
                listaServico.add(aux);
            }
        }
        return listaServico;
    }
    @Override
    public void initialize(URL url, ResourceBundle rs){
        if(criarListaVeiculos().size() != 0){
            for(int i = 0; i < criarListaVeiculos().size(); i++){
                veiculosStatusList.add(criarListaVeiculos().get(i));
            }
        }
        veiculosCbox.setValue("Veiculos");
        veiculosCbox.setItems(veiculosStatusList);
    }

    public void registrar(){
        try{
            ObservableList<String> servicosStatusList = FXCollections.observableArrayList();
            veiculosCbox.setVisible(false);
            lb1.setVisible(false);
            selecionar.setVisible(false);
            String placa = (String)veiculosCbox.getSelectionModel().getSelectedItem();
            Veiculo veiculo = null;
            if(fachada.getNegocioVeiculo().getRepositorio().getArray().size() != 0){
                veiculo = fachada.getNegocioVeiculo().getRepositorio().procurarVeiculo(placa);
            }
            if(fachada.getServicosNaoConcluidos(veiculo).size() != 0){
                if(criarListaServico(veiculo).size() != 0){
                    for(int i = 0; i < criarListaServico(veiculo).size(); i++){
                        servicosStatusList.add(criarListaServico(veiculo).get(i));
                    }
                }
                servicosCbox.setValue("Servicos");
                servicosCbox.setItems(servicosStatusList);

            }
            lb2.setVisible(true);
            servicosCbox.setVisible(true);
            concluir.setVisible(true);
        }
        catch (Exception e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Veiculo nao escolhido");
            alerta.showAndWait();
        }
    }
    public void concluir() {
        try {
            String listaServ[] = new String[3];
            String servicos = (String) servicosCbox.getSelectionModel().getSelectedItem();
            listaServ = servicos.split("; ");
            Veiculo veiculo = null;
            String placa = (String) veiculosCbox.getSelectionModel().getSelectedItem();
            if (fachada.getNegocioVeiculo().getRepositorio().getArray().size() != 0) {
                veiculo = fachada.getNegocioVeiculo().getRepositorio().procurarVeiculo(placa);
            }
            if (veiculo != null) {
                if (fachada.getServicosNaoConcluidos(veiculo).size() != 0) {
                    for (int i = 0; i < fachada.getServicosNaoConcluidos(veiculo).size(); i++) {
                        if (fachada.getServicosNaoConcluidos(veiculo).get(i).getTipoOperacao().equals(listaServ[2]) && fachada.getServicosNaoConcluidos(veiculo).get(i).getDescricao().equals(listaServ[1]) && fachada.getServicosNaoConcluidos(veiculo).get(i).getProduto().getTipo().equals(listaServ[0])) {
                            fachada.concluirServico(veiculo, fachada.getServicosNaoConcluidos(veiculo).get(i));
                            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                            alerta.setTitle("Confirmacao");
                            alerta.setHeaderText("Conclusao efetuada");
                            alerta.setContentText("Servico foi concluido com sucesso");
                            alerta.showAndWait();
                            Stage telaConcluirServico = (Stage) this.telaConcluirServico.getScene().getWindow();
                            telaConcluirServico.close();
                        }
                    }
                }
            }
        } catch (ServicoAConcluirNaoEncontradoException e) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Servico nao escolhido");
            alerta.showAndWait();
        }
        catch (Exception e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Dados invalidos");
            alerta.showAndWait();
        }
    }
}

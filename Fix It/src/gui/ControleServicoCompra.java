
package gui;
import gui.excecao.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;



import javafx.fxml.Initializable;
import negocio.entidade.DataSimples;
import negocio.entidade.Peca;
import negocio.entidade.Produto;
import negocio.entidade.Servico;
import negocio.fachada.Fachada;

import javax.xml.crypto.Data;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControleServicoCompra implements Initializable{
    private Fachada fachada;
    public ControleServicoCompra(){
        fachada = fachada.getInstance();
    }
    ObservableList<String> produtosStatusList = FXCollections.observableArrayList();
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private TextField dia;
    @FXML
    private TextField mes;
    @FXML
    private TextField ano;
    @FXML
    private ChoiceBox produtosCbox;
    @FXML
    private Button salvar;
    @FXML
    private Button sair;

    private ArrayList<String> criarListaProdutos(){
        ArrayList<String> lista = new ArrayList<String>();
        if(fachada.getNegocioProduto().getRepositorio().getArrayProduto().size() != 0){
            for(int i = 0; i < fachada.getNegocioProduto().getRepositorio().getArrayProduto().size(); i++){
                String aux;
                if (fachada.getNegocioProduto().getRepositorio().getArrayProduto().get(i) instanceof Peca){
                    aux = fachada.getNegocioProduto().getRepositorio().getArrayProduto().get(i).getTipo() +"; "+ ((Peca) fachada.getNegocioProduto().getRepositorio().getArrayProduto().get(i)).getModeloCarro();
                    lista.add(aux);

                }
                else{
                    aux = fachada.getNegocioProduto().getRepositorio().getArrayProduto().get(i).getTipo();
                    lista.add(aux);
                }
            }
        }

        return lista;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        if(criarListaProdutos().size() != 0){
            for(int i = 0; i < criarListaProdutos().size(); i++){
                produtosStatusList.add(criarListaProdutos().get(i));
            }
        }
        produtosCbox.setValue("Produtos");
        produtosCbox.setItems(produtosStatusList);
    }

    public void addServicoCompra(){
        try{
            int diaTf = Integer.valueOf(dia.getText());
            int mesTf = Integer.valueOf(mes.getText());
            int anoTf = Integer.valueOf(ano.getText());
            DataSimples data = new DataSimples(diaTf, mesTf,anoTf);
            String listaprod[] = new String[2];
            String produto = (String) produtosCbox.getSelectionModel().getSelectedItem();
            listaprod = produto.split("; ");
            Produto escolhido = null;
            if(fachada.getNegocioProduto().getRepositorio().getArrayProduto().size() != 0){
                if(listaprod.length == 2){
                    escolhido = fachada.getNegocioProduto().getRepositorio().procurarProduto(listaprod[0], listaprod[1]);
                }
                else{
                    escolhido = fachada.getNegocioProduto().getRepositorio().procurarProduto(listaprod[0]);
                }
            }
            Servico servico = new Servico(escolhido, data);
            fachada.adicionarCompra(servico);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Confirmacao");
            alerta.setHeaderText("Compra efetuada");
            alerta.setContentText("Servico de compra concluido");
            alerta.showAndWait();
        }
        catch (DataInvalidaException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Data invalida");
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

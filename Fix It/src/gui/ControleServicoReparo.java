package gui;
import gui.excecao.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;



import javafx.fxml.Initializable;
import negocio.entidade.*;
import gui.excecao.DescricaoNaoDeclaradaException;
import negocio.excecao.ModeloIncompativelException;
import negocio.excecao.OperacaoIncompativelException;
import negocio.excecao.ServicoRepetidoException;
import negocio.fachada.Fachada;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControleServicoReparo implements Initializable {
    private Fachada fachada;
    public ControleServicoReparo(){
        fachada = fachada.getInstance();
    }
    ObservableList<String> produtosStatusList = FXCollections.observableArrayList();
    ObservableList<String> veiculosStatusList = FXCollections.observableArrayList();
    ObservableList<String> operacoesStatusList = FXCollections.observableArrayList("Venda", "Reparo", "Instalacao");

    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Label lb3;
    @FXML
    private Label lb4;
    @FXML
    private TextField dia;
    @FXML
    private TextField mes;
    @FXML
    private TextField ano;
    @FXML
    private ChoiceBox produtosCbox;
    @FXML
    private ChoiceBox veiculosCbox;
    @FXML
    private ChoiceBox operacoesCbox;
    @FXML
    private TextField descricao;
    @FXML
    private Label lb5;
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
        if(criarListaProdutos().size() != 0){
            for(int i = 0; i < criarListaProdutos().size(); i++){
                produtosStatusList.add(criarListaProdutos().get(i));
            }
        }
        produtosCbox.setValue("Produtos");
        produtosCbox.setItems(produtosStatusList);
        if(criarListaVeiculos().size() != 0){
            for(int i = 0; i < criarListaVeiculos().size(); i++){
                veiculosStatusList.add(criarListaVeiculos().get(i));
            }
        }
        veiculosCbox.setValue("Veiculos");
        veiculosCbox.setItems(veiculosStatusList);
        operacoesCbox.setItems(operacoesStatusList);
    }

    public void addServicoVendaOuReparo(){
        try{
            int diaTf = Integer.valueOf(dia.getText());
            int mesTf = Integer.valueOf(mes.getText());
            int anoTf = Integer.valueOf(ano.getText());
            DataSimples data = new DataSimples(diaTf, mesTf, anoTf);
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
            String placa = (String) veiculosCbox.getSelectionModel().getSelectedItem();
            Veiculo veiculo = null;
            if(fachada.getNegocioVeiculo().getRepositorio().getArray().size() != 0){
                veiculo = fachada.getNegocioVeiculo().getRepositorio().procurarVeiculo(placa);
            }
            String operacao = (String) operacoesCbox.getSelectionModel().getSelectedItem();
            String descricaoTf = descricao.getText();
            Servico servico = new Servico(operacao, escolhido, descricaoTf, data);
            fachada.adicionarServico(veiculo, servico);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Confirmacao");
            alerta.setHeaderText("Servico cadastrado");
            alerta.setContentText("Servico de venda/reparo cadastrado");
            alerta.showAndWait();

        } catch (ServicoRepetidoException e) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Este servico ja existe nesse veiculo");
            alerta.showAndWait();
        } catch (DataInvalidaException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Data invalida");
            alerta.showAndWait();
        } catch (DescricaoNaoDeclaradaException e) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Descricao nao declarada");
            alerta.showAndWait();
        } catch (OperacaoIncompativelException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Esse produto nao pode ser reparado");
            alerta.showAndWait();
        }catch (ModeloIncompativelException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Modelo do carro e do peca sao incompativeis");
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

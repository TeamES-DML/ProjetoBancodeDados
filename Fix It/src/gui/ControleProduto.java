package gui;

import gui.excecao.PrecoDeCompraNaoDeclaradoException;
import gui.excecao.PrecoDeVendaNaoDeclaradoException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import negocio.entidade.Produto;
import negocio.excecao.*;
import negocio.fachada.Fachada;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleProduto implements Initializable{
    private Fachada fachada;

    public ControleProduto(){
        this.fachada = fachada.getInstance();
    }

    @FXML
    private Button registrar;

    @FXML
    private Label lb1;

    @FXML
    private Label lb2;

    @FXML
    private Label lb3;



    @FXML
    private TextField tipoTF;

    @FXML
    private TextField precoCompraTF;

    @FXML
    private TextField precoVendaTF;

    @Override
    public void initialize(URL url, ResourceBundle rs){
        //
    }

    public void addProduto(){
        try{
            String tipo = tipoTF.getText();
            double precoCompra = Double.valueOf(precoCompraTF.getText());
            double precoVenda = Double.valueOf(precoVendaTF.getText());
            Produto produto = new Produto(tipo, precoCompra, precoVenda);
            this.fachada.adicionarProduto(produto);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Confirmacao");
            alerta.setHeaderText("Cadastro efetuado com sucesso");
            alerta.setContentText("Produto foi cadastrado");
            alerta.showAndWait();
        }
        catch (ProdutoRepetidoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Produto ja cadastrado");
            alerta.showAndWait();
        }
        catch (TipoNaoDeclaradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("tipo nao declarado");
            alerta.showAndWait();
        }
        catch (PrecoDeCompraNaoDeclaradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Preco de compra nao declarado");
            alerta.showAndWait();
        }
        catch (PrecoDeVendaNaoDeclaradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Preco de venda nao declarado");
            alerta.showAndWait();
        }
        catch (Exception e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Dados formatados de forma incorreta");
            alerta.showAndWait();
        }
    }
}

package gui;

import gui.excecao.ModeloNaoDeclaradoException;
import gui.excecao.PrecoDeCompraNaoDeclaradoException;
import gui.excecao.PrecoDeReparoNaoDeclaradoException;
import gui.excecao.PrecoDeVendaNaoDeclaradoException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import negocio.entidade.Peca;
import negocio.excecao.*;
import negocio.fachada.Fachada;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class ControlePeca implements Initializable {


    private Fachada fachada;

    public ControlePeca(){
        this.fachada = fachada.getInstance();
    }

    @FXML
    private Button registrar;

    @FXML
    private AnchorPane tela;

    @FXML
    private Label lb1;

    @FXML
    private Label lb2;

    @FXML
    private Label lb3;

    @FXML
    private Label lb4;

    @FXML
    private Label lb5;

    @FXML
    private Label lb6;

    @FXML
    private TextField tipoTF;

    @FXML
    private TextField modeloTF;

    @FXML
    private TextField precoCompraTF;

    @FXML
    private TextField precoVendaTF;

    @FXML
    private TextField precoReparoTF;

    @FXML
    private TextField precoInstalacaoTF;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //OK
    }

    public void addPeca(){
        try {
            String tipo = tipoTF.getText();
            String modelo = modeloTF.getText();
            double precoCompra = Double.valueOf(precoCompraTF.getText());
            double precoVenda = Double.valueOf(precoVendaTF.getText());
            double precoReparo = Double.valueOf(precoReparoTF.getText());
            double precoInstalacao = Double.valueOf(precoInstalacaoTF.getText());
            Peca peca = new Peca(tipo,modelo,precoCompra,precoVenda, precoInstalacao ,precoReparo);
            this.fachada.adicionarProduto(peca);
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Confirmacao");
            alerta.setHeaderText("Cadastro de Peca Concluido");
            alerta.setContentText("Peca foi cadastrada");
            alerta.showAndWait();
        }
        catch (ProdutoRepetidoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Peca ja cadastrada");
            alerta.showAndWait();
        }
        catch (ModeloNaoDeclaradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Modelo nao declarado");
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
        catch (PrecoDeReparoNaoDeclaradoException e){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro");
            alerta.setHeaderText("ERRO");
            alerta.setContentText("Preco de reparo nao declarado");
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

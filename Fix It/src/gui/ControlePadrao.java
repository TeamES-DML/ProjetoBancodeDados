package gui;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import negocio.fachada.Fachada;
import gui.Main;

import java.awt.*;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
public class ControlePadrao implements Initializable{
    private Fachada fachada;

    public ControlePadrao(){
        this.fachada = fachada.getInstance();
    }
    @FXML
    private TabPane tela;

    @FXML
    private Tab listas;

    @FXML
    private Tab registros;

    @FXML
    private AnchorPane registrosTela;

    @FXML
    private AnchorPane listasTela;

    @FXML
    private Button botaoPeca;

    @FXML
    private Button botaoCompra;

    @FXML
    private Button botaoServico;

    @FXML
    private Button botaoVeiculo;

    @FXML
    private Button botaoProduto;

    @FXML
    private Button botaoLucroAnual;

    @FXML
    private Button botaoLucroMensal;

    @FXML
    private Button botaoConcluirServico;

    @FXML
    private Button botaoServicosAndamento;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //OK
    }

    public void cadastroProduto(){
        Main.janelaNova("TelaCadastroProduto.fxml", "TelaCadastroProduto");
    }
    public void cadastroPeca(){
        Main.janelaNova("TelaCadastroPeca.fxml", "TelaCadastroPeca");

    }
    public void cadastroCompra(){
        Main.janelaNova("ServicoCompra.fxml", "TelaServicoCompra");
    }
    public void cadastroServico(){
        Main.janelaNova("ServicoVendaReparo.fxml", "TelaServicoVenda/Reparo");
    }
    public void cadastroVeiculo(){
        Main.janelaNova("Veiculo.fxml", "TelaCadastroVeiculo");
    }

    public void concluirServico(){
        Main.janelaNova("TelaConcluirServico.fxml", "TelaConcluirServico");
    }
    public void listarLucroMensal(){
        Main.janelaNova("TelaLucroMensal.fxml", "TelaLucroMensal");
    }
    public void listarLucroAnual(){
        Main.janelaNova("TelaLucroAnual.fxml", "TelaLucroAnual");
    }
    public void servicosAndamento(){
        Main.janelaNova("TelaServicosAndamento.fxml", "ListaServicosEmAndamento");
    }
}

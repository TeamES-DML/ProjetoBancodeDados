package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import negocio.entidade.Funcionario;
import negocio.fachada.Fachada;
import gui.Main;

import java.awt.*;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleGerente implements Initializable{

    private Fachada fachada;

    public ControleGerente()
    {
        this.fachada = fachada.getInstance();
    }


    @FXML
    private TabPane tela;

    @FXML
    private Tab listas;

    @FXML
    private Tab exclusoes;

    @FXML
    private Tab atualizacoes;

    @FXML
    private Tab registros;

    @FXML
    private AnchorPane registrosTela;

    @FXML
    private AnchorPane listasTela;

    @FXML
    private AnchorPane exclusoesTela;

    @FXML
    private AnchorPane atualizacoesTela;

    @FXML
    private Button botaoPeca;

    @FXML
    private Button botaoFuncionario;

    @FXML
    private Button botaoCompra;

    @FXML
    private Button botaoServico;

    @FXML
    private Button botaoVeiculo;

    @FXML
    private Button botaoProduto;

    @FXML
    private Button botaoListaFuncionario;

    @FXML
    private Button botaoLucroAnual;

    @FXML
    private Button botaoLucroMensal;

    @FXML
    private Button botaoDemitir;

    @FXML
    private Button botaoPromover;

    @FXML
    private Button botaoDespromover;

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
    public void cadastroFuncionario(){
        Main.janelaNova("NovoFuncionario.fxml", "TelaCadastroFuncionario");
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
    public void listarFuncionarios(){
        Main.janelaNova("ListaFuncionario.fxml", "ListaFuncionario");
    }
    public void demitirFuncionario(){
        Main.janelaNova("TelaDemitirFuncionario.fxml", "TelaDemitirFuncionario");
    }
    public void promoverFuncionario(){
        Main.janelaNova("TelaPromoverFuncionario.fxml", "TelaPromoverFuncionario");
    }
    public void despromoverFuncionario(){
        Main.janelaNova("TelaDespromoverFuncionario.fxml","TelaDespromoverFuncionario");
    }
    public void servicosEmAndamento(){
        Main.janelaNova("TelaServicosAndamento.fxml","TelaServicosEmAndamento");
    }








}

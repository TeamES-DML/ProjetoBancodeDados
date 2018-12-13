package gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import negocio.entidade.Funcionario;
import dados.*;
import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage inicio) throws Exception{

        inicio.setTitle("LOGIN");

        try{

            FXMLLoader carregador = new FXMLLoader(Main.class.getResource("TelaLogin.fxml"));
            Pane pane = carregador.load();
            Scene scene = new Scene(pane);
            inicio.setScene(scene);
            inicio.setResizable(false);
            inicio.show();

        }
        catch (Exception e){

            e.printStackTrace();

        }

    }
    public static void main(String[] args){

        launch(args);
        //Database testando = new Database();
        //testando.iniciarBanco();

    }

    public static void janelaNova(String janela,String titulo){

        try{
            Stage novo = new Stage();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(janela));
            Pane pane = loader.load();
            Scene scene = new Scene(pane);
            novo.setScene(scene);
            novo.setResizable(false);
            novo.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void janelaMenuNova(String janela, String titulo){
        try{
            Stage novo = new Stage();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(janela));
            TabPane pane = loader.load();
            Scene scene = new Scene(pane);
            novo.setScene(scene);
            novo.setResizable(false);
            novo.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



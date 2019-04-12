package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Steven
 */
public class Window extends Application {
//Variables

    private final int WIDTH = Utility.Utility.WIDTH;
    private final int HEIGHT = Utility.Utility.HEIGHT;
    private Pane pane;
    private Scene scene;
    private Canvas canvas;
    private GraphicsContext gc;
    private int x = 30;
    private int y = 30;
    private int sizeX = 75;
    private int sizeY = 100;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Second Paint");
        initComponents(primaryStage);
        primaryStage.show();
    }//Start

    private void initComponents(Stage primaryStage) {
        this.pane = new Pane();
        this.scene = new Scene(pane, WIDTH, HEIGHT);
        this.canvas = new Canvas(WIDTH, HEIGHT);
        this.pane.getChildren().add(this.canvas);
        this.gc = this.canvas.getGraphicsContext2D();
        draw(this.gc);
        scene.setFill(Color.CORNSILK);

        primaryStage.setScene(this.scene);
    }//init

    private void draw(GraphicsContext gc) {
        drawCircles(gc);
    }//fin metodo draw

    public void drawCircles(GraphicsContext gc) {
        //Coloca la figura en el centro
        gc.setTransform(1.0, 0.0, 0.0, 1.0, this.canvas.getWidth() / 2.0, this.canvas.getHeight() / 2.0);
        int cont = 0;
        while (cont < 1900) {
            gc.setStroke(Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
            gc.strokeOval(x, y, sizeX, sizeY);
            gc.rotate(5);
            cont += 10;
        }
    }//fin de metodo drawCircles
}//fin de clase

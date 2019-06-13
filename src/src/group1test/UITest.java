package group1test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import group1src.GameMap;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;


public class UITest extends Application { 
	GameMap gameMap;
    @Override
    public void start(Stage stage) {
    	ConcurrentHashMap<Integer, Boolean> map = new ConcurrentHashMap<>(); 
    	gameMap = new GameMap(10,10,map);
    	stage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(600, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
       
        drawGameMap(gc);
        
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();

    }
    
    private void drawGameMap(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(2d);
        
        int tableHeight = gameMap.getSizeY();
        int tableWidth = gameMap.getSizeX();
        
        //鐢绘í绾� 
        for(int i=0;i<tableHeight;i++) {
        	gc.strokeLine(300-30*tableHeight/2, 10+30*i, 300+30*(tableHeight/2-1), 10+30*i);
        }
        //鐢荤珫绾� 
        for(int i=0;i<tableWidth;i++) {
        	gc.strokeLine(300+30*(i-tableWidth/2), 10, 300+30*(i-tableWidth/2), 280);
        }
        //gc.strokeLine(50,10, 550, 10);
        //gc.strokeLine(50,100,550,100);
 
    }


    public static void main(String[] args) {
        launch(args);
    }
}

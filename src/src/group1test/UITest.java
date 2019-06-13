package group1test;

import group1src.GameMap;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class UITest extends Pane {
	
	private GameMap gameMap;
	private Canvas canvas;
	private GraphicsContext gc;
	
	//棋盘距窗口边框左、上的距离
	private double align = 70;
	
	public UITest(GameMap gameMap) {
		this.gameMap = gameMap;
		draw();
		getChildren().add(canvas);
	}
	
	public double getAlign() {
		return align;
	}

	public void setAlign(double align) {
		this.align = align;
	}

	/**
	 * 绘制棋盘
	 */
	public void draw() {
		canvas = new Canvas(700,700);
		this.gc = canvas.getGraphicsContext2D();
		
		double cell = 30;
		
		int width = 400;
		int height = 400;
		
		//填充棋盘颜色
		gc.setFill(Color.BURLYWOOD);
		gc.fillRect(align-15, align-15, width+30, height+30);
		
		for(int y=1;y<gameMap.getSizeY();y++) {
			//画横线
			gc.strokeLine(align, y*cell+align, width+align, y*cell+align);
		}
		
		for(int x=1;x<gameMap.getSizeX();x++) {
			//画竖线
			gc.strokeLine(x*cell+align, align, x*cell+align, height+align);
		}
		
		/**
		* 天元(7,7),四个星位(3,3),(3,11),(11,3),(11,11)
		* 不想要这五个点的可以不要这一部分，没有什么影响
		**/
		for(int i=3;i<=14;i+=4) 
			for(int j=3;j<=14;) {
				gc.setFill(Color.BLACK);
				//画天元
				if(i == 7) {
					j = 7;
					gc.strokeOval(i*cell+align-4, j*cell+align-4, 8, 8);
					gc.fillOval(i*cell+align-4, j*cell+align-4, 8, 8);
					break;
				}
				//画星位
				else {
					gc.strokeOval(i*cell+align-4, j*cell+align-4, 8, 8);
					gc.fillOval(i*cell+align-4, j*cell+align-4, 8, 8);
					j += 8;
				}
			}
		
		//边框加粗
		gc.setLineWidth(3.0f);
		gc.strokeRect(align, align, width, height);
		
	}

	/**
	 * 绘制棋子
	 */
	/**
	public void paintChess(int x,int y) {
		
		double cell = fiveChess.getCellLen();
		
		if(fiveChess.getCurrentSide() == 'B')
			gc.setFill(Color.BLACK);
		else
			gc.setFill(Color.WHITE);
		gc.strokeOval(align+x*cell-cell/2, align+y*cell-cell/2, cell, cell);
		gc.fillOval(align+x*cell-cell/2, align+y*cell-cell/2, cell, cell);
		
	}
	**/
	
}
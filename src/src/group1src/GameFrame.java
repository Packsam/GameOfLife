package group1src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameFrame extends JFrame{
	JLabel title = new JLabel("Game Of Life",JLabel.CENTER);
	GameMap gameMap;
	JButton[][] cells;
	static GameFrame gf;
	int speed;
	//Boolean flag = false;
	
	public static void main(String[] args) {
		gf = new GameFrame();
		gf.init();
		gf.setVisible(true);
		gf.setSize(1000, 1000);
		gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//gf.upadateFrame();
		
	}
	
	public void init() {
		
		speed = 1000;
		
		this.setLayout(new BorderLayout());
		
		title.setFont(new Font (Font.DIALOG, Font.BOLD, 50)); 
		this.add(title, BorderLayout.NORTH);
		
		final HashMap<Integer, Boolean> map = new HashMap<>();
		
		gameMap = new GameMap(20,20,map);
		
		JPanel gameTable = new JPanel();
		
		gameTable.setLayout(new GridLayout(gameMap.getSizeY(),gameMap.getSizeX()));
		gameTable.setPreferredSize(new Dimension(100,100));
		gameTable.setSize(100, 100);
		
		cells = new JButton[gameMap.getSizeY()][gameMap.getSizeY()];
		
		for(int i=0;i<gameMap.getSizeY();i++) {
			for(int j=0; j<gameMap.getSizeX();j++) {
				cells[i][j] = new JButton();
				final JButton t = cells[i][j];
				final int pos = gameMap.assemblePosiotion(j, i);
				t.addActionListener(new ActionListener() {
				
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						t.setBackground(Color.BLUE);
						map.put(pos,true);
					}
					
				});
				gameTable.add(cells[i][j]);
			}
		}
		initTable();
		showCells();
		
		this.add(gameTable, BorderLayout.CENTER);
		
		Font f = new Font("宋体",Font.BOLD,16);
		
		JPanel optionPanel = new JPanel(new FlowLayout());
		JButton start = new JButton("start");
		JButton next = new JButton("next");
		JButton stop = new JButton("stop");
		start.setFont(f);
		next.setFont(f);
		stop.setFont(f);
		start.setPreferredSize(new Dimension(100,50));
		stop.setPreferredSize(new Dimension(100,50));
		next.setPreferredSize(new Dimension(100,50));
		optionPanel.add(start);
		optionPanel.add(next);
		optionPanel.add(stop);
		
		JButton speedUp = new JButton("+");
		JButton speedDown = new JButton("-");
		speedUp.setPreferredSize(new Dimension(100,50));
		speedDown.setPreferredSize(new Dimension(100,50));
		optionPanel.add(speedUp);
		optionPanel.add(speedDown);
		
		this.add(optionPanel,BorderLayout.SOUTH);
		
		final Thread t = new Thread(new Runnable() {
			public void run(){
				// TODO Auto-generated method stub
				gf.upadateFrame();
			}
		});
		
		start.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t.start();
			}
		});
		
		speedUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(speed<100) {
					speed=100;
				}else {
					speed/=2;
				}
			}
			
		});
		
		speedDown.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(speed>2000) {
					speed=2000;
				}else {
					speed+=500;
				}
			}
			
		});
		
//		stop.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				try {
//					t.wait();
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
//		
//		next.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(!t.isInterrupted()){
//					t.interrupt();
//				}
//			}
//		});
		
	}

	
	public void initTable() {
		for(int i=0;i<gameMap.getSizeY();i++) {
			for(int j=0; j<gameMap.getSizeY();j++) {
				cells[i][j].setBackground(Color.white);
			}
		}
	}
	
	public void upadateFrame() {
//		initTable();
//		gameMap.update();
//		showCells();
		while(true) {
			initTable();
			gameMap.update();
			showCells();
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void showCells() {
		HashMap<Integer, Boolean> map = gameMap.getAliveCell();
		for(Integer pos:map.keySet()) {
			cells[gameMap.getyOfPosition(pos)][gameMap.getxOfPosition(pos)].setBackground(Color.BLUE);
			System.out.println(pos);
		}
	}
}

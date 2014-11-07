package com.brian_ife.matrix.window;
import java.awt.*;
import java.awt.image.BufferStrategy;

import com.brian_ife.matrix.framework.KeyInput;
import com.brian_ife.matrix.framework.ObjectId;
import com.brian_ife.matrix.objects.Player;


public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	
	private boolean running = false;
	private Thread thread;
	public static int WIDTH, HEIGHT;
	
	Handler handler;
	
	private void init(){
		setFocusable(true);
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		handler = new Handler();
		handler.addObject(new Player(100, 100, handler, ObjectId.Player));
		handler.createTestBlocks();
		
		this.addKeyListener(
			new KeyInput(handler)
		);
	}
	
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run(){
		init();
		
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				updatePositions();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private void updatePositions(){
		handler.updatePosition();
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();//Canvas method
		//automatically initializes itself to null
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		////////////ALL OF THE IMAGES GO HERE//////////////////
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		handler.render(g);
		//////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public static void main (String[] args){
		new Window(800, 600, "Neon Platrom Game Prototype", new Game());
	}
}

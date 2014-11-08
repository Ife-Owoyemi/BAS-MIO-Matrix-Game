package com.brian_ife.matrix.window;

import java.awt.Graphics;
import java.util.LinkedList;

import com.brian_ife.matrix.framework.GameObject;
import com.brian_ife.matrix.framework.ObjectId;
import com.brian_ife.matrix.objects.Block;

public class Handler {
	
public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private GameObject tempObject;
	
	public void updatePosition(){
		for(int i = 0; i < object.size(); i++){
			tempObject = object.get(i);
			tempObject.updatePosition(object);
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	public void createTestBlocks(){
		
		for(int xx = 0; xx < Game.WIDTH + 32; xx +=32){
			addObject(new Block(xx, Game.HEIGHT - 32));
		}
		
	}


}

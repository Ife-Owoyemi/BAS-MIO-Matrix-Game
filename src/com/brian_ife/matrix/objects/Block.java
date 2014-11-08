package com.brian_ife.matrix.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.brian_ife.matrix.framework.GameObject;
import com.brian_ife.matrix.framework.ObjectId;

public class Block extends GameObject{
	
	public Block(float x, float y) {
		super(x, y, ObjectId.Block);
		
	}

	public void updatePosition(LinkedList<GameObject> object) {

	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawRect((int)x, (int)y, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int) y, 32, 32);
	}


}

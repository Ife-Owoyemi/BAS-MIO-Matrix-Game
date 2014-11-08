package com.brian_ife.matrix.commands;

import com.brian_ife.matrix.framework.GameObject;

public class BasicMoveCommand extends Command {

	private GameObject actor;
	private float xDelta;
	private float yDelta;
	
	public BasicMoveCommand(GameObject commandActor, float commnadXDelta, float commandYDelta){
		actor = commandActor;
		xDelta = commnadXDelta;
		yDelta = commandYDelta;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		actor.moveCommand(xDelta,yDelta);
		//some kinda collision handler
		

	}

}

package com.mallanojonkin.snake;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Snake {
	public Texture imgHead;
	public Texture imgBody;
	public Vector2 position;
	public ArrayList<Vector2> body;
	String direction;
	final float SPACING;
	boolean grow;
	boolean collission;
	
	public Snake(Vector2 pos, String dir){
		imgHead = new Texture("snake_head_right.png");
		position = pos;
		direction = dir;
		SPACING = 10f;
		grow = false;
		body = new ArrayList<Vector2>();
		body.add(new Vector2(pos.x, pos.y));
		body.add(new Vector2(pos.x, pos.y));
		body.add(new Vector2(pos.x, pos.y));
		body.add(new Vector2(pos.x, pos.y));
	}
	
	public void moveUp(){
		imgHead = new Texture("snake_head_up.png");
		direction = "up";
	}
	
	public void moveDown(){
		imgHead = new Texture("snake_head_down.png");
		direction = "down";
	}
	
	public void moveRight(){
		imgHead = new Texture("snake_head_right.png");
		direction = "right";
	}
	
	public void moveLeft(){
		imgHead = new Texture("snake_head_left.png");
		direction = "left";
	}
	
	public void grow(){
		grow = true;
	}
	
	public void move(){
		
//		if (direction.equals("right")){
//			body.add(0, new Vector2(position.x, position.y));
//		}
//		else if (direction.equals("left")){
//			body.add(0, new Vector2(position.x, position.y));
//		}
//		else if (direction.equals("up")){
//			body.add(0, new Vector2(position.x, position.y));
//		}
//		else if (direction.equals("down")){
//			body.add(0, new Vector2(position.x, position.y));
//		}
		body.add(0, new Vector2(position.x, position.y));
		
		if (!grow){
			body.remove(body.size() - 1);
		}
		grow = false;
	}
	
}

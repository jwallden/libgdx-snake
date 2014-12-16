package com.mallanojonkin.snake;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Snake {
	public Texture imgHead;
	public Texture imgBody;
	public Vector2 position;
	public ArrayList<Body> body;
	String direction;
	final float SPACING;
	boolean grow;
	boolean collission;
	Circle headCircle;
	Body tempBody;
	
	public Snake(Vector2 pos, String dir){
		imgHead = new Texture("snake_head_right.png");
		position = pos;
		direction = dir;
		SPACING = 25f;
		grow = false;
		headCircle = new Circle();
		headCircle.set(position, 10);
		
		body = new ArrayList<Body>();
		body.add(new Body(new Vector2(pos.x-SPACING, pos.y), "horizontal"));
		body.add(new Body(new Vector2(pos.x-64, pos.y), "horizontal"));
		body.add(new Body(new Vector2(pos.x-128, pos.y), "horizontal"));
		body.add(new Body(new Vector2(pos.x-256, pos.y), "horizontal"));
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
		
//		if (direction.equals("up") || direction.equals("down")){
//			body.add(0, new Body(new Vector2(position.x, position.y), "vertical"));
//		}
//		else if (direction.equals("left") || direction.equals("right")){
//			body.add(0, new Body(new Vector2(position.x-SPACING, position.y), "horizontal"));
//		}
//				
//		if (!grow){
//			body.remove(body.size() - 1);
//		}
//		grow = false;
		for (int i = body.size()-1; i >=1 ;i--){
			
			tempBody = body.get(i-1);
			body.set(i, tempBody);
			System.out.println( i + " Updated body at: " + body.get(i).position.x + ", " + body.get(i).position.y);
		}
		tempBody = new Body(new Vector2(position.x, position.y), "horizontal");
		//body.get(i).position = position;
		body.set(0, tempBody);
		System.out.println("new head at " + body.get(0).position.x + ", " + body.get(0).position.y);
	}
	
}

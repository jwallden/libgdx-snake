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
		tempBody = body.get(body.size()-1);
		body.add(tempBody);
	}
	
	public void move(){		
		for (int i = body.size()-1; i >=1 ;i--){
			tempBody = body.get(i-1);
			body.set(i, tempBody);
		}
		tempBody = new Body(new Vector2(position.x, position.y), "horizontal");
		body.set(0, tempBody);
	}
	
}

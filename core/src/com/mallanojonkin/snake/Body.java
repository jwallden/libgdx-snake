package com.mallanojonkin.snake;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Body {
	 Texture imgBody;
	 Vector2 position;
	 Circle BodyCircle;
	 
	 public Body(Vector2 pos, String axis){
		 if (axis.equals("horizontal")){
			 imgBody = new Texture("circle.png");
		 }
		 else if (axis.equals("vertical")){
			 imgBody = new Texture("circle.png");
		 }
		 
		 position = pos;
		 BodyCircle = new Circle();
		 BodyCircle.setRadius(10);
	 }	 
}

package com.mallanojonkin.snake;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Body {
	 Texture imgBody;
	 Vector2 position;
	 
	 public Body(Vector2 pos, String axis){
		 if (axis.equals("horizontal")){
			 imgBody = new Texture("kroppHorizontal.png");
		 }
		 else if (axis.equals("vertical")){
			 imgBody = new Texture("kroppVertical.png");
		 }
		 
		 position = pos;
	 }	 
}

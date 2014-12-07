package com.mallanojonkin.snake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ChristmasSnake extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Vector2 position;
	float moveX;
	float moveY;
	float speed;
	Snake theSnake;
	boolean draw;
	int frames;
	int collisionRadius;
	boolean collision;
	
	public boolean detectCollision(){
		collision = false;
		collisionRadius = 20;
//		for (Vector2 pos : theSnake.body){
//			if ((theSnake.position.x == pos.x + collisionRadius || theSnake.position.x == pos.x - collisionRadius) &&
//					(theSnake.position.y == pos.y)){
//				System.out.println("Collision");
//			}
//		}
		
		
		return collision;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("kropp.png");
		position = new Vector2(64, 0);
		speed = 3f;
		
		//Set inital speed and direction
		moveX = +speed;
		moveY = 0;
		
		theSnake = new Snake(position, "right");
		draw = true;
		frames = 0;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		frames +=1;
		
		if(Gdx.input.isKeyJustPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP)){
			theSnake.moveUp();
			moveX = 0;
			moveY = +speed;
		}
		else if(Gdx.input.isKeyJustPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.DOWN)){
			theSnake.moveDown();
			moveX = 0;
			moveY = -speed;
		}
		else if(Gdx.input.isKeyJustPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)){
			theSnake.moveRight();
			moveX = +speed;
			moveY = 0;
		}
		else if(Gdx.input.isKeyJustPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)){
			theSnake.moveLeft();
			moveX = -speed;
			moveY = 0;
		}
		else if(Gdx.input.isKeyJustPressed(Keys.SPACE)){
			//theSnake.body.add(0, new Vector2(theSnake.position.x, theSnake.position.y));
			theSnake.grow();
			System.out.println(theSnake.body.size());
		}
		
		theSnake.position.x += moveX;
		theSnake.position.y += moveY;
		
		
		
		if (frames >= 15) {
			System.out.println(theSnake.position.x + " " + theSnake.position.y);
			theSnake.move();
			frames = 0;
		}
		batch.begin();
		for (Vector2 pos : theSnake.body){
			batch.draw(img, pos.x, pos.y);
		}
		//batch.draw(theSnake.img, theSnake.position.x -32, theSnake.position.y);
		batch.draw(theSnake.imgHead, theSnake.position.x, theSnake.position.y);
		batch.end();
	}
}

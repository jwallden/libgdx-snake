package com.mallanojonkin.snake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ChristmasSnake extends ApplicationAdapter {
	private SpriteBatch batch;
	private Vector2 position;
	private float moveX;
	private float moveY;
	private float speed;
	private Snake theSnake;
	private int frames;
	private OrthographicCamera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1024, 768);
		
		position = new Vector2(64, 0);
		
		speed = 200;
		
		//Set inital speed and direction
		moveX = speed;
		moveY = 0;
		
		theSnake = new Snake(position, "right");
		frames = 0;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		frames +=1;
		
		if(Gdx.input.isKeyJustPressed(Keys.W) || Gdx.input.isKeyJustPressed(Keys.UP)){
			theSnake.moveUp();
			moveX = 0;
			moveY = +speed;
		}
		else if(Gdx.input.isKeyJustPressed(Keys.S) || Gdx.input.isKeyJustPressed(Keys.DOWN)){
			theSnake.moveDown();
			moveX = 0;
			moveY = -speed;
		}
		else if(Gdx.input.isKeyJustPressed(Keys.D) || Gdx.input.isKeyJustPressed(Keys.RIGHT)){
			theSnake.moveRight();
			moveX = +speed;
			moveY = 0;
		}
		else if(Gdx.input.isKeyJustPressed(Keys.A) || Gdx.input.isKeyJustPressed(Keys.LEFT)){
			theSnake.moveLeft();
			moveX = -speed;
			moveY = 0;
		}
		else if(Gdx.input.isKeyJustPressed(Keys.SPACE)){
			theSnake.grow();
			System.out.println(theSnake.body.size());
		}
		
		theSnake.position.x += moveX * Gdx.graphics.getDeltaTime();
		theSnake.position.y += moveY * Gdx.graphics.getDeltaTime();
		
		if (theSnake.position.x > 1024 ) theSnake.position.x = 0;
		if (theSnake.position.x < 0) theSnake.position.x = 1024;
		if (theSnake.position.y > 768) theSnake.position.y = 0;
		if (theSnake.position.y < 0) theSnake.position.y = 768;
		
		
		if (frames >= 17) {
			System.out.println(theSnake.position.x + " " + theSnake.position.y);
			theSnake.move();
			frames = 0;
		}
		
		//Collision detection
		for (Body bodyPart: theSnake.body){
			if (bodyPart.BodyCircle.overlaps(theSnake.HeadCircle)){
				System.out.println("COLlISION");
			}
		}
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (Body bodyPart : theSnake.body){
			batch.draw(bodyPart.imgBody, bodyPart.position.x, bodyPart.position.y);
		}
		
		batch.draw(theSnake.imgHead, theSnake.position.x, theSnake.position.y);
		batch.end();
	}
}

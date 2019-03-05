package fi.tamk.tiko;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class CompanionGame extends Game {
	static SpriteBatch menuButtons;
	Texture bHome;
	Texture bWater;
	homeScreen home;
	waterScreen water;
	settingsScreen settings;
	OrthographicCamera camera;
	OrthographicCamera cameraFont;
	FreeTypeFontGenerator generator;
	BitmapFont font12;


	public SpriteBatch getBatch() {
		return menuButtons; }

	public homeScreen getHome() {
		return home;
	}


	@Override
	public void create () {
		menuButtons = new SpriteBatch();
		home = new homeScreen(this);
		water = new waterScreen(this);
		settings = new settingsScreen(this);
		setScreen(home);
		generator = new FreeTypeFontGenerator(Gdx.files.internal("abel.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 48;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 3;
		font12 = generator.generateFont(parameter);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 600, 500);
		cameraFont = new OrthographicCamera();
		cameraFont.setToOrtho(false, 600, 500);
	}
	public waterScreen getWater() { return water; }

	@Override
	public void render () {
		super.render();

	}

	@Override
	public void dispose () {
		menuButtons.dispose();

	}




}

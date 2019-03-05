package fi.tamk.tiko;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class settingsScreen implements Screen {

    Stage menu;
    Stage setting;
    TextureAtlas buttonAtlas;
    Skin skin2;
    Button homeButton;
    Button.ButtonStyle homeButtonStyle;


    CompanionGame peli;
    SpriteBatch batch;

    public settingsScreen(CompanionGame peli) {

        skin2 = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons/buttonHome/buttonHomePlc.pack"));
        skin2.addRegions(buttonAtlas);
        homeButtonStyle = new TextButton.TextButtonStyle();
        homeButtonStyle.up = skin2.getDrawable("b_home");
        homeButtonStyle.down = skin2.getDrawable("b_home");
        homeButtonStyle.checked = skin2.getDrawable("b_home");

        this.peli = peli;
        batch = peli.getBatch();
        menu = new Stage(new FitViewport(8f, 4f), batch);
        setting = new Stage(new FitViewport(8f, 4f), batch);




    }

    public void create() {

        Gdx.input.setInputProcessor(setting);


    }


    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(255, 0, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        menu.act(Gdx.graphics.getDeltaTime());
        menu.draw();
        setting.act(Gdx.graphics.getDeltaTime());
        setting.draw();
        homeButton = new Button(homeButtonStyle);
        homeButton.setPosition(3f, 3f);
        homeButton.setHeight(1f);
        homeButton.setWidth(1f);
        /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */

        homeButton.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("my app", "Not"); //** Usually used to start Game, etc.

                return false;
            } });

        homeButton.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("my app", "Pressed"); //** Usually used to start Game, etc.

                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Example", "touch done at (" + x + ", " + y + ")"); //** Usually used to start Game, etc. **//
                peli.setScreen(peli.water);
                }


        } );

        setting.addActor(homeButton);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        peli.getScreen().dispose();
        buttonAtlas.dispose();
        menu.dispose();
        setting.dispose();
    }
}

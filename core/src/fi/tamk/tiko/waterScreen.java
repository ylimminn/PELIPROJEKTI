package fi.tamk.tiko;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class waterScreen implements Screen {

    Texture img;
    Texture bHome;
    Texture bWater;
    static menuButton buttonHome;
    static menuButton buttonWater;
    Stage menu;


    CompanionGame peli;
    SpriteBatch batch;
    public waterScreen(CompanionGame peli) {
        bHome = new Texture("b_home.png");
        bWater = new Texture("b_water.png");
        this.peli = peli;
        batch = peli.getBatch();
        menu = new Stage(new FitViewport(8f, 4f), batch);
        menuButton buttonHome = new menuButton(bHome, 0);
        menuButton buttonWater  = new menuButton(bWater, 2.5f);
        menu.addActor(buttonHome);
        menu.addActor(buttonWater);
    }

    public void create() {


        buttonHome = new menuButton(bHome, 0);
        buttonWater = new menuButton(bWater, 2.5f);


    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        menu.act(Gdx.graphics.getDeltaTime());
        menu.draw();
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
        img.dispose();
    }
}

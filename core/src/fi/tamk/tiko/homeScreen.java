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

public class homeScreen implements Screen {
    Texture img;
    Texture bHome;
    Texture bWater;
    static menuButton buttonHome;
    static menuButton buttonWater;
    Stage menu;
    Stage waifu;
    TextureAtlas monAtlas;
    Skin skin;
    Button monButton;
    Button.ButtonStyle monButtonStyle;


    CompanionGame peli;
    SpriteBatch batch;

    public homeScreen(CompanionGame peli) {
        img = new Texture("momo.png");
        bHome = new Texture("b_home.png");
        bWater = new Texture("b_water.png");

        skin = new Skin();
        monAtlas = new TextureAtlas(Gdx.files.internal("mons/mons.pack"));
        skin.addRegions(monAtlas);
        monButtonStyle = new TextButton.TextButtonStyle();
        monButtonStyle.up = skin.getDrawable("momo");
        monButtonStyle.down = skin.getDrawable("yuki");
        monButtonStyle.checked = skin.getDrawable("yuki");


        this.peli = peli;
        batch = peli.getBatch();





    }

    public void create() {



    }


    @Override
    public void show() {
        menu = new Stage(new FitViewport(8f, 4f), batch);
        waifu = new Stage(new FitViewport(8f, 4f), batch);
        Gdx.input.setInputProcessor(waifu);
        menuButton buttonHome = new menuButton(bHome, 0);
        menuButton buttonWater  = new menuButton(bWater, 3.5f, 2f);

        menu.addActor(buttonHome);
        menu.addActor(buttonWater);
        menuButton momo = new menuButton(img, 2f, 2f);
        monButton = new Button(monButtonStyle);
        monButton.setPosition(1f, 1f); //** Button location **//
        monButton.setHeight(1f); //** Button Height **//
        monButton.setWidth(1f);
        monButton.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //Gdx.app.log("my app", "Pressed"); //** Usually used to start Game, etc.

                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //Gdx.app.log("Example", "touch done at (" + x + ", " + y + ")"); //** Usually used to start Game, etc. **//
                peli.setScreen(peli.settings);}


                                  } );
        waifu.addActor(monButton);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(255, 0, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       /* batch.setProjectionMatrix(peli.cameraOther.combined);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0, img.getWidth()/50f, img.getHeight()/50f);

        batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {

            peli.setScreen(peli.getKR()); }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

            peli.setScreen(peli.getAloitus()); }*/

        menu.act(Gdx.graphics.getDeltaTime());
        menu.draw();
        waifu.act(Gdx.graphics.getDeltaTime());
        waifu.draw();
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
        bWater.dispose();
        bHome.dispose();
        peli.getScreen().dispose();
    }
}

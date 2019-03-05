package fi.tamk.tiko;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class menuButton extends Actor {


    private Texture texture;


    public menuButton(Texture z, float x) {
        texture = z;
        setWidth(texture.getWidth()/100f);
        setHeight(texture.getHeight()/100f);
        setBounds(x, 0, getWidth(), getHeight());
        addListener(new InputListener() {} );

    }

    public menuButton(Texture z, float x, float y) {
        texture = z;
        setWidth(texture.getWidth()/100f);
        setHeight(texture.getHeight()/100f);
        setBounds(x, y, getWidth(), getHeight());
        addListener(new InputListener() {} );

    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
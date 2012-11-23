package com.skyseed.androidgames.cointosky;

import java.util.List;

import javax.microedition.khronos.opengles.GL10;

import com.skyseed.androidgames.framework.Game;
import com.skyseed.androidgames.framework.Input.TouchEvent;
import com.skyseed.androidgames.framework.gl.Camera2D;
import com.skyseed.androidgames.framework.gl.SpriteBatcher;
import com.skyseed.androidgames.framework.impl.GLScreen;
import com.skyseed.androidgames.framework.math.OverlapTester;
import com.skyseed.androidgames.framework.math.Rectangle;
import com.skyseed.androidgames.framework.math.Vector2;

public class MainMenuScreen extends GLScreen {
    Camera2D guiCam;
    SpriteBatcher batcher;
    Rectangle soundBounds;
    Rectangle playBounds;
    Rectangle highscoresBounds;
    Vector2 touchPoint;

    public MainMenuScreen(Game game) {
        super(game);
        guiCam = new Camera2D(glGraphics, 720, 1200);
        batcher = new SpriteBatcher(glGraphics, 100);
        soundBounds = new Rectangle(0, 0, 64, 64);
        playBounds = new Rectangle(360 - 196, 500, 392, 64);
        highscoresBounds = new Rectangle(360 - 201, 600, 402, 78);
        //helpBounds = new Rectangle(160 - 150, 200 - 18 - 36, 300, 36);
        touchPoint = new Vector2();               
    }       

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);                        
            if(event.type == TouchEvent.TOUCH_UP) {
                touchPoint.set(event.x, event.y);
                guiCam.touchToWorld(touchPoint);
                
                if(OverlapTester.pointInRectangle(playBounds, touchPoint)) {
                    Assets.playSound(Assets.clickSound);
                    game.setScreen(new GameScreen(game));
                    return;
                }

                if(OverlapTester.pointInRectangle(highscoresBounds, touchPoint)) {
                    Assets.playSound(Assets.clickSound);
                    //game.setScreen(new HighscoresScreen(game));
                    return;
                }

                if(OverlapTester.pointInRectangle(helpBounds, touchPoint)) {
                    Assets.playSound(Assets.clickSound);
                    //game.setScreen(new HelpScreen(game));
                    return;
                }

                if(OverlapTester.pointInRectangle(soundBounds, touchPoint)) {
                    Assets.playSound(Assets.clickSound);
                    Settings.soundEnabled = !Settings.soundEnabled;
                    if(Settings.soundEnabled) 
                        Assets.music.play();
                    else
                        Assets.music.pause();
                }
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        GL10 gl = glGraphics.getGL();        
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        guiCam.setViewportAndMatrices();
        
        gl.glEnable(GL10.GL_TEXTURE_2D);
        
        batcher.beginBatch(Assets.background);
        batcher.drawSprite(360, 600, 720, 1200, Assets.backgroundRegion);
        batcher.drawSprite(360, 900, 394, 286, Assets.city);
        batcher.endBatch();
        
        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);               
        
        batcher.beginBatch(Assets.items);                 
        
        batcher.drawSprite(320, 256, 286, 190, Assets.logo);
        batcher.drawSprite(320, 700 - 32, 392, 64, Assets.gameStartBtn);
        batcher.drawSprite(320, 600 - 32, 392, 64, Assets.highScoreBtn);
        batcher.drawSprite(32, 32, 64, 64, Settings.soundEnabled?Assets.soundOnBtn:Assets.soundOffBtn);
                
        batcher.endBatch();
        
        gl.glDisable(GL10.GL_BLEND);
    }
    
    @Override
    public void pause() {        
        Settings.save(game.getFileIO());
    }

    @Override
    public void resume() {        
    }       

    @Override
    public void dispose() {        
    }
}

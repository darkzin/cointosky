package com.skyseed.androidgames.cointosky;

import com.skyseed.androidgames.framework.Music;
import com.skyseed.androidgames.framework.Sound;
import com.skyseed.androidgames.framework.gl.Animation;
import com.skyseed.androidgames.framework.gl.Font;
import com.skyseed.androidgames.framework.gl.Texture;
import com.skyseed.androidgames.framework.gl.TextureRegion;
import com.skyseed.androidgames.framework.impl.GLGame;

public class Assets {
  public static Texture background;
  public static TextureRegion backgroundRegion;
  public static TextureRegion light;
  public static TextureRegion city;
    
  public static Texture items;
  public static TextureRegion floor;
  public static TextureRegion coin;
  public static TextureRegion logo;
  public static TextureRegion balanceBar;
  public static TextureRegion energyBar;
  public static TextureRegion feverBar;
  public static TextureRegion energy;
  public static TextureRegion fever;
  public static TextureRegion backBtn;
  public static TextureRegion gameStartBtn;
  public static TextureRegion highScoreBtn;
  public static TextureRegion soundOnBtn;
  public static TextureRegion soundOffBtn;
  public static TextureRegion mascot;
  public static Animation balancePoint;
  
  /*public static TextureRegion mainMenu;
    public static TextureRegion pauseMenu;
    public static TextureRegion ready;
    public static TextureRegion gameOver;
    public static TextureRegion highScoresRegion;
    public static TextureRegion logo;
    public static TextureRegion soundOn;
    public static TextureRegion soundOff;
    public static TextureRegion arrow;
    public static TextureRegion pause;    
    public static TextureRegion spring;
    public static TextureRegion castle;
    public static Animation coinAnim;
    public static Animation bobJump;
    public static Animation bobFall;
    public static TextureRegion bobHit;
    public static Animation squirrelFly;
    public static TextureRegion platform;
    public static Animation brakingPlatform;    
    public static Font font;*/
    
    public static Music music;
    public static Sound jumpSound;
    public static Sound highJumpSound;
    public static Sound hitSound;
    public static Sound coinSound;
    public static Sound clickSound;
    
  public static void load(GLGame game) {
    background = new Texture(game, "background.png");
    backgroundRegion = new TextureRegion(background, 0, 0, 480, 800);
    light = new TextureRegion(background, 874, 0, 150, 636);
    city = new TextureRegion(background, 360, 0, 394, 286);
        
    items = new Texture(game, "items.png");        

    floor = new TextureRegion(items, 0, 320, 720, 110);
    coin = new TextureRegion(items, 0, 54, 160, 54);
    logo = new TextureRegion(items, 0, 128, 286, 190);
    balanceBar = new TextureRegion(items, 0, 0, 706, 64);
    energyBar = new TextureRegion(items, 896, 0, 60, 1024);
    feverBar = new TextureRegion(items, 960, 0, 60, 1024);
    energy = new TextureRegion(items, 736, 0, 60, 888);
    fever = new TextureRegion(items, 820, 0, 60, 888);

    balancePoint = new Animation(0.2f,
                                 new TextureRegion(items, 0, 448, 32, 32),
                                 new TextureRegion(items, 32, 448, 32, 32),
                                 new TextureRegion(items, 64, 448, 32, 32),
                                 new TextureRegion(items, 96, 448, 32, 32),
                                 new TextureRegion(items, 128, 448, 32, 32),
                                 new TextureRegion(items, 160, 448, 32, 32),
                                 new TextureRegion(items, 196, 448, 32, 32),
                                 new TextureRegion(items, 228, 448, 32, 32),
                                 new TextureRegion(items, 260, 448, 32, 32),
                                 new TextureRegion(items, 292, 448, 32, 32));
        
    //music = game.getAudio().newMusic("music.mp3");
    //music.setLooping(true);
    //music.setVolume(0.5f);
    //if(Settings.soundEnabled)
    //music.play();
    jumpSound = game.getAudio().newSound("jump.ogg");
    highJumpSound = game.getAudio().newSound("highjump.ogg");
    hitSound = game.getAudio().newSound("hit.ogg");
    coinSound = game.getAudio().newSound("coin.ogg");
    clickSound = game.getAudio().newSound("click.ogg");       
  }       
    
  public static void reload() {
    background.reload();
    items.reload();
    //if(Settings.soundEnabled)
    //music.play();
  }
    
  public static void playSound(Sound sound) {
    //if(Settings.soundEnabled)
    //sound.play(1);
  }
}

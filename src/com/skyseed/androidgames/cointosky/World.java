package com.skyseed.androidgames.cointosky;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.skyseed.androidgames.framework.math.OverlapTester;
import com.skyseed.androidgames.framework.math.Vector2;

public class World {
  public interface WorldListener {
    public void jump();

    public void highJump();

    public void hit();

    public void coin();
  }

  public static final float WORLD_WIDTH = 10;
  public static final float WORLD_HEIGHT = 15 * 20;
  public static final int WORLD_STATE_BALANCING = 0;
  public static final int WORLD_STATE_DROP_COIN = 1;
  public static final int WORLD_STATE_GAME_OVER = 2;
  public static final int BALANCE_MAX = 20;
  public static final Vector2 gravity = new Vector2(0, -12);

  public final CoinTower coinTower;

  public final int balance;
  public final int dirBalance;
  public final float energy;
  public final float fever;
  
  public final Coin coin;
  public final WorldListener listener;
  public final Random rand;

  //public float heightSoFar;
  public int score;
  public int state;

  public World(WorldListener listener) {
    /*this.bob = new Bob(5, 1);
    this.platforms = new ArrayList<Platform>();
    this.springs = new ArrayList<Spring>();
    this.squirrels = new ArrayList<Squirrel>();
    this.coins = new ArrayList<Coin>();*/

    this.coinTower = new CoinTower();
    this.coin = new Coin(320, 1200);
    this.balance = 0;
    this.dirBalance = 1;
    this.energy = 100;
    this.fever = 0;
    

    this.state = WORLD_STATE_DROP_COIN;
    this.listener = listener;
    rand = new Random();
    //generateLevel();

    this.heightSoFar = 0;
    this.score = 0;
    this.state = WORLD_STATE_RUNNING;
  }

  public void update(float deltaTime, float accelX) {
    /*updateBob(deltaTime, accelX);
    updatePlatforms(deltaTime);
    updateSquirrels(deltaTime);
    updateCoins(deltaTime);
    if (bob.state != Bob.BOB_STATE_HIT)
      checkCollisions();
      checkGameOver();*/
    
    
    if (this.state == WORLD_STATE_DROP_COIN)
      updateCoin();

    else
      updateBalanceBar(deltaTime);
    
    checkGameOver();
  }

  public void updateBalanceBar(float deltaTime){
    this.balance += dirBalance;
  }

  public void updateCoin(float deltaTime){
    coin.update(deltaTime);
  }

  
  /*
  private void updateBob(float deltaTime, float accelX) {
    if (bob.state != Bob.BOB_STATE_HIT && bob.position.y <= 0.5f)
      bob.hitPlatform();
    if (bob.state != Bob.BOB_STATE_HIT)
      bob.velocity.x = -accelX / 10 * Bob.BOB_MOVE_VELOCITY;
    bob.update(deltaTime);
    heightSoFar = Math.max(bob.position.y, heightSoFar);
  }

  private void updatePlatforms(float deltaTime) {
    int len = platforms.size();
    for (int i = 0; i < len; i++) {
      Platform platform = platforms.get(i);
      platform.update(deltaTime);
      if (platform.state == Platform.PLATFORM_STATE_PULVERIZING
          && platform.stateTime > Platform.PLATFORM_PULVERIZE_TIME) {
        platforms.remove(platform);
        len = platforms.size();
      }
    }
  }

  private void updateSquirrels(float deltaTime) {
    int len = squirrels.size();
    for (int i = 0; i < len; i++) {
      Squirrel squirrel = squirrels.get(i);
      squirrel.update(deltaTime);
    }
  }

  private void updateCoins(float deltaTime) {
    int len = coins.size();
    for (int i = 0; i < len; i++) {
      Coin coin = coins.get(i);
      coin.update(deltaTime);
    }
  }
  */
  private void checkCollisions() {
    
  }
	
  /*private void checkPlatformCollisions() {
    if (bob.velocity.y > 0)
      return;
	
    int len = platforms.size();
    for (int i = 0; i < len; i++) {
      Platform platform = platforms.get(i);
      if (bob.position.y > platform.position.y) {
        if (OverlapTester
            .overlapRectangles(bob.bounds, platform.bounds)) {
          bob.hitPlatform();
          listener.jump();
          if (rand.nextFloat() > 0.5f) {
            platform.pulverize();
          }
          break;
        }
      }
    }
  }
	
  private void checkSquirrelCollisions() {
    int len = squirrels.size();
    for (int i = 0; i < len; i++) {
      Squirrel squirrel = squirrels.get(i);
      if (OverlapTester.overlapRectangles(squirrel.bounds, bob.bounds)) {
        bob.hitSquirrel();
        listener.hit();
      }
    }
  }
	
  private void checkItemCollisions() {
    int len = coins.size();
    for (int i = 0; i < len; i++) {
      Coin coin = coins.get(i);
      if (OverlapTester.overlapRectangles(bob.bounds, coin.bounds)) {
        coins.remove(coin);
        len = coins.size();
        listener.coin();
        score += Coin.COIN_SCORE;
      }
	
    }
	
    if (bob.velocity.y > 0)
      return;
	
    len = springs.size();
    for (int i = 0; i < len; i++) {
      Spring spring = springs.get(i);
      if (bob.position.y > spring.position.y) {
        if (OverlapTester.overlapRectangles(bob.bounds, spring.bounds)) {
          bob.hitSpring();
          listener.highJump();
        }
      }
    }
  }
	
  private void checkCastleCollisions() {
    if (OverlapTester.overlapRectangles(castle.bounds, bob.bounds)) {
      state = WORLD_STATE_NEXT_LEVEL;
    }
  }

  private void checkGameOver() {
    if (heightSoFar - 7.5f > bob.position.y) {
      state = WORLD_STATE_GAME_OVER;
    }
    }*/
}
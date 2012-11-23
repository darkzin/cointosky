package com.skyseed.androidgames.cointosky;

import com.skyseed.androidgames.framework.DynamicGameObject;

public class Coin extends DynamicGameObject {
  public static final float COIN_WIDTH = 0.5f;
  public static final float COIN_HEIGHT = 0.8f;
  public static final int COIN_SCORE = 10;
  
  public static final int COIN_NORMAL = 0;
  public static final int COIN_COLLISION = 1;
  public static final int COIN_DIE = 2;
  
  int state;
  float stateTime;
  
  public Coin(float x, float y) {
    super(x, y, COIN_WIDTH, COIN_HEIGHT);
    stateTime = 0;
    state = COIN_NORMAL;
  }
    
  public void update(float deltaTime) {
    if(state == COIN_NORMAL){
      velocity.add(World.gravity.x * deltaTime, World.gravity.y * deltaTime);
      position.add(velocity.x * deltaTime, velocity.y * deltaTime);
    }
        
    stateTime += deltaTime;
  }
}

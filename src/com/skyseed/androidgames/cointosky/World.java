package com.skyseed.androidgames.cointosky;

import java.util.Random;

public class World {
  public static enum GamePhase {
    Balance,
      DroppingCoin,
      CoinPileUp
      }
  
  static final int WORLD_HEIGHT = 450;
  static final int SCORE_INCREMENT = 10;
  static final float DROPPING_COIN_TICK = 0.01f;
  static final int DROPPING_COIN_DISTANCE = 5;
  static final int HALF_MARKINGS_MAX = 10;

  public CoinTower coinTower;
  public BalanceBar balanceBar;

  public GamePhase phase = GamePhase.DroppingCoin;
  
  public int score = 0;
  public int markingDirection = 1;
  public int moveCount = 0;
  public int droppingCoinY;
  public int balance;
  
  public boolean gameOver = false;

  Random random = new Random();
  float tickTime = 0;
  public float tick;

  public World() {
    coinTower = new CoinTower();
    balanceBar = new BalanceBar();
    changePhase(GamePhase.DroppingCoin);
  }

  public void update(float deltaTime) {
    if (gameOver)
      return;

    tickTime += deltaTime;

    /* if a user does not set balance yet, the ticker on the balance bar should move continuously
     * to set balance value. when a user tap the screen anywhere, balance is set,
     * and play the drop-coin animation.
     */

    switch(phase){
    case Balance:
      tick = balanceBar.balanceBarTick;

      if(tickTime < tick)
        return;

      moveCount = (int)(tickTime / tick);
      tickTime -= tick*moveCount;

      if((balanceBar.currentMarking + moveCount) > HALF_MARKINGS_MAX || (balanceBar.currentMarking + moveCount) < -HALF_MARKINGS_MAX){
        balanceBar.currentMarking = markingDirection * HALF_MARKINGS_MAX - (markingDirection * moveCount + balanceBar.currentMarking - markingDirection * HALF_MARKINGS_MAX);
        markingDirection *= -1;
      }

      else{
        balanceBar.currentMarking += markingDirection * moveCount;
      }

      break;

    case DroppingCoin:
      tick = DROPPING_COIN_TICK;

      if(tickTime < tick)
        return;
        
      if((WORLD_HEIGHT - coinTower.towerHeight) < (droppingCoinY + DROPPING_COIN_DISTANCE)){
        changePhase(GamePhase.CoinPileUp);
      }

      else{
        moveCount = (int)(tickTime / tick);
        tickTime -= tick*moveCount;
        droppingCoinY += moveCount * DROPPING_COIN_DISTANCE;
      }

      break;

    case CoinPileUp:
      coinTower.addCoin(balance);

      if(coinTower.check_fall())
        gameOver = true;

      else{
        changePhase(GamePhase.Balance);
        balanceBar.currentMarking = 0;
      }
      break;
    }
  }

  public void changePhase(GamePhase gamePhase){
    moveCount = 0;
    tickTime = 0;
    phase = gamePhase;
    droppingCoinY = 50;
    balance = balanceBar.currentMarking;
  }
}

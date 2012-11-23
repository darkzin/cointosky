package com.skyseed.androidgames.cointosky;

import java.util.ArrayList;
import java.util.List;

public class CoinTower {
  static final int TOWER_BALANCE_MAX = 4;
  
  public int coinCount;
  public int towerBalance;
  public int towerHeight;
  
  public List<Coin> coins = new ArrayList<Coin>();
    
  public CoinTower() {        
    coinCount = 0;
    towerHeight = 25 + 50;
  }

  public void addCoin(int balance){
    if(balance <= TOWER_BALANCE_MAX && balance >= -TOWER_BALANCE_MAX) {
      coins.add(new Coin(balance));
      towerHeight += 25;
      coinCount++;
    }
  }

  public boolean check_fall() {
    if(towerBalance > TOWER_BALANCE_MAX || towerBalance < -TOWER_BALANCE_MAX)
      return true;

    return false;
  }
}

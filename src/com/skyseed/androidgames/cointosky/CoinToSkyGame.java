package com.skyseed.androidgames.cointosky;

import com.skyseed.androidgames.framework.Screen;
import com.skyseed.androidgames.framework.impl.AndroidGame;

public class CoinToSkyGame extends AndroidGame {
    @Override
    public Screen getStartScreen() {
        return new LoadingScreen(this); 
    }
}
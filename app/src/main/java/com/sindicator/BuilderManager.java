package com.sindicator;

import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;


public class BuilderManager {

    private static int[] imageResources = new int[]{
            R.drawable.homesweet,
            R.drawable.favoriteicon,
            R.drawable.settingicon,
            R.drawable.exiticon,
    };

    private static int imageResourceIndex = 0;

    static int getImageResource() {
        if (imageResourceIndex >= imageResources.length)
            imageResourceIndex = 0;
        return imageResources[imageResourceIndex++];
    }

    public static SimpleCircleButton.Builder getSimpleCircleButtonBuilder() {
        return new SimpleCircleButton.Builder()
                .normalImageRes(getImageResource());
    }









    private static BuilderManager ourInstance = new BuilderManager();

    public static BuilderManager getInstance() {
        return ourInstance;
    }

    private BuilderManager() {
    }
}
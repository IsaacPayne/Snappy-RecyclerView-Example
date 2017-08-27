package com.payne.isaac.snappyRecyclerViewExample.recyclerView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

/**
 * Created by isaac on 13/08/17.
 *
 * Extends the RecyclerView and adds the SnapHelper class, to snap to items.
 * Also uses the OnScrollListener to set alpha as items move away from the center
 * and scale up items to 1.5x as they get closer to the center.
 */

public class SnappyRecyclerView extends RecyclerView {
    final String TAG = "SnappyRecyclerView";

    public SnappyRecyclerView(Context context) {
        super(context);
        initDefault();
    }

    public SnappyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initDefault();
    }

    public SnappyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initDefault();
    }

    private void initDefault() {
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(this);
        addFadeOut();
    }

    private void addFadeOut() {
        final int viewWidth = getViewWidth();

        addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager llm = (LinearLayoutManager) recyclerView.getLayoutManager();
                int firstView = llm.findFirstVisibleItemPosition();
                int lastView = llm.findLastVisibleItemPosition();

                for(int i = firstView; i <= lastView; i++) {
                    View currentView = llm.findViewByPosition(i);
                    Log.d(TAG, "Finding View #" + i);
                    Log.d(TAG, "X: " + currentView.getX());
                    Log.d(TAG, "Center of item: " + currentView.getWidth()/2);

                    float xPosCenter = currentView.getX() + currentView.getWidth()/2.0f;
                    float centerScreen = viewWidth/2.0f;

                    float distanceFromCenter = Math.abs(centerScreen - xPosCenter);
                    Log.d(TAG, "Distance from center of view: " +
                            distanceFromCenter);

                    float percentFromCenter = distanceFromCenter/centerScreen;
                    Log.d(TAG, "Distance from center of view (%): " +
                            percentFromCenter);


                    setAlpha(percentFromCenter, currentView);
                    setScale(percentFromCenter, currentView);
                }
            }
        });
    }

    public int getViewWidth() {
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        return metrics.widthPixels;
    }

    /**
     * Sets the scale factor
     * Min: 1
     * Max: 1.5
     * @param percentFromCenter The distance from the center as a percentage
     * @param currentView The view to scale
     */
    private void setScale(float percentFromCenter, View currentView) {
        float scaleFactor = 1.0f + (.5f * (1.0f - percentFromCenter));
        currentView.setScaleX(scaleFactor);
        currentView.setScaleY(scaleFactor);
    }

    /**
     * Sets the alpha factor
     * Min: 20%
     * Max: 100%
     * @param percentFromCenter The distance from the center as a percentage
     * @param currentView The view to set the alpha for
     */
    private void setAlpha(float percentFromCenter, View currentView){
        float alpha = 0.2f + (0.8f * (1.0f - percentFromCenter));
        Log.d(TAG, "alpha: " +
                alpha);
        currentView.setAlpha(alpha);
    }
}

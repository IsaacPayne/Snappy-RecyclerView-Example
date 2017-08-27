package com.payne.isaac.snappyRecyclerViewExample.activities;

import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.payne.isaac.snappyRecyclerViewExample.recyclerView.adapters.ItemAdapter;
import com.payne.isaac.snappyRecyclerViewExample.models.ImageItemModel;
import com.payne.isaac.snappyRecyclerViewExample.models.ItemModel;
import com.payne.isaac.snappyRecyclerViewExample.R;
import com.payne.isaac.snappyRecyclerViewExample.recyclerView.SnappyRecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.pick_your_things);
        }

        initArrayLists();
    }

    /**
     * Initialises the arrays ready for the main activity
     */
    private void initArrayLists() {
        ArrayList<Observable> itemModelsTop = fillNumberArr(R.drawable.circle_green, 10);
        ArrayList<Observable> itemModelsMiddle = fillImageArr(R.drawable.circle_image, 7);
        ArrayList<Observable> itemModelsEnd = fillNumberArr(R.drawable.circle_purple, 15);

        //Top
        SnappyRecyclerView recyclerViewTop = (SnappyRecyclerView) findViewById(R.id.rv_top);
        ItemAdapter itemAdapterTop =
                new ItemAdapter(ItemAdapter.ItemType.Default, itemModelsTop, recyclerViewTop.getViewWidth());
        recyclerViewTop.setAdapter(itemAdapterTop);

        //Middle
        SnappyRecyclerView recyclerViewMiddle = (SnappyRecyclerView) findViewById(R.id.rv_middle);
        ItemAdapter itemAdapterMiddle =
                new ItemAdapter(ItemAdapter.ItemType.Image, itemModelsMiddle, recyclerViewMiddle.getViewWidth());
        recyclerViewMiddle.setAdapter(itemAdapterMiddle);

        //Bottom
        SnappyRecyclerView recyclerViewEnd = (SnappyRecyclerView) findViewById(R.id.rv_end);
        ItemAdapter itemAdapterEnd =
                new ItemAdapter(ItemAdapter.ItemType.Default, itemModelsEnd, recyclerViewEnd.getViewWidth());
        recyclerViewEnd.setAdapter(itemAdapterEnd);

    }

    /**
     * Creates an arrayList of ItemModels ready for an ItemAdapter
     * @param imageRes The image resource to be used as a background
     * @param length The number of items to add to the arrayList
     * @return An arrayList of ItemModels
     */
    private ArrayList<Observable> fillNumberArr(@DrawableRes int imageRes, int length) {
        ArrayList<Observable> itemModels = new ArrayList<>();

        for(int i = 0; i < length; i++) {
            itemModels.add(new ItemModel(imageRes, "" + i));
        }

        return itemModels;
    }

    /**
     * Creates an arrayList of ImageItemModels ready for an ItemAdapter
     * @param imageRes The image resource to be used as a background
     * @param length The number of items to add to the arrayList
     * @return An arrayList of ImageItemModels
     */
    private ArrayList<Observable> fillImageArr(@DrawableRes int imageRes, int length) {
        ArrayList<Observable> imageItemModels = new ArrayList<>();

        for(int i = 0; i < length; i++) {
            imageItemModels.add(new ImageItemModel(imageRes));
        }

        return imageItemModels;
    }

    public void confirmTapped(View view) {
        Toast.makeText(this, "\uD83D\uDC4D Nice job", Toast.LENGTH_LONG).show();
    }
}

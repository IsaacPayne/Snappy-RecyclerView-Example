package com.payne.isaac.snappyRecyclerViewExample.recyclerView.viewHolders;

import android.databinding.Observable;

import com.payne.isaac.snappyRecyclerViewExample.models.ImageItemModel;
import com.payne.isaac.snappyRecyclerViewExample.databinding.ItemImageBinding;

/**
 * Created by isaac on 13/08/17.
 */

public class ImageItemViewHolder extends DefaultBindingViewHolder {

    private final ItemImageBinding mBinding;

    public ImageItemViewHolder(ItemImageBinding binding) {
        super(binding);
        this.mBinding = binding;
    }

    @Override
    public void bind(Observable imageItemModel) {
        mBinding.setItem((ImageItemModel)imageItemModel);
        mBinding.executePendingBindings();
    }
}

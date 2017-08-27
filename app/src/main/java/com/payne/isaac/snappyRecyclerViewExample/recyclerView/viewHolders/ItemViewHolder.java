package com.payne.isaac.snappyRecyclerViewExample.recyclerView.viewHolders;

import android.databinding.Observable;

import com.payne.isaac.snappyRecyclerViewExample.models.ItemModel;
import com.payne.isaac.snappyRecyclerViewExample.databinding.ItemDefaultBinding;

/**
 * Created by isaac on 12/08/17.
 */

public class ItemViewHolder extends DefaultBindingViewHolder {

    private final ItemDefaultBinding mBinding;

    public ItemViewHolder(ItemDefaultBinding binding) {
        super(binding);
        this.mBinding = binding;
    }

    @Override
    public void bind(Observable itemModel) {
        mBinding.setItem((ItemModel)itemModel);
        mBinding.executePendingBindings();
    }
}

package com.payne.isaac.snappyRecyclerViewExample.recyclerView.viewHolders;

import android.databinding.Observable;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by isaac on 13/08/17.
 *
 * Extend this abstract class to create a ViewHolder to be used with the ItemAdapter
 */

public abstract class DefaultBindingViewHolder extends RecyclerView.ViewHolder {

    DefaultBindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
    }

    public abstract void bind(Observable observable);
}

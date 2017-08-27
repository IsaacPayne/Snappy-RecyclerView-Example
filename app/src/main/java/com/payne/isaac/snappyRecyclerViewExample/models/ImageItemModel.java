package com.payne.isaac.snappyRecyclerViewExample.models;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.support.annotation.DrawableRes;

import com.payne.isaac.snappyRecyclerViewExample.BR;

/**
 * Created by isaac on 13/08/17.
 *
 * A model which implements the Observable interface to allow for Data Binding
 *
 * Has an image which is used as the back ground
 */

public class ImageItemModel implements Observable {

    //DataBinding
    private transient PropertyChangeRegistry mCallbacks = new PropertyChangeRegistry();

    private @DrawableRes int mImageRes;

    public ImageItemModel(@DrawableRes int imageRes) {
        mImageRes = imageRes;
    }

    @Bindable
    public @DrawableRes int getImageRes() {
        return mImageRes;
    }

    public void setImageRes(@DrawableRes int imageRes) {
        this.mImageRes = imageRes;
        notifyPropertyChanged(BR.imageRes);
    }

    //Observable Interface
    @Override
    public synchronized void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        mCallbacks.add(callback);
    }

    @Override
    public synchronized void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        mCallbacks.remove(callback);
    }

    /**
     * Notifies listeners that all properties of this instance have changed.
     */
    public synchronized void notifyChange() {
        if (mCallbacks != null) {
            mCallbacks.notifyCallbacks(this, 0, null);
        }
    }

    /**
     * Notifies listeners that a specific property has changed. The getter for the property
     * that changes should be marked with {@link Bindable} to generate a field in
     * <code>BR</code> to be used as <code>fieldId</code>.
     *
     * @param fieldId The generated BR id for the Bindable field.
     */
    public void notifyPropertyChanged(int fieldId) {
        if (mCallbacks != null) {
            mCallbacks.notifyCallbacks(this, fieldId, null);
        }
    }
}

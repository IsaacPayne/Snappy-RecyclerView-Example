package com.payne.isaac.snappyRecyclerViewExample.models;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.support.annotation.DrawableRes;

import com.payne.isaac.snappyRecyclerViewExample.BR;

/**
 * Created by isaac on 12/08/17.
 *
 * A model which implements the Observable interface to allow for Data Binding
 *
 * Has an image which is used as the background and a String which is overlaid as a title
 */

public class ItemModel implements Observable {

    //DataBinding
    private transient PropertyChangeRegistry mCallbacks = new PropertyChangeRegistry();

    private @DrawableRes int mImageRes;
    private String mTitle;

    public ItemModel(@DrawableRes int imageRes, String title) {
        mImageRes = imageRes;
        mTitle = title;
    }

    @Bindable
    public @DrawableRes int getImageRes() {
        return mImageRes;
    }

    @Bindable
    public String getTitle() {
        return mTitle;
    }

    public void setImageRes(@DrawableRes int imageRes) {
        this.mImageRes = imageRes;
        notifyPropertyChanged(BR.imageRes);
    }

    public void setTitle(String title) {
        this.mTitle = title;
        notifyPropertyChanged(BR.title);
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

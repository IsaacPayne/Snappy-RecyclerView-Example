# Snappy RecyclerView

A simple implementation of a RecyclerView which makes use of the [SnapHelper](https://developer.android.com/reference/android/support/v7/widget/SnapHelper.html) class to make the RecyclerView snap the nearest item.

Also uses the distance from the center to fade out and scale each item on scroll.

## Uses
 - Android Data Binding

## Limitations
 - Currently only works in portrait
 - `scrollToPosition` is broken as it uses the the average size of an item and the first and last items are bigger than the rest
 
## Future Work
 - Add a `snappedToItem` listener
 - Fix `scrollToPosition`, by manually calculating the offset
 
## Screenshots
![Sample screenshot](https://raw.githubusercontent.com/IsaacPayne/Snappy-RecyclerView-Example/master/screenshots/screenshot.png)

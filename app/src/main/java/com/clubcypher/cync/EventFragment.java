package com.clubcypher.cync;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.nineoldandroids.view.ViewHelper;



/**
 * Created by nisargkolhe on 5/29/15.
 */
public class EventFragment extends Fragment implements ObservableScrollViewCallbacks {

    public EventFragment(){}

    Intent intent;

    private static final float MAX_TEXT_SCALE_DELTA = 0.3f;

    private ImageView mImageView;
    private View mOverlayView;
    private ObservableScrollView mScrollView;
    private TextView mTitleView;
    private View mFab;
    private int mActionBarSize;
    private int mFlexibleSpaceShowFabOffset;
    private int mFlexibleSpaceImageHeight;
    private int mFabMargin;
    private boolean mFabIsShown;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_event, container, false);
        Bundle bundle=getArguments();
        int eventID = (int) bundle.getFloat("eventid");



        //TextView name = (TextView) rootView.findViewById(R.id.eventName);
        //ImageView img = (ImageView) rootView.findViewById(R.id.logo);
        //Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);

        mFlexibleSpaceImageHeight = getResources().getDimensionPixelSize(R.dimen.flexible_space_image_height);
        mFlexibleSpaceShowFabOffset = getResources().getDimensionPixelSize(R.dimen.flexible_space_show_fab_offset);
        mActionBarSize = getActionBarSize();

        mImageView = (ImageView) rootView.findViewById(R.id.image);
        mOverlayView = rootView.findViewById(R.id.overlay);
        mScrollView = (ObservableScrollView) rootView.findViewById(R.id.scroll);
        mScrollView.setScrollViewCallbacks(this);
        mTitleView = (TextView) rootView.findViewById(R.id.title);
        //mTitleView.setText(getActivity().getTitle());
        //setTitle(null);

        ScrollUtils.addOnGlobalLayoutListener(mScrollView, new Runnable() {
            @Override
            public void run() {
                mScrollView.scrollTo(0, mFlexibleSpaceImageHeight - mActionBarSize);

                // If you'd like to start from scrollY == 0, don't write like this:
                //mScrollView.scrollTo(0, 0);
                // The initial scrollY is 0, so it won't invoke onScrollChanged().
                // To do this, use the following:
                //onScrollChanged(0, false, false);

                // You can also achieve it with the following codes.
                // This causes scroll change from 1 to 0.
                //mScrollView.scrollTo(0, 1);
                //mScrollView.scrollTo(0, 0);
            }
        });

        String eventName = "";
        switch (eventID){
            case 1:
                eventName = "(c)ode";
                mImageView.setImageResource(R.drawable.codeposter);
                break;
            case 2:
                eventName = "Decypher";
                mImageView.setImageResource(R.drawable.decypherposter);
                break;
            case 3:
                eventName = "(c)lick";
                mImageView.setImageResource(R.drawable.clickposter);
                break;
            case 4:
                eventName = "(c)reation";
                mImageView.setImageResource(R.drawable.creationposter);
                break;
            case 5:
                eventName = "Respawn";
                mImageView.setImageResource(R.drawable.respawnposter);
                break;
            case 6:
                eventName = "(c)yptcross";
                mImageView.setImageResource(R.drawable.ccposter);
                break;
            case 7:
                eventName = "(c)ynth";
                mImageView.setImageResource(R.drawable.cynthposter);
                break;
            case 8:
                eventName = "Suprise Event";
                mImageView.setImageResource(R.drawable.thposter);
                break;

        }
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(eventName);
        mTitleView.setText(eventName);


        return rootView;
    }

    protected int getActionBarSize() {
        TypedValue typedValue = new TypedValue();
        int[] textSizeAttr = new int[]{R.attr.actionBarSize};
        int indexOfAttrTextSize = 0;
        TypedArray a = getActivity().obtainStyledAttributes(typedValue.data, textSizeAttr);
        int actionBarSize = a.getDimensionPixelSize(indexOfAttrTextSize, -1);
        a.recycle();
        return actionBarSize;
    }

    public void onBackPressed() {
        // TODO Auto-generated method stub
        //super.onBackPressed();
        //Toast.makeText(getApplicationContext(), "click",2000).show();
        String cameback="CameBack";
        intent = new Intent(getActivity(),MainActivity.class);
        intent.putExtra("Comingback", cameback);
        startActivity(intent);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                String cameback="CameBack";
                intent = new Intent(getActivity(),MainActivity.class);
                intent.putExtra("Comingback", cameback);
                startActivity(intent);
                return true;
        }
        return false;
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll,
                                boolean dragging) {
        // Translate overlay and image
        float flexibleRange = mFlexibleSpaceImageHeight - mActionBarSize;
        int minOverlayTransitionY = mActionBarSize - mOverlayView.getHeight();
        ViewHelper.setTranslationY(mOverlayView, ScrollUtils.getFloat(-scrollY, minOverlayTransitionY, 0));
        ViewHelper.setTranslationY(mImageView, ScrollUtils.getFloat(-scrollY / 2, minOverlayTransitionY, 0));

        // Change alpha of overlay
        ViewHelper.setAlpha(mOverlayView, ScrollUtils.getFloat((float) scrollY / flexibleRange, 0, 1));

        // Scale title text
        float scale = 1 + ScrollUtils.getFloat((flexibleRange - scrollY) / flexibleRange, 0, MAX_TEXT_SCALE_DELTA);
        ViewHelper.setPivotX(mTitleView, 0);
        ViewHelper.setPivotY(mTitleView, 0);
        ViewHelper.setScaleX(mTitleView, scale);
        ViewHelper.setScaleY(mTitleView, scale);

        // Translate title text
        int maxTitleTranslationY = (int) (mFlexibleSpaceImageHeight - mTitleView.getHeight() * scale);
        int titleTranslationY = maxTitleTranslationY - scrollY;
        ViewHelper.setTranslationY(mTitleView, titleTranslationY);




    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
    }

}

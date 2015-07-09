package com.clubcypher.cync;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {



    //save our header or result
    private Drawer result = null;
    // Handle Toolbar
    Toolbar toolbar;

    Bundle bndl = new Bundle();

    Fragment fragment = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragment.setRetainInstance(true);

        result = new DrawerBuilder(this)
                //this layout have to contain child layouts
                .withRootView(R.id.drawer_container)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Home").withIcon(FontAwesome.Icon.faw_home),
                        new SectionDrawerItem().withName("Events"),
                        new SecondaryDrawerItem().withName("(c)ode").withIcon(FontAwesome.Icon.faw_code),
                        new SecondaryDrawerItem().withName("Decypher").withIcon(FontAwesome.Icon.faw_search),
                        new SecondaryDrawerItem().withName("(c)lick").withIcon(FontAwesome.Icon.faw_camera),
                        new SecondaryDrawerItem().withName("(c)reation").withIcon(FontAwesome.Icon.faw_paint_brush),
                        new SecondaryDrawerItem().withName("Respawn").withIcon(FontAwesome.Icon.faw_gamepad),
                        new SecondaryDrawerItem().withName("(c)rypt(c)ross").withIcon(FontAwesome.Icon.faw_puzzle_piece),
                        new SecondaryDrawerItem().withName("(c)ynth").withIcon(FontAwesome.Icon.faw_music),
                        new SecondaryDrawerItem().withName("Surprise Event").withIcon(FontAwesome.Icon.faw_question_circle),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("Contact").withIcon(FontAwesome.Icon.faw_bullhorn),
                        new PrimaryDrawerItem().withName("Results").withIcon(FontAwesome.Icon.faw_list),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("Registrations").withIcon(FontAwesome.Icon.faw_check_square_o)

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        displayView(position);
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();
        }

    }




    public String getEventName(int id){
        String eventName="(c)ync";
        switch (id){
            case 1:
                eventName = "(c)ode";
                break;
            case 2:
                eventName = "Decypher";
                break;
            case 3:
                eventName = "(c)lick";
                break;
            case 4:
                eventName = "(c)reation";
                break;
            case 5:
                eventName = "Respawn";
                break;
            case 6:
                eventName = "(c)yptic crossword";
                break;
            case 7:
                eventName = "(c)ynth";
                break;
            case 8:
                eventName = "Suprise Event";
                break;

        }
        return eventName;
    }
    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                toolbar.setTitle("(c)ync");
                toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                }
                break;

            case 2:
                bndl.putFloat("eventid", 1);
                fragment = new EventFragment();
                fragment.setArguments(bndl);
                toolbar.setTitle(getEventName(1));
                toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.CodePrimary)));
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.CodePrimary));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.CodePrimaryDark));
                }
                break;
            case 3:
                bndl.putFloat("eventid", 2);
                fragment = new EventFragment();
                fragment.setArguments(bndl);
                toolbar.setTitle(getEventName(2));
                toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.DecPrimary)));
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.DecPrimary));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.DecPrimaryDark));
                }
                break;
            case 4:
                bndl.putFloat("eventid", 3);
                fragment = new EventFragment();
                fragment.setArguments(bndl);
                toolbar.setTitle(getEventName(3));
                toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.ClkPrimary)));
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.ClkPrimary));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.ClkPrimaryDark));
                }
                break;
            case 5:
                bndl.putFloat("eventid", 4);
                fragment = new EventFragment();
                fragment.setArguments(bndl);
                toolbar.setTitle(getEventName(4));
                toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.CrePrimary)));
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.CrePrimary));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.CrePrimaryDark));
                }
                break;
            case 6:
                bndl.putFloat("eventid", 5);
                fragment = new EventFragment();
                fragment.setArguments(bndl);
                toolbar.setTitle(getEventName(5));
                //ActionBar bar = getActionBar();
                toolbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF5722")));
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.ResPrimary));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.ResPrimaryDark));
                }

                //getActivity().setTheme(R.style.RespawnTheme);
                break;
            case 7:
                bndl.putFloat("eventid", 6);
                fragment = new EventFragment();
                fragment.setArguments(bndl);
                toolbar.setTitle(getEventName(6));
                toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.CrsPrimary)));
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.CrsPrimary));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.CrsPrimaryDark));
                }
                break;
            case 8:
                bndl.putFloat("eventid", 7);
                fragment = new EventFragment();
                fragment.setArguments(bndl);
                toolbar.setTitle(getEventName(7));
                toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.CynPrimary)));
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.CynPrimary));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.CynPrimaryDark));
                }
                break;
            case 9:
                bndl.putFloat("eventid", 8);
                fragment = new EventFragment();
                fragment.setArguments(bndl);
                toolbar.setTitle(getEventName(8));
                toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.SrpPrimary)));
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.SrpPrimary));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.SrpPrimaryDark));
                }
                break;
            case 11:
                fragment = new ContactFragment();
                toolbar.setTitle("Contact Us");
                toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                }
                break;
            case 12:
                fragment = new ResultsFragment();
                toolbar.setTitle("Results");
                toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                }
                break;
            case 14:
                fragment = new RegisFragment();
                toolbar.setTitle("Registrations");
                toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                }
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();
            Log.e("MainActivity", "Success.");
            // update selected item and title, then close the drawer
            //result.setItemChecked(position, true);
            //result.setSelection(position);
            //toolbar.setTitle(((Nameable) drawerItem).getNameRes());

            //mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}

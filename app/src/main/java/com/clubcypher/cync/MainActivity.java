package com.clubcypher.cync;

import android.app.Fragment;
import android.app.FragmentManager;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        result = new DrawerBuilder(this)
                //this layout have to contain child layouts
                .withRootView(R.id.drawer_container)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Home").withIcon(FontAwesome.Icon.faw_home),
                        //new PrimaryDrawerItem().withName("Play").withIcon(FontAwesome.Icon.faw_gamepad),
                        //new PrimaryDrawerItem().withName("Custom").withIcon(FontAwesome.Icon.faw_eye),
                        new SectionDrawerItem().withName("Events"),
                        new SecondaryDrawerItem().withName("(c)ode").withIcon(FontAwesome.Icon.faw_code),
                        new SecondaryDrawerItem().withName("Decypher").withIcon(FontAwesome.Icon.faw_search),
                        new SecondaryDrawerItem().withName("(c)lick").withIcon(FontAwesome.Icon.faw_camera),
                        new SecondaryDrawerItem().withName("(c)reation").withIcon(FontAwesome.Icon.faw_paint_brush),
                        new SecondaryDrawerItem().withName("Respawn").withIcon(FontAwesome.Icon.faw_gamepad),
                        new SecondaryDrawerItem().withName("(c)ryptic (c)rossword").withIcon(FontAwesome.Icon.faw_puzzle_piece),
                        new SecondaryDrawerItem().withName("(c)ynth").withIcon(FontAwesome.Icon.faw_music),
                        new SecondaryDrawerItem().withName("Surprise Event").withIcon(FontAwesome.Icon.faw_question_circle),
                        //new SecondaryDrawerItem().withName("Settings").withIcon(FontAwesome.Icon.faw_cog),
                        //new SecondaryDrawerItem().withName("Help").withIcon(FontAwesome.Icon.faw_question).setEnabled(false),
                        //new SecondaryDrawerItem().withName(R.string.drawer_item_open_source).withIcon(FontAwesome.Icon.faw_github),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("Contact").withIcon(FontAwesome.Icon.faw_bullhorn),
                        new PrimaryDrawerItem().withName("Results").withIcon(FontAwesome.Icon.faw_list)
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
        Fragment fragment = new HomeFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment).commit();
    }

    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            /*
            case 1:
                fragment = new FindPeopleFragment();
                break;
            case 2:
                fragment = new PhotosFragment();
                break;
            case 3:
                fragment = new CommunityFragment();
                break;
            case 4:
                fragment = new PagesFragment();
                break;*/
            case 0:
                fragment = new HomeFragment();
                break;
            case 11:
                fragment = new ContactFragment();
                break;
            case 12:
                fragment = new ResultsFragment();
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

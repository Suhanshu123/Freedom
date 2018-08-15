package com.example.suhanshu.lucknowtourism;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.suhanshu.lucknowtourism.fragments.Emotive;
import com.example.suhanshu.lucknowtourism.fragments.Fighter;
import com.example.suhanshu.lucknowtourism.fragments.History;
import com.example.suhanshu.lucknowtourism.fragments.NationalAnthem;
import com.example.suhanshu.lucknowtourism.fragments.NationalSong;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    //Global Declaration
    SNavigationDrawer sNavigationDrawer;
    Class fragmentClass;
    public static Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        settingNavigationDrawer();

    }

    private void settingNavigationDrawer() {
        List<MenuItem> menuItems = new ArrayList<>();

        //Use the MenuItem given by this library and not the default one.
        //First parameter is the title of the menu item and then the second parameter is the image which will be the background of the menu item.
        menuItems.add(new MenuItem("Home", R.drawable.flag));
        menuItems.add(new MenuItem("History", R.drawable.flag));
        menuItems.add(new MenuItem("Freedom Fighters", R.drawable.flag));
        menuItems.add(new MenuItem("National Anthem", R.drawable.flag));
        menuItems.add(new MenuItem("National Song", R.drawable.flag));
        menuItems.add(new MenuItem("Emotive Quotes", R.drawable.flag));

        //then add them to navigation drawer

        sNavigationDrawer.setMenuItemList(menuItems);
        sNavigationDrawer.setAppbarTitleTextColor(ContextCompat.getColor(this,R.color.lightBlue));
        sNavigationDrawer.setAppbarTitleTV("Home");
        sNavigationDrawer.setBackgroundResource(R.drawable.flag);
        sNavigationDrawer.setNavigationDrawerBackgroundColor(R.drawable.flag);
        fragmentClass = Home.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();
        }


        //Listener to handle the menu item click. It returns the position of the menu item clicked. Based on that you can switch between the fragments.

        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position " + position);

                switch (position) {
                    case 0: {
                        fragmentClass = Home.class;
                        break;
                    }
                    case 1: {
                        fragmentClass = History.class;
                        break;
                    }
                    case 2: {
                        fragmentClass = Fighter.class;
                        break;
                    }
                    case 3: {
                        fragmentClass = NationalAnthem.class;
                        break;
                    }case 4: {
                        fragmentClass = NationalSong.class;
                        break;
                    }
                    case 5: {
                        fragmentClass = Emotive.class;
                        break;
                    }

                }

                //Listener for drawer events such as opening and closing.
                sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

                    @Override
                    public void onDrawerOpened() {
                    }

                    @Override
                    public void onDrawerOpening() {
                    }

                    @Override
                    public void onDrawerClosing() {
                        System.out.println("Drawer closed");

                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (fragment != null) {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();

                        }
                    }

                    @Override
                    public void onDrawerClosed() {

                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        System.out.println("State " + newState);
                    }
                });
            }
        });
    }
}

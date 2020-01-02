package com.itn.terranode.presentation.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.itn.terranode.R;
import com.itn.terranode.presentation.view.login.LoginActivity;
import com.itn.terranode.presentation.view.main.news_screen.NewsFragment;
import com.itn.terranode.presentation.view.main.office_screen.OfficeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bnvNavigation)
    BottomNavigationView bnvNavigation;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initUI();
    }

    private void initUI() {
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        bnvNavigation.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.office:
                    showBottomNavigationMenuFragment(new NewsFragment());
                    return true;
                case R.id.news:
                    showBottomNavigationMenuFragment(new NewsFragment());
                    return true;
                case R.id.support:
//                    showBottomNavigationMenuFragment(new SupportFragment());
                    return true;
                case R.id.products:
//                    showBottomNavigationMenuFragment(new ProductsFragment());
                    return true;
                default:
                    return false;
            }
        });
        bnvNavigation.setSelectedItemId(R.id.office);
    }

    private void showBottomNavigationMenuFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        if (fragmentManager.findFragmentByTag("new") != null){
            fragmentTransaction.remove(fragmentManager.findFragmentByTag("new"));
        }
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }


    public void showLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

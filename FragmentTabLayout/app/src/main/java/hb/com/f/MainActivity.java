package hb.com.f;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import hb.com.f.fragment.ActionFragment;
import hb.com.f.fragment.HomeFragment;
import hb.com.f.fragment.MeFragment;

public class MainActivity extends AppCompatActivity {

    private android.widget.FrameLayout flylayout;
    private android.widget.RadioGroup radioGroup;
    private List<Fragment> mFragments;
    private FragmentTransaction mFt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        this.flylayout = (FrameLayout) findViewById(R.id.fly_layout);

        FragmentManager fragmentManager = getSupportFragmentManager();
        mFt = fragmentManager.beginTransaction();
        initData();

        initEvent();


    }


    private void initEvent() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (lastRadioId != checkedId) {
                    checkedRadioBtn();
                    lastRadioId=checkedId;

                }

            }
        });

    }

    private void checkedRadioBtn() {
        int count = radioGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            if (radioGroup.getCheckedRadioButtonId() == radioGroup.getChildAt(i).getId()) {
                Log.d("MainActivity", "==========执行了");
                getSupportFragmentManager().beginTransaction().replace(R.id.fly_layout, mFragments.get(i)).commit();

            }
        }

    }

    private int lastRadioId;

    private void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new ActionFragment());
        mFragments.add(new MeFragment());

        mFt.replace(R.id.fly_layout, mFragments.get(0)).commit();
        radioGroup.check(radioGroup.getChildAt(0).getId());
        lastRadioId = mFragments.get(0).getId();

    }
}

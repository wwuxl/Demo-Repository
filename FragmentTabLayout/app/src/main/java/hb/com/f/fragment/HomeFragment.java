package hb.com.f.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hb.com.f.R;


/**
 * Created by Administrator on 2017/2/10.
 */

public class HomeFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    private String[] mTitles;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        TextView textView=new TextView(getContext());
//        textView.setText("首页页面");
//        textView.setTextSize(30);
//        textView.setTextColor(Color.RED);
        Log.d("HomeFragment", "HomeFragment");
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_home,null);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_home_title);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_home_pager);

        initData();

        return view;
    }

    private void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(new NewFragment());
        mFragments.add(new PicFragment());
        mFragments.add(new FootFragment());
        mFragments.add(new GirlsFragment());
        mFragments.add(new SportsFragment());
        mFragments.add(new PeopleFragment());

        mTitles = new String[]{"新闻","图片","美食","美女","体育","人物"};

        mViewPager.setAdapter(new MyPagerAdapter(getFragmentManager()));
        //将TabLayout和ViewPager关联起来。
        mTabLayout.setupWithViewPager(mViewPager);
        //设置可以滑动
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    class MyPagerAdapter extends FragmentPagerAdapter{


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}

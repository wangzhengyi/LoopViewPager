package genius.com.wzy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import genius.com.library.LoopPagerAdapterWrapper;
import genius.com.library.LoopViewPager;

public class LoopViewPagerActivity extends FragmentActivity {
    private List<Fragment> mFragmentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_view_pager);

        initData();
        initView();
    }

    private void initData() {
        String[] nbaPlayerName = new String[] {"科比", "乔丹", "姚明", "艾弗森", "加内特", "邓肯"};
        for (String name : nbaPlayerName) {
            Fragment fragment = NbaStarFragment.newInstance(name);
            mFragmentList.add(fragment);
        }
    }

    private void initView() {
        LoopViewPager viewPager = (LoopViewPager) findViewById(R.id.id_loop_viewpager);
        LoopPagerAdapterWrapper loopAdapter = new LoopPagerAdapterWrapper(mAdapter);
        viewPager.setAdapter(loopAdapter);
        viewPager.setCurrentItem(1);
    }

    private FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    };
}

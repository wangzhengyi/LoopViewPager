package genius.com.library;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/** 无限循环的ViewPager. */
public class LoopViewPager extends ViewPager {
    public LoopViewPager(Context context) {
        super(context);
    }

    public LoopViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);
        setCurrentItem(0);
    }

    @Override
    public void setCurrentItem(int item) {
        setCurrentItem(item, false);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        if (getAdapter().getCount() == 0) {
            super.setCurrentItem(item, smoothScroll);
        } else {
            item = getOffsetAmount() + (item % getAdapter().getCount());
            super.setCurrentItem(item, smoothScroll);
        }
    }

    @Override
    public int getCurrentItem() {
        if (getAdapter().getCount() == 0) {
            return super.getCurrentItem();
        }

        int position = super.getCurrentItem();
        if (getAdapter() instanceof  LoopPagerAdapterWrapper) {
            return position % ((LoopPagerAdapterWrapper) getAdapter()).getRealCount();
        } else {
            return super.getCurrentItem();
        }
    }

    private int getOffsetAmount() {
        if (getAdapter() instanceof LoopPagerAdapterWrapper) {
            LoopPagerAdapterWrapper loopPagerAdapter = (LoopPagerAdapterWrapper) getAdapter();
            return loopPagerAdapter.getRealCount() * 1000;
        }

        return 0;
    }
}

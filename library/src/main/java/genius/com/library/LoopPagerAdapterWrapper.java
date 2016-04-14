package genius.com.library;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class LoopPagerAdapterWrapper extends PagerAdapter {
    private PagerAdapter mPagerAdapter;

    public LoopPagerAdapterWrapper(PagerAdapter adapter) {
        mPagerAdapter = adapter;
    }

    public int getRealCount() {
        return mPagerAdapter.getCount();
    }

    @Override
    public int getCount() {
        if (getRealCount() == 0) {
            return 0;
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int realPosition = position % getRealCount();

        return mPagerAdapter.instantiateItem(container, realPosition);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int realPosition = position % getRealCount();
        mPagerAdapter.destroyItem(container, realPosition, object);
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        mPagerAdapter.finishUpdate(container);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return mPagerAdapter.isViewFromObject(view, object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        mPagerAdapter.restoreState(state, loader);
    }

    @Override
    public Parcelable saveState() {
        return mPagerAdapter.saveState();
    }

    @Override
    public void startUpdate(ViewGroup container) {
        mPagerAdapter.startUpdate(container);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        int realPosition = position % getRealCount();
        return super.getPageTitle(realPosition);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        mPagerAdapter.setPrimaryItem(container, position, object);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mPagerAdapter.unregisterDataSetObserver(observer);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        mPagerAdapter.registerDataSetObserver(observer);
    }

    @Override
    public void notifyDataSetChanged() {
        mPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        return mPagerAdapter.getItemPosition(object);
    }
}

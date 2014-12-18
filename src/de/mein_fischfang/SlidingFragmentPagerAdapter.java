package de.mein_fischfang;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * <b>Title:</b> SlidingFragmentPagerAdapter <br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2014 <br>
 * <b>Company:</b><br>
 *
 * @author Matthias
 * @version 1.0.0
 */
public class SlidingFragmentPagerAdapter extends FragmentPagerAdapter
{
    private List<SlidingPagerItem> mTabs;

    /**
     * SlidingFragmentPagerAdapter
     *
     * @param fm FragmentManager
     * @param tabs List<SlidingPagerItem>
     */
    SlidingFragmentPagerAdapter(final FragmentManager fm, final List<SlidingPagerItem> tabs)
    {
        super(fm);

        mTabs = tabs;
    }

    @Override
    /**
     * getItem
     *
     * @param int i
     * @return Fragment
     */
    public final Fragment getItem(int i)
    {
        return mTabs.get(i).createFragment();
    }

    @Override
    /**
     * getCount
     *
     * @return int
     */
    public final int getCount()
    {
        return mTabs.size();
    }

    @Override
    /**
     * getPageTitle
     *
     * @param position int
     * @return CharSequence
     */
    public final CharSequence getPageTitle(int position)
    {
        return mTabs.get(position).getTitle();
    }
}

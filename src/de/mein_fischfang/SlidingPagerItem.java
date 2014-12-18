package de.mein_fischfang;

import android.support.v4.app.Fragment;

/**
 * <b>Title:</b> SlidingPagerItem <br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2014 <br>
 * <b>Company:</b><br>
 *
 * @author Matthias
 * @version 1.0.0
 */
public class SlidingPagerItem
{
    private final ContentFragment mContentFragment;

    /**
     * SlidingPagerItem
     *
     * @param contentFragment ContentFragment
     */
    public SlidingPagerItem(final ContentFragment contentFragment)
    {
        mContentFragment = contentFragment;
    }

    /**
     * createFragment
     *
     * @return Fragment
     */
    public final Fragment createFragment()
    {
        return mContentFragment;
    }

    /**
     * getTitle
     *
     * @return CharSequence
     */
    public final CharSequence getTitle()
    {
        return mContentFragment.getTitle();
    }

    /**
     * getIndicatorColor
     *
     * @return int
     */
    public final int getIndicatorColor()
    {
        return mContentFragment.getIndicatorColor();
    }

    /**
     * getDividerColor
     *
     * @return int
     */
    public final int getDividerColor()
    {
        return mContentFragment.getDividerColor();
    }
}

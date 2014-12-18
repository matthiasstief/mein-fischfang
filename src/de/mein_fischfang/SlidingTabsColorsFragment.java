package de.mein_fischfang;

import java.util.ArrayList;
import java.util.List;

import de.mein_fischfang.view.SlidingTabLayout;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * <b>Title:</b> SlidingTabsColorsFragment <br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2014 <br>
 * <b>Company:</b><br>
 *
 * @author Matthias
 * @version 1.0.0
 */
public class SlidingTabsColorsFragment extends Fragment
{
    private List<SlidingPagerItem> mTabs = new ArrayList<SlidingPagerItem>();

    @Override
    /**
     * onCreate
     *
     * @param savedInstanceState
     */
    public final void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ContentFragmentNewCatch cfNewCatch = new ContentFragmentNewCatch(getString(R.string.tab_new_catch), Color.BLUE, Color.GRAY);
        mTabs.add(new SlidingPagerItem(cfNewCatch));

        ContentFragmentCatches cfCatches = new ContentFragmentCatches(getString(R.string.tab_catches), Color.GREEN, Color.GRAY);
        mTabs.add(new SlidingPagerItem(cfCatches));

        ContentFragmentConfiguration cfConfig = new ContentFragmentConfiguration(getString(R.string.tab_configuration), Color.RED, Color.GRAY);
        mTabs.add(new SlidingPagerItem(cfConfig));
    }

    @Override
    /**
     * onCreateView
     *
     * @param inflater LayoutInflager
     * @param container ViewGroup
     * @param savedInstanceState Bundle
     * @return View
     */
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_slider, container, false);
    }

    @Override
    /**
     * onView
     *
     * @param view View
     * @param savedInstanceState Bundle
     */
    public final void onViewCreated(View view, Bundle savedInstanceState)
    {
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new SlidingFragmentPagerAdapter(getChildFragmentManager(), mTabs));

        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        slidingTabLayout.setViewPager(viewPager);

        slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer()
        {

            @Override
            /**
             * getIndicatorColor
             *
             * @param position int
             * @return int
             */
            public int getIndicatorColor(int position)
            {
                return mTabs.get(position).getIndicatorColor();
            }

            @Override
            /**
             * getDividerColor
             *
             * @param position int
             * @return int
             */
            public int getDividerColor(int position)
            {
                return mTabs.get(position).getDividerColor();
            }

        });
    }
}

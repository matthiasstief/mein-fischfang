package de.mein_fischfang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * <b>Title:</b> ContentFragmentCatches <br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2014 <br>
 * <b>Company:</b><br>
 *
 * @author Matthias
 * @version 1.0.0
 */
public class ContentFragmentCatches extends ContentFragment
{
    private CharSequence mTitle;
    private int mIndicatorColor;
    private int mDividerColor;

    /**
     * ContentFragmentCatches
     *
     * @param csTitle CharSequence
     * @param iIndicatorColor int
     * @param iDividerColor int
     */
    public ContentFragmentCatches(final CharSequence csTitle, final int iIndicatorColor, final int iDividerColor)
    {
        mTitle = csTitle; // getString(R.string.tab_catches);
        mIndicatorColor = iIndicatorColor; // Color.GREEN;
        mDividerColor = iDividerColor; // Color.GRAY;

        Bundle bundle = new Bundle();
        bundle.putCharSequence("title", mTitle);
        bundle.putInt("indicator_color", mIndicatorColor);
        bundle.putInt("divider_color", mDividerColor);

        this.setArguments(bundle);
    }

    @Override
    /**
     * onCreateView
     *
     * @param inflater LayoutInflater
     * @param container ViewGroup
     * @param saveInstanceState Bundle
     * @return View
     */
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.page_catches, container, false);
    }

    @Override
    /**
     * onViewCreated
     *
     * @param view View
     * @param savedInstanceState Bundle
     */
    public final void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        TextView title = (TextView) view.findViewById(R.id.catches_title);
        title.setText("Alle Fänge hier");
    }

    @Override
    /**
     * getTitle
     *
     * @return CharSequence
     */
    public final CharSequence getTitle()
    {
        return mTitle;
    }

    @Override
    /**
     * getIndicatorColor
     *
     * @return int
     */
    public final int getIndicatorColor()
    {
        return mIndicatorColor;
    }

    @Override
    /**
     * getDividerColor
     *
     * @return int
     */
    public final int getDividerColor()
    {
        return mDividerColor;
    }

}

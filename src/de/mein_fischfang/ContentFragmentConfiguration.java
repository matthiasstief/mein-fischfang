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
public class ContentFragmentConfiguration extends ContentFragment
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
    public ContentFragmentConfiguration(final CharSequence csTitle, final int iIndicatorColor, final int iDividerColor)
    {
        mTitle = csTitle;
        mIndicatorColor = iIndicatorColor;
        mDividerColor = iDividerColor;

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
        return inflater.inflate(R.layout.page_configuration, container, false);
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

        TextView title = (TextView) view.findViewById(R.id.configuration_title);
        title.setText("Einstellungen hier");
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

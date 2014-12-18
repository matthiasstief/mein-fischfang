package de.mein_fischfang;

import android.support.v4.app.Fragment;

/**
 * <b>Title:</b> ContentFragment <br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2014 <br>
 * <b>Company:</b><br>
 *
 * @author Matthias
 * @version 1.0.0
 */
public abstract class ContentFragment extends Fragment
{
    /**
     * getTitle
     *
     * @return CharSequence
     */
    public abstract CharSequence getTitle();

    /**
     * getIndicatorColor
     *
     * @return int
     */
    public abstract int getIndicatorColor();

    /**
     * getDividerColor
     *
     * @return int
     */
    public abstract int getDividerColor();
}

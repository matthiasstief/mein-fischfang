package de.mein_fischfang;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * <b>Title:</b> MainActivity <br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2014 <br>
 * <b>Company:</b><br>
 *
 * @author Matthias
 * @version 1.0.0
 */
public class MainActivity extends FragmentActivity
{

    /**
     * onCreate
     *
     * @param savedInstanceState Bundle
     */
    protected final void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null)
        {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            SlidingTabsColorsFragment fragment = new SlidingTabsColorsFragment();
            transaction.replace(R.id.sliding_content_fragment, fragment);
            transaction.commit();
        }
    }
}

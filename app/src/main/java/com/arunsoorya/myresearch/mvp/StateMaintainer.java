package com.arunsoorya.myresearch.mvp;

import android.app.FragmentManager;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by T10778 on 19/06/2016.
 */
public class StateMaintainer {

    private static final String TAG = "state";
    private final WeakReference<FragmentManager> mFragmentManager;
    private final String mStateMaintenerTag;
    private StateMngFragment mStateMaintainerFrag;
    /**
     * Constructor
     * @param fragmentManager       FragmentManager reference
     * @param stateMaintainerTAG    the TAG used to insert the state maintainer fragment
     */
    public StateMaintainer(FragmentManager fragmentManager, String stateMaintainerTAG) {
        mFragmentManager = new WeakReference<>(fragmentManager);
        mStateMaintenerTag = stateMaintainerTAG;
    }
    /**
     * Create the state maintainer fragment
     * @return  true: the frag was created for the first time
     *          false: recovering the object
     */
    public boolean firstTimeIn() {
        try {
            // Recovering the reference
            mStateMaintainerFrag = (StateMngFragment)mFragmentManager.get().findFragmentByTag(mStateMaintenerTag);

            // Creating a new RetainedFragment
            if (mStateMaintainerFrag == null) {
                Log.d(TAG, "Creating a new RetainedFragment " + mStateMaintenerTag);
                mStateMaintainerFrag = new StateMngFragment();
                mFragmentManager.get().beginTransaction().add(mStateMaintainerFrag, mStateMaintenerTag).commit();
                return true;
            } else {
                Log.d(TAG, "Returns a existent retained fragment existente " + mStateMaintenerTag);
                return false;
            }
        } catch (NullPointerException e) {
            Log.w(TAG, "Error firstTimeIn()");
            return false;
        }
    }
    /**
     * Insert Object to be preserved during configuration change
     * @param key   Object's TAG reference
     * @param obj   Object to maintain
     */
    public void put(String key, Object obj) {
        mStateMaintainerFrag.put(key, obj);
    }
    /**
     * Recovers saved object
     * @param key   TAG reference
     * @param <T>   Class type
     * @return      Objects
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key)  {
        return mStateMaintainerFrag.get(key);

    }

    /**
     * Verify the object existence
     * @param key   Obj TAG
     */
    public boolean hasKey(String key) {
        return mStateMaintainerFrag.get(key) != null;
    }

}

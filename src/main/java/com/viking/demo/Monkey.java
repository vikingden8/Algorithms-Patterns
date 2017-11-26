package com.viking.demo;

import java.util.Random;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2017/9/17
 */
public class Monkey {

    /** The number of iterations **/
    int mCount = 1000;
    /** The random number seed **/
    long mSeed = 0;
    /** The random number generator **/
    Random mRandom = null;

    float[] mFactors = new float[MonkeySourceRandom.FACTORZ_COUNT];

    MonkeySourceRandom mEventSource ;

    /**
     * Command-line entry point.
     *
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        int resultCode = (new Monkey()).run();
        System.exit(resultCode);
    }

    /**
     * Run the command!
     *
     * @return Returns a posix-style result code. 0 for no error.
     */
    private int run() {
        // Default values for some command-line options
        mCount = 10;
        mSeed = 0;

        // set a positive value, indicating none of the factors is provided yet
        for (int i = 0; i < MonkeySourceRandom.FACTORZ_COUNT; i++) {
            mFactors[i] = 1.0f;
        }

        if (!processOptions()) {
            return -1;
        }

        mRandom = new Random(mSeed);
        mEventSource = new MonkeySourceRandom(mRandom) ;

        // set any of the factors that has been set
        for (int i = 0; i < MonkeySourceRandom.FACTORZ_COUNT; i++) {
            if (mFactors[i] <= 0.0f) {
                mEventSource.setFactors(i, mFactors[i]);
            }
        }

        // validate source generator
        if (!mEventSource.adjustEventFactors()) {
            return -5;
        }

        int curCount = 0 ;
        while (curCount < mCount){
            mEventSource.generateEvents() ;
            curCount ++ ;
        }

        return 0 ;
    }

    /**
     * Process the command-line options
     *
     * @return Returns true if options were parsed with no apparent errors.
     */
    private boolean processOptions() {
        mFactors[MonkeySourceRandom.FACTOR_TOUCH] = -15f;
        mFactors[MonkeySourceRandom.FACTOR_MOTION] = -10f;
        mFactors[MonkeySourceRandom.FACTOR_TRACKBALL] = -15f;
        mFactors[MonkeySourceRandom.FACTOR_ROTATION] = -2f;
        mFactors[MonkeySourceRandom.FACTOR_SYSOPS] = -2f;
        mFactors[MonkeySourceRandom.FACTOR_NAV] = -20f;
        mFactors[MonkeySourceRandom.FACTOR_MAJORNAV] = -15f;
        mFactors[MonkeySourceRandom.FACTOR_APPSWITCH] = -2f;
        mFactors[MonkeySourceRandom.FACTOR_FLIP] = -1f;
        mFactors[MonkeySourceRandom.FACTOR_ANYTHING] = -13f;
        mFactors[MonkeySourceRandom.FACTOR_PINCHZOOM] = -2f;
        mFactors[MonkeySourceRandom.FACTOR_PERMISSION] = -3f;
        return true ;
    }
}

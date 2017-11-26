package com.viking.demo;

import java.util.Random;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2017/9/17
 */
public class MonkeySourceRandom {

    public static final int FACTOR_TOUCH        = 0;
    public static final int FACTOR_MOTION       = 1;
    public static final int FACTOR_PINCHZOOM    = 2;
    public static final int FACTOR_TRACKBALL    = 3;
    public static final int FACTOR_ROTATION     = 4;
    public static final int FACTOR_PERMISSION   = 5;
    public static final int FACTOR_NAV          = 6;
    public static final int FACTOR_MAJORNAV     = 7;
    public static final int FACTOR_SYSOPS       = 8;
    public static final int FACTOR_APPSWITCH    = 9;
    public static final int FACTOR_FLIP         = 10;
    public static final int FACTOR_ANYTHING     = 11;
    public static final int FACTORZ_COUNT       = 12;    // should be last+1

    private Random mRandom;

    /** percentages for each type of event.  These will be remapped to working
     * values after we read any optional values.
     **/
    private float[] mFactors = new float[FACTORZ_COUNT];

    public MonkeySourceRandom(Random random){
        // default values for random distributions
        // note, these are straight percentages, to match user input (cmd line args)
        // but they will be converted to 0..1 values before the main loop runs.
        mFactors[FACTOR_TOUCH] = 15.0f;
        mFactors[FACTOR_MOTION] = 10.0f;
        mFactors[FACTOR_TRACKBALL] = 15.0f;
        // Adjust the values if we want to enable rotation by default.
        mFactors[FACTOR_ROTATION] = 0.0f;
        mFactors[FACTOR_NAV] = 25.0f;
        mFactors[FACTOR_MAJORNAV] = 15.0f;
        mFactors[FACTOR_SYSOPS] = 2.0f;
        mFactors[FACTOR_APPSWITCH] = 2.0f;
        mFactors[FACTOR_FLIP] = 1.0f;
        // disbale permission by default
        mFactors[FACTOR_PERMISSION] = 0.0f;
        mFactors[FACTOR_ANYTHING] = 13.0f;
        mFactors[FACTOR_PINCHZOOM] = 2.0f;
        mRandom = random;
    }

    /**
     * generate a random event based on mFactor
     */
    public void generateEvents() {
        float cls = mRandom.nextFloat();
        System.out.println("Generated factor: " + cls);
        if (cls < mFactors[FACTOR_TOUCH]) {
            System.out.println("FACTOR_TOUCH");
            return;
        } else if (cls < mFactors[FACTOR_MOTION]) {
            System.out.println("FACTOR_MOTION");
            return;
        } else if (cls < mFactors[FACTOR_PINCHZOOM]) {
            System.out.println("FACTOR_PINCHZOOM");
            return;
        } else if (cls < mFactors[FACTOR_TRACKBALL]) {
            System.out.println("FACTOR_TRACKBALL");
            return;
        } else if (cls < mFactors[FACTOR_ROTATION]) {
            System.out.println("FACTOR_ROTATION");
            return;
        } else if (cls < mFactors[FACTOR_PERMISSION]) {
            System.out.println("FACTOR_PERMISSION");
            return;
        }

        if (cls < mFactors[FACTOR_NAV]) {
            System.out.println("FACTOR_NAV");
        } else if (cls < mFactors[FACTOR_MAJORNAV]) {
            System.out.println("FACTOR_MAJORNAV");
        } else if (cls < mFactors[FACTOR_SYSOPS]) {
            System.out.println("FACTOR_SYSOPS");
        } else if (cls < mFactors[FACTOR_APPSWITCH]) {
            System.out.println("FACTOR_APPSWITCH");
            return;
        } else if (cls < mFactors[FACTOR_FLIP]) {
            System.out.println("FACTOR_FLIP");
            return;
        } else {
            System.out.println("FACTOR_PERMISSION");
        }
    }

    /**
     * Adjust the percentages (after applying user values) and then normalize to a 0..1 scale.
     */
    public boolean adjustEventFactors() {
        // go through all values and compute totals for user & default values
        float userSum = 0.0f;
        float defaultSum = 0.0f;
        int defaultCount = 0;
        for (int i = 0; i < FACTORZ_COUNT; ++i) {
            if (mFactors[i] <= 0.0f) {   // user values are zero or negative
                userSum -= mFactors[i];
            } else {
                defaultSum += mFactors[i];
                ++defaultCount;
            }
        }
        // if the user request was > 100%, reject it
        if (userSum > 100.0f) {
            System.err.println("** Event weights > 100%");
            return false;
        }
        // if the user specified all of the weights, then they need to be 100%
        if (defaultCount == 0 && (userSum < 99.9f || userSum > 100.1f)) {
            System.err.println("** Event weights != 100%");
            return false;
        }

        // compute the adjustment necessary
        float defaultsTarget = (100.0f - userSum);
        float defaultsAdjustment = defaultsTarget / defaultSum;
        // fix all values, by adjusting defaults, or flipping user values back to >0
        for (int i = 0; i < FACTORZ_COUNT; ++i) {
            if (mFactors[i] <= 0.0f) {   // user values are zero or negative
                mFactors[i] = -mFactors[i];
            } else {
                mFactors[i] *= defaultsAdjustment;
            }
        }

        // if verbose, show factors
        System.out.println("// Event percentages:");
        for (int i = 0; i < FACTORZ_COUNT; ++i) {
            System.out.println("//   " + i + ": " + mFactors[i] + "%");
        }

        // finally, normalize and convert to running sum
        float sum = 0.0f;
        for (int i = 0; i < FACTORZ_COUNT; ++i) {
            sum += mFactors[i] / 100.0f;
            mFactors[i] = sum;
        }

        System.out.println("// After Normalize Event percentages:");
        for (int i = 0; i < FACTORZ_COUNT; ++i) {
            System.out.println("//   " + i + ": " + mFactors[i]);
        }

        return true;
    }

    public void setFactors(int index, float v) {
        mFactors[index] = v;
    }
}

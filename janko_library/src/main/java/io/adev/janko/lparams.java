package io.adev.janko;

import android.os.Build;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class lparams {

    private final JankoContext jankoContext;

    public int width = WRAP_CONTENT;
    public int height = WRAP_CONTENT;

    public int weight;

    public int gravity;

    public int leftMargin;
    public int rightMargin;
    public int topMargin;
    public int bottomMargin;
    public int startMargin;
    public int endMargin;

    public lparams(JankoContextProvider jankoContextProvider) {
        this.jankoContext = jankoContextProvider.getJankoContext();
    }

    public lparams(int width, int height, JankoContextProvider jankoContextProvider) {
        this.jankoContext = jankoContextProvider.getJankoContext();
        this.width = width;
        this.height = height;
    }

    public lparams(JankoContext jankoContext) {
        this.jankoContext = jankoContext;
    }

    public ViewGroup.LayoutParams _() {

        ViewGroup.LayoutParams layoutParams;
        if (jankoContext.parentViewClass == FrameLayout.class) {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, height);
            marginLayoutParams(params);
            params.gravity = gravity;
            layoutParams = params;
        }
        else if (jankoContext.parentViewClass == LinearLayout.class) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
            marginLayoutParams(params);
            params.gravity = gravity;
            params.weight = weight;
            layoutParams = params;
        }
        else {
            layoutParams = new ViewGroup.LayoutParams(width, height);
        }

        jankoContext.layoutParams = layoutParams;

        return layoutParams;
    }

    private void marginLayoutParams(ViewGroup.MarginLayoutParams params) {

        params.leftMargin = leftMargin;
        params.rightMargin = rightMargin;
        params.topMargin = topMargin;
        params.bottomMargin = bottomMargin;

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR1) {
            params.setMarginStart(startMargin);
            params.setMarginEnd(endMargin);
        }

    }

}

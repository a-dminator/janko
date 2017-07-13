package io.adev.janko;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

public class linearLayout extends LinearLayout implements JankoContextProvider<LinearLayout> {

    private final JankoContext<LinearLayout> jankoContext;

    public linearLayout(Context context) {
        super(context);
        jankoContext = new JankoContext<>(context, LinearLayout.class);
    }

    public linearLayout(Activity activity) {
        super(activity);
        jankoContext = new JankoContext<>(activity, LinearLayout.class);
    }

    public linearLayout(JankoContext rootJankoContext) {
        super(rootJankoContext.context);
        jankoContext = new JankoContext<>(rootJankoContext.context, LinearLayout.class);
    }

    public linearLayout(JankoContextProvider rootContextProvider) {
        super(rootContextProvider.getJankoContext().context);
        jankoContext = new JankoContext<>(rootContextProvider, LinearLayout.class);
    }

    @Override
    public JankoContext getJankoContext() {
        return jankoContext;
    }

    public int orientation;
    public int backgroundColor = -1;
    public View.OnClickListener onClickListener;
    public LinearLayout _() {

        if (backgroundColor != -1) { setBackgroundColor(backgroundColor); }
        if (onClickListener != null) { setOnClickListener(onClickListener); }
        setOrientation(orientation);

        return jankoContext.build(this);
    }

}
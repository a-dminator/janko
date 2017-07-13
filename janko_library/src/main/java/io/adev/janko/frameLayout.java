package io.adev.janko;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

public class frameLayout extends FrameLayout implements JankoContextProvider {

    private final JankoContext<FrameLayout> jankoContext;

    public frameLayout(Context context) {
        super(context);
        jankoContext = new JankoContext<>(context, FrameLayout.class);
    }

    public frameLayout(Activity activity) {
        super(activity);
        jankoContext = new JankoContext<>(activity, FrameLayout.class);
    }

    public frameLayout(JankoContext rootJankoContext) {
        super(rootJankoContext.context);
        jankoContext = new JankoContext<>(rootJankoContext, FrameLayout.class);
    }

    public frameLayout(JankoContextProvider rootJankoContextProvider) {
        super(rootJankoContextProvider.getJankoContext().context);
        jankoContext = new JankoContext<>(rootJankoContextProvider, FrameLayout.class);
    }

    @Override
    public JankoContext getJankoContext() {
        return jankoContext;
    }

    public int backgroundColor;
    public View.OnClickListener onClickListener;

    @Override
    public FrameLayout _() {

        if (backgroundColor != -1) { setBackgroundColor(backgroundColor); }
        if (onClickListener != null) { setOnClickListener(onClickListener); }

        return jankoContext.build(this);
    }

}
package io.adev.janko;

import android.app.Activity;
import android.content.Context;
import android.view.View;

public class view extends View implements JankoContextProvider<View> {

    private final JankoContext<View> jankoContext;

    public view(Context context) {
        super(context);
        jankoContext = new JankoContext<>(context, View.class);
    }

    public view(Activity activity) {
        super(activity);
        jankoContext = new JankoContext<>(activity, View.class);
    }

    public view(JankoContext rootJankoContext) {
        super(rootJankoContext.context);
        jankoContext = new JankoContext<>(rootJankoContext.context, View.class);
    }

    public view(JankoContextProvider rootContextProvider) {
        super(rootContextProvider.getJankoContext().context);
        jankoContext = new JankoContext<>(rootContextProvider, View.class);
    }

    @Override
    public JankoContext getJankoContext() {
        return jankoContext;
    }

    public int backgroundColor = -1;
    public View.OnClickListener onClickListener;

    @Override
    public View _() {

        if (backgroundColor != -1) { setBackgroundColor(backgroundColor); }
        if (onClickListener != null) { setOnClickListener(onClickListener); }

        return jankoContext.build(this);
    }

}
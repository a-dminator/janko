package io.adev.janko;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import static android.view.Gravity.NO_GRAVITY;

public class textView extends TextView implements JankoContextProvider<TextView> {

    private final JankoContext<TextView> jankoContext;

    public textView(Context context) {
        super(context);
        jankoContext = new JankoContext<>(context, TextView.class);
    }

    public textView(Activity activity) {
        super(activity);
        jankoContext = new JankoContext<>(activity, TextView.class);
    }

    public textView(JankoContext rootJankoContext) {
        super(rootJankoContext.context);
        jankoContext = new JankoContext<>(rootJankoContext.context, TextView.class);
    }

    public textView(JankoContextProvider rootContextProvider) {
        super(rootContextProvider.getJankoContext().context);
        jankoContext = new JankoContext<>(rootContextProvider, TextView.class);
    }

    @Override
    public JankoContext getJankoContext() {
        return jankoContext;
    }

    public int backgroundColor = -1;
    public View.OnClickListener onClickListener;
    public String text;
    public float textSize = -1f;
    public int textResource;
    public int gravity = NO_GRAVITY;

    @Override
    public TextView _() {

        if (backgroundColor != -1) { setBackgroundColor(backgroundColor); }
        if (onClickListener != null) { setOnClickListener(onClickListener); }
        if (textResource != 0) { setText(textResource); }
        if (text != null) { setText(text); }
        if (textSize >= 0) { setTextSize(textSize); }
        if (gravity != NO_GRAVITY) { setGravity(gravity); }

        return jankoContext.build(this);
    }

}
package io.adev.janko;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import static android.view.Gravity.NO_GRAVITY;

public class button extends Button implements JankoContextProvider<TextView> {

    private final JankoContext<Button> jankoContext;

    public button(Context context) {
        super(context);
        jankoContext = new JankoContext<>(context, Button.class);
    }

    public button(Activity activity) {
        super(activity);
        jankoContext = new JankoContext<>(activity, Button.class);
    }

    public button(JankoContext rootJankoContext) {
        super(rootJankoContext.context);
        jankoContext = new JankoContext<>(rootJankoContext.context, Button.class);
    }

    public button(JankoContextProvider rootContextProvider) {
        super(rootContextProvider.getJankoContext().context);
        jankoContext = new JankoContext<>(rootContextProvider, Button.class);
    }

    @Override
    public JankoContext getJankoContext() {
        return jankoContext;
    }

    public int backgroundColor = -1;
    public OnClickListener onClickListener;
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
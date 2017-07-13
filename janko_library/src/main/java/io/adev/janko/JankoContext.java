package io.adev.janko;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class JankoContext<V extends View> {

    final Class<?> viewClass;
    final Class<?> parentViewClass;
    final JankoContext rootContext;
    public final Context context;
    private final ViewGroup root;

    private List<View> children = new ArrayList<>();

    public JankoContext(Context context, Class<?> viewClass) {
        this.context = context;
        this.root = null;
        this.rootContext = null;
        this.viewClass = viewClass;
        this.parentViewClass = null;
    }

    public JankoContext(Activity activity, Class<?> viewClass) {
        this.context = activity;
        this.rootContext = null;
        this.root = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        this.viewClass = viewClass;
        this.parentViewClass = null;
    }

    public JankoContext(JankoContext rootContext, Class<?> viewClass) {
        this.context = rootContext.context;
        this.rootContext = rootContext;
        this.root = null;
        this.viewClass = viewClass;
        this.parentViewClass = rootContext.viewClass;
    }

    public JankoContext(JankoContextProvider rootContextProvider, Class<?> viewClass) {
        this.context = rootContextProvider.getJankoContext().context;
        this.rootContext = rootContextProvider.getJankoContext();
        this.root = null;
        this.viewClass = viewClass;
        this.parentViewClass = rootContext.viewClass;
    }

    ViewGroup.LayoutParams layoutParams;

    protected V build(V result) {

        if (layoutParams == null) {
            new lparams(this)._();
        }

        result.setLayoutParams(layoutParams);

        if (!children.isEmpty()) {
            for (View child : children) {
                ((ViewGroup) result).addView(child);
            }
        }

        if (root != null) {

            root.addView(result);

        } else if (rootContext != null) {

            rootContext.children.add(result);

        }

        return result;
    }

}

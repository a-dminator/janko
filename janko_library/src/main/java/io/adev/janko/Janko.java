package io.adev.janko;

import android.content.Context;

import java.lang.ref.WeakReference;

public class Janko {

    private static WeakReference<Context> contextWeak = new WeakReference<>(null);
    public static void init(Context context) {
        contextWeak = new WeakReference<>(context);
    }

    public static int dip(float metric) {
        Context context = contextWeak.get();
        if (context == null) throw new RuntimeException("Context has been released. Please, re-init Janko.");
        return (int)(context.getResources().getDisplayMetrics().density * metric);
    }

    public static int dimen(int resource) {
        Context context = contextWeak.get();
        if (context == null) throw new RuntimeException("Context has been released. Please, re-init Janko.");
        return context.getResources().getDimensionPixelSize(resource);
    }

}

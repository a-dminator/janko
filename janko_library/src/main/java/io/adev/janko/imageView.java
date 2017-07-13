package io.adev.janko;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public class imageView extends ImageView implements JankoContextProvider<ImageView> {

    private final JankoContext<ImageView> jankoContext;

    public imageView(Context context) {
        super(context);
        jankoContext = new JankoContext<>(context, ImageView.class);
    }

    public imageView(Activity activity) {
        super(activity);
        jankoContext = new JankoContext<>(activity, ImageView.class);
    }

    public imageView(JankoContext rootJankoContext) {
        super(rootJankoContext.context);
        jankoContext = new JankoContext<>(rootJankoContext.context, ImageView.class);
    }

    public imageView(JankoContextProvider rootContextProvider) {
        super(rootContextProvider.getJankoContext().context);
        jankoContext = new JankoContext<>(rootContextProvider, ImageView.class);
    }

    @Override
    public JankoContext getJankoContext() {
        return jankoContext;
    }

    public int imageResource;
    public Drawable imageDrawable;
    public Bitmap imageBitmap;
    public ImageView.ScaleType scaleType;
    public int backgroundColor = -1;
    public View.OnClickListener onClickListener;

    @Override
    public ImageView _() {
        
        if (scaleType != null) { setScaleType(scaleType); }
        if (backgroundColor != -1) { setBackgroundColor(backgroundColor); }
        if (onClickListener != null) { setOnClickListener(onClickListener); }
        if (imageResource != 0) { setImageResource(imageResource); }
        if (imageDrawable != null) { setImageDrawable(imageDrawable); }
        if (imageBitmap != null) { setImageBitmap(imageBitmap); }

        return jankoContext.build(this);
    }

}
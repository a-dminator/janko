package io.adev.janko.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.adev.janko.frameLayout;
import io.adev.janko.imageView;
import io.adev.janko.linearLayout;
import io.adev.janko.lparams;
import io.adev.janko.textView;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.view.Gravity.CENTER;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static io.adev.janko.Janko.dimen;
import static io.adev.janko.Janko.dip;

public class AvatarSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new frameLayout(this) {{

            new lparams(MATCH_PARENT, MATCH_PARENT, this)._();

            new linearLayout(this) {{

                new lparams(this) {{
                    gravity = CENTER;
                }}._();

                orientation = VERTICAL;

                new imageView(this) {{

                    new lparams(this) {{
                        width = dimen(R.dimen.avatarSide);
                        height = dimen(R.dimen.avatarSide);
                        gravity = CENTER;
                    }}._();

                    backgroundColor = BLUE;

                }}._();

                new textView(this) {{

                    new lparams(this) {{
                        width = dimen(R.dimen.avatarSide) + dip(10);
                        height = WRAP_CONTENT;
                    }}._();

                    text = "Подпись";
                    backgroundColor = GREEN;

                }}._();

            }}._();

        }}._();

    }

}

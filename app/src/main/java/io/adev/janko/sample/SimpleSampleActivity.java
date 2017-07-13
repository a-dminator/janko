package io.adev.janko.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.adev.janko.frameLayout;
import io.adev.janko.lparams;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.view.Gravity.CENTER;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static io.adev.janko.Janko.dip;

public class SimpleSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new frameLayout(this) {{

            new lparams(this) {{
                width  = MATCH_PARENT;
                height = dip(100);
            }}._();

            backgroundColor = RED;

            new frameLayout(this) {{

                new lparams(this) {{
                    width  = dip(50);
                    height = dip(50);
                    gravity = CENTER;
                }}._();

                backgroundColor = GREEN;

            }}._();

        }}._();

    }

}

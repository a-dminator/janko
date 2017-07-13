package io.adev.janko.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.adev.janko.button;
import io.adev.janko.linearLayout;
import io.adev.janko.lparams;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static io.adev.janko.Janko.dip;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new linearLayout(this) {{

            new lparams(MATCH_PARENT, MATCH_PARENT, this)._();

            orientation = VERTICAL;

            class Item {
                String title;
                Class<?> activityClass;
                Item(String title, Class<?> activityClass) {
                    this.title = title;
                    this.activityClass = activityClass;
                }
            }

            for (final Item item : new Item[]{
                    new Item("Простой пример", SimpleSampleActivity.class),
                    new Item("Пример с аватаром", AvatarSampleActivity.class),
                    new Item("Пример на Kotlin", KotlinSampleActivity.class) }) {

                new button(this) {{

                    new lparams(this) {{
                        width = MATCH_PARENT;
                        height = WRAP_CONTENT;
                        topMargin = dip(5);
                    }}._();

                    text = item.title;
                    textSize = 18f;
                    onClickListener = new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(getContext(), item.activityClass));
                        }
                    };

                }}._();

            }

        }}._();

    }

}
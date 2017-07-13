package io.adev.janko.sample

import android.graphics.Color.GREEN
import android.graphics.Color.RED
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity.CENTER
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import io.adev.janko.Janko.dip
import io.adev.janko.frameLayout
import io.adev.janko.lparams

class KotlinSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        object : frameLayout(this) {
            init {

                object : lparams(this) {
                    init {
                        width = MATCH_PARENT
                        height = dip(100f)
                    }
                }.`_`()

                backgroundColor = RED

                object : frameLayout(this) {
                    init {

                        object : lparams(this) {
                            init {
                                width = dip(50f)
                                height = dip(50f)
                                gravity = CENTER
                            }
                        }.`_`()

                        backgroundColor = GREEN

                    }
                }.`_`()

            }

        }.`_`()

    }

}
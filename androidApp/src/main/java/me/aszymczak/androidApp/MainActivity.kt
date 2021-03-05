package me.aszymczak.androidApp

import GithubApi
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import currentPlatform
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) = super
        .onCreate(savedInstanceState)
        .also {
            setContentView(R.layout.activity_main)
            layout
                .addView(
                    TextView(this)
                        .apply {
                            text = "LADING..."
                            GithubApi()
                                .users { user ->
                                    runOnUiThread {
                                        text = "PLATFORM:${currentPlatform()}\n$user"
                                    }
                                }
                        }
                )
    }
}

package dev.yangfengfan.study.preferencedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * @author yangfengfandev@gmail.com
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings_container, MainFragment())
            .commit()
    }
}
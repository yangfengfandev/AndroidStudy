package dev.yangfengfan.study.preferencedemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * @author yangfengfan 2020-09-09
 */
class PreferenceIntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference_intent)
        findViewById<TextView>(R.id.text_view).text = intent.getStringExtra("intent_key")
    }
}
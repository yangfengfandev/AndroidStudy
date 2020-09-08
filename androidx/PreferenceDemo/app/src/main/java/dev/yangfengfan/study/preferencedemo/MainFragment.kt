package dev.yangfengfan.study.preferencedemo

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

/**
 * @author yangfengfandev@gmail.com
 */
class MainFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preference, rootKey)
    }
}
package dev.yangfengfan.study.preferencedemo

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.preference.*

/**
 * @author yangfengfandev@gmail.com
 */
class MainFragment : PreferenceFragmentCompat() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preference, rootKey)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        initSwitchPreferenceCompat()
        initEditTextPreference()
        initPreference()
    }

    private fun initSwitchPreferenceCompat() {
        val switchPreferenceCompat: SwitchPreferenceCompat? = findPreference("SwitchPreferenceCompat")
        switchPreferenceCompat?.isChecked
        switchPreferenceCompat?.switchTextOff = "ff"
        switchPreferenceCompat?.switchTextOn = "ff"
        switchPreferenceCompat?.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, newValue ->
            Log.d(TAG, "SwitchPreferenceCompat: $newValue")
            true
        }
    }

    private fun initEditTextPreference() {
        val editTextPreference: EditTextPreference? = findPreference("EditTextPreference_visible")
        editTextPreference?.text = "123" //默认内容
        editTextPreference?.summaryProvider = Preference.SummaryProvider<EditTextPreference> { preference ->
            if (TextUtils.isEmpty(preference.text)) {
                "Not set"
            } else {
                "Length of saved value: " + preference.text.length
            }
        }
        editTextPreference?.setOnBindEditTextListener { editText ->
            editText.inputType = InputType.TYPE_CLASS_NUMBER  // 输入类型限制
        }

        editTextPreference?.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, newValue ->
            Log.d(TAG, "EditTextPreference: $newValue")
            true
        }
    }

    private fun initPreference() {
        val preference: Preference? = findPreference("Preference_intent")
        // 点击Preference的跳转
        preference?.intent =
            Intent(context, PreferenceIntentActivity::class.java).putExtra("intent_key", "Preference setIntent")
        preference?.setOnPreferenceClickListener {
            Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
            true
        }
    }

    companion object {
        private const val TAG = "MainFragment"
    }
}
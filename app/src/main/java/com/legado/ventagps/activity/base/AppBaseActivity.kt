package com.legado.ventagps.activity.base

import android.app.Dialog
import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import java.util.*


open class AppBaseActivity : AppCompatActivity() {
    private var progressDialog: Dialog? = null
    var language: Locale? = null
    private var themeApp: Int = 0
    var isAdShown=false

    fun setToolbarWithoutBackButton(mToolbar: Toolbar) {
        setSupportActionBar(mToolbar)
    }

    fun setToolbar(mToolbar: Toolbar) {
        setSupportActionBar(mToolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        mToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace)
//        mToolbar.changeToolbarFont()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
//        switchToDarkMode(WooBoxApp.appTheme == DARK)
        super.onCreate(savedInstanceState)
//        noInternetDialog = null
//        if (progressDialog == null) {
//            progressDialog = Dialog(this)
//            progressDialog?.window?.setBackgroundDrawable(ColorDrawable(0))
//            progressDialog?.setContentView(R.layout.custom_dialog)
//        }
//        themeApp = WooBoxApp.appTheme
//        language = Locale(WooBoxApp.language)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
    fun showProgress(show: Boolean) {
        when {
            show -> {
                if (!isFinishing && !progressDialog!!.isShowing) {
                    progressDialog?.setCanceledOnTouchOutside(false)
                    progressDialog?.show()
                }
            }
            else -> try {
                if (progressDialog?.isShowing!! && !isFinishing) {
                    progressDialog?.dismiss()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

//
//    override fun attachBaseContext(newBase: Context?) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(updateBaseContextLocale(newBase!!)))
//    }


    override fun onStart() {
        Log.d("onStart", "called")
        super.onStart()
    }

    override fun onResume() {
        super.onResume()


    }
}

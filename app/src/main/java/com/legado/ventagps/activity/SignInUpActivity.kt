package com.legado.ventagps.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import com.iqonic.woobox.fragments.SignInFragment
import com.iqonic.woobox.fragments.SignUpFragment
import com.legado.ventagps.App
import com.legado.ventagps.AppBaseActivity
import com.legado.ventagps.R
import com.legado.ventagps.activity.base.BaseActivity
import com.legado.ventagps.utils.extensions.addFragment
import com.legado.ventagps.utils.extensions.fadeIn
import com.legado.ventagps.utils.extensions.removeFragment
import com.legado.ventagps.utils.extensions.replaceFragment

class SignInUpActivity : BaseActivity() {
    private val mSignInFragment: SignInFragment = SignInFragment()
    private val mSignUpFragment: SignUpFragment = SignUpFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_up)
        /**
         * Load Default Fragment
         */
        loadSignInFragment()
    }

    override fun providesActivityToolbar(): Boolean {
        TODO("Not yet implemented")
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        callbackManager?.onActivityResult(requestCode, resultCode, data)
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == Constants.RequestCode.SIGN_IN) {
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            try {
//                val account = task.getResult(ApiException::class.java)
//                authenticate(GoogleAuthProvider.getCredential(account?.idToken, null), account?.idToken!!, "google")
//            } catch (e: ApiException) {
//                Log.w("SIGN IN", "Google sign in failed", e)
//            }
//        }
    }

    fun loadSignUpFragment() {
        if (mSignUpFragment.isAdded) {
            replaceFragment(mSignUpFragment, R.id.fragmentContainer)
            findViewById<FrameLayout>(R.id.fragmentContainer).fadeIn(500)
        } else {
            addFragment(mSignUpFragment, R.id.fragmentContainer)
        }
    }

    fun loadSignInFragment() {
        if (mSignInFragment.isAdded) {
            replaceFragment(mSignInFragment, R.id.fragmentContainer)
            findViewById<FrameLayout>(R.id.fragmentContainer).fadeIn(500)
        } else {
            addFragment(mSignInFragment, R.id.fragmentContainer)
        }
    }

    override fun onBackPressed() {
        when {
            mSignUpFragment.isVisible -> removeFragment(mSignUpFragment)
            else -> super.onBackPressed()

        }
    }

}
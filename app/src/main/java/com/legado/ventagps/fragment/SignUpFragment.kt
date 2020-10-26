package com.iqonic.woobox.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iqonic.woobox.utils.extensions.checkIsEmpty
import com.iqonic.woobox.utils.extensions.isValidEmail
import com.iqonic.woobox.utils.extensions.showError
import com.legado.ventagps.R
import com.legado.ventagps.activity.SignInUpActivity
import com.legado.ventagps.fragment.BaseFragment
import com.legado.ventagps.utils.extensions.onClick
import kotlinx.android.synthetic.main.fragment_sign_up.*


class SignUpFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeFragment()
    }

    private fun initializeFragment() {
//        edtEmail.onFocusChangeListener = this
//        edtPassword.onFocusChangeListener = this
//        edtConfirmPassword.onFocusChangeListener = this
//        edtFirstName.onFocusChangeListener = this
//        edtLastName.onFocusChangeListener = this
//        edtPassword.transformationMethod = biggerDotTranformation
//        edtConfirmPassword.transformationMethod = biggerDotTranformation

        btnSignUp.onClick { if (validate()) activarUsuario() }
        btnSignIn.onClick { (activity as SignInUpActivity).loadSignInFragment() }
    }

    private fun activarUsuario() {
//        val requestModel = RequestModel()
//        requestModel.email = edtEmail.textToString()
//        requestModel.first_name = edtFirstName.textToString()
//        requestModel.last_name = edtLastName.textToString()
//        requestModel.password = edtPassword.textToString()
//        requestModel.username=edtFirstName.textToString()
//        (activity!! as AppBaseActivity).createCustomer(requestModel) {
//            runDelayedOnUiThread(1000) {
//                (activity as SignInUpActivity).loadSignInFragment()
//            }
//        }
    }

    private fun validate(): Boolean {
        return when {
//            edtFirstName.checkIsEmpty() -> {
//                edtFirstName.showError("error")
//                false
//            }
//            edtLastName.checkIsEmpty() -> {
//                edtLastName.showError(getString(R.string.error_field_required))
//                false
//            }
//            edtEmail.checkIsEmpty() -> {
//                edtEmail.showError(getString(R.string.error_field_required))
//                false
//            }
//            !edtEmail.isValidEmail() -> {
//                edtEmail.showError(getString(R.string.error_enter_valid_email))
//                false
//            }
//            edtPassword.checkIsEmpty() -> {
//                edtPassword.showError(getString(R.string.error_field_required))
//                false
//            }
//            edtConfirmPassword.checkIsEmpty() -> {
//                edtConfirmPassword.showError(getString(R.string.error_field_required))
//                false
//            }
//            !edtPassword.text.toString().equals(edtConfirmPassword.text.toString(), false) -> {
//                edtConfirmPassword.showError(getString(R.string.error_password_not_matches))
//                false
//            }
            else -> true
        }

    }
}
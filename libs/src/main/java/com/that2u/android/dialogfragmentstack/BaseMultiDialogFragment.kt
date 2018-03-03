package com.that2u.android.dialogfragmentstack

import android.content.DialogInterface
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager

/**
 * Created by phama on 3/2/2018.
 */
open abstract class BaseMultiDialogFragment : DialogFragment() {

    var dismissListener: OnDismissListener? = null

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)

        if(dismissListener != null){

            dismissListener!!.onDismiss(fragmentManager, this)
            this.dismissListener = null
        }
    }

    public abstract fun onBeforeHide();

    public abstract fun onBeforeDismiss();

    open interface OnDismissListener{
        fun onDismiss(fragmentManager: FragmentManager, dialog: BaseMultiDialogFragment)
    }
}
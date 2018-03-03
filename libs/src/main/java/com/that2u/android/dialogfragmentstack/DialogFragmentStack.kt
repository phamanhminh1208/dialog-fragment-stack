package com.that2u.android.dialogfragmentstack

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import java.util.*

/**
 * Created by phama on 3/2/2018.
 */
class DialogFragmentStack {
    companion object {
        val DIALOG_TAG: String = "multi_dialog"
    }

    private val dialogStack: Stack<BaseMultiDialogFragment> = Stack()

    private val dismissListener = object : BaseMultiDialogFragment.OnDismissListener {
        override fun onDismiss(fragmentManager: FragmentManager, dialog: BaseMultiDialogFragment) {
            dismiss(fragmentManager)
        }
    }

    /**
     * show new dialog fragment on top of all
     * current dialog will be hide
     */
    fun show(fragmentManager: FragmentManager, dialog: BaseMultiDialogFragment) {
        dialogStack.push(dialog);
        fragmentManager.executePendingTransactions()

        val prevFragment: Fragment? = fragmentManager.findFragmentByTag(DIALOG_TAG)
        if (prevFragment != null && prevFragment is BaseMultiDialogFragment) {
            val prevDialog: BaseMultiDialogFragment = prevFragment as BaseMultiDialogFragment

            //dismiss currently showing dialog
            prevDialog.onBeforeHide()
            prevDialog.dismissAllowingStateLoss()
        }
        //show new dialog
        dialog.show(fragmentManager.beginTransaction(), DIALOG_TAG);

        dialog.dismissListener = dismissListener
    }

    /**
     * dismiss current top dialog fragment
     * recent dialog will be shown
     */
    fun dismiss(fragmentManager: FragmentManager) {
        val curDialog: BaseMultiDialogFragment? = dialogStack.pop()
        val lastDialog: BaseMultiDialogFragment? = if (dialogStack.isEmpty()) null else dialogStack.peek()

        if (curDialog != null) {
            //dismiss currently showing dialog
            curDialog.onBeforeDismiss()
            curDialog.dismissAllowingStateLoss()
            curDialog.dismissListener = null

            if (lastDialog != null) {
                //show last recent dialog
                lastDialog.show(fragmentManager, DIALOG_TAG)
            }
        }
    }

    /**
     * dismiss all dialog
     */
    fun dismissAll(fragmentManager: FragmentManager) {
        var curDialog: BaseMultiDialogFragment? = dialogStack.peek()
        if (curDialog != null) {
            curDialog.onBeforeDismiss()
            curDialog.dismissAllowingStateLoss()
        }

        do {
            curDialog = dialogStack.pop();
            if (curDialog != null) {
                curDialog.dismissListener = null
            }
        } while (curDialog != null)
    }
}
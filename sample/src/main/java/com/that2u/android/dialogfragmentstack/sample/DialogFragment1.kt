package com.that2u.android.dialogfragmentstack.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.that2u.android.dialogfragmentstack.BaseMultiDialogFragment
import kotlinx.android.synthetic.main.layout_dialog_fragment_1.*

/**
 * Created by phama on 3/2/2018.
 */
open class DialogFragment1 : BaseMultiDialogFragment() {
    override fun onBeforeHide() {
    }

    override fun onBeforeDismiss() {
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.layout_dialog_fragment_1, container);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button1.setOnClickListener(View.OnClickListener { view -> run {
            dismissAllowingStateLoss()
        } })
    }
}
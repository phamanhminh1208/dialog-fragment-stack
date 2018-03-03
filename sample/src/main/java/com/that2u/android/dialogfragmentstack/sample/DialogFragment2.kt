package com.that2u.android.dialogfragmentstack.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.that2u.android.dialogfragmentstack.BaseMultiDialogFragment
import kotlinx.android.synthetic.main.layout_dialog_fragment_2.*

/**
 * Created by phama on 3/2/2018.
 */
open class DialogFragment2 : BaseMultiDialogFragment() {
    override fun onBeforeHide() {
    }

    override fun onBeforeDismiss() {
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.layout_dialog_fragment_2, container);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button2.setOnClickListener(View.OnClickListener { view -> run {
            dismissAllowingStateLoss()
        } })
    }
}
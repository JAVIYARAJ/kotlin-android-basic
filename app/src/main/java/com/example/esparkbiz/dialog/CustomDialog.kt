package com.example.esparkbiz.dialog

import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.example.esparkbiz.R

class CustomDialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //use for make dialog circular
        dialog?.window?.setBackgroundDrawableResource(R.drawable.dialog_rounded_shape);

        return layoutInflater.inflate(R.layout.activity_linear_layout, container,false);
    }

    override fun onStart() {
        super.onStart()
        dialog!!.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }
}
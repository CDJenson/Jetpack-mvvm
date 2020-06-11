package com.jenson.common.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatTextView;

import com.jenson.common.R;

/**
 * author: CDJenson
 * date: 2020/5/20 15:49
 * version: 1.0
 * description: One-sentence description
 */
public class DialogUtils {

    public static AlertDialog showProgressDialog(Activity activity, String message, boolean cancelable, DialogInterface.OnDismissListener onDismissListener){
        View view = activity.getLayoutInflater().inflate(R.layout.layout_progress_dialog,null);
        AppCompatTextView messageView = view.findViewById(R.id.progress_dialog_message);
        if(TextUtils.isEmpty(message)){
            messageView.setVisibility(View.GONE);
        }else{
            messageView.setText(message);
        }

        return new AlertDialog.Builder(activity)
                .setView(view)
                .setCancelable(cancelable)
                .setOnDismissListener(onDismissListener)
                .show();
    }
}

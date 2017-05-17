package com.example.song.songapplication.widget;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * Created by song
 */
public class PicPickerDialog extends DialogFragment {

  String mHint;
  AlertDialog mAlertDialog;
  DialogInterface.OnClickListener mListener;

  String[] mItems = new String[] {"相册", "相机"};

  public void setOnClickListener(DialogInterface.OnClickListener listener) {
    mListener = listener;
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setItems(mItems, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        if (mListener != null) {
          mListener.onClick(dialog, which);
        }
      }
    });
    mAlertDialog = builder.create();
    return mAlertDialog;
  }

  public void setHint(String hint) {
    mHint = hint;
  }
}

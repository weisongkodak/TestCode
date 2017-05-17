package com.example.song.songapplication.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.song.songapplication.R;
import com.example.song.songapplication.Utils.PermissionUitls;

/**
 * Created by song on 11/23/2016.
 */
public class PerPermissionDialog extends DialogFragment {
    private Button vBtnPositive;
    private Button vBtnNegative;
    private TextView vTxtTitle, vTxtContent;
    private ImageView vImgTitle;
    private OnPerPermissionDialogClickListener btnOnclickListener;
    private String contentStr;

    private int permissionCode; // the permission which need check.

    public interface OnPerPermissionDialogClickListener {
        void positive();
        void negative();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_per_permission, container);
        vBtnPositive = (Button) view.findViewById(R.id.btn_permission_positive);
        vBtnNegative = (Button) view.findViewById(R.id.btn_permission_negative);
        vTxtTitle = (TextView) view.findViewById(R.id.txt_permission_title);
        vTxtContent = (TextView) view.findViewById(R.id.txt_permission_content);
        vImgTitle = (ImageView) view.findViewById(R.id.img_permission_title);
        vBtnPositive.setOnClickListener(clickListener);
        vBtnNegative.setOnClickListener(clickListener);
        initViewByPermissionCode();
        setCancelable(false);
        return view;
    }

    View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int i = v.getId();
            if (i == R.id.btn_permission_positive) {
                btnOnclickListener.positive();
                dismiss();

            } else if (i == R.id.btn_permission_negative) {
                btnOnclickListener.negative();
                dismiss();

            }
        }

    };

    private void initViewByPermissionCode() {
        vBtnNegative.setVisibility(permissionCode == PermissionUitls.PERMISSION_FIRST_PAGE_CODE ? View.GONE : View.VISIBLE);
        vTxtContent.setText(contentStr);
        vTxtTitle.setText(getResources().getString(R.string.dialogTitle));
        switch (permissionCode) {
            case PermissionUitls.PERMISSION_FIRST_PAGE_CODE:
//                vTxtTitle.setText(R.string.PrePermission_Launch_Title);
//                vImgTitle.setImageResource(R.drawable.icon_alert_confirm);
//                vTxtContent.setText(R.string.PrePermission_Launch_Message);
                vTxtContent.setGravity(Gravity.LEFT);
                break;
            case PermissionUitls.PERMISSION_CAMERA_CODE:
                break;
            case PermissionUitls.PERMISSION_READ_PHONE_STATE_CODE:
                break;
            case PermissionUitls.PERMISSION_STORAGE_CODE:
                break;
            case PermissionUitls.PERMISSION_CONTACTS_CODE:
                break;
            case PermissionUitls.PERMISSION_LOCATION_CODE:
                break;
        }
    }

    public void setBtnOnclickListener(OnPerPermissionDialogClickListener btnOnclickListener) {
        this.btnOnclickListener = btnOnclickListener;
    }

    public void setPermissionCode(int permissionCode) {
        this.permissionCode = permissionCode;
    }

    public void setContentStr(String contentStr) {
        this.contentStr = contentStr;
    }
}

package com.example.song.songapplication.Utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.example.song.songapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10181198 on 9/5/2016.
 */
public class PermissionUitls {
    public static String coarseLocation = Manifest.permission.ACCESS_COARSE_LOCATION;
    public static String fineLocation = Manifest.permission.ACCESS_FINE_LOCATION;
    public static String phoneState = Manifest.permission.READ_PHONE_STATE;
    public static String camera = Manifest.permission.CAMERA;
    public static String writeExternalStorage = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static String readContacts = Manifest.permission.READ_CONTACTS;
    public static PermissionUitls permissionUitls;
    public static Context mContext;
    public static FragmentManager mFragmentManager;
    /**
     * Manifest.permission.ACCESS_COARSE_LOCATION
     * Manifest.permission.ACCESS_FINE_LOCATION
     * Manifest.permission.READ_PHONE_STATE
     */
    public static final int PERMISSION_ALL_CODE = 0;//
    public static final int PERMISSION_FIRST_PAGE_CODE = 10;// the permission of first page
    public static final int PERMISSION_CAMERA_CODE = 1;//Manifest.permission.CAMERA
    public static final int PERMISSION_READ_PHONE_STATE_CODE = 2;//Manifest.permission.READ_PHONE_STATE
    public static final int PERMISSION_STORAGE_CODE = 3;//Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static final int PERMISSION_CONTACTS_CODE = 4;//Manifest.permission.READ_CONTACTS;
    public static final int PERMISSION_LOCATION_CODE = 5;//Manifest.permission.ACCESS_COARSE_LOCATION; Manifest.permission.ACCESS_FINE_LOCATION;
    private static PermissionListener mPermissionListener;
    private static int permissionCodeCheck = 0;
    public PermissionUitls() {

    }

    public static PermissionUitls getInstance() {
        if (permissionUitls == null) {
            permissionUitls = new PermissionUitls();
        }
        return permissionUitls;
    }

    public static PermissionUitls getInstance(FragmentManager fragmentManager, PermissionListener permissionListener) {
        mFragmentManager = fragmentManager;
        mPermissionListener = permissionListener;
        return getInstance();
    }


    public static void permssionCheck(int permissionCode) {
        if (Build.VERSION.SDK_INT >= 23) {
            permissionCodeCheck = permissionCode;
            List<String> unauthorizedPermissions = getUnauthorizedPermissonListByCode(permissionCode);
            if (unauthorizedPermissions != null && unauthorizedPermissions.size() !=0) {
                requestPermissions(permissionCode, unauthorizedPermissions);
            } else {
                mPermissionListener.permissionAgree();
            }
        }else {
            mPermissionListener.permissionAgree();
        }

    }

    public static boolean isAuthorized(String permission) {
        boolean isAuthorized = false;
        if (ContextCompat.checkSelfPermission(mContext, permission) == PackageManager.PERMISSION_GRANTED) {
            isAuthorized = true;
        }
        return isAuthorized;
    }

    public static boolean isAuthorizedByCode(int permissionCode) {
        boolean isAuthorized = false;
        List<String> unauthorizedPermissonList = getUnauthorizedPermissonListByCode(permissionCode);
        if (unauthorizedPermissonList.size() == 0) {
            isAuthorized = true;
        }
        return isAuthorized;
    }
    public static List<String> getUnauthorizedPermissonListByCode(int permissionCode) {
        List<String> permissionList = new ArrayList<>();
        switch (permissionCode) {
            case PERMISSION_ALL_CODE:
                if (!isAuthorized(coarseLocation)) {
                    permissionList.add(coarseLocation);
                }
                if (!isAuthorized(fineLocation)) {
                    permissionList.add(fineLocation);
                }
                if (!isAuthorized(phoneState)) {
                    permissionList.add(phoneState);
                }
                if (!isAuthorized(writeExternalStorage)) {
                    permissionList.add(writeExternalStorage);
                }
                if (!isAuthorized(camera)) {
                    permissionList.add(camera);
                }
                if (!isAuthorized(readContacts)) {
                    permissionList.add(readContacts);
                }
                break;
            case PERMISSION_CAMERA_CODE:

                if (!isAuthorized(camera)) {
                    permissionList.add(camera);
                }
                break;
            case PERMISSION_READ_PHONE_STATE_CODE:
                if (!isAuthorized(phoneState)) {
                    permissionList.add(phoneState);
                }
                break;
            case PERMISSION_STORAGE_CODE:
                if (!isAuthorized(writeExternalStorage)) {
                    permissionList.add(writeExternalStorage);
                }
                break;
            case PERMISSION_CONTACTS_CODE:
                if (!isAuthorized(readContacts)) {
                    permissionList.add(readContacts);
                }
                break;
            case PERMISSION_FIRST_PAGE_CODE:
                if (!isAuthorized(phoneState)) {
                    permissionList.add(phoneState);
                }
                if (!isAuthorized(writeExternalStorage)) {
                    permissionList.add(writeExternalStorage);
                }
                if (!isAuthorized(coarseLocation)) {
                    permissionList.add(coarseLocation);
                }
                if (!isAuthorized(fineLocation)) {
                    permissionList.add(fineLocation);
                }
                break;

            case PERMISSION_LOCATION_CODE:
                if (!isAuthorized(coarseLocation)) {
                    permissionList.add(coarseLocation);
                }
                if (!isAuthorized(fineLocation)) {
                    permissionList.add(fineLocation);
                }
                break;
        }
        return permissionList;
    }

    public static boolean isGetAllPermissionsByList(List<String> permissions) {
        boolean getAllPermissoins = true;
        if (permissions == null) return true;
        for (String permissionCode : permissions) {
            if (ContextCompat.checkSelfPermission(mContext, permissionCode)
                    != PackageManager.PERMISSION_GRANTED) {
                getAllPermissoins = false;
                break;
            }
        }
        return getAllPermissoins;
    }

    public static boolean isGetAllPermissionsByList(int[] grantResults) {
        boolean getAllPermissoins = true;
        if (grantResults == null) return true;
        for (int grantResult : grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                getAllPermissoins = false;
                break;
            }
        }
        return getAllPermissoins;
    }

    public static boolean shouldShowRequestPermissionRationaleByList(String[] permissions) {
        boolean shouldShow = false;
        if (permissions == null) return true;
        for (String permission : permissions) {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) mContext, permission)) {
                shouldShow = true;
                break;
            }
        }
        return shouldShow;
    }

    /**
     * Requests the Camera permission.
     * If the permission has been denied previously, a SnackBar will prompt the user to grant the
     * permission, otherwise it is requested directly.
     */
    private static void requestPermissions(int permissionCode, List<String> permissionList) {
        int REQUEST_CODE = permissionCode;
        if (permissionList != null) {
            int size = permissionList.size();
            if (size != 0) {
                String[] permissions = permissionList.toArray(new String[size]);
                ActivityCompat.requestPermissions((Activity) mContext, permissions, REQUEST_CODE);
            }

        }

    }

    private static void showPermissionWarn(String content) {
        Toast.makeText(mContext,content,Toast.LENGTH_SHORT).show();
    }

    public static void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                                  @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_FIRST_PAGE_CODE :
                if (!isAuthorized(writeExternalStorage)) {
                    String content;
                    if (!ActivityCompat.shouldShowRequestPermissionRationale((Activity) mContext, writeExternalStorage)) {

                        content = mContext.getString(R.string.PermissionDialog_setting);
                    }else {
                        content = mContext.getString(R.string.PermissionDialog_Needful);
                    }
                    showPermissionWarn(content);
                }else{
                    // the other permission is not important. agree or not will go on;
                    mPermissionListener.permissionAgree();
                }
                break;
            default:
            case PERMISSION_CONTACTS_CODE:
            case PERMISSION_CAMERA_CODE :
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    mPermissionListener.permissionAgree();
                }else{
                    mPermissionListener.permissionReject();
                }
                break;
        }

    }

    public interface PermissionListener {
        void permissionAgree();
        void permissionReject();
    }
}

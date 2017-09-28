package cn.hchstudio.example;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.hchstudio.kpermissions.Permission;
import cn.hchstudio.kpermissions.KPermission;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/**
 * Created by changhuin on 2017/8/1.
 */

public class JavaActivity extends AppCompatActivity {

    private KPermission kPermission;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        kPermission = new KPermission(this);
        kPermission.requestPermission(new String[]{"", ""}, new Function1<Boolean, Unit>() {
            @Override
            public Unit invoke(Boolean aBoolean) {
                return null;
            }
        }, new Function1<Permission, Unit>() {
            @Override
            public Unit invoke(Permission permission) {
                return null;
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        kPermission.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}

package cn.hchstudio.example

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import cn.hchstudio.kpermissions.KPermission

class MainActivity : AppCompatActivity() {

    private val TAG = "KPermission"
    private var kPermission: KPermission = KPermission(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kPermission.requestPermission(arrayOf(Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE), {
            Log.i(TAG, "isAllow---$it")
        }, {
            Log.i(TAG, "permission---$it")
        })

        findViewById(R.id.button).setOnClickListener {
            KPermission.startPermissionSetting(this)
        }

        var transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.fl_main, KFragment())
        transaction.commit()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        kPermission.onRequestPermissionsResult(requestCode, permissions, grantResults)
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}

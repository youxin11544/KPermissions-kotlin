package cn.hchstudio.example

import android.Manifest
import android.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.hchstudio.kpermissions.KPermission

/**
 * Created by ChanghuiN on 17-8-14.
 */
class KFragment : Fragment() {

    private val TAG = "KFragment"
    private var kPermission: KPermission = KPermission(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater.inflate(R.layout.fragment_k, container, false)

        view.findViewById(R.id.bt_frag).setOnClickListener {
            kPermission.requestPermission(arrayOf(Manifest.permission.READ_PHONE_STATE), {
                Log.i(TAG, "isAllow---$it")
            }, {
                Log.i(TAG, "permission---$it")
            })
        }

        return view
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        kPermission.onRequestPermissionsResult(requestCode, permissions, grantResults)
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
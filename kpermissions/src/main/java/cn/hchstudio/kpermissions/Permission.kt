package cn.hchstudio.kpermissions

/**
 * Created by ChanghuiN on 17-7-30.
 */
data class Permission(
    var name: String,
    var granted: Boolean,
    var shouldShowRequestPermission: Boolean
)
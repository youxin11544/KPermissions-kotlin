# KPermissions

This library allows the usage of Kotlin with the new Android M permission model.

## Setup

To use this library your `minSdkVersion` must be >= 14.

In your build.gradle :

```gradle
repositories {
    jcenter() // If not already there
}

dependencies {
    compile 'cn.hchstudio:kpermissions:1.0.9'
}
```

## Usage

Create a `KPermissions` instance :

```kotlin
var kPermission: KPermission = KPermission(this) // where this is an Activity instance
```

Example : request the CAMERA permission

```kotlin
kPermission.requestPermission(arrayOf(Manifest.permission.CAMERA), {
    Log.i(TAG, "isAllow---$it")
}, {
    Log.i(TAG, "permission---$it")
})
```

You can need add callback in 'onRequestPermissionsResult' :
```kotlin
override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
    kPermission.onRequestPermissionsResult(requestCode, permissions, grantResults)
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
}
```

It can been use in Java.  
Look at the `sample` app for more.

## History
### Version 1.0.9 (2017-08-14)
1. add support in fragment

### Version 1.0.8 (2017-08-05)
1. add 'isDebug'
2. add API 'startPermissionSetting()'
3. Compatibility optimization
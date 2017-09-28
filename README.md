# KPermissions

This library allows the usage of Kotlin with the new Android M permission model.

## Setup

To use this library your `minSdkVersion` must be >= 14.


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


# rn-android-notifications-permissions

## Description

React-native library to get necessary permissions for notifications on android (Autostart and Battery optimizations)

## Installation

`yarn add rn-android-notifications-permissions`

Add `REQUEST_IGNORE_BATTERY_OPTIMIZATIONS` permission in AndroidManifest
```xml
<uses-permission android:name="android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS" />
```

## Usage

```ts
import {Autostart, BatteryOptimizations} from 'rn-android-notifications-permissions';

BatteryOptimizations.isSupported().then(supported => {
  if (supported) {
    BatteryOptimizations.isIgnoringBatteryOptimizations().then(
      ignoringBatteryOptimizations => {
        if (!ignoringBatteryOptimizations) {
          BatteryOptimizations.open();
        }
      },
    )
  }
});


...


Autostart.isSupported().then(supported => {
  if (supported) {
    Autostart.open();
  }
});
```

import { NativeModules, Platform} from 'react-native';

const { BatteryOptimizationsModule, AutostartModule } = NativeModules;

function blank() {}
function blankPromise() {
  return Promise.resolve(false)
}

export const BatteryOptimizations = Platform.OS === 'android' ? {
  isSupported:  BatteryOptimizationsModule.isSupported,
  isIgnoringBatteryOptimizations:  BatteryOptimizationsModule.isIgnoringBatteryOptimizations,
  open:  BatteryOptimizationsModule.open,
} : {
  isSupported:  blankPromise,
  isIgnoringBatteryOptimizations:  blankPromise,
  open:  blank,
}

export const Autostart = Platform.OS === 'android' ? {
  isSupported:  AutostartModule.isSupported,
  open:  AutostartModule.open,
} : {
  isSupported:  blankPromise,
  open:  blank,
}

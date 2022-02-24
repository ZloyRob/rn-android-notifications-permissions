import { NativeModules, Platform} from 'react-native';

const { BatteryOptimizationsModule, AutostartModule } = NativeModules;

export const BatteryOptimizations = {
  isSupported:  BatteryOptimizationsModule.isSupported,
  isIgnoringBatteryOptimizations:  BatteryOptimizationsModule.isIgnoringBatteryOptimizations,
  open:  BatteryOptimizationsModule.open,
}

export const Autostart = {
  isSupported:  AutostartModule.isSupported,
  open:  AutostartModule.open,
}

import { NativeModules, Platform} from 'react-native';

export const isIgnoringBatteryOptimizations = () => {
  if (Platform.OS === 'android') {
    NativeModules.BatteryOptimizations.isIgnoringBatteryOptimizations();
  }
};

export { RNAutostart, BatteryOptimizations} = NativeModules;

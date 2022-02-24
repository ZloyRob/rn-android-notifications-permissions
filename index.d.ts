declare module 'rn-android-notifications-permissions' {
  export const RNAutostart: {
    isSupported(): Promise<boolean>;
    open(): void;
  };
  
  export const BatteryOptimizations: {
    isSupported(): Promise<boolean>;
    isIgnoringBatteryOptimizations(): Promise<boolean>;
    open(): void;
  }
}



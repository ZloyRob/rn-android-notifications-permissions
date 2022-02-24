declare module 'rn-android-notifications-permissions' {
  export const Autostart: {
    isSupported(): Promise<boolean>;
    open(): void;
  };
  
  export const BatteryOptimizations: {
    isSupported(): Promise<boolean>;
    isIgnoringBatteryOptimizations(): Promise<boolean>;
    open(): void;
  };
}

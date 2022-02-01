import { registerPlugin } from '@capacitor/core';
import { MigrateLocalStoragePlugin } from './definitions';

const MigrateLocalStorage = registerPlugin<MigrateLocalStoragePlugin>(
  'MigrateLocalStorage',
  {
    web: () => import('./web').then(m => new m.MigrateLocalStorageWeb()),
  }
);

export * from './definitions';
export { MigrateLocalStorage };

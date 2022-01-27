import { registerPlugin } from '@capacitor/core';
import type { migratelocalstoragePlugin } from './definitions';

const migratelocalstorage = registerPlugin<migratelocalstoragePlugin>('migratelocalstorage', {
  web: () => import('./web').then(m => new m.migratelocalstorageWeb()),
});

export * from './definitions';
export { migratelocalstorage };

import { WebPlugin } from '@capacitor/core';

import type { migratelocalstoragePlugin } from './definitions';

export class migratelocalstorageWeb extends WebPlugin implements migratelocalstoragePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async getLocalStorageItems(): Promise<any> {
    throw this.unimplemented('getLocalStorageItems not implemented on web.');
  }
}

const MigrateLocalStorage = new migratelocalstorageWeb();

export { MigrateLocalStorage };

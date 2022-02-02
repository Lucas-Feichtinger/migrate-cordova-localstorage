import { WebPlugin } from '@capacitor/core';
import type { MigrateLocalStoragePlugin } from './definitions';

export class MigrateLocalStorageWeb extends WebPlugin implements MigrateLocalStoragePlugin {

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async getVertragswerk(): Promise<{ vwk: string }> {
    throw this.unimplemented('getVertragswerk not implemented on web.');
  }
}

const MigrateLocalStorage = new MigrateLocalStorageWeb();

export { MigrateLocalStorage };

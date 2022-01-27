import { WebPlugin } from '@capacitor/core';

import type { migratelocalstoragePlugin } from './definitions';

export class migratelocalstorageWeb extends WebPlugin implements migratelocalstoragePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}

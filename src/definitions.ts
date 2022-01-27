export interface migratelocalstoragePlugin {

  getLocalStorageItems(): Promise<any>
  echo(options: { value: string }): Promise<{ value: string }>;
}

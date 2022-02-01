export interface MigrateLocalStoragePlugin {
  getVertragswerk(): Promise<string>
  echo(options: { value: string }): Promise<{ value: string }>;
}

export interface MigrateLocalStoragePlugin {
  getVertragswerk(): Promise<{ vwk: string }>
  echo(options: { value: string }): Promise<{ value: string }>;
}

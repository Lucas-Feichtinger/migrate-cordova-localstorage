export interface migratelocalstoragePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}

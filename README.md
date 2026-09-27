# Rockstar

Fabric client mod for Minecraft 1.21.4, reconstructed from the original (unpacked/decompiled) client.

## Requirements

- JDK 21
- On Windows, set `JAVA_HOME` before building:
  ```powershell
  $env:JAVA_HOME = "C:\Program Files\Java\jdk-21.0.10"
  ```

## Build

```powershell
.\gradlew.bat build --no-daemon --console=plain
```

Output: `build/libs/rockstar-1.0.0.jar`

The jar is remapped to the `intermediary` namespace (`Fabric-Mapping-Namespace: intermediary`), matching the
environment the original mod shipped for. Included dependencies (`META-INF/jars/`): catboost-prediction,
zxing core + javase, nanohttpd.

## Mapping / namespace setup

All source is written in **intermediary** names (`class_310`, `method_1574`, ...) because it was decompiled from
the original intermediary-remapped jar. The project compiles against an intermediary-named Minecraft jar provided
by the identity mapping file in `mappings/intermediary-1.21.4-named.jar` (`official -> intermediary -> named`
identity tiny). There is no named-source dev environment; `runClient` is not wired up.

### Mixin refmap

- `src/main/resources/rockstar-refmap.json` is the refmap extracted from the original jar. It is identity
  (`intermediary -> intermediary`) and is shipped as-is.
- The mixin annotation processor is intentionally **not** run (`loom.mixin.useLegacyMixinAp` is off). It is
  incompatible with intermediary-named source: it expects named names and fails to locate mappings for strings
  like `@Inject(method = "close()V")`. The mixin string references in this source already use intermediary names
  (or names that exist literally in the intermediary classes, e.g. `close()` on `AutoCloseable` targets), so they
  resolve at runtime without AP-generated remapping.

## Access widener

`src/main/resources/rockstar.accesswidener` is declared with header `accessWidener v2 named` in source; Loom
remaps it to `intermediary` inside the shipped jar.

## Notes

- `fabric.mod.json` declares no entrypoints; initialization happens through `MinecraftClientMixin`.
- Depends on fabric-api `0.119.4+1.21.4` and fabric-loader `0.16.14`.

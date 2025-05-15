import "package:envied/envied.dart";

part "env.g.dart";

@Envied(path: ".env")
final class Env {
  @EnviedField(varName: "OPM_API_KEY", obfuscate: true)
  static final String opmApiKey = _Env.opmApiKey;
}

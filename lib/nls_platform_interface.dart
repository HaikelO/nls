import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'nls_method_channel.dart';

abstract class NlsPlatform extends PlatformInterface {
  /// Constructs a NlsPlatform.
  NlsPlatform() : super(token: _token);

  static final Object _token = Object();

  static NlsPlatform _instance = MethodChannelNls();

  /// The default instance of [NlsPlatform] to use.
  ///
  /// Defaults to [MethodChannelNls].
  static NlsPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [NlsPlatform] when
  /// they register themselves.
  static set instance(NlsPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }

  Future<void> scan() {
    throw UnimplementedError('scan() has not been implemented.');
  }
}

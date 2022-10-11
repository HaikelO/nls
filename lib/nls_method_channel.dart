import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'nls_platform_interface.dart';

/// An implementation of [NlsPlatform] that uses method channels.
class MethodChannelNls extends NlsPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('nls');

  @override
  Future<String?> getPlatformVersion() async {
    final version =
        await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }

  @override
  Future<void> scan() async {
    await methodChannel.invokeMethod<String>('scan');
  }
}

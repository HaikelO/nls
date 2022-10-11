import 'dart:async';

import 'package:flutter/services.dart';

import 'nls_platform_interface.dart';

class Nls {
  static const EventChannel _resultChannel = const EventChannel('result');

  Future<String?> getPlatformVersion() {
    return NlsPlatform.instance.getPlatformVersion();
  }

  Future<void> scan() {
    return NlsPlatform.instance.scan();
  }

  static Stream<String> get getResultStream {
    return _resultChannel.receiveBroadcastStream().cast();
  }
}

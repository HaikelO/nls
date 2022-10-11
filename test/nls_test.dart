import 'package:flutter_test/flutter_test.dart';
import 'package:nls/nls.dart';
import 'package:nls/nls_method_channel.dart';
import 'package:nls/nls_platform_interface.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockNlsPlatform with MockPlatformInterfaceMixin implements NlsPlatform {
  @override
  Future<String?> getPlatformVersion() => Future.value('42');

  @override
  Future<String?> getScannerResult() {
    // TODO: implement getScannerResult
    throw UnimplementedError();
  }
}

void main() {
  final NlsPlatform initialPlatform = NlsPlatform.instance;

  test('$MethodChannelNls is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelNls>());
  });

  test('getPlatformVersion', () async {
    Nls nlsPlugin = Nls();
    MockNlsPlatform fakePlatform = MockNlsPlatform();
    NlsPlatform.instance = fakePlatform;

    expect(await nlsPlugin.getPlatformVersion(), '42');
  });
}

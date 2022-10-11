package com.example.nls

import android.content.Context
import android.content.SharedPreferences
import android.content.Intent
import android.util.Log
import androidx.annotation.NonNull;
import androidx.core.content.edit


import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

/** NlsPlugin */
class NlsPlugin: FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel
  private lateinit var context: Context

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "nls")
    channel.setMethodCallHandler(this)
    context = flutterPluginBinding.applicationContext

    val resultEventChannel = EventChannel(flutterPluginBinding.binaryMessenger, "nlsresult")
    val streamHandler = StreamHandler(context)
    resultEventChannel.setStreamHandler(streamHandler)
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    if (call.method == "getPlatformVersion") {
      result.success("Android ${android.os.Build.VERSION.RELEASE}")
    } else if (call.method == "scan") {
      scan(call)
    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }

  fun scan(call: MethodCall) {
    val intent = Intent("nlscan.action.SCANNER_TRIG")
    context.sendBroadcast(intent)
  }
}

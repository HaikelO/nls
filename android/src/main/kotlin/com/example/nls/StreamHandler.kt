package com.example.nls

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import io.flutter.plugin.common.EventChannel

class StreamHandler(var context: Context): EventChannel.StreamHandler {

    private lateinit var receiver: Receiver

    override fun onListen(arguments: Any?, events: EventChannel.EventSink?) {
        println("onListen")
        receiver = Receiver(events)
        val intentFilter = IntentFilter("nlscan.action.SCANNER_RESULT")
        context.registerReceiver(receiver,intentFilter)
    }

    override fun onCancel(arguments: Any?) {
        context.unregisterReceiver(receiver)
    }

}

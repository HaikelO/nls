package com.example.nls

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import io.flutter.plugin.common.EventChannel


class Receiver(private val event: EventChannel.EventSink?) : BroadcastReceiver() {
    override fun  onReceive(context: Context?,  intent: Intent) {
        val scanResult_1 = intent.getStringExtra("SCAN_BARCODE1")
        val scanResult_2 = intent.getStringExtra("SCAN_BARCODE2")
        val scanStatus = intent.getStringExtra("SCAN_STATE")
        if("ok".equals(scanStatus)){
            if(scanResult_1 != null) {
                event?.success(scanResult_1)
            }
            if(scanResult_2 != null) {
                event?.success(scanResult_2)
            }
        }else{
            println("onReceive Not OK")
        }

    };
}
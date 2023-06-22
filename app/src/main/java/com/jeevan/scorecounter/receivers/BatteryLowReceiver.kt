package com.jeevan.scorecounter.receivers

import android.content.BroadcastReceiver
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log

class BatteryLowReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "onReceive: Battery Low")
    }
}
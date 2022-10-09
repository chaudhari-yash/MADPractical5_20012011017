package com.example.madpractical5_20012011017

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.media.MediaPlayer


class MyService : Service() {

    private lateinit var media:MediaPlayer
    companion object {
        public final val DATA_KEY = "service"
        public final val DATA_VALUE = "play/pause"
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //Log.i("ONSTART", "onStartCommand: ")
        if (!this::media.isInitialized) {
            media = MediaPlayer.create(this, R.raw.song)
            //Log.i("MEDIA:", "MEDIA INITIALIZED")
        }
        if (intent != null) {
            val str = intent.getStringExtra(DATA_KEY)
            if(str == DATA_VALUE){
                if (!media.isPlaying){
                    media.start()
                }
                else {
                    media.pause()
                }
            }
        }
        else {
            media.start()
        }

        return START_STICKY
    }

    override fun onDestroy() {
        media.stop()
        super.onDestroy()
    }
}
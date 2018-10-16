package com.example.nikit.videocache

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.danikula.videocache.HttpProxyCacheServer
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(Video)
        Video.setMediaController(mediaController)

        val proxy = getProxy()
        val proxyUrl = proxy.getProxyUrl(getString(R.string.Video_Url))
        Video.setVideoPath(proxyUrl)
        Video.start()

    }

    private fun getProxy(): HttpProxyCacheServer {
        // should return single instance of HttpProxyCacheServer shared for whole app.
        return App.getProxy(this)
    }
}

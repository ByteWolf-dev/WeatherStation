package com.example.weatherstation_tadeot.client

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okio.ByteString

class WebSocketClient(private val url: String) {

    private var webSocket: WebSocket? = null
    private val client = OkHttpClient()

    fun start() {
        val request = Request.Builder().url(url).build()
        webSocket = client.newWebSocket(request, WebSocketListener())
    }

    fun stop() {
        webSocket?.close(1000, "Goodbye!")
    }

    private inner class WebSocketListener : okhttp3.WebSocketListener() {
        override fun onOpen(webSocket: WebSocket, response: Response) {
            // Handle WebSocket connection opened
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            // Handle text message received
        }

        override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
            // Handle binary message received
        }

        override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
            webSocket.close(1000, null)
            // Handle WebSocket connection closing
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            // Handle WebSocket connection failure
        }
    }
}
package com.example.store.controlcenter

import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

fun chat(chatContent:String, callback:(String)->Unit){

    var answer = ""

    val apiKey = "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"

    val url = "https://api.openai.com/v1/engines/text-davinci-003/completions"
    val client = OkHttpClient()

    val json = JSONObject()
    json.put("prompt", chatContent)
    json.put("max_tokens", 50)

    val requestBody = json.toString().toRequestBody("application/json".toMediaType())

    val request = Request.Builder()
        .url(url)
        .addHeader("Authorization", "Bearer $apiKey")
        .post(requestBody)
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            e.printStackTrace()
        }

        override fun onResponse(call: Call, response: Response) {
            val responseBody = response.body?.string()
            println(responseBody)
            answer = extractAnswer(responseBody)
            println("Answer: $answer")
            callback(answer)
        }
    })


}

private fun extractAnswer(responseBody: String?): String {
    val jsonObject = JSONObject(responseBody)
    val choicesArray = jsonObject.getJSONArray("choices")
    return choicesArray.getJSONObject(0).getString("text")
}
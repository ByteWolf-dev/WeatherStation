package com.example.weatherstation_tadeot.model

import com.google.gson.GsonBuilder
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://192.168.137.1:8080"

//    private val moshi = Moshi.Builder()
//        .add(LocalDateTimeAdapter())
//        .add(KotlinJsonAdapterFactory())
//        .build()

//    val instance: ApiService by lazy {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .build()
//
//        retrofit.create(ApiService::class.java)
//    }

    private val gson = GsonBuilder()
        .setLenient()
        .create()

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        retrofit.create(ApiService::class.java)
    }

}

class LocalDateTimeAdapter {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @FromJson
    fun fromJson(reader: JsonReader): LocalDateTime? {
        return if (reader.peek() != JsonReader.Token.NULL) {
            LocalDateTime.parse(reader.nextString(), formatter)
        } else {
            reader.nextNull<LocalDateTime>()
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: LocalDateTime?) {
        if (value != null) {
            writer.value(value.format(formatter))
        } else {
            writer.nullValue()
        }
    }
}
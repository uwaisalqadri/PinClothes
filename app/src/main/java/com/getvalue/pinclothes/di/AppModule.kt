package com.getvalue.pinclothes.di

import com.getvalue.pinclothes.data.souce.remote.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
	// viewModel etc.
}

val repositoryModule = module {
	// repos etc.
}

val networkModule = module {
	single {
		Retrofit.Builder()
			.baseUrl("Constants.BASE_URL")
			.addConverterFactory(GsonConverterFactory.create())
			.client(get())
			.build()
			.create(ApiService::class.java)
	}

	single {
		OkHttpClient.Builder()
			.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
			.build()
	}
}

package com.getvalue.pinclothes

import android.app.Application
import com.getvalue.pinclothes.di.appModule
import com.getvalue.pinclothes.di.networkModule
import com.getvalue.pinclothes.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

//class BaseApplication: Application() {
//
//	override fun onCreate() {
//		super.onCreate()
//		Timber.plant(Timber.DebugTree())
//		startKoin {
//			androidLogger()
//			androidContext(this@BaseApplication)
//			modules(
//				appModule,
//				repositoryModule,
//				networkModule
//			)
//		}
//	}
//}
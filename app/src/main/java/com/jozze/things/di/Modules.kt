package com.jozze.things.di

import com.jozze.core.networking.ApiService
import com.jozze.things.data.repository.ThingsRepositoryImpl
import com.jozze.things.domain.repository.ThingsRepository
import org.koin.dsl.module

val appModule = module {

    single {
        ApiService.getClient()
    }

    single<ThingsRepository> {
        ThingsRepositoryImpl(get())
    }

}
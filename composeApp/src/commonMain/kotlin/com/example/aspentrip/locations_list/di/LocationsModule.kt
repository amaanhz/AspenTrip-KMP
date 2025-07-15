package com.example.aspentrip.locations_list.di

import com.example.aspentrip.locations_list.data.service.LocationsRepositoryImpl
import com.example.aspentrip.locations_list.domain.LocationsRepository
import com.example.aspentrip.locations_list.presentation.LocationsListViewModel
import org.koin.dsl.module

val locationsModule = module {
    single<LocationsRepository> { LocationsRepositoryImpl() }
    factory { LocationsListViewModel(get()) }
}
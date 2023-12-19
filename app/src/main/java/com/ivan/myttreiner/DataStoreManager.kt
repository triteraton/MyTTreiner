package com.ivan.myttreiner

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStoreManager(context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "User")
    private val dataStore = context.dataStore

    companion object {
        val weightKey = intPreferencesKey(name = "weight")
        val heightKey = intPreferencesKey(name = "height")
        val waistKey = intPreferencesKey(name = "waist")
        val hipKey = intPreferencesKey(name = "hip")
        val ageKey = intPreferencesKey(name = "age")
        val sexKey = intPreferencesKey(name = "sex")
    }

    suspend fun setWeight(newWeight: Int) {
        dataStore.edit { pref ->
            pref[weightKey] = newWeight
        }
    }

    fun getWeight(): Flow<Int> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { pref ->
                val weightN = pref[weightKey] ?: 0
                weightN
            }
    }

    suspend fun setHeight(newHeight: Int) {
        dataStore.edit { pref ->
            pref[heightKey] = newHeight
        }
    }

    fun getHeight(): Flow<Int> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { pref ->
                val heightN = pref[heightKey] ?: 0
                heightN
            }
    }

    suspend fun setWaist(newWaist: Int) {
        dataStore.edit { pref ->
            pref[waistKey] = newWaist
        }
    }

    fun getWaist(): Flow<Int> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { pref ->
                val waistN = pref[waistKey] ?: 0
                waistN
            }
    }

    suspend fun setHip(newHip: Int) {
        dataStore.edit { pref ->
            pref[hipKey] = newHip
        }
    }

    fun getHip(): Flow<Int> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { pref ->
                val hipN = pref[hipKey] ?: 0
                hipN
            }
    }

    suspend fun setAge(newAge: Int) {
        dataStore.edit { pref ->
            pref[ageKey] = newAge
        }
    }

    fun getAge(): Flow<Int> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { pref ->
                val ageN = pref[ageKey] ?: 0
                ageN
            }
    }

    suspend fun setSex(newSex: Int) {
        dataStore.edit { pref ->
            pref[sexKey] = newSex
        }
    }

    fun getSex(): Flow<Int> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { pref ->
                val sexN = pref[sexKey] ?: 0
                sexN
            }
    }
}
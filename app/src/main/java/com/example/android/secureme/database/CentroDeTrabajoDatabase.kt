package com.example.android.secureme.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CentroDeTrabajo::class], version = 1, exportSchema = false)
abstract class CentroDeTrabajoDatabase : RoomDatabase() {

    abstract val centroDeTrabajoDatabaseDao: CentroDeTrabajoDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: CentroDeTrabajoDatabase? = null

        fun getInstance(context: Context): CentroDeTrabajoDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CentroDeTrabajoDatabase::class.java,
                        "centro_de_trabajo_database"
                    )
                        .createFromAsset("database/guanajuato.db")
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
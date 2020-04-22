package com.example.app4

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.app4.automobiles.Automobile
import com.example.app4.producers.Producer
import com.example.app4.sales.Sale
import com.google.gson.Gson

class DatabaseHandler(context: Context):
    SQLiteOpenHelper(
        context,
        DATABASE_NAME,
        null,
        DATABASE_VERSION
    ),
    IDatabaseHandler {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "App4"
        private const val TABLE_AUTOMOBILES = "automobiles"
        private const val TABLE_PRODUCERS = "producers"
        private const val TABLE_SALES = "sales"
        private const val KEY_ID = "id"
        private const val KEY_DATA = "data"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createAutomobilesTable = "CREATE TABLE " + TABLE_AUTOMOBILES + "(" +
                KEY_ID + " INTEGER PRIMARY KEY," + KEY_DATA + " TEXT" + ")"
        val createProducersTable = "CREATE TABLE " + TABLE_PRODUCERS + "(" +
                KEY_ID + " INTEGER PRIMARY KEY," + KEY_DATA + " TEXT" + ")"
        val createSalesTable = "CREATE TABLE " + TABLE_SALES + "(" +
                KEY_ID + " INTEGER PRIMARY KEY," + KEY_DATA + " TEXT" + ")"
        db.execSQL(createAutomobilesTable)
        db.execSQL(createProducersTable)
        db.execSQL(createSalesTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AUTOMOBILES)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCERS)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SALES)
        onCreate(db)
    }

    override fun addAutomobile(automobile: Automobile) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_DATA, Gson().toJson(automobile))
        db.insert(TABLE_AUTOMOBILES, null, values)
    }

    override fun addProducer(producer: Producer) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_DATA, Gson().toJson(producer))
        db.insert(TABLE_PRODUCERS, null, values)
    }

    override fun addSale(sale: Sale) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_DATA, Gson().toJson(sale))
        db.insert(TABLE_SALES, null, values)
    }

    override fun editAutomobile(automobile: Automobile) {
        var automobiles = getAllAutomobiles()
        var oldAuto: Automobile? = null
        automobiles.forEach {
            if (it.id == automobile.id) {
                oldAuto = it
            }
        }
        if (oldAuto != null) {
            automobiles.remove(oldAuto as Automobile)
        }
        automobiles.add(automobile)
        val clearQuery = "DELETE FROM " + TABLE_AUTOMOBILES
        val db = this.writableDatabase
        db.execSQL(clearQuery)
        automobiles.forEach {
            addAutomobile(it)
        }
    }

    fun clearTables() {
        val clearAutomobiles = "DELETE FROM " + TABLE_AUTOMOBILES
        val clearProducers = "DELETE FROM " + TABLE_PRODUCERS
        val clearSales = "DELETE FROM " + TABLE_SALES

        val db = this.writableDatabase
        db.execSQL(clearAutomobiles)
        db.execSQL(clearProducers)
        db.execSQL(clearSales)
    }

    override fun editProducer(producer: Producer) {
        var producers = getAllProducers()
        var oldProducer: Producer? = null
        producers.forEach {
            if (it.id == producer.id) {
                oldProducer = it
            }
        }
        if (oldProducer != null) {
            producers.remove(oldProducer as Producer)
        }
        producers.add(producer)
        val clearQuery = "DELETE FROM " + TABLE_PRODUCERS
        val db = this.writableDatabase
        db.execSQL(clearQuery)
        producers.forEach {
            addProducer(it)
        }
    }

    override fun editSale(sale: Sale) {
        var sales = getAllSales()
        var oldSale: Sale? = null
        sales.forEach {
            if (it.id == sale.id) {
                oldSale = it
            }
        }
        if (oldSale != null) {
            sales.remove(oldSale as Sale)
        }
        sales.add(sale)
        val clearQuery = "DELETE FROM " + TABLE_SALES
        val db = this.writableDatabase
        db.execSQL(clearQuery)
        sales.forEach {
            addSale(it)
        }
    }

    override fun removeAutomobile(automobile: Automobile) {
        var automobiles = getAllAutomobiles()
        var oldAutomobile: Automobile? = null
        automobiles.forEach {
            if (it.id == automobile.id) {
                oldAutomobile = it
            }
        }
        automobiles.remove(oldAutomobile)
        val clearQuery = "DELETE FROM " + TABLE_AUTOMOBILES
        val db = this.writableDatabase
        db.execSQL(clearQuery)
        automobiles.forEach {
            addAutomobile(it)
        }
    }

    override fun removeProducer(producer: Producer) {
        var producers = getAllProducers()
        var oldProducer: Producer? = null
        producers.forEach {
            if (it.id == producer.id) {
                oldProducer = it
            }
        }
        producers.remove(oldProducer)
        val clearQuery = "DELETE FROM " + TABLE_PRODUCERS
        val db = this.writableDatabase
        db.execSQL(clearQuery)
        producers.forEach {
            addProducer(it)
        }
    }

    override fun removeSale(sale: Sale) {
        var sales = getAllSales()
        var oldSale: Sale? = null
        sales.forEach {
            if (it.id == sale.id) {
                oldSale = it
            }
        }
        sales.remove(oldSale)
        val clearQuery = "DELETE FROM " + TABLE_SALES
        val db = this.writableDatabase
        db.execSQL(clearQuery)
        sales.forEach {
            addSale(it)
        }
    }

    override fun getAllAutomobiles(): ArrayList<Automobile> {
        val automobilesList = arrayListOf<Automobile>()
        val selectQuery = "SELECT * FROM " + TABLE_AUTOMOBILES
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val automobile = Gson().fromJson(
                    cursor.getString(1),
                    Automobile::class.java
                )
                automobilesList.add(automobile)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return automobilesList
    }

    override fun getAllProducers(): ArrayList<Producer> {
        val producersList = arrayListOf<Producer>()
        val selectQuery = "SELECT * FROM " + TABLE_PRODUCERS
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val producer = Gson().fromJson(
                    cursor.getString(1),
                    Producer::class.java
                )
                producersList.add(producer)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return producersList
    }

    override fun getAllSales(): ArrayList<Sale> {
        val salesList = arrayListOf<Sale>()
        val selectQuery = "SELECT * FROM " + TABLE_SALES
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val sale = Gson().fromJson(
                    cursor.getString(1),
                    Sale::class.java
                )
                salesList.add(sale)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return salesList
    }

}
package com.example.app4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app4.automobiles.Automobile
import com.example.app4.automobiles.AutomobilesActivity
import com.example.app4.producers.Producer
import com.example.app4.producers.ProducersActivity
import com.example.app4.sales.Sale
import com.example.app4.sales.SalesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        automobiles_button.setOnClickListener {
            val intent = Intent(this, AutomobilesActivity::class.java)
            startActivity(intent)
        }

        producers_button.setOnClickListener {
            val intent = Intent(this, ProducersActivity::class.java)
            startActivity(intent)
        }

        sales_button.setOnClickListener {
            val intent = Intent(this, SalesActivity::class.java)
            startActivity(intent)
        }

        val db = DatabaseHandler(this)

        db.clearTables()
        db.addAutomobile(
            Automobile(
                "1",
                "Mazda",
                "2",
                200,
                1999
            )
        )
        db.addAutomobile(
            Automobile("2", "Lexus", "2", 40, 1999)
        )
        db.addAutomobile(
            Automobile("3", "MBW", "2", 500, 1999)
        )

        db.addProducer(
            Producer(
                "2",
                "Layon",
                "Streen",
                "234",
                "aaa@a.aa"
            )
        )
        db.addProducer(
            Producer(
                "3",
                "Layon2",
                "Streen",
                "234",
                "aaa@a.aa"
            )
        )
        db.addProducer(
            Producer(
                "1",
                "Layon3",
                "Streen",
                "234",
                "aaa@a.aa"
            )
        )

        db.addSale(
            Sale(
                "2",
                "4",
                5,
                10,
                "20.10.20"
            )
        )
        db.addSale(
            Sale(
                "3",
                "4",
                5,
                10,
                "20.10.20"
            )
        )

        db.addSale(
            Sale(
                "1",
                "4",
                5,
                10,
                "20.10.20"
            )
        )

        db.close()


        submit_search.setOnClickListener {
            search_result.text = "Results:"
            val items = arrayListOf<String>()
            val db2 = DatabaseHandler(this)
            val automobiles = db2.getAllAutomobiles()
            val producers = db2.getAllProducers()
            automobiles.forEach {
                if (it.name.contains(search_edittext.text.toString())) {
                    search_result.text = search_result.text.toString() + "\n" + it.name + " (auto)"
                }
            }
            producers.forEach {
                if (it.name.contains(search_edittext.text.toString())) {
                    search_result.text = search_result.text.toString() + "\n" + it.name + " (producer)"
                }
            }
            db2.close()
        }


        request_auto_by_producer.setOnClickListener {
            val intent = Intent(it.context, RequestActivity::class.java)
            intent.putExtra("request_name", "request auto by producer")
            startActivity(intent)
        }
        request_auto_price_less.setOnClickListener {
            val intent = Intent(it.context, RequestActivity::class.java)
            intent.putExtra("request_name", "request auto with price less")
            startActivity(intent)
        }
        request_auto_in_year.setOnClickListener {
            val intent = Intent(it.context, RequestActivity::class.java)
            intent.putExtra("request_name", "request auto sold in year")
            startActivity(intent)
        }
        request_producers_with_auto_more.setOnClickListener {
            val intent = Intent(it.context, RequestActivity::class.java)
            intent.putExtra("request_name", "request producers with auto more")
            startActivity(intent)
        }
        request_auto_unsold.setOnClickListener {
            val intent = Intent(it.context, RequestActivity::class.java)
            intent.putExtra("request_name", "request unsold auto")
            startActivity(intent)
        }
    }
}

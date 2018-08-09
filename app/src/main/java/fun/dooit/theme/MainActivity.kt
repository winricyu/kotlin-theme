package `fun`.dooit.theme

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var mBtnGo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBtnGo = findViewById(R.id.btn_go)
        mBtnGo.setOnClickListener { startActivity(Intent(this, TripListActivity::class.java)) }
    }
}

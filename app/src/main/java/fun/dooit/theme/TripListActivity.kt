package `fun`.dooit.theme

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TripListActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    private lateinit var mRecycler: RecyclerView
    private lateinit var mBottomNavigationView: BottomNavigationView
    lateinit var mTripList: MutableList<TripModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_list)
        mTripList= arrayListOf()
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("Day Tour from Tokyo: Nikko Toshogu Shrine & Kegon Falls", 7, 1))
        mTripList.add(TripModel("Day Tour from Tokyo: Lake Kawaguchi, Oshino Hakkai, Ice Cave & Wind Cave", 12, 5))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("Day Tour from Tokyo: Lake Kawaguchi, Oshino Hakkai, Ice Cave & Wind Cave", 0, 0))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("Day Tour from Tokyo: Lake Kawaguchi, Oshino Hakkai, Ice Cave & Wind Cave", 12, 5))
        mTripList.add(TripModel("Day Tour from Tokyo: Lake Kawaguchi, Oshino Hakkai, Ice Cave & Wind Cave", 0, 0))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))
        mTripList.add(TripModel("【動漫巴士專車一日遊】藤子・F・不二雄博物館・鬼太郎茶屋・狹山公園・多摩湖", 5, 29))

        mBottomNavigationView = findViewById(R.id.nav_bottom)
        mBottomNavigationView.setOnNavigationItemSelectedListener(this)
        mRecycler = findViewById(R.id.recyclerview)

        val tripAdapter = TripAdapter(this, mTripList)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecycler.layoutManager = layoutManager
        mRecycler.adapter = tripAdapter

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        println("item = [${item.title}]")
        return true
    }

    data class TripModel(val name: String, val month: Int, val day: Int)


    class TripAdapter(context: Context, list: MutableList<TripModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        var mList: MutableList<TripModel> = list
        var mContext = context

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(mContext).inflate(R.layout.item_plan, parent, false)
            return TripVH(view)
        }

        override fun getItemCount(): Int {
            return mList.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val vh = holder as TripVH
            val model = mList.get(position)
            vh.txtName?.text = model.name
        }

        class TripVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            val txtName = itemView?.findViewById<TextView>(R.id.txt_name)
        }
    }
}

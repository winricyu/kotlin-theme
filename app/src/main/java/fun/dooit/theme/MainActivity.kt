package `fun`.dooit.theme

import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.telephony.PhoneNumberUtils
import android.widget.Button
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {

    private lateinit var mBtnGo: Button

    override fun attachBaseContext(newBase: Context?) {
        println("MainActivity.attachBaseContext")
//        newBase!!.setTheme(R.style.AppRedTheme)
        super.attachBaseContext(newBase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("MainActivity.onCreate")
//        setTheme(R.style.AppRedTheme)
        theme.applyStyle(R.style.AppRedTheme, true)

        setContentView(R.layout.activity_main)
//        mBtnGo.setTextColor(theme.resources.getColor())
        mBtnGo = findViewById(R.id.btn_go)
        mBtnGo.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                resources.newTheme().applyStyle(R.style.AppRedTheme, true)
//                recreate()
                println(printName("Eric"))

                val nameSize = printName("YJJ")
                println(nameSize)

                println(matchName("YJJ", "Eric", "Jason", "Ariel"))

            }
//            startActivity(Intent(this, TripListActivity::class.java))
        }

        //lambdas
        val dialNumber = { phone: String ->
            println("phone = ${phone}")
            PhoneNumberUtils.isGlobalPhoneNumber(phone)
        }

        val counter = { x: Int, y: Int -> x + y }
        println("counter:${counter(5, 6)}")
        println("dialNumber:${dialNumber("09783334555")}")

        val list = (1..100).toList()
        println(list.filter { item -> item % 2 == 0 })
        println(list.filter { it % 3 == 0 })
        println(list.filter { it.test() })
        //println(list.filter({ x: Int -> x % 10 == 0 }))
        println(list.filter(::isTest))

//        TODO("map,flatMap")
        var doubled = list.map { element -> element * 2 }
        doubled = doubled.map { it * 2 }
        val average = doubled.average()
        val nestList = listOf((1..5).toList(), (50..60).toList(), (11..20).toList())
        val sorted = nestList.map { it.sortedDescending() }
        val flatmap = nestList.flatMap { it.sortedDescending() }


//        TODO("sort by sth.")
        val userList = listOf(
                UserModel("Eric", 42),
                UserModel("YJJ", 12),
                UserModel("Eric", 26),
                UserModel("Alex", 39),
                UserModel("Eriz", 77)
        )
        val filterName = fun(name: String): Boolean {
            return name.contains("eri", true)
        }
        val userSorted = userList.sortedBy { it.name }
//        val userFilter=userList.filter{it.name.contains("eri",true)}
        val userFilter = userList.filter { filterName(it.name) }

        val compName = Comparator { x: UserModel, y: UserModel -> x.name.compareTo(y.name) }
        val compAge = Comparator { x: UserModel, y: UserModel -> x.age.compareTo(y.age) }

//        val userMultiSort = userList.sortedByDescending{it.name}
//        val userMultiSort = userList.toSortedSet(sdfasfs)

        val xxx = userList.filterIndexed { index, userModel -> userModel.age == 39 }


        println("xxx:${xxx.toString()}")
        println("userList:${userList.toString()}")
        println("userSorted:${userSorted.toString()}")
        println("userFilter:${userFilter.toString()}")
//        println("userMultiSort:${userMultiSort.toString()}")

        println("doubled:${doubled}")
        println("average:${average}")


//        TODO("take")
        val first10 = list.take(10)
        val drop10 = list.drop(50)
        val dropLast10 = list.dropLast(10)


        println("first10:${first10.toString()}")
        println("drop10:${drop10.toString()}")
        println("dropLast10:${dropLast10.toString()}")

//        TODO("generateSequence")
        val seqList = generateSequence(5, { it + 3 })
        val seqFirst10 = seqList.take(10)
        println("seqList:${seqList}")
        println("seqFirst10:${seqFirst10}")
        println("seqFirst10:${seqFirst10.toList()}")

//        TODO("zip")
        val names = listOf("Eric", "JJ", "Jason")
        val ages = listOf(34, 5, 22)
        val zippedList = names.zip(ages)
        val zipWithCompare = names.zip(names.map { it.contains("j", true) })
        println("zippedList:{${zippedList}}")
        println("zippedList:{${zippedList.get(1)}}")
        println("zipWithCompare:{${zipWithCompare.first().first}}")
        println("zipWithCompare:{${zipWithCompare.first().second}}")


        // Some faulty data with ages of our users
        val data = mapOf(
                "users1.csv" to listOf(32, 45, 17, -1, 34),
                "users2.csv" to listOf(19, -1, -67, 22),
                "users3.csv" to listOf(),
                "users4.csv" to listOf(56, 32, 18, 44)
        )


        val validUsers =  data.flatMap{it.value}.filter { it>0 }
        val userAverage=validUsers.average()
        val invalidFiles=data.filter {  it.value.any{it<=0} }.keys
       val invalidValues=data.flatMap { it.value }.filter { it<0 }.size
        println("validUsers:${validUsers}")
        println("userAverage:${userAverage}")
        println("invalidFiles:${invalidFiles}")
        println("invalidValues:${invalidValues}")


    }

    /*private fun Int.test(): Boolean {
        return this % 5 == 0
    }*/

    private fun Int.test() = this % 5 == 0
    private fun isTest(i: Int) = i % 6 == 0


    fun somuchNamesAny(vararg names: String): Boolean {
        return names.any { name -> name.length < 4 }
    }

    fun somuchNamesAll(vararg names: String): Boolean {
        return names.all { name -> name.length <= 4 }
    }

    fun matchName(vararg names: String): Boolean {
        return names.contains("dsijfos")
    }


    fun printName(name: String): String = name + "_${name.length}"

    data class UserModel(val name: String, val age: Int)
}


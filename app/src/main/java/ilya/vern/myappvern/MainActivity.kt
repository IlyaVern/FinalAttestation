package ilya.vern.myappvern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var greetingButton: Button
    lateinit var bottomNavigationMenu: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        greetingButton = findViewById(R.id.greeting_button)
        bottomNavigationMenu = findViewById(R.id.bottom_navigation)

        bottomNavigationMenu.setOnNavigationItemSelectedListener { item->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.greeting -> {
                    fragment = GreetingFragment()
                }
                R.id.about -> {
                    fragment = HelloFragment()
                }
            }
            replaceFragment(fragment!!)

            true
        }

        val greetingFragment = GreetingFragment()
        val helloFragment = HelloFragment()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.greeting_container,greetingFragment)
            .commit()

        greetingButton.setOnClickListener{
            val fragment =
                when (supportFragmentManager.findFragmentById(R.id.greeting_container)) {
                    is GreetingFragment -> helloFragment
                    is HelloFragment -> greetingFragment
                    else -> greetingFragment

                }

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.greeting_container,fragment)
                .commit()
        }




    }
    fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.greeting_container,fragment)
            .commit()

    }
}
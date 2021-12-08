package ilya.vern.myappvern

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "item"

class MainActivity : AppCompatActivity() {

    lateinit var greetingButton: Button
    lateinit var bottomNavigationMenu: BottomNavigationView
    lateinit var intentButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        greetingButton = findViewById(R.id.greeting_button)
        bottomNavigationMenu = findViewById(R.id.bottom_navigation)
        intentButton = findViewById(R.id.intent_button)

        intentButton.setOnClickListener{
            val link = Uri.parse("https://www.tyumen-city.ru/")
            val intent = Intent(Intent.ACTION_VIEW,link)
            startActivity(intent)
        }

        bottomNavigationMenu.setOnNavigationItemSelectedListener { item->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.greeting -> {
                    fragment = GreetingFragment()
                }
                R.id.about -> {
                    fragment = DevelopersFragment()
                }
            }
            replaceFragment(fragment!!)

            true
        }

        bottomNavigationMenu.selectedItemId =
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.greeting



        val developersFragment = DevelopersFragment()

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM,bottomNavigationMenu.selectedItemId)

        val currentFragment = supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(
            outState,currentFragment.javaClass.name,currentFragment)
    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.greeting_container,fragment)
            .commit()

    }
}
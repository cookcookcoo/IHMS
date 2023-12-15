package com.example.store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_main)

        //底部导航栏
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_devices -> {
                    switchFragment(Devices())
                    true
                }
                R.id.navigation_scenario -> {
                    switchFragment(Scenario())
                    true
                }
                R.id.navigation_mine -> {
                    switchFragment(Mine())
                    true
                }
                else -> false
            }
        }

        // 默认显示Home Fragment
                switchFragment(Devices())

        // 检查是否有额外的信息
        val fragmentToLoad = intent.getStringExtra("fragmentToLoad")
        if (fragmentToLoad == "sceneFragment") {
            // 加载 Scene Fragment
            switchFragment(Scenario())
        }
    }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}



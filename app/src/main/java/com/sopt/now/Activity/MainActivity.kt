package com.sopt.now.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sopt.now.Fragment.HomeFragment
import com.sopt.now.Fragment.MyPageFragment
import com.sopt.now.Fragment.SearchFragment
import com.sopt.now.R
import com.sopt.now.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var id: String? = null
    private var password: String? = null
    private var nickname: String? = null
    private var mbti: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        id = intent.getStringExtra("id") ?: ""
        password = intent.getStringExtra("password") ?: ""
        nickname = intent.getStringExtra("nickname") ?: ""
        mbti = intent.getStringExtra("mbti") ?: ""

        val currentFragment = supportFragmentManager.findFragmentById(binding.fcvHome.id)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(binding.fcvHome.id, HomeFragment())
                .commit()
        }
        clickBottomNavigation()
    }

    private fun clickBottomNavigation() {
        binding.bnvHome.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> replaceFragment(HomeFragment())
                R.id.menu_search -> replaceFragment(SearchFragment())
                R.id.menu_my_page -> navigateToMyPage()
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fcvHome.id, fragment)
            .commit()
    }

    private fun navigateToMyPage() {
        val myPageBundle = Bundle().apply {
            putString("id", id)
            putString("password", password)
            putString("nickname", nickname)
            putString("mbti", mbti)
        }
        val myPageFragment = MyPageFragment().apply {
            arguments = myPageBundle
        }
        replaceFragment(myPageFragment)
    }


}
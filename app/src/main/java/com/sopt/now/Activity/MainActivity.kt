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
    private var phonenumber: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        extractIntentData()
        setupBottomNavigation()
        addFragment(HomeFragment())
    }

    private fun extractIntentData() {
        intent.run {
            id = getStringExtra("id") ?: ""
            password = getStringExtra("password") ?: ""
            nickname = getStringExtra("nickname") ?: ""
            phonenumber = getStringExtra("phoneNumber") ?: ""
        }
    }

    private fun setupBottomNavigation() {
        binding.bnvHome.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> replaceFragment(HomeFragment())
                R.id.menu_search -> replaceFragment(SearchFragment())
                R.id.menu_my_page -> navigateToMyPage()
            }
            true
        }
    }

    private fun addFragment(fragment: Fragment) {
        if (supportFragmentManager.findFragmentById(binding.fcvHome.id) == null) {
            supportFragmentManager.beginTransaction()
                .add(binding.fcvHome.id, fragment)
                .commit()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fcvHome.id, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun navigateToMyPage() {
        val myPageBundle = createMyPageBundle()
        val myPageFragment = MyPageFragment().apply {
            arguments = myPageBundle
        }
        replaceFragment(myPageFragment)
    }

    private fun createMyPageBundle(): Bundle {
        return Bundle().apply {
            putString("id", id)
            putString("password", password)
            putString("nickname", nickname)
            putString("phoneNumber", phonenumber)
        }
    }
}

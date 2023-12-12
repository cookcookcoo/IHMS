package com.example.store

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)

        btnLogin.setOnClickListener { onLoginClick() }
        btnRegister.setOnClickListener { onRegisterClick() }
    }

    private fun onLoginClick() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()

        if (isValidCredentials(username, password)) {
            // 如果用户名和密码符合条件，跳转到MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // 结束当前登录活动
        } else {
            Toast.makeText(this, "无效的用户名或密码", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onRegisterClick() {
        // 处理注册逻辑
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        // 在实际应用中，你可能需要更复杂的条件来验证用户名和密码
        return username.isNotEmpty() && password.isNotEmpty()
    }
}

package vn.edu.vlsc.kiemtra_2500115657

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ bằng findViewById truyền thống (không dùng ViewBinding)
        val tvProfileTitle: TextView = findViewById(R.id.tvProfileTitle)
        val tvProfileEmail: TextView = findViewById(R.id.tvProfileEmail)
        val btnLogout: Button = findViewById(R.id.btnLogout)

        // Nhận dữ liệu Email từ Intent được truyền sang từ LoginActivity
        val email = intent.getStringExtra("USER_EMAIL") ?: ""
        tvProfileEmail.text = "Email: $email"

        // Xử lý nút Đăng xuất đóng Activity hiện tại bằng finish() để quay về LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }
    }
}

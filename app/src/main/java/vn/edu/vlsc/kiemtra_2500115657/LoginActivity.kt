package vn.edu.vlsc.kiemtra_2500115657

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ánh xạ các thành phần giao diện bằng findViewById truyền thống (không dùng ViewBinding)
        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val edtEmail: EditText = findViewById(R.id.edtEmail)
        val edtPassword: EditText = findViewById(R.id.edtPassword)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val tvStatus: TextView = findViewById(R.id.tvStatus)

        // Xử lý sự kiện nút Đăng nhập
        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            // Kiểm tra bỏ trống Email hoặc Mật khẩu
            if (email.isEmpty() && password.isEmpty()) {
                tvStatus.text = "Vui lòng nhập Email và Mật khẩu"
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                tvStatus.text = "Vui lòng nhập Email"
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                tvStatus.text = "Vui lòng nhập Mật khẩu"
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            // Kiểm tra định dạng Email
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvStatus.text = "Email không đúng định dạng"
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            // Kiểm tra độ dài Mật khẩu >= 6 ký tự
            if (password.length < 6) {
                tvStatus.text = "Mật khẩu phải từ 6 ký tự trở lên"
                tvStatus.setTextColor(Color.RED)
                return@setOnClickListener
            }

            // Dữ liệu hợp lệ
            tvStatus.text = "Đăng nhập hợp lệ"
            tvStatus.setTextColor(Color.parseColor("#2E7D32"))
        }
    }
}

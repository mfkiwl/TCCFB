package `in`.csias.tcclient.otp

import `in`.csias.tcclient.MainActivity
import `in`.csias.tcclient.R
import `in`.csias.tcclient.databinding.ActivityNumberBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class NumberActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNumberBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.button.setOnClickListener {
            if (binding.phoneNumber.text!!.isEmpty()) {
                Toast.makeText(this, "Please enter your number", Toast.LENGTH_SHORT).show()
            } else {
                var intent = Intent(this, OtpActivity::class.java)
                intent.putExtra("number", binding.phoneNumber.text!!.toString())
                startActivity(intent)
            }
        }
    }
}
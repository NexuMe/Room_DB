package bg.nbu.android_base

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val userViewModel: UsersViewModel by viewModels {
        UserViewModelFactory((application as UsersApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputName: EditText = findViewById(R.id.inputUser)
        val button: Button = findViewById(R.id.btnSave)
        
        button.setOnClickListener {
            if (TextUtils.isEmpty(inputName.text.toString())) {
                inputName.error = "Въведете име!"
            } else {
                userViewModel.insertUser(User(user = inputName.text.toString()))
                startActivity(Intent(this@MainActivity, UserListActivity::class.java))
            }
        }

    }
}
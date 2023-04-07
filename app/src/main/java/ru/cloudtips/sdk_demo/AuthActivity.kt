package ru.cloudtips.sdk_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.cloudtips.sdk.TipsManager
import ru.cloudtips.sdk_demo.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private val viewBinding: ActivityAuthBinding by viewBinding()

    private val tipsManager = TipsManager.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        with(viewBinding) {
//            codeInput.setText("11747142") // prod
            codeInput.setText("eddd7594") // predprod
            mainButton.setOnClickListener {
                validateMainClick()
            }
        }
    }

    private fun validateMainClick() = with(viewBinding) {
        val layoutId = codeInput.text?.toString()
        val sum = sumInput.text?.toString()?.toDoubleOrNull()
        tipsManager.launch(layoutId, sum)
    }
}
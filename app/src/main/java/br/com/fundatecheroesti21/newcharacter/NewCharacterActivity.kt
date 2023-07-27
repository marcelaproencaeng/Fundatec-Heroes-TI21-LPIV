package br.com.fundatecheroesti21.newcharacter


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.core.show
import br.com.fundatecheroesti21.databinding.ActivityNewCharacterBinding
import com.bumptech.glide.Glide


class NewCharacterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewCharacterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.url.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.ivCharacter.show()
                Glide
                    .with(binding.root.context)
                    .load(s.toString())
                    .centerCrop()
                    .into(binding.ivCharacter);
            }
        })
    }


}


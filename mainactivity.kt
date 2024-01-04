import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var generateButton: Button
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        generateButton = findViewById(R.id.generateButton)
        imageView = findViewById(R.id.imageView)

        generateButton.setOnClickListener {
            generateImage()
        }
    }

    private fun generateImage() {
        val text = editText.text.toString()
        val bitmap = textToImage(text)

        imageView.setImageBitmap(bitmap)
    }

    private fun textToImage(text: String): Bitmap {
        // Define bitmap properties
        val width = 500
        val height = 200
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

        // Create canvas and paint
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.color = Color.BLACK
        paint.textSize = 30f

        // Draw text on canvas
        canvas.drawText(text, 50f, 100f, paint)

        return bitmap
    }

    // Other necessary methods and UI setup can go here
}

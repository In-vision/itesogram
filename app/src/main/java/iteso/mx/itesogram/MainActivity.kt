package iteso.mx.itesogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.parse.FindCallback
import com.parse.Parse
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.ParseException
import iteso.mx.itesogram.adapters.AdapterPhoto
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.activity_main_names_rv)
        val query = ParseQuery<ParseObject>("Feed")

            query.findInBackground { list, e ->
                if (e == null) {
                    recyclerView.adapter = AdapterPhoto(list)
                    recyclerView.layoutManager = LinearLayoutManager(this)
                } else
                    error { "Error $e" }  // Log.e using anko
            }
        //save git
    }



/*    query.findInBackground(new FindCallback<ParseObject>() {
        public void done(List<ParseObject> scoreList, ParseException e) {
            if (e == null) {
                Log.d("score", "Retrieved " + scoreList.size() + " scores");
            } else {
                Log.d("score", "Error: " + e.getMessage());
            }
        }
    });*/
}

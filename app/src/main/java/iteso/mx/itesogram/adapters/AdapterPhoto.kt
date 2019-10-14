package iteso.mx.itesogram.adapters

import android.icu.text.SimpleDateFormat
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.parse.ParseFile
import com.parse.ParseObject
import iteso.mx.itesogram.R
import java.io.File

class AdapterPhoto (private val data: List<ParseObject>): RecyclerView.Adapter<PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(data[position])
    }
}

class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val usernameTitle: TextView = view.findViewById(R.id.item_title_username)
    private val numberLikesTitle: TextView = view.findViewById(R.id.item_title_number_likes)
    private val photoTitle: ImageView = view.findViewById(R.id.item_title_image_photo)
    private val username_photo: ImageView = view.findViewById(R.id.item_title_username_image)

    fun bind(igramFeed: ParseObject) {
        usernameTitle.text = igramFeed.get("username").toString()
        photoTitle.setImageURI(Uri.fromFile((igramFeed.get("photo") as ParseFile).file))
        numberLikesTitle.text = igramFeed.get("commentsNumber").toString() + " comments"
        username_photo.setImageURI(Uri.fromFile((igramFeed.get("photo") as ParseFile).file))
    }
}
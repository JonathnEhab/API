import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api.R
import com.example.api.pojo.PostsModel


class PostAdapter(private val context: Context) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
       var  postList: List<PostsModel> =ArrayList()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postId: TextView = itemView.findViewById(R.id.postId)
        val postTitle: TextView = itemView.findViewById(R.id.postTitle)
        val postBody: TextView = itemView.findViewById(R.id.postBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postBody.text=postList.get(position).body
        holder.postTitle.text=postList.get(position).title
        holder.postId.text=postList.get(position).id.toString()

        // Bind data to the views

    }

    override fun getItemCount(): Int {

        return postList.size
    }
}

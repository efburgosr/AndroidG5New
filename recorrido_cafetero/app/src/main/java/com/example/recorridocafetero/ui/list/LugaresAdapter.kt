package com.example.recorridocafetero.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.RemoteViews
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recorridocafetero.R
import com.example.recorridocafetero.model.LugarItem
import com.squareup.picasso.Picasso

class LugaresAdapter(
    private val lugaresList: ArrayList<LugarItem>,
    private val onItemClicked: (LugarItem) -> Unit
) : RecyclerView.Adapter<LugaresAdapter.LugarViewHolder>() {

    override fun onCreateViewHolder(parent:  ViewGroup, viewType: Int): LugarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item, parent, false)
        return  LugarViewHolder(view)

    }

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugar = lugaresList[position]
        holder.itemView.setOnClickListener { onItemClicked(lugaresList[position]) }
        holder.bind(lugar)

    }

    override fun getItemCount(): Int = lugaresList.size

    fun appendItems(newItems:ArrayList<LugarItem>) {
        lugaresList.clear()
        lugaresList.addAll(newItems)
        notifyDataSetChanged()

    }


    class LugarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var descriptionTextView : TextView = itemView.findViewById(R.id.description_text_view)
        private var ratingBar: RatingBar = itemView.findViewById(R.id.score_double_view)
        private var pictureImageView: ImageView = itemView.findViewById((R.id.picture_image_view))

        fun bind(lugar: LugarItem){
            nameTextView.text = lugar.nombre
            descriptionTextView.text = lugar.description
            ratingBar.rating = lugar.calificacion.toFloat()
            Picasso.get().load(lugar.urlPicture).into(pictureImageView)

        }

    }
}
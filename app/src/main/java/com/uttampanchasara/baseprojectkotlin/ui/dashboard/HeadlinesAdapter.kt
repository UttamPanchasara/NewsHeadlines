package com.uttampanchasara.baseprojectkotlin.ui.dashboard

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.uttampanchasara.baseprojectkotlin.R
import com.uttampanchasara.baseprojectkotlin.data.repository.headlines.Headlines
import com.uttampanchasara.baseprojectkotlin.getDateInFormat


class HeadlinesAdapter(val context: Context, private val clickListener: HeadlinesClickListener) : RecyclerView.Adapter<ViewHolder>() {

    private var headlines = emptyList<Headlines>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_headlines, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val headline = headlines[position]

        viewHolder.txtTitle.text = headline.title ?: ""
        viewHolder.txtDescription.text = headline.title ?: ""
        headline.publishedAt?.let {
            viewHolder.txtPublishedDate.text = getDateInFormat(it)
        }
        viewHolder.txtSourceName.text = headline.source?.name ?: ""

        Glide.with(context)
                .load(headline.urlToImage)
                .into(viewHolder.ivPreview)

        viewHolder.itemView.setOnClickListener {
            clickListener.onHeadlinesClicked(headline)
        }
    }

    override fun getItemCount(): Int {
        return headlines.size
    }

    fun setHeadlines(headlines: List<Headlines>) {
        this.headlines = headlines
        notifyDataSetChanged()
    }

    interface HeadlinesClickListener {
        fun onHeadlinesClicked(headline: Headlines)
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
    val txtDescription: TextView = itemView.findViewById(R.id.txtDescription)
    val txtPublishedDate: TextView = itemView.findViewById(R.id.txtPublishedDate)
    val txtSourceName: TextView = itemView.findViewById(R.id.txtSourceName)
    val ivPreview: ImageView = itemView.findViewById(R.id.ivPreview)
}

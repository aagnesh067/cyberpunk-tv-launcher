package com.example.tv.launcher

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class AppItem(val name: String, val packageName: String, val icon: Drawable)

class AppGridAdapter(private val apps: List<AppItem>) :
    RecyclerView.Adapter<AppGridAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container: LinearLayout = view.findViewById(R.id.tileContainer)
        val icon: ImageView = view.findViewById(R.id.ivAppIcon)
        val name: TextView = view.findViewById(R.id.tvAppName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_app_tile, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val app = apps[position]
        holder.name.text = app.name.uppercase()
        holder.icon.setImageDrawable(app.icon)

        holder.container.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                holder.container.setBackgroundColor(Color.parseColor("#FCEE0A"))
                holder.name.setTextColor(Color.parseColor("#08080A"))
                holder.container.scaleX = 1.08f
                holder.container.scaleY = 1.08f
            } else {
                holder.container.setBackgroundColor(Color.parseColor("#111116"))
                holder.name.setTextColor(Color.parseColor("#E5E7EB"))
                holder.container.scaleX = 1.0f
                holder.container.scaleY = 1.0f
            }
        }

        holder.container.setOnClickListener {
            val launchIntent = holder.itemView.context.packageManager
                .getLaunchIntentForPackage(app.packageName)
            if (launchIntent != null) {
                holder.itemView.context.startActivity(launchIntent)
            }
        }
    }

    override fun getItemCount(): Int = apps.size
}
package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.profile_item.view.*

class ListProfiles : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_profiles)

        val recyclerView = findViewById<RecyclerView>(R.id.profileRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter()
    }

    inner class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun getItemCount(): Int {
            return 20
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            println("position $position")
            holder.bind("foo")
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)

            return ViewHolder(inflater, parent)
        }

        inner class ViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
            RecyclerView.ViewHolder(inflater.inflate(R.layout.profile_item, parent, false)) {

            private var profileNameView: TextView? = null

            init {
                profileNameView = itemView.findViewById<TextView>(R.id.profileName)
            }

            fun bind(profileName: String) {
                profileNameView?.text = profileName
            }
        }

    }
}
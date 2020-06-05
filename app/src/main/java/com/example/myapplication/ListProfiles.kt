package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Profile
import kotlinx.android.synthetic.main.profile_item.*
import kotlinx.android.synthetic.main.profile_item.view.*
import kotlinx.android.synthetic.main.profile_item.view.profileCheckbox
import java.util.stream.Collector

class ListProfiles : AppCompatActivity() {

    private var listOfFiles = listOf<String>()
    private var checkBoxes = mutableMapOf<CheckBox, Profile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_profiles)

        listOfFiles = applicationContext.fileList().toList().filter{ p -> p.startsWith("profile_") }

        val recyclerView = findViewById<RecyclerView>(R.id.profileRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter()
    }

    inner class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun getItemCount(): Int {
            return listOfFiles.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(listOfFiles[position])
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)

            return ViewHolder(inflater, parent)
        }

        inner class ViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
            RecyclerView.ViewHolder(inflater.inflate(R.layout.profile_item, parent, false)) {

            private var profileNameView: TextView? = null
            private var profileCheckBox: CheckBox? = null

            init {
                profileNameView = itemView.findViewById<TextView>(R.id.profileName)
                profileCheckBox = itemView.findViewById<CheckBox>(R.id.profileCheckbox)
            }

            fun bind(profileName: String) {
                profileNameView?.text = profileName

                if(profileCheckBox == null) return

                var profile = Profile()
                profile.firstName = profileName
                profile.lastName = profileName
                checkBoxes[profileCheckBox!!] = profile

                profileCheckBox?.setOnCheckedChangeListener { compoundButton: CompoundButton, isChecked : Boolean ->
                    checkBoxes.keys.forEach {
                        if(it != compoundButton && isChecked)
                        {
                            it.isChecked = false
                        }
                    }

                    ApplicationVariables.setProfile(checkBoxes[compoundButton])
                };
            }
        }

    }
}
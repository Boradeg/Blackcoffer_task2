package com.example.blackcoffertask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView

class BlankFragment : Fragment() {

    private lateinit var adapter: UserProfileAdapter // Assuming you have created the adapter
    private lateinit var rv:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv=view.findViewById(R.id.rv)
        // Initialize the adapter with your list of user profiles
        adapter = UserProfileAdapter(getUserProfiles()) // Assuming getUserProfiles() returns a list of UserProfile objects

        // Set layout manager and adapter to the RecyclerView
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter
    }

    // Method to get list of user profiles (replace with your implementation)
    private fun getUserProfiles(): List<UserProfile> {
        // Sample data
        return listOf(
            UserProfile("Gokul Borade", "Student", "Pune", "within 100km", 26),
            UserProfile("John Doe", "Professional", "New York", "within 50km", 70),
            UserProfile("John Doe", "Professional", "New York", "within 50km", 70),
            UserProfile("John Doe", "Professional", "New York", "within 50km", 70),
            UserProfile("John Doe", "Professional", "New York", "within 50km", 70),
            UserProfile("John Doe", "Professional", "New York", "within 50km", 70),
            UserProfile("John Doe", "Professional", "New York", "within 50km", 70),
            UserProfile("John Doe", "Professional", "New York", "within 50km", 70),
            UserProfile("John Doe", "Professional", "New York", "within 50km", 70),
            UserProfile("John Doe", "Professional", "New York", "within 50km", 70),
            UserProfile("John Doe", "Professional", "New York", "within 50km", 70),
            UserProfile("John Doe", "Professional", "New York", "within 50km", 70),
            UserProfile("John Doe", "Professional", "New York", "within 50km", 70),
            UserProfile("John Doe", "Professional", "New York", "within 50km", 70),
            UserProfile("John Doe", "Professional", "New York", "within 50km", 70),
            // Add more user profiles as needed
        )
    }

}
data class UserProfile(
    val userName: String,
    val userProfile: String,
    val userLocation: String,
    val distance: String,
    val pBar: Int
)


class UserProfileAdapter(private val userProfiles: List<UserProfile>) :
    RecyclerView.Adapter<UserProfileAdapter.UserProfileViewHolder>() {

    inner class UserProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Declare variables for TextViews
        private val profileNameTextView: TextView = itemView.findViewById(R.id.profile_name)
        private val userLocationTextView: TextView = itemView.findViewById(R.id.user_location)
        private val userDistanceTextView: TextView = itemView.findViewById(R.id.user_distance)
        private val p_bar: ProgressBar = itemView.findViewById(R.id.p_bar)
        private val p_bar_tv: TextView = itemView.findViewById(R.id.tv_prof_score)


        fun bind(userProfile: UserProfile) {
            with(itemView) {
                // Set text for TextViews
                profileNameTextView.text = userProfile.userName
                userLocationTextView.text = userProfile.userLocation
                userDistanceTextView.text = userProfile.distance
                 p_bar.progress = userProfile.pBar
                 p_bar_tv.text = "Profile Score - ${userProfile.pBar}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return UserProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserProfileViewHolder, position: Int) {
        holder.bind(userProfiles[position])
    }

    override fun getItemCount(): Int = userProfiles.size
}

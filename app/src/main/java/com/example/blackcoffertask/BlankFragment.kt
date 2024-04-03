package com.example.blackcoffertask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
            UserProfile("Gokul Borade", "Student", "Pune", "within 140km", 26, R.drawable.woman_s),
            UserProfile("John Doe", "Enginner", "Mumbai", "within 30km", 90, R.drawable.man2),
            UserProfile("Sagar Shinde", "Doctor", "Nagpur", "within 50km", 80, R.drawable.man_three),
            UserProfile("Dhanraj Doe", "Intern", "Lonawala", "within 50km", 70, R.drawable.woman_s),
            UserProfile("John Metakar", "Student", "Nashik", "within 10km", 60, R.drawable.mans),
            UserProfile("Punem Doe", "Professional", "Shirdi", "within 10km", 50, R.drawable.man_three),
            UserProfile("Rimzim Gadekar", "Student", "Pune", "within 50km", 70, R.drawable.man2),
            UserProfile("Gauri Wagh", "Intern", "Sinner", "within 30km", 70, R.drawable.mans),
            UserProfile("Nilam Wagh", "Professional", "Noida", "within 40km", 20, R.drawable.woman_s),
            UserProfile("Harshal Doe", "Student", "Mumbai", "within 50km", 30, R.drawable.man_three),
            UserProfile("Datta Borade", "Intern", "New York", "within 50km", 10, R.drawable.woman_s),
            UserProfile("John Doe", "Professional", "New York", "within 540km", 40, R.drawable.woman_s),
            UserProfile("John Doe", "Student", "New York", "within 50km", 70, R.drawable.man2),
            // Add more user profiles as needed
        )
    }


}
data class UserProfile(
    val userName: String,
    val userProfile: String,
    val userLocation: String,
    val distance: String,
    val pBar: Int,
    val imageResId: Int // Add this field for image resource ID
)



class UserProfileAdapter(private val userProfiles: List<UserProfile>) :
    RecyclerView.Adapter<UserProfileAdapter.UserProfileViewHolder>() {

    inner class UserProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Declare variables for Views including ImageView
        private val profileNameTextView: TextView = itemView.findViewById(R.id.profile_name)
        private val userLocationTextView: TextView = itemView.findViewById(R.id.user_location)
        private val userDistanceTextView: TextView = itemView.findViewById(R.id.user_distance)
        private val p_bar: ProgressBar = itemView.findViewById(R.id.p_bar)
        private val p_bar_tv: TextView = itemView.findViewById(R.id.tv_prof_score)
        private val profileImageView: ImageView = itemView.findViewById(R.id.profile_image)

        fun bind(userProfile: UserProfile) {
            with(itemView) {
                // Set text for TextViews
                profileNameTextView.text = userProfile.userName
                userLocationTextView.text = userProfile.userLocation
                userDistanceTextView.text = userProfile.distance
                p_bar.progress = userProfile.pBar
                p_bar_tv.text = "Profile Score - ${userProfile.pBar}%"

                // Set image
                profileImageView.setImageResource(userProfile.imageResId)
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

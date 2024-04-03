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

class BlankFragment3 : Fragment() {

    private lateinit var adapter: UserBuisnessAdapter // Assuming you have created the adapter
    private lateinit var rv: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view.findViewById(R.id.rv3)
        // Initialize the adapter with your list of user profiles
        adapter =
            UserBuisnessAdapter(getUserProfiles()) // Assuming getUserProfiles() returns a list of UserProfile objects

        // Set layout manager and adapter to the RecyclerView
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter
    }

    // Method to get list of user profiles (replace with your implementation)
    private fun getUserProfiles(): List<UserServices> {
        // Sample data
        return listOf(
            UserServices("Gokul Shinde", "Student", "Pune", "within 100km", 26,R.drawable.store),
            UserServices("Sagar Borade", "Engineer", "Mumbai", "within 100km", 28,R.drawable.store_three),
            UserServices("Rushi Borade", "Intern", "Benglore", "within 100km", 26,R.drawable.store_two),
            UserServices("Gokul Shinde", "Student", "Mumbai", "within 100km", 36,R.drawable.store),
            UserServices("Rushi Jadhav", "Engineer", "Pune", "within 100km", 76,R.drawable.store_three),
            UserServices("Gokul Borade", "Intern", "Mumbai", "within 100km", 56,R.drawable.store_two),
            UserServices("Sagar Jadhav", "Student", "Mumbai", "within 100km", 36,R.drawable.store),
            UserServices("Rushi Shinde", "Engineer", "Pune", "within 100km", 254,R.drawable.store_three),
            UserServices("Gokul Borade", "Intern", "Mumbai", "within 100km", 43,R.drawable.store_two),
            UserServices("Sagar Jadhav", "Engineer", "Pune", "within 100km", 56,R.drawable.store),
            UserServices("Gokul Shinde", "Student", "Mumbai", "within 100km", 26,R.drawable.store_three),
            UserServices("Rushi Borade", "Engineer", "Mumbai", "within 100km", 66,R.drawable.store_two),
            UserServices("Sagar Jadhav", "Intern", "Pune", "within 100km", 26,R.drawable.store),

            )
    }
}



class UserBuisnessAdapter(private val UserServices: List<UserServices>) :
    RecyclerView.Adapter<UserBuisnessAdapter.UserProfileViewHolder>() {

    inner class UserProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Declare variables for TextViews
        private val profileNameTextView: TextView = itemView.findViewById(R.id.profile_name)
        private val userLocationTextView: TextView = itemView.findViewById(R.id.user_location)
        private val userDistanceTextView: TextView = itemView.findViewById(R.id.user_distance)
        private val p_bar: ProgressBar = itemView.findViewById(R.id.p_bar)
        private val p_bar_tv: TextView = itemView.findViewById(R.id.tv_prof_score)
        private val profileImageView: ImageView = itemView.findViewById(R.id.profile_image)


        fun bind(userProfile: UserServices) {
            with(itemView) {
                // Set text for TextViews
                profileNameTextView.text = userProfile.userName
                userLocationTextView.text = userProfile.userLocation
                userDistanceTextView.text = userProfile.distance
                p_bar.progress = userProfile.pBar
                p_bar_tv.text = "Profile Score - ${userProfile.pBar}"
                profileImageView.setImageResource(userProfile.imageResId)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_buisness, parent, false)
        return UserProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserProfileViewHolder, position: Int) {
        holder.bind(UserServices[position])
    }

    override fun getItemCount(): Int = UserServices.size
}

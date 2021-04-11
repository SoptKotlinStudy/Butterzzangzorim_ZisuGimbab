package org.sopt.signinactivitythird

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.signinactivitythird.databinding.FragmentFollowingListBinding


class FollowingListFragment: Fragment() {
    lateinit var binding : FragmentFollowingListBinding
    lateinit var followingListAdapter: FollowingListAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowingListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        followingListAdapter = FollowingListAdapter()

        binding.userList.adapter = followingListAdapter

        followingListAdapter.userList.addAll(
                listOf<FollowingUserInfo>(
                        FollowingUserInfo(
                                userImage = "지금은 빈 칸! 4차 때 넣어봅시다.",
                                userName = "jinsu4755"
                        ),
                        FollowingUserInfo(
                                userImage = "지금은 빈 칸! 4차 때 넣어봅시다.",
                                userName = "12hyunwoo"
                        ),
                        FollowingUserInfo(
                                userImage = "지금은 빈 칸! 4차 때 넣어봅시다.",
                                userName = "SSong-develop"
                        ),
                        FollowingUserInfo(
                                userImage = "지금은 빈 칸! 4차 때 넣어봅시다.",
                                userName = "kym1924"
                        )
                )
        )
        followingListAdapter.notifyDataSetChanged()
    }
}
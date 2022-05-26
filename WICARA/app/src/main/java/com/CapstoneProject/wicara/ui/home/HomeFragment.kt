package com.CapstoneProject.wicara.ui.home

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.CapstoneProject.wicara.R
import com.CapstoneProject.wicara.databinding.FragmentHomeBinding
import com.CapstoneProject.wicara.ui.TextToTextActivity

class HomeFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        binding.cardView1.setOnClickListener(this)
        binding.cardView2.setOnClickListener(this)
        playAnimation()
        return root
    }

    private fun playAnimation(){

        val txt1 = ObjectAnimator.ofFloat(binding!!.textView14, View.ALPHA, 1f).setDuration(1000)
        val txt2 = ObjectAnimator.ofFloat(binding!!.txtUser, View.ALPHA, 1f).setDuration(1000)
        val cd1 = ObjectAnimator.ofFloat(binding!!.cardView1, View.ALPHA, 1f).setDuration(500)
        val cd2 = ObjectAnimator.ofFloat(binding!!.cardView2, View.ALPHA, 1f).setDuration(500)
        val cd3 = ObjectAnimator.ofFloat(binding!!.cardView3, View.ALPHA, 1f).setDuration(500)
        val cd4 = ObjectAnimator.ofFloat(binding!!.cardView4, View.ALPHA, 1f).setDuration(500)

        val text = AnimatorSet().apply {
            playTogether(txt1, txt2)
        }
        AnimatorSet().apply {
            playSequentially(text, cd1, cd2, cd3, cd4)
            start()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.card_view1 -> {
                Toast.makeText(requireActivity(), "ini di tekan", Toast.LENGTH_SHORT).show()
            }
            R.id.card_view2 -> {
                val move = Intent(requireActivity(), TextToTextActivity::class.java)
                startActivity(move)
            }
        }
    }
}
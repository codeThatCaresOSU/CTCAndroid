package com.example.codethatcaresandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView



class SplashScreenFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstances: Bundle?): View? {
        val rootview = inflater.inflate(R.layout.splash_screen, container, false)
        val heart = rootview.findViewById(R.id.heart_animation) as LottieAnimationView

        val motionLayout: MotionLayout = rootview.findViewById(R.id.motionLayout)

        heart.setMinFrame(4)
        heart.setMaxFrame(20)
        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(motionLayout: MotionLayout, i: Int, i1: Int) {

            }

            override fun onTransitionChange(motionLayout: MotionLayout, i: Int, i1: Int, v: Float) {
                heart.progress = v
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout, i: Int) {
                //this is called every time the user 'stops' moving the screen
                //make sure the user moved it as much as 95% to show the next fragment
                if (motionLayout.progress > .95) {
                    val auf = AboutUsFragment()
                    val ft = fragmentManager!!.beginTransaction()
                    ft.replace(R.id.fragment_container, auf)
                    ft.addToBackStack(null)
                    ft.commit()
                }

            }

            override fun onTransitionTrigger(motionLayout: MotionLayout, i: Int, b: Boolean, v: Float) {

            }
        })
        return rootview
    }
}
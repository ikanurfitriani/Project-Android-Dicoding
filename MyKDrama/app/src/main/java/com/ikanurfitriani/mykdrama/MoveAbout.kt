package com.ikanurfitriani.mykdrama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MoveAbout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_about)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.apply {
            title = getString(R.string.moveAbout)
        }
    }
}
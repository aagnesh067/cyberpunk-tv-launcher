package com.example.tv.launcher

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var tvClock: TextView
    private lateinit var rvApps: RecyclerView
    private val clockHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvClock = findViewById(R.id.tvClock)
        rvApps = findViewById(R.id.rvApps)

        startClockUpdate()
        loadInstalledApps()
    }

    private fun startClockUpdate() {
        val clockRunnable = object : Runnable {
            override fun run() {
                val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                tvClock.text = timeFormat.format(Date())
                clockHandler.postDelayed(this, 1000)
            }
        }
        clockHandler.post(clockRunnable)
    }

    private fun loadInstalledApps() {
        val pm = packageManager
        val intent = Intent(Intent.ACTION_MAIN, null).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
        }

        val resolveInfos = pm.queryIntentActivities(intent, 0)
        val appList = mutableListOf<AppItem>()

        for (resolveInfo in resolveInfos) {
            val pkg = resolveInfo.activityInfo.packageName
            if (pkg != packageName) {
                val name = resolveInfo.loadLabel(pm).toString()
                val icon = resolveInfo.loadIcon(pm)
                appList.add(AppItem(name, pkg, icon))
            }
        }

        rvApps.layoutManager = GridLayoutManager(this, 4)
        rvApps.adapter = AppGridAdapter(appList)
    }
}
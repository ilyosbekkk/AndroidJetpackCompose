package com.example.androidjetpackcompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment


class RecipeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.recipe_list, container, false)
        view.findViewById<ComposeView>(R.id.compose_view).setContent {

            Column(
                modifier = Modifier
                    .border(border = BorderStroke(1.dp, color = Color.Black))
                    .padding(16.dp)
            ) {
                androidx.compose.material.Text(text = "This is an introduction to ComposeView  in Jetpack")
                Spacer(modifier = Modifier.padding(10.dp))
                CircularProgressIndicator()
                Spacer(modifier = Modifier.padding(10.dp))
                androidx.compose.material.Text(text = "NEAT")
                Spacer(modifier = Modifier.padding(10.dp))

                val customView = HorizontalDottedProgress(AmbientContext.current)
                AndroidView(viewBlock = { customView })

                val customView2 = inflater.inflate(R.layout.button, container, false)
                AndroidView(viewBlock = { customView2 })


            }


        }

        return view
    }
}


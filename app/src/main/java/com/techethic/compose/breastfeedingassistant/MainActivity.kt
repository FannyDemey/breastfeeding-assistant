package com.techethic.compose.breastfeedingassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.whenResumed
import com.techethic.compose.breastfeedingassistant.ui.BreastFeedTracker
import com.techethic.compose.dailycounter.theme.TestTheme
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

/*
* adb forward tcp:4444 localabstract:/adb-hub
*  adb connect 127.0.0.1:4444
* */
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            lifecycle.whenResumed {
                mainViewModel.retrieveBreastFeedingInfo()
            }
        }
        setContent {
            TestTheme {
                MainApp(mainViewModel = mainViewModel)
            }
        }
    }

}


@Composable
fun MainApp(mainViewModel: MainViewModel){
    BreastFeedTracker(mainViewModel)
}
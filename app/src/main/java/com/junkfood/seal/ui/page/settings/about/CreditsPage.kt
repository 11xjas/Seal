package com.junkfood.seal.ui.page.settings.about


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.junkfood.seal.R
import com.junkfood.seal.ui.component.BackButton
import com.junkfood.seal.ui.component.CreditItem
import com.junkfood.seal.ui.component.LargeTopAppBar

data class Credit(val title: String = "", val license: String? = null, val url: String = "")

const val GPL_V3 = "GNU General Public License v3.0"
const val GPL_V2 = "GNU General Public License v2.0"
const val APACHE_V2 = "Apache License, Version 2.0"
const val UNLICENSE = "The Unlicense"
const val BSD = "BSD 3-Clause License"

const val youtubedlAndroidUrl = "https://github.com/yausername/youtubedl-android"
const val ytdlpUrl = "https://github.com/yt-dlp/yt-dlp"
const val readYou = "https://github.com/Ashinch/ReadYou"
const val musicYou = "https://github.com/Kyant0/MusicYou"
const val dvd = "https://github.com/yausername/dvd"
const val icons8 = "https://icons8.com/"
const val materialIcon = "https://fonts.google.com/icons"
const val materialColor = "https://github.com/material-foundation/material-color-utilities"
const val jetpack = "https://github.com/androidx/androidx"
const val coil = "https://github.com/coil-kt/coil"
const val mmkv = "https://github.com/Tencent/MMKV"
const val dagger = "https://github.com/google/dagger"
const val kotlin = "https://kotlinlang.org/"
const val okhttp = "https://github.com/square/okhttp"
const val accompanist = "https://github.com/google/accompanist"
const val aria2 = "https://github.com/aria2/aria2"
const val material3 = "https://m3.material.io/"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditsPage(onBackPressed: () -> Unit) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        rememberTopAppBarState(),
        canScroll = { true }
    )

    val creditsList = listOf(
        Credit("Android Jetpack", APACHE_V2, jetpack),
        Credit("Kotlin", APACHE_V2, kotlin),
        Credit("youtubedl-android", GPL_V3, youtubedlAndroidUrl),
        Credit("yt-dlp", UNLICENSE, ytdlpUrl),
        Credit("Read You", GPL_V3, readYou),
//        Credit("Music You"),
        Credit("dvd", GPL_V3, dvd),
        Credit("Accompanist", APACHE_V2, accompanist),
        Credit("Material Design 3", APACHE_V2, material3),
        Credit("Material Icons", APACHE_V2, materialIcon),
        Credit("Material color utilities", APACHE_V2, materialColor),
        Credit("MMKV", BSD, mmkv),
        Credit("Coil", APACHE_V2, coil),
        Credit("Dagger", APACHE_V2, dagger),
        Credit("aria2", GPL_V2, aria2),
        Credit("OkHttp", APACHE_V2, okhttp),
        Credit("App icon by Icons8", "Universal Multimedia Licensing Agreement for Icons8", icons8)
    )
    val uriHandler = LocalUriHandler.current
    fun openUrl(url: String) {
        uriHandler.openUri(url)
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = stringResource(id = R.string.credits),
                    )
                }, navigationIcon = {
                    BackButton(modifier = Modifier.padding(start = 8.dp)) {
                        onBackPressed()
                    }
                }, scrollBehavior = scrollBehavior
            )
        }, content = {
            LazyColumn(modifier = Modifier.padding(it)) {
                items(creditsList) { item ->
                    CreditItem(title = item.title, license = item.license) { openUrl(item.url) }
                }
            }
        })

}
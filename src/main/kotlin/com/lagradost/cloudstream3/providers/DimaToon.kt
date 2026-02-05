package com.lagradost.cloudstream3.providers

import com.lagradost.cloudstream3.*
import org.jsoup.Jsoup

class DimaToon : MainAPI() {
    override var mainUrl = "https://dima-toon.com"
    override var name = "DimaToon"
    override val hasMainPage = true
    override val hasQuickSearch = true
    override val supportedTypes = setOf(TvType.Cartoon)
    override var lang = "ar"
    
    override val mainPage = mainPageOf(
        "$mainUrl" to "الصفحة الرئيسية"
    )
    
    override suspend fun getMainPage(
        page: Int,
        request: MainPageRequest
    ): HomePageResponse {
        val items = ArrayList<HomePageList>()
        
        try {
            val doc = Jsoup.connect(mainUrl).get()
            
            // Try different selectors
            val elements = doc.select("article, .post,
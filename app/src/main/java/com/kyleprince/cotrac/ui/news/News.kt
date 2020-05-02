package com.kyleprince.cotrac.ui.news

class News(status: String, totalResults: String, articles: MutableList<Article>) {
     var status = ""
     var totalResults = ""
     var articles = mutableListOf<Article>()

    init {
        this.status = status
        this.totalResults = totalResults
        this.articles = articles
    }

    class Article(article: String,
                  title: String,
                  description: String,
                  url: String,
                  urlToImage: String,
                  publishedAt: String,
                  content: String) {
         var author = ""
         var title = ""
         var description = ""
         var url = ""
         var urlToImage = ""
         var publishedAt = ""
         var content = ""

        init {
            this.author = author
            this.title = title
            this.description = description
            this.url = url
            this.urlToImage = urlToImage
            this.publishedAt = publishedAt
            this.content = content
        }
    }
}
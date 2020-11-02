package hu.advertisersystem.advertiserlibrary.model

data class Advertisement(
    val advertiserId: String = "",
    val outerUrl: String = "",
    val addType: String = "",
    val position: Number = 0,
    val length: Number = 0,
    val radius: Number = 0,
    val gender: String = "",
    val mainTitle: String = "",
    val subTitle: String = "",
    val imageUrl: String = "",
    val videoUrl: String = ""
) {}
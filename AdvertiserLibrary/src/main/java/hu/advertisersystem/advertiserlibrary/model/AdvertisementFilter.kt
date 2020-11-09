package hu.advertisersystem.advertiserlibrary.model

class AdvertisementFilter private constructor(
        val advType: String?,
        val gender: String?)
{
    data class Builder(
        private var advType: String? = null,
        private var gender: String? = null)
    {
        fun advType(advType: String) = apply { this.advType = advType }
        fun gender(gender: String) = apply { this.gender = gender }

        fun build() = AdvertisementFilter(advType, gender)
    }

}
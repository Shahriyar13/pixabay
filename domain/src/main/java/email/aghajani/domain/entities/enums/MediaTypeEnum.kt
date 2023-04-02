package email.aghajani.domain.entities.enums

enum class MediaTypeEnum(val value: String) {
    PHOTO("photo"),
    SVG("vector/svg"),
    AI("vector/ai"),
    ILLUSTRATION("illustration"),
    OTHER("");

    override fun toString(): String {
        return value
    }

    companion object {
        fun getEnum(value: String): MediaTypeEnum {
            return values().first { it.value == value }
        }
    }
}

//fun MediaTypeEnum.valueOf(value: String): MediaTypeEnum {
//    return when(value) {
//        "photo" -> MediaTypeEnum.PHOTO
//        "vector/svg" -> MediaTypeEnum.SVG
//        "vector/ai" -> MediaTypeEnum.AI
//        "illustration" -> MediaTypeEnum.ILLUSTRATION
//        else -> MediaTypeEnum.OTHER
//    }
//}
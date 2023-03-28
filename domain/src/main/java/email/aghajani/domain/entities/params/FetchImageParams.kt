package email.aghajani.domain.entities.params

import email.aghajani.domain.entities.enums.OrderEnum

data class FetchImageParams(
    val query: String? = null,
    val isSafeSearch: Boolean = true,
    val page: Int = 1,
    val perPage: Int = 21,
    val order: OrderEnum = OrderEnum.POPULAR
)
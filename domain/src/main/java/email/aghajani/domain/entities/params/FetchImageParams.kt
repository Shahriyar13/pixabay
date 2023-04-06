package email.aghajani.domain.entities.params

import email.aghajani.domain.entities.enums.OrderEnum

data class FetchImageParams(
    var query: String? = null,
    var isSafeSearch: Boolean = true,
    var page: Int = 1,
    var perPage: Int = 21,
    var order: OrderEnum = OrderEnum.POPULAR
)
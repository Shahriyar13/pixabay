package email.aghajani.domain.usecases

import email.aghajani.domain.common.PixabayResult
import kotlinx.coroutines.flow.Flow

abstract class BaseUseCase<in P, out R> {
    abstract suspend fun execute(param: P): PixabayResult<R>
}
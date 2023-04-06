package email.aghajani.domain.usecases

import email.aghajani.domain.common.PixabayResult
import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<in P, out R> {
    abstract suspend fun execute(param: P): Flow<PixabayResult<R>>
}
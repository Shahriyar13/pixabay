package email.aghajani.domain.usecases

import email.aghajani.domain.common.PixabayResult
import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<in P, out R>: BaseUseCase<P, Flow<R>>() {
    abstract override suspend fun execute(param: P): PixabayResult<Flow<R>>
}
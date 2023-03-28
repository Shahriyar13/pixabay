package email.aghajani.domain.usecases

import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<in P, out R>: BaseUseCase<P, Flow<R>>() {
    abstract override suspend fun execute(param: P): Flow<R>
}
package email.aghajani.domain.usecases

abstract class BaseUseCase<in P, out R> {
    abstract suspend fun execute(param: P): R
}
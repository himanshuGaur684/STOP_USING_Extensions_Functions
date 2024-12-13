package gaur.himanshu.mappers.domain.repository

import gaur.himanshu.mappers.domain.model.Login

interface AuthRepository {
    fun login(login: Login): Result<String>
    fun loginMapper(login: Login): Result<String>
}

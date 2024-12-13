package gaur.himanshu.mappers.data.repository

import gaur.himanshu.mappers.data.mappers.LoginToLoginDTOMapper
import gaur.himanshu.mappers.data.mappers.toDTO
import gaur.himanshu.mappers.domain.model.Login
import gaur.himanshu.mappers.domain.repository.AuthRepository

class AuthRepoImpl(
    private val mapper: LoginToLoginDTOMapper? = null
) : AuthRepository {

    override fun login(login: Login): Result<String> {
        return try {
            val loginDTO = login.toDTO()
            if (loginDTO.email.contains("@gmail.com")) {
                Result.success("success")
            } else {
                throw Exception("error")
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun loginMapper(login: Login): Result<String> {
        return try {
            val loginDTO = mapper!!.map(login)
            if (loginDTO.email.contains("@gmail.com")) {
                Result.success("success")
            } else {
                throw Exception("error")
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

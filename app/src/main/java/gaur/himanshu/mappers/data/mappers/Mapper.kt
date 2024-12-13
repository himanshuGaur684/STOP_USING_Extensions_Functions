package gaur.himanshu.mappers.data.mappers

import gaur.himanshu.mappers.data.model.LoginDTO
import gaur.himanshu.mappers.domain.model.Login

interface Mapper<F, T> {
    fun map(from: F): T
}

fun <F, T> Mapper<F, T>.mapAll(list: List<F>) = list.map { map(it) }

class LoginToLoginDTOMapper : Mapper<Login, LoginDTO> {
    override fun map(from: Login): LoginDTO {
        val email = from.firstName.lowercase().plus(from.lastName.lowercase()).plus(from.age)
            .plus("@gmail.com")
        return LoginDTO(
            email = email,
            password = from.password
        )
    }
}

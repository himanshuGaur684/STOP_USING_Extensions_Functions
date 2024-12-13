package gaur.himanshu.mappers.data.mappers

import gaur.himanshu.mappers.data.model.LoginDTO
import gaur.himanshu.mappers.domain.model.Login

fun Login.toDTO(): LoginDTO {
    val email = firstName.lowercase().plus(lastName.lowercase()).plus(age).plus("@gmail.com")
    return LoginDTO(
        email = email,
        password = password
    )
}

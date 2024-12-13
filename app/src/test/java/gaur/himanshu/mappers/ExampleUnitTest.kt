package gaur.himanshu.mappers

import gaur.himanshu.mappers.data.mappers.LoginToLoginDTOMapper
import gaur.himanshu.mappers.data.model.LoginDTO
import gaur.himanshu.mappers.data.repository.AuthRepoImpl
import gaur.himanshu.mappers.domain.model.Login
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `should not proceed with wrong email`() {
        val authRepository = AuthRepoImpl()
        val login = Login(
            firstName = "himanshu",
            lastName = "gaur",
            age = 24,
            password = "flakdsjflkaf"
        )
        val result = authRepository.login(login)
        assertEquals("error", result.exceptionOrNull()?.message)
    }

    @Test
    fun `should not proceed with wrong email mapper`() {
        val mapper = mock<LoginToLoginDTOMapper>()
        val authRepository = AuthRepoImpl(mapper)
        val login = Login(
            firstName = "himanshu",
            lastName = "gaur",
            age = 24,
            password = "flakdsjflkaf"
        )
        whenever(mapper.map(login)).thenReturn(LoginDTO(email = "", password = ""))
        val result = authRepository.loginMapper(login)
        assertEquals("error", result.exceptionOrNull()?.message)
    }
}

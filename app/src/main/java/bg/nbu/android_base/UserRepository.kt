package bg.nbu.android_base

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {
    val allUsers: Flow<List<User>> = userDao.getAll()

    @WorkerThread
    suspend fun insert(user: User) {
        userDao.insertUser(user)
    }

}
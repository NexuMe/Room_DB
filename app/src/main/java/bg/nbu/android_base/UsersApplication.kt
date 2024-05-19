package bg.nbu.android_base

import android.app.Application

class UsersApplication:Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { UserRoomDatabase.getDatabase(this) }
    val repository by lazy { UserRepository(database.userDao()) }
}
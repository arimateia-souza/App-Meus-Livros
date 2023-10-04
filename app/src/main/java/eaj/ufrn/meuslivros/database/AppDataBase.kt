package eaj.ufrn.meuslivros.database

import androidx.room.Database
import androidx.room.RoomDatabase
import eaj.ufrn.meuslivros.model.Livro
import eaj.ufrn.meuslivros.repository.LivroDao


@Database(entities = [Livro::class], version =1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun livroDao(): LivroDao
}
















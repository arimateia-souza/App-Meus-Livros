package eaj.ufrn.meuslivros.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "livros")
data class Livro(

    @ColumnInfo(name = "nome")
    var nome: String,

    @ColumnInfo(name = "autor")
    var autor: String,

    @ColumnInfo(name = "ano")
    var ano: Int,

    @ColumnInfo(name = "nota")
    var nota: Float
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var uid: Long = 0

}


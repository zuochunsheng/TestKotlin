package edz.example.com.kotlinapplication.service

/**
 * anther: created by zuochunsheng on 2019/11/3 15 : 01
 * description :
 *
 */
data class User(var login: String, val id: Int, val avatar_uar: String){
    override fun toString(): String {
        return super.toString()
    }
}

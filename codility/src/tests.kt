import java.util.*
import kotlin.streams.toList

fun solution(A: IntArray): Int {
    //        for(int i = 0; i < A.length; i++){
    //
    //        }

    var list  = Arrays.stream(A).toList()

    for(i in list){
        if(list.contains(list.max()!!.minus(1))){
            list.drop(list.max()!!)
        }
    }
    println(list)
    if(!(list.contains(list.max()!!.minus(1)))){
        println( list.max()?.minus(1) as Int)
        return 0
    }else{
        return 1
    }
}

fun main() {
    solution(intArrayOf(1,2,3,4,5))
}

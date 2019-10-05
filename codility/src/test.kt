import java.util.Arrays

class test {

    fun solution(A: IntArray): Int {
        //        for(int i = 0; i < A.length; i++){
        //
        //        }

        return Arrays.stream(A).min().asInt
    }

    fun main() {
        solution(intArrayOf(1,2,3,4,5))
    }
}

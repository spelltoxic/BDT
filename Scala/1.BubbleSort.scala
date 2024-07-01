//1. Write the scala code to implement bubble sort algorithm.

object BubbleSort{
    def bubblesort(arr:Array[Int]): Unit={
        val n=arr.length
        var swapped=true

        while(swapped==true) {
            swapped=false
            for(i <- 1 until n){
                if(arr(i-1)>arr(i)){
                    val temp= arr(i)
                    arr(i)= arr(i-1)
                    arr(i-1)=temp
                    swapped=true
                }
            }
        }
    }

    def main(args:Array[String]):Unit={
        val arr=Array(12,34,45,242,12,98,2)
        println("Original Array:")
        arr.foreach(println)
        bubblesort(arr)
        println("\nSorted Array:")
        arr.foreach(println)
    }
}


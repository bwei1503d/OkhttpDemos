package muhanxi.okhttpdemos.kotlin

/**
 * Created by muhanxi on 17/11/20.
 */
class TestKotlin {







    /**
     * 定义参数和定义返回值
     */
    fun sum(a : Int , b : Int) : Int{
        return a + b ;
    }


    // 该函数只有一个表达式 及返回值  可以这么写
    fun sum1(a : Int, b : Int) = a + b ;


    /**
     * 定义一个没有意义的返回值 Unit 返回可以省略
     * $a 表示变量
     */
    fun printSum(a : Int , b: Int) : Unit {
        return print("sum is $a and $b  is ${a+b}");
    }


    fun  main(args : Array<String>) {

        //定义一个变量 及变量类型
        var  a : Int = 1 ;
        // 定义一个变量 ， 类型有编译器推导
        var b = 2 ;

        // 定一个一个未初始化的变量
        var c : Int;
        c = 10 ;

        print(" a is $a b is $b c fis $c");



        var d = " this is $a" ;

        //字符串模版替换
        var d1 = "${d.replace("is","newis")} test" ;




    }



//    条件表达式
    fun maxOf(a: Int ,b :Int) : Int {
        if(a > b){
            return a ;
        }else{
            return b ;
        }
    }


    fun  testMainOf(){
        print("${maxOf(1,2)}");
    }




    fun  parseInt(a : Int) : Int?{
        return  a.toInt();
    }


//    类型监测
    fun getStringLength (str : Any) {

        if(str is String){
           var len =  str.length;


        }

    }


    /**
     * var 声明变量
     * val 声明只读变量 相当于java final
     */
    fun testFor(){
        val items = listOf("1","2","3");

        for (item in  items){
            print(item);
        }

    }













}
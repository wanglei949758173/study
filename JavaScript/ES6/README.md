# 1. let

  * 声明变量只在代码块内生效
    ```js
    {
      let a = 10;
      var b = 1;
    }
    a // ReferenceError: a is not defined.
    b // 1

    // 示例1
    var a = new Array(10);
    for (var i = 0; i < 10; i++){
    	a[i] = function(){
    		console.log(i);
    	}
    }

    // 由于var声明的变量是全局变量,因此输入的i是全局的i,即i=10
    a[6](); // 10

    // 示例2
    var a = new Array(10);
    for (let i = 0; i < 10; i++){
    	a[i] = function(){
    		console.log(i);
    	}
    }

    a[6](); // 6
    ```

  * 不存在变量提升
    ```js
    // var 的情况
    console.log(foo); // 输出undefined
    var foo = 2;

    // let 的情况
    console.log(bar); // 报错ReferenceError
    let bar = 2;
    ```

  * 暂时性死区

    只要块级作用域内存在`let`命令，它所声明的变量就 **“绑定”（binding）这个区域** ，不再受外部的影响。
    ```js
    var tmp = 123;

    if (true) {
      // 一旦在此代码块中声明了tmp变量，就不能在此变量声明前使用此变量
      tmp = 'abc'; // ReferenceError
      let tmp;
    }

    // 示例1
    if (true) {
      // TDZ(“暂时性死区” temporal dead zone)开始
      tmp = 'abc'; // ReferenceError
      console.log(tmp); // ReferenceError

      let tmp; // TDZ结束
      console.log(tmp); // undefined

      tmp = 123;
      console.log(tmp); // 123
    }
    ```

  * 不允许重复声明
    ```js
    function func(arg) {
      let arg;
    }
    func() // 报错

    function func(arg) {
      {
        let arg;
      }
    }
    func() // 不报错
    ```

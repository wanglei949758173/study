# 1. let & const命令
## 1.1 let命令
### 声明变量只在代码块内生效
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

### 不存在变量提升
  ```js
  // var 的情况
  console.log(foo); // 输出undefined
  var foo = 2;

  // let 的情况
  console.log(bar); // 报错ReferenceError
  let bar = 2;
  ```

### 暂时性死区

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

### 不允许重复声明
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

## 1.2 块级作用域
### 为什么需要块级作用域？
  由于代码A处的变量提升导致输出的`tmp`变量为`undefined`
  ```js
  var tmp = new Date();

  function f() {
    console.log(tmp);
    if (false) {
      var tmp = 'hello world'; // A
    }
  }

  f(); // undefined
  ```
  循环变量变为全局变量
  ```js
  var s = 'hello';

  for (var i = 0; i < s.length; i++) {
    console.log(s[i]);
  }

  console.log(i); // 5
  ```

 ### ES6块级作用域
 不存在变量提升，输出值与预期值相同
  ```js
  function f1() {
    let n = 5;
    if (true) {
      let n = 10;
    }
    console.log(n); // 5
  }
  ```
  上层级不能访问下层级的变量
  ```js
  {{{{
    {let insane = 'Hello World'}
    console.log(insane); // 报错
  }}}};
  ```

### 块级作用域使得ITFE(立即执行函数表达式)不在必要了
```js
// IIFE 写法
(function () {
  var tmp = ...;
  ...
  return xx;
}());

// 块级作用域写法
{
  let tmp = ...;
  ...
}
```

## 1.3 const命令
`const`声明一个只读的常量。一旦声明，常量的值就不能改变。
```js
const PI = 3.1415;
PI // 3.1415

PI = 3;
// TypeError: Assignment to constant variable.
```

# 2. 解构赋值

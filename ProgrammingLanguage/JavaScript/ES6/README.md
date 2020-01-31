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
## 2.1 数组的解构赋值
### 基本使用
```js
let [foo, [[bar], baz]] = [1, [[2], 3]];
foo // 1
bar // 2
baz // 3

let [ , , third] = ["foo", "bar", "baz"];
third // "baz"

let [x, , y] = [1, 2, 3];
x // 1
y // 3

let [head, ...tail] = [1, 2, 3, 4];
head // 1
tail // [2, 3, 4]

let [x, y, ...z] = ['a'];
x // "a"
y // undefined
z // []
```

* 如果等号的右边不是数组（或者严格地说，不是可遍历的结构),那么将会 **报错**
  ```js
  // 全部报错
  let [foo] = 1;
  let [foo] = false;
  let [foo] = NaN;
  let [foo] = undefined;
  let [foo] = null;
  let [foo] = {}
  ```
* Set对象的解构赋值
  ```js
  let [x, y, z] = new Set(['a', 'b', 'c']);
  x // "a"
  ```

### 默认值
**只有当一个数组成员严格等于undefined，默认值才会生效**
```js
let [foo = true] = [];
foo // true

let [x, y = 'b'] = ['a']; // x='a', y='b'
let [x, y = 'b'] = ['a', undefined]; // x='a', y='b'

let [x = 1] = [undefined];
x // 1

let [x = 1] = [null];
x // null
// 如果一个数组成员是null，默认值就不会生效，因为null不严格等于undefined。
```

* 默认值为表达式
  ```js
  function f() {
    console.log('aaa');
  }

  let [x = f()] = [1];
  // 因为x能取到值，所以函数f根本不会执行
  ```

* 默认值可以引用解构赋值的其他变量
  ```js
  let [x = 1, y = x] = [];     // x=1; y=1
  let [x = 1, y = x] = [2];    // x=2; y=2
  let [x = 1, y = x] = [1, 2]; // x=1; y=2
  let [x = y, y = 1] = [];     // ReferenceError: y is not defined
  ```

## 2.2 对象的解构赋值
### 基本使用
```js
let { foo, bar } = { foo: 'aaa', bar: 'bbb' };
foo // "aaa"
bar // "bbb"

// 解构失败，变量的值等于undefined
let {foo} = {bar: 'baz'};
foo // undefined
```

* 取对象的方法
  ```js
  // 例一
  let { log, sin, cos } = Math;

  // 例二
  const { log } = console;
  log('hello') // hello
  ```

* 变量名与属性名不一致
  ```js
  let { foo: baz } = { foo: 'aaa', bar: 'bbb' };
  baz // "aaa"

  let obj = { first: 'hello', last: 'world' };
  let { first: f, last: l } = obj;
  f // 'hello'
  l // 'world'
  ```
* **实际上说明，对象的解构赋值是下面形式的简写**
  ```js
  let { foo: foo, bar: bar } = { foo: 'aaa', bar: 'bbb' };
  ```
  也就是说，对象的解构赋值的内部机制，是先找到同名属性，然后再赋给对应的变量。真正被赋值的是后者，而不是前者。

* 嵌套结构
  ```js
  let obj = {
    p: [
      'Hello',
      { y: 'World' }
    ]
  };

  let { p: [x, { y }] } = obj;
  x // "Hello"
  y // "World"

  const node = {
    loc: {
      start: {
        line: 1,
        column: 5
      }
    }
  };

  // 示例二
  let { loc, loc: { start }, loc: { start: { line }} } = node;
  line // 1
  loc  // Object {start: Object}
  start // Object {line: 1, column: 5}

  // 示例三
  let obj = {};
  let arr = [];

  ({ foo: obj.prop, bar: arr[0] } = { foo: 123, bar: true });

  obj // {prop:123}
  arr // [true]
  ```

### 默认值
```js
var {x = 3} = {};
x // 3

var {x, y = 5} = {x: 1};
x // 1
y // 5

var {x: y = 3} = {};
y // 3

var {x: y = 3} = {x: 5};
y // 5

var { message: msg = 'Something went wrong' } = {};
msg // "Something went wrong"
```
默认值生效的条件是，对象的属性值严格等于`undefined`。

## 2.3 字符串的解构赋值
```js
const [a, b, c, d, e] = 'hello';
a // "h"
b // "e"
c // "l"
d // "l"
e // "o"

let {length : len} = 'hello';
len // 5
```

## 2.4 数值和布尔值的解构赋值
```js
let {toString: s} = 123;
s === Number.prototype.toString // true

let {toString: s} = true;
s === Boolean.prototype.toString // true
```

## 2.5 函数参数的解构赋值
```js
function add([x, y]){
  return x + y;
}

add([1, 2]); // 3

// 示例二
[[1, 2], [3, 4]].map(([a, b]) => a + b);
// [ 3, 7 ]

// 示例三
function move({x = 0, y = 0} = {}) {
  return [x, y];
}
move({x: 3, y: 8}); // [3, 8]
move({x: 3}); // [3, 0]
move({}); // [0, 0]
move(); // [0, 0]
```

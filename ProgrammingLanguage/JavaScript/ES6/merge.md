# let

let 关键字用来声明变量，使用 let 声明的变量有几个特点：

1.  不允许重复声明

2.  块儿级作用域

3.  不存在变量提升

4.  不影响作用域链

**应用场景：项目编码中使用let代替var**

# const

const 关键字用来声明常量，const 声明有以下特点

1. 声明必须赋初始值
2. 标识符一般为大写

3. 不允许重复声明

4. 值不允许修改

5. 块儿级作用域

# 解构赋值

ES6 允许按照一定模式，从数组和对象中提取值，对变量进行赋值，这被称为解构赋值。

**数组的解构赋值**

```javascript
const arr = ['张学友', '刘德华', '黎明', '郭富城'];
let [zhang, liu, li, guo] = arr;
```

**对象的解构赋值**

```javascript
const lin = {
	name: '林志颖',
	tags: ['车手', '歌手', '小旋风', '演员']
};
let {name, tags} = lin;
```

**复杂对象的解构赋值**

```javascript
let wangfei = {
	name: '王菲', age: 18,
	songs: ['红豆', '流年', '暧昧', '传奇'],
    history: [
		{name: '窦唯'},
		{name: '李亚鹏'},
		{name: '谢霆锋'}
	]
};
let {songs: [one, two, three], history: [first, second, third]} = wangfei;
```

# 模板字符串

模板字符串（template string）是增强版的字符串，用反引号（`）标识，具有以下特点：

* 字符串中可以出现换行
* 可以使用`${xxx}`形式输出变量

```javascript
// 定义字符串
let str = `<ul>
            <li>沈腾</li>

            <li>玛丽</li>

            <li>魏翔</li>

            <li>艾伦</li>
           </ul>`;

// 变量拼接
let star = '王宁';

let result = `${star}在前几年离开了开心麻花`;
```

**使用场景：当遇到字符串与变量拼接的情况下使用模板字符串。**

# 简化对象写法

ES6 允许在大括号里面，直接写入变量和函数，作为对象的属性和方法。这样的书写更加简洁。

```javascript
let name = '计算机';

let slogon = 'coding forever'; 

let improve = function () {
    console.log('改变事件');
}

//属性和方法简写
let department = { 
    name, 
    slogon, 
    improve, 
    change() {
		console.log('可以改变你')
	}
};
```

# 箭头函数

ES6 允许使用「箭头」（=>）定义函数。

```javascript
/**
* 1. 通用写法
*/
let fn = (arg1, arg2, arg3) => {
	return arg1 + arg2 + arg3;
}
```

箭头函数的注意点:

1. 如果形参只有一个，则小括号可以省略
2. 函数体如果只有一条语句，则花括号可以省略，函数的返回值为该条语句的执行结果
3. 箭头函数 this 指向声明时所在作用域下 this 的值
4. 箭头函数不能作为构造函数实例化
5. 不能使用 arguments

```javascript
let school = {
	name: '清华大学',
    getName(){
        let fn5 = () => {
            console.log(this);
        }
		fn5();
    }
};
```

**箭头函数中的this仍然为当前上下文的this指针。**

# rest参数

S6 引入 rest 参数，用于获取函数的实参，用来代替 arguments。

```javascript
/**
* 作用与 arguments 类似
*/
function add(...args){
	console.log(args);
}
add(1,2,3,4,5);

/**
* rest 参数必须是最后一个形参
*/
function minus(a,b,...args){
	console.log(a,b,args);
}
minus(100,1,2,3,4,5,19);
```

**rest参数适用于不定个数参数函数的场景。**

# spread扩展运算符

spread运算符即`...`，用户对数据或对象进行解包。

```javascript
/**
* 展开数组
*/

let tfboys = ['德玛西亚之力','德玛西亚之翼','德玛西亚皇子'];

function fn(){
	console.log(arguments);
}

fn(...tfboys)

/**
* 展开对象
*/
let skillOne = {
	q: '致命打击',
};
let skillTwo = {
	w: '勇气'
};
let skillThree = {
	e: '审判'
};
let skillFour = {
	r: '德玛西亚正义'
};

let gailun = {...skillOne, ...skillTwo,...skillThree,...skillFour};
```

# Symbol

ES6 引入了一种新的原始数据类型 `Symbol`， 表示独一无二的值。它是JavaScript 语言的第七种数据类型，是一种类似于字符串的数据类型。

## Symbol 特点

1. **Symbol 的值是唯一的，用来解决命名冲突的问题**

2. Symbol 值不能与其他数据进行运算

3. Symbol 定义的对象属性不能使用 for…in 循环遍历， 但是但是可以使用 `Reflect.ownKeys` 来获取对象的所有键名

## 应用实例

```javascript
//创建 Symbol
let s1 = Symbol(); 
console.log(s1, typeof s1);// Symbol() "symbol"

//添加标识的 Symbol
let s2 = Symbol('wl');

let s2_2 = Symbol('wl'); 
console.log(s2 === s2_2);// false

//使用 Symbol for 定义
let s3 = Symbol.for('wl');
let s3_2 = Symbol.for('wl'); 
console.log(s3 === s3_2);// true
```

## symbol内置值

除了定义自己使用的 `Symbol` 值以外，ES6 还提供了11 个内置的Symbol 值，指向语言内部使用的方法。可以称这些方法为魔术方法，因为它们会在特定的场景下自动执行。

| 方法                      | 含义                                                         |
| ------------------------- | ------------------------------------------------------------ |
| Symbol.hasInstance        | 当其他对象使用 instanceof 运算符，判断是否为该对象的实例时，会调用这个方法 |
| Symbol.isConcatSpreadable | 对象的 Symbol.isConcatSpreadable 属性等于的是一个布尔值，表示该对象用于 Array.prototype.concat()时，是否可以展开。 |
| Symbol.species            | 创建衍生对象时，会使用该属性                                 |
| Symbol.match              | 当执行 str.match(myObject) 时，如果该属性存在，会调用它，返回该方法的返回值。 |
| Symbol.replace            | 当该对象被 str.replace(myObject)方法调用时，会返回 方法的返回值。 |
| Symbol.search             | 当该对象被  str. search (myObject)方法调用时，会返回该方法的返回值。 |
| Symbol.split              | 当该对象被  str. split (myObject)方法调用时，会返回该方法的返回值。 |
| Symbol.iterator           | 对象进行  for...of 循环时，会调用  Symbol.iterator 方法，  返回该对象的默认遍历器 |
| Symbol.toPrimitive        | 该对象被转为原始类型的值时，会调用这个方法，返回该对象对应的原始类型值。 |
| Symbol. toStringTag       | 在该对象上面调用 toString 方法时，返回该方法的返回值         |
| Symbol. unscopables       | 该对象指定了使用  with 关键字时，哪些属性会被 with 环境排除。 |

# 迭代器

遍历器（Iterator）就是一种机制。它是一种接口，为各种不同的数据结构提供统一的访问机制。任何数据结构只要部署 `Iterator` 接口，就可以完成遍历操作。

1. ES6 创造了一种新的遍历命令 for...of 循环，Iterator 接口主要供 for...of 消费

2. 原生具备 iterator 接口的数据(可用 for of 遍历)
   * Array
   * Arguments
   * Set
   * Map
   * String
   * TypedArray
   * NodeList

3. 工作原理
   * 创建一个指针对象，指向当前数据结构的起始位置
   * 第一次调用对象的 next 方法，指针自动指向数据结构的第一个成员
   * 接下来不断调用 next 方法，指针一直往后移动，直到指向最后一个成员
   * 每调用 next 方法返回一个包含 value 和done 属性的对象

 

# Promise

`Promise`是异步编程的一种解决方案，从语法上讲，Promise是一个对象，从它可以获取异步操作的消息；从本意上讲，它是承诺，承诺它过一段时间会给你一个结果。

Promise有三种状态：pending(等待态)，fulfiled(成功态),rejected(失败态)；**状态一旦改变，就不会再变**。创造Promise实例后，它会立即执行。

## 基本使用

* 创建Promise

  ```javascript
  let p = new Promise((resolve, reject) => {
      // 做一些异步操作
      setTimeout(() => {
        console.log('执行完成');
        resolve('成功结果')
      }, 2000);
  })
  ```

* then和reject的用法

  ```javascript
  new Promise((resolve, reject) => {
      // 请求数据
      cosnt {success, data} = request('/hello');
      if(success) {
          resolve(data)
      } else {
          reject('请求数据出错')
      }
  }).then((data) => {
      console.log("请求成功,数据=" + data);
  }, (errMsg) => {
      console.log(errMsg)
  })
  ```

* catch的用法

  ```javascript
  new Promise((resolve, reject) => {
      // 请求数据
      cosnt {success, data} = request('/hello');
      if(success) {
          resolve(data)
      } else {
          reject('请求数据出错')
      }
  }).then((data) => {
      console.log("请求成功,数据=" + data);
  }).catch((errMsg) => {
      console.log(errMsg)
  })
  ```

  >效果与.then的第二个参数一样，也是reject的一个回调。
  >与.then的第二个参数的区别，**在运行时如果js代码报错，也会进入catch**。

## Promise有什么作用

 * 解决 **回调地狱问题**
 * promise可以支持多个并发的请求，获取并发请求中的数据
 * promise可以解决异步的问题，本身不能说promise是异步的

## 扩展用法

* `Promise.all()`

  Promise.all()接收一个Promise数组的参数；

  const p = Promise.all([p1, p2, p3]);只有p1、p2、p3**全部成功，p才成功**,只要有一个失败，则p失败；

  有了all，就可以并行执行多个异步操作，然后在一个回调里处理所有数据。例如初始化一个游戏前可能需要很多资源，那就可以使用此功能做到所有资源都加载完成后才初始化游戏。

  ```javascript
  let promise1 = new Promise((resolve, reject) => {});
  let promise2 = new Promise((resolve, reject) => {});
  let promise3 = new Promise((resolve, reject) => {});
  Promise.all([promise1, promise2, promise3]).then(() => {
      // 三个都成功,则成功
  }, () => {
      // 只要有一个失败，则失败
  })
  ```

* `Promise.race()`

  Promise.race()和Promise.all()一样，也是接收一个数组参数；
  const p = Promise.race([p1, p2, p3]);只要p1、p2、p3中**有一个状态率先改变，则P的状态随之改变**。

  ```javascript
  const p = Promise.race([
      fetch('/resource-that-may-take-a-while'),
      new Promise(function (resolve, reject) {
          setTimeout(() => reject(new Error('request timeout')), 5000)
      })
  ]);
  p.then(console.log)
   .catch(console.error);
  // 上面代码中，如果 5 秒之内fetch方法无法返回结果，变量p的状态就会变为rejected，从而触发catch方法指定的回调函数。
  ```

  

# Set

ES6 提供了新的数据结构 Set（集合）。它类似于数组，但成员的值都是唯一的，集合实现了 iterator 接口，所以可以使用『扩展运算符』和『for…of…』进行遍历，集合的属性和方法：

1. size 返回集合的元素个数
2. add 增加一个新元素，返回当前集合
3. delete 删除元素，返回 boolean 值
4. has 检测集合中是否包含某个元素，返回 boolean 值
5. clear 清空集合，返回 undefined

```javascript
//创建一个空集合
let s = new Set();
//创建一个非空集合
let s1 = new Set([1,2,3,1,2,3]);

//集合属性与方法
//返回集合的元素个数
console.log(s1.size);
//添加新元素
console.log(s1.add(4));
//删除元素
console.log(s1.delete(1));
//检测是否存在某个值
console.log(s1.has(2));
//清空集合
console.log(s1.clear());
```

# Map

ES6 提供了 Map 数据结构。它类似于对象，也是键值对的集合。但是“键” 的范围不限于字符串，各种类型的值（包括对象）都可以当作键。Map 也实现了iterator 接口，所以可以使用『扩展运算符』和『for…of…』进行遍历。Map 的属性和方法：

1.  size 返回 Map 的元素个数
2.  set 增加一个新元素，返回当前 Map
3.  get 返回键名对象的键值
4.  has 检测 Map 中是否包含某个元素，返回 boolean 值
5.  clear 清空集合，返回 undefined

```javascript
//创建一个空 map
let m = new Map();
//创建一个非空 map
let m2 = new Map([ 
    ['name','zhangsan'],
	['slogon','codeing everywhere']
]);
//属性和方法
//获取映射元素的个数
console.log(m2.size);
//添加映射值
console.log(m2.set('age', 6));
//获取映射值
console.log(m2.get('age'));
//检测是否有该映射
console.log(m2.has('age'));
//清除
console.log(m2.clear());
```

# class类

ES6 提供了更接近传统语言的写法，引入了 Class（类）这个概念，作为对象的模板。通过 class 关键字，可以定义类。基本上，ES6 的 class 可以看作只是一个语法糖，它的绝大部分功能，ES5 都可以做到，新的 class 写法只是让对象原型的写法更加清晰、更像面向对象编程的语法而已。

知识点：

1. class 声明类
2. constructor 定义构造函数初始化
3. extends 继承父类
4. super 调用父级构造方法
5. static 定义静态方法和属性
6. 父类方法可以重写

## 基本使用

```javascript
//父类
class Phone {
    //构造方法
    constructor(brand, color, price) {
    this.brand = brand; this.color = color; this.price = price;
    }

    //对象方法
    call() {
        console.log('我可以打电话!!!')
    }
}

//子类
class SmartPhone extends Phone {
    constructor(brand, color, price, screen, pixel) {
        super(brand, color, price); 
        this.screen = screen; this.pixel = pixel;
     }
    
    //子类方法
	photo() {
        console.log('我可以拍照!!');
    }
    playGame() {
        console.log('我可以打游戏!!');
    }
    
    //方法重写
    call() {
        console.log('我可以视频通话!!');
    }
    
    // 静态方法
    static run() {
        console.log('开机....!!');
    }
}

//实例化对象
const Nokia = new Phone('诺基亚', '灰色', 230);

const iPhone6s = new SmartPhone('苹果', '白色', 6088, '4.7inch','500w');

//调用子类方法
iPhone6s.playGame();
//调用重写方法
iPhone6s.call();
//调用静态方法
SmartPhone.run();
```

# 数值扩展

* `Number.isFinite()` 

  用来检查一个数值是否为有限的

  如果参数类型不是数值，`Number.isFinite`一律返回`false`

* `Number.isNaN()`

  用来检查一个值是否为 NaN

* `Math.trunc`

  用于去除一个数的小数部分，返回整数部分

  ```javascript
  Math.trunc(4.1) // 4
  Math.trunc(4.9) // 4
  Math.trunc(-4.1) // -4
  Math.trunc(-4.9) // -4
  Math.trunc(-0.1234) // -0
  ```

  ```javascript
  Math.trunc('123.456') // 123
  Math.trunc(true) //1
  Math.trunc(false) // 0
  Math.trunc(null) // 0
  ```

# 对象扩展

ES6 新增了一些 Object 对象的方法

* `Object.is` 

  比较两个值是否严格相等，与`===`行为基本一致

  ```javascript
  Object.is('foo', 'foo')
  // true
  Object.is({}, {})
  // false
  ```

* `Object.assign` 

  对象的合并，将源对象的所有可枚举属性，复制到目标对象

  ```javascript
  const target = { a: 1 };
  
  const source1 = { b: 2 };
  const source2 = { c: 3 };
  
  Object.assign(target, source1, source2);
  target // {a:1, b:2, c:3}
  ```

# 模块化

模块功能主要由两个命令构成：export 和 import。

##  export 

用于规定模块的对外接口

* 输出变量

  ```javascript
  var firstName = 'Michael';
  var lastName = 'Jackson';
  var year = 1958;
  
  export { firstName, lastName, year };
  ```

* 输出变量或class

  ```javascript
  export function multiply(x, y) {
    return x * y;
  };
  ```

* 重命名输出信息

  ```javascript
  function v1() { ... }
  function v2() { ... }
  
  export {
    v1 as streamV1,
    v2 as streamV2,
    v2 as streamLatestVersion
  };
  ```

## import

 用于导入其他模块提供的功能

* 导入

  ```javascript
  import { firstName, lastName, year } from './profile.js';
  
  function setName(element) {
    element.textContent = firstName + ' ' + lastName;
  }
  ```

* 导入后重命名

  ```javascript
  import { lastName as surname } from './profile.js';
  ```

  
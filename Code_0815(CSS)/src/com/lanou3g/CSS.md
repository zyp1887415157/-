# CSS

## 一. 简介

1. 层叠样式表(Cascading Style Sheet)
2. 用来定义如何显示HTML元素
3. 样式通常存储在样式表中, 解决内容与表现分离
4. 外部样式表可以提高工作效率
5. 样式表通常存储在css文件中

## 二. 简单使用

### 1. CSS语法

#### 1.1 基本语法

```
选择器 {属性1: 值1 值2; 属性2: 值1 值2 值3}
```

#### 1.2 选择器

##### 基本选择器

1. 标签选择器: `标签名`
2. id选择器: `#id`
3. 类选择器: `.类名`
4. `选择器1, 选择器2`: 所有的1和2
5. `选择器1 选择器2`: 选择器1 里面的 选择器2
6. `标签.类名`
7. 还有其他好几十个

### 2. 加载样式

#### 2.1 在元素中使用样式: 内联样式

```
<p style="color: darkcyan; font-size: 2em">大连的天气真能热死个狗</p>
```

#### 2.2 在html中使用样式: 内部样式表

```
<head>
    <meta charset="UTF-8">
    <title>CSS</title>
    <style>
        .inner-text {
            color: brown;
            font-size: 2em;
        }
    </style>
</head>
<body>
<p class="inner-text">能不能申请穿短裤和拖鞋上班呢?</p>
</body>
```

#### 2.3 使用独立的css文件中的样式: 外部样式表

```
<head>
    <link rel="stylesheet" type="text/css" href="../css/comment.css">
</head>
```

### 3. 常用属性

#### 3.1 背景

1. background-color

    - 定义背景颜色
    - 可以使用8位16进制的颜色值, 或者`rgb(红, 绿, 蓝)`, 或者颜色名称

2. background-image

    - 使用`url()`函数加载背景图片

3. background-repeat

    - 设置平铺方式
    - repeat-x
    - repeat-y
    - no-repeat

4. background-attachment

    - 网页滚动时背景图片的显示效果

5. background-position

    - 设置背景图片放置的位置

#### 3.2 文字

1. color
2. text-align
3. text-decoration

#### 3.4 字体

1. font-family
2. font-style
3. font-size
4. font-weight

#### 4.5 链接

1. `:link` 未访问
2. `:visited` 已访问
3. `:hover` 鼠标悬停
4. `:active` 鼠标按下

#### 4.6 列表

1. list-style-type 有序列表
2. list-style-image 无序列表

## 三. 盒子模型

### 1. 边框border
### 2. 外边距margin
### 3. 内边距padding
### 4. 显示display

1. visibility:hidden
2. display:none
3. display:inline
4. display:block

### 5. 定位position

#### 5.1 static
#### 5.2 fixed
#### 5.3 relative
#### 5.4 absolute
#### 5.5 sticky粘性定位

### 6. 浮动

#### 6.1 clear

### 7. 对齐

7.1 margin: auto 居中




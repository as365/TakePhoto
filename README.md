## PictureSelect



对于每个APP基本上都有一个头像上传的功能，对于如何获取头像照片，可以通过使用本地相册或者拍照获取，而是用原生的相机功能都会或多或少遇到一些问题，因此特地封装了相机和相册功能，使用简单，方便，只需要简单的几行代码就可以获取图片。



### **效果演示**


![这里写图片描述](http://img.blog.csdn.net/20161026151259070)

### 主要亮点

 1. 可以进行拍照或者从本地相册获取图片
 2. 可以对已经选中的图片进行编辑、如裁剪、放大、缩小等操作
 3. 直接返回选中图片的地址，方便后续操作，如上传服务器等。


### **gradle引用**

```
compile 'liji.library.dev:takephotolib:1.1.0'
```


### **代码示例（v1.1.0）**

```
	  TakePhoto takePhoto = new TakePhoto(MainActivity.this);
      takePhoto.setOnPictureSelected(new TakePhoto.onPictureSelected() {
                    @Override
                    public void select(String path，String compresspath) {
      //path图片原始地址
      //compresspath  图片经过压缩后的地址          
                    }
                });
      takePhoto.show();
```

 
 


----------


### **关于作者**

 1. QQ：        275137657
 2. github：   https://github.com/crazyandcoder
 3. 个人博客：http://crazyandcoder.github.io/

### **感谢**

 - [galleryfinal](https://github.com/pengjianbo/GalleryFinal)

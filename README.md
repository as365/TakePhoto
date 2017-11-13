## **TakePhotoV2.0.0**

[![](https://badge.juejin.im/entry/5a06740d51882512a860c893/likes.svg?style=flat-square)](https://juejin.im/post/5a06739ff265da432b4a4bb5)

## **说明**

对于现在的APP开发，项目中一般都会有图片上传的功能，简单的功能就是头像上传，复杂一点的就是类似于微信朋友圈九宫格图片上传与显示，如果全凭自己手工写的话，费时费力还不一定能有好效果，现在这款神器将祝你一臂之力，让你在图片上传和显示这块尽量花费较少的时间，取得最大的效果！

### **功能点**

 1. 支持本地选择照片以及相机拍摄
 2. 图片压缩，采用[Luban](https://github.com/Curzibn/Luban)算法压缩图片，效果明显
 3. 支持显示网路图片
 4. 支持图片的常规手势操作，放大、缩小等
 5. 仿微信九宫格显示图片
 6. 支持图片删除操作

..............



### **效果演示**

![](http://img.blog.csdn.net/20171111112234163?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

(图1，支持选择照片以及拍照功能)

![](http://img.blog.csdn.net/20171111112712689?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

(图2，支持九宫格显示网络图片)

![](http://img.blog.csdn.net/20171111112823265?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

(图3，支持九宫格显示本地图片)


![](http://img.blog.csdn.net/20171111112856356?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbGlqaV94Yw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

图4，显示大图，支持缩放操作)


![](https://user-gold-cdn.xitu.io/2017/11/13/a8246e89268fd6312e4d25be76057267?w=2060&h=208&f=png&s=89533)

图5，压缩对比)


## **使用方法**


### **gradle引用**

```
compile 'liji.library.dev:takephotolib:2.0.1'
```


### **代码示例（v2.0.0）**

### **获取图片**
```
 
        TakePhoto takePhoto = new TakePhoto(Main2Activity.this);
        takePhoto.setOnPictureSelected(new TakePhoto.onPictureSelected() {
            @Override
            public void select(String path, String compresspath) {
                //path 图片原始地址
                //compresspath 图片压缩地址
            }
        });
        takePhoto.show();
```

### **九宫格展示图片(具体使用方法请看demo)**

```
	//第一步 Activity实现IMakePic接口
	xxActivity implements IMakePic

	//九宫格图片适配器
    MakePicAdapter mMakePicAdapter;
    
    //图片数据集
    ArrayList<PhotoInfo> photoInfos = new ArrayList<>();


   //RecyclerView管理器
    GridLayoutManager mLayoutManager = new GridLayoutManager(this, 3);
    mRecyclerView.setLayoutManager(mLayoutManager);
        
    //设置RecyclerView适配器   
	mMakePicAdapter = new MakePicAdapter(this, photoInfos, this, Constatnt.EDIT);
	mRecyclerView.setAdapter(mMakePicAdapter);

......
```

### **数据结构**
[1、图片信息模型 PhotoInfo结构](https://github.com/crazyandcoder/TakePhoto/blob/master/takephotolib/src/main/java/com/liji/takephoto/PhotoInfo.java)

```
  
    /**
     * 原始图片路径
     */
    private String originalPath;
    
    /**
     * 压缩的图片路径
     */
    private String compressPath;
    
    /**
     * 图片的网络地址
     */
    private String imgUrl;
```

[2、九宫格适配器MakePicAdapter](https://github.com/crazyandcoder/TakePhoto/blob/master/takephotolib/src/main/java/com/liji/takephoto/MakePicAdapter.java)

 
 


----------

### **更新日志**
**V2.0.0版本更新内容（2017.11.11）**

 1. 新增图片压缩
 2. 新增九宫格显示
 3. 拍照及本地图片获取UI改版

**V1.0.2版本更新内容（2016.10.26）**

 1. bug修改
 2. 优化小细节

**V1.0.0版本更新内容（2016.05.13）**

 1. 初始版本发布
 2. 新增图片选择支持本地相册选取以及拍照

### **关于作者**

 

 1. 简书 http://www.jianshu.com/users/18281bdb07ce/latest_articles
 2. 博客 http://crazyandcoder.github.io/
 3. github https://github.com/crazyandcoder
 4. 掘金 https://juejin.im/user/56b96af96240b8005865df59
 

### **感谢**

 - [1、galleryfinal](https://github.com/pengjianbo/GalleryFinal)
 - [2、Luban算法](https://github.com/Curzibn/Luban)

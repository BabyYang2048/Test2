# Test2  
    多个Activity之间来回传递数据，既能够将数据传递给指定的Activity，也能够获得Activity返回的数据。
    属于 Intent 显式启动 （Test3中将会介绍隐式启动） 
    
    注意：因为这是在两个Activity之间进行界面跳转还要传递数据，所以首先第一步你需要在
          Android下 app->manifests->Androidmainfests.xml  文件中添加一个新的Activity
    
    <activity android:name=".SecondActivity">  //新的Activity名
            <intent-filter>
                <action android:name="secondactivity" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
    </activity>
    
    
    ---第一步 创建Intent对象
    Intent intent = new Intent(/** 当前界面Java名 **/.this, /** 跳转界面Java名 **/.class);
    ---第二步 传递参数
    intent.putExtra("/** 要传递的参数你起的名字 **/", /** 要传递的参数的具体值或变量名 **/);
    ---第三步 启动第二个Activity
    startActivityForResult(intent, 0);  
    
    
    然后接收方面
    
    ---创建这样两个方法，在Create()函数中调用
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        setIntent(intent);
        processExtraData();
    }
    private void processExtraData(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("UserId");
        Toast.makeText(this,"用户  "+ name +"  上线了",Toast.LENGTH_LONG).show();
    }
    
    ！！！最好不要直接在create函数中写，因为你的有一个设置可能是singletask，这样可能会导致数据传不过来。
    
    
    本实验因为牵扯到来回传递数据，多个数据可能会导致计算机无法识别，所以要引进requestcode和resultcode两个整型变量来区分。
    具体方法如下：
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==0 && resultCode==0){
            String str = data.getStringExtra("result");
            Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        }
    }
    
    与此方法对应传递参数时的语句是：
    
    startActivityForResult(intent, 0);  
    setResult(0,intent);
    
    ！！！在实践过程中遇到一运行就闪退的问题时一般就是在mainfests.xml文件中没有添加新的Activity，添加之后闪退问题就会解决。
    
    

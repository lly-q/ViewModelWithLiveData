package com.android.viewlmodelrestore;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel { //创建继承ViewModel的子类MyViewModel
    private SavedStateHandle handle; //创建成员变量，类型为SavedStateHandle
    public MyViewModel(SavedStateHandle handle) { //创建一个构造方法,语法请看下方
        if (!handle.contains("NUMBER")){ //解决初始化时出现空错误 如果handle(局部变量)中不包括NUMBER
            handle.set("NUMBER",0); // 则把0赋值到NUMBER，再传入handle(局部变量)
        }
        this.handle = handle; //将handle（局部）传入this.handle（成员）
    }//构造方法末端
    public LiveData<Integer> getNumber() { //写一个获取值的公开方法，返回值类型是LiveData<Integer>，方法名为getNumber，无参数
        return handle.getLiveData("NUMBER");  //返回使用getLiveData获取“NUMBER”常量中的值，传入handle中，首次则取出0
    }
    public void add() { //创建一个公开的加方法，无返回值
        handle.set("NUMBER", (int) handle.get("NUMBER") + 1);
        //将对象类型的handle转化为int类型，再加1，再将这个值放进NUMBER，然后传入handle对象中
    }
}
/*java构造方法必须满足以下语法规则:
*1.方法名必须与类名相同。
*2.不要声明返回类型。
*3.不能被static、final、synchronized、abstract和native修饰。构造方法不能被子类继承,所以用final和abstract修饰没有意义。
*/
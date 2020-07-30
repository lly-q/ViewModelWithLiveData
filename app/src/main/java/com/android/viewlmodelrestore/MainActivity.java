package com.android.viewlmodelrestore;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import com.android.viewlmodelrestore.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding; //创建对象，类型为ActivityMainBinding
    MyViewModel myViewModel; //创建对象，类型为MyViewModel
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main); //设置需要观察layout
        myViewModel = new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this)).get(MyViewModel.class);
        //设置ViewModel
        binding.setData(myViewModel); //设置数据来源
        binding.setLifecycleOwner(this); //设置所属activity，绑定Controller
    }
}
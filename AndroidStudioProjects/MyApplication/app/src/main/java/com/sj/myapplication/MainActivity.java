package com.sj.myapplication;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends FragmentActivity{
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        Fragmentone one=new Fragmentone();
        fm=getSupportFragmentManager();
        FragmentTransaction transaction= fm.beginTransaction();
        transaction.add(R.id.content,one,"one");
        transaction.commit();
    }

  public void one(View v){
      Fragmenttwo two = (Fragmenttwo) fm.findFragmentByTag("two");
      if(null!=two&&two.isVisible()&&two.isAdded()){
          fm.beginTransaction().hide(two).commit();
      }  Fragmentone one = (Fragmentone) fm.findFragmentByTag("one");
      fm.beginTransaction().show(one).commit();

  }
    public void two(View v){
        Fragmentone one = (Fragmentone) fm.findFragmentByTag("one");
        if(null!=one&&one.isVisible()&&one.isAdded()){
            fm.beginTransaction().hide(one).commit();
        }
        Fragmenttwo two = (Fragmenttwo) fm.findFragmentByTag("two");
        if(null!=two){
            fm.beginTransaction().show(two).commit();
        }else{
             two=new Fragmenttwo();
            fm=getSupportFragmentManager();
            FragmentTransaction transaction= fm.beginTransaction();
            transaction.add(R.id.content,two,"two");
            transaction.commit();
        }
    }
}

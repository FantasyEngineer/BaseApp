package com.hjg.baseapp;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.hjg.base.activity.BaseActivity;
import com.hjg.base.manage.TopBarManage;

public class MainActivity extends BaseActivity {

    private RoundMenuView roundMenuView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.topBar);
        TopBarManage topBarManage = new TopBarManage(activity, view);
        topBarManage.iniTop(true, "天气");
        topBarManage.setTopBarBackground(R.color.darkgoldenrod);
        roundMenuView = (RoundMenuView) findViewById(R.id.roundview);

        initRoundView();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void initRoundView() {
        RoundMenuView.RoundMenu roundMenu = new RoundMenuView.RoundMenu();
        roundMenu.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "点击了1", Toast.LENGTH_SHORT).show();
            }
        };
        roundMenuView.addRoundMenu(roundMenu);

        roundMenu = new RoundMenuView.RoundMenu();
        roundMenu.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "点击了2", Toast.LENGTH_SHORT).show();
            }
        };
        roundMenuView.addRoundMenu(roundMenu);

        roundMenu = new RoundMenuView.RoundMenu();
        roundMenu.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "点击了3", Toast.LENGTH_SHORT).show();
            }
        };
        roundMenuView.addRoundMenu(roundMenu);

        roundMenu = new RoundMenuView.RoundMenu();
        roundMenu.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "点击了4", Toast.LENGTH_SHORT).show();
            }
        };
        roundMenuView.addRoundMenu(roundMenu);

//        roundMenuView.setCoreMenu(activity.getResources().getColor(R.color.gray),
//                activity.getResources().getColor(R.color.red), activity.getResources().getColor(R.color.red)
//                , 1, 0.43, ConvertUtils.drawable2Bitmap(getResources().getDrawable(R.mipmap.ic_launcher)), new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(activity, "点击了中心圆圈", Toast.LENGTH_SHORT).show();
//                    }
//                });


    }

    @Override
    protected boolean isAllowSwipExit() {
        return false;
    }

    @Override
    protected boolean isStateBarTransparent() {
        return true;
    }
}

package com.jsqix.dq.zhima;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jsqix.dq.zhima.credit_9.InstrumentView;
import com.jsqix.dq.zhima.credit_9_5.SesameCreditPanel;
import com.jsqix.dq.zhima.credit_9_5.SesameItemModel;
import com.jsqix.dq.zhima.credit_9_5.SesameModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd");
    private SesameCreditPanel panel;

    private InstrumentView iView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iView = (InstrumentView) findViewById(R.id.iView);
        final TextView txtView = (TextView) findViewById(R.id.txtView);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                iView.setReferValue(682, new InstrumentView.RotateListener() {
                    @Override
                    public void rotate(float sweepAngle, final float value) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                txtView.setText(Math.round(value) + "");
                            }
                        });
                    }
                });
            }
        }, 1000);

        panel= (SesameCreditPanel) findViewById(R.id.panel);
        panel.setDataModel(getData());
    }

    public SesameModel getData() {
        SesameModel model = new SesameModel();
        model.setUserTotal(752);
        model.setAssess("信用良好");
        model.setTotalMin(350);
        model.setTotalMax(950);
        model.setFirstText("BETA");
        model.setTopText("因为信用 所以简单");
        model.setFourText("评估时间:" + formater.format(new Date()));
        ArrayList<SesameItemModel> sesameItemModels = new ArrayList<SesameItemModel>();

        SesameItemModel ItemModel350 = new SesameItemModel();
        ItemModel350.setArea("较差");
        ItemModel350.setMin(350);
        ItemModel350.setMax(550);
        sesameItemModels.add(ItemModel350);

        SesameItemModel ItemModel550 = new SesameItemModel();
        ItemModel550.setArea("中等");
        ItemModel550.setMin(550);
        ItemModel550.setMax(600);
        sesameItemModels.add(ItemModel550);

        SesameItemModel ItemModel600 = new SesameItemModel();
        ItemModel600.setArea("良好");
        ItemModel600.setMin(600);
        ItemModel600.setMax(650);
        sesameItemModels.add(ItemModel600);

        SesameItemModel ItemModel650 = new SesameItemModel();
        ItemModel650.setArea("优秀");
        ItemModel650.setMin(650);
        ItemModel650.setMax(700);
        sesameItemModels.add(ItemModel650);

        SesameItemModel ItemModel700 = new SesameItemModel();
        ItemModel700.setArea("较好");
        ItemModel700.setMin(700);
        ItemModel700.setMax(950);
        sesameItemModels.add(ItemModel700);

        model.setSesameItemModels(sesameItemModels);
        return model;
    }
}

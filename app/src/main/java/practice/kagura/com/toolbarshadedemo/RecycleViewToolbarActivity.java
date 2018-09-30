package practice.kagura.com.toolbarshadedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import practice.kagura.com.toolbarshadedemo.adapter.DataAdapter;

public class RecycleViewToolbarActivity extends AppCompatActivity {

    private List<String> data;
    private RecyclerView rvData;
    private TextView title;
    private Toolbar toolbar;
    private int mDistanceY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_toolbar);
        initData();
        initView();
    }

    private void initView() {
        title = findViewById(R.id.title);
        toolbar = findViewById(R.id.toolbar);
        rvData = findViewById(R.id.recyclerview);
        DataAdapter adapter = new DataAdapter(this);
        rvData.setLayoutManager(new LinearLayoutManager(this));
        rvData.setAdapter(adapter);
        adapter.setData(data);

        rvData.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mDistanceY = mDistanceY + dy;// 累加y值 解决滑动一半y值为0
                if (mDistanceY <= 0) {   //设置标题的背景颜色
                    toolbar.getBackground().setAlpha(0);
                    title.setAlpha(0);
                } else if (mDistanceY > 0 && mDistanceY <= 600) {
                    //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
                    float scale = (float) mDistanceY / 600;
                    float alpha = (255 * scale);
                    toolbar.getBackground().setAlpha((int)alpha);
                    title.setAlpha((int)alpha);
                } else {
                    toolbar.getBackground().setAlpha(255);
                    title.setAlpha(255);
                }
            }

        });
    }

    private void initData() {
        data = new ArrayList<>();
        for(int i = 0;i < 50;i ++){
            data.add("Data" + i);
        }
    }

    public static void startActivity(Activity activity){
        Intent intent = new Intent(activity,RecycleViewToolbarActivity.class);
        activity.startActivity(intent);
    }
}

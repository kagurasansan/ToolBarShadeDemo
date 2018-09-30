package practice.kagura.com.toolbarshadedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class ScrollviewToolbarActivity extends AppCompatActivity {

    private ScrollView scrollView;
    private TextView title;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview_toolbar);
        initView();
    }

    private void initView() {
        title = findViewById(R.id.title);
        toolbar = findViewById(R.id.toolbar);
        toolbar.getBackground().setAlpha(0);
        scrollView = findViewById(R.id.scrollView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    if (scrollY <= 0) {   //设置标题的背景颜色
                        toolbar.getBackground().setAlpha(0);
                        title.setAlpha(0);
                    } else if (scrollY > 0 && scrollY <= 600) {
                        //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
                        float scale = (float) scrollY / 600;
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


    }

    public static void startActivity(Activity activity){
        Intent intent = new Intent(activity,ScrollviewToolbarActivity.class);
        activity.startActivity(intent);
    }
}

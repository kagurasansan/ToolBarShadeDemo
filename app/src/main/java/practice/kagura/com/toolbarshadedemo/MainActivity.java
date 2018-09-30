package practice.kagura.com.toolbarshadedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_rv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecycleViewToolbarActivity.startActivity(MainActivity.this);
            }
        });
        findViewById(R.id.bt_sc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScrollviewToolbarActivity.startActivity(MainActivity.this);
            }
        });
    }
}

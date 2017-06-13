package scut.carson_ho.ndk_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity  {

    // 步骤1:加载生成的so库文件
    // 注意要跟so库文件名相同
    static {

        System.loadLibrary("hello_jni");
    }

    // 步骤2:定义在JNI中实现的方法
    public native String getFromJNI();

    private Button Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 通过Button调用JNI中的方法
        Button = (Button) findViewById(R.id.button);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button.setText(getFromJNI());

            }
        });
    }


}

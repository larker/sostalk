package com.larkersos.sostalk.activity;

import android.view.KeyEvent;
import android.widget.Toast;

public class BaseContentActivity extends BaseActivity {
	// 退出事件时间
	public long exitTime = 0;
	public long exitSeparateTime = 1000*2;

	// 再按一次返回键退出程序
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > exitSeparateTime) {
				Toast.makeText(getApplicationContext(), "再按一次退出程序",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				finish();
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}

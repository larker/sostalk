package com.larkersos.sostalk.activity;

import android.view.KeyEvent;
import android.widget.Toast;

public class BaseContentActivity extends BaseActivity {
	// �˳��¼�ʱ��
	public long exitTime = 0;
	public long exitSeparateTime = 1000*2;

	// �ٰ�һ�η��ؼ��˳�����
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > exitSeparateTime) {
				Toast.makeText(getApplicationContext(), "�ٰ�һ���˳�����",
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

package com.larkersos.sostalk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.larkersos.sostalk.R;

public class AboutUsDialog extends Dialog implements android.view.View.OnClickListener{
	
	private Context context = null;
	private Button okBtn = null;
	public AboutUsDialog(Context context) {
		super(context);
		this.context = context;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_us_dialog_layout);
		
		// 消息提示标题
		setTitle(context.getString(R.string.about));
		
		// 确认关闭按钮
		okBtn = (Button)findViewById(R.id.okBtn);
		okBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View btn) {
		this.dismiss();
	}

}

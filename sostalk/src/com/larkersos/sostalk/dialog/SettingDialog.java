package com.larkersos.sostalk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.larkersos.sostalk.R;
import com.larkersos.sostalk.utils.Constant;

public class SettingDialog extends Dialog implements OnItemSelectedListener,android.view.View.OnClickListener{
	private Context context = null;
	private int[] headIconIds = {R.drawable.black_bird,
								R.drawable.blue_bird,
								R.drawable.green_bird,
								R.drawable.green_pig,
								R.drawable.pig_egg,
								R.drawable.red_bird,
								R.drawable.white_bird,
								R.drawable.yellow_bird};
	private SpinAdapter adapter = null;
	// 头像spinner
	private Spinner spin = null;
	// 分组spinner
	private Spinner spinGroup= null;
	
	private int headIconPos = 0;
	private Button okBtn = null;
	private Button cancelBtn = null;
	private SharedPreferences pre = null;
	private SharedPreferences.Editor editor = null;
	
	public SettingDialog(Context context) {
		super(context);
		this.context = context;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_dialog_layout);
		
		// 标题
		setTitle(context.getString(R.string.set_dialog_title));
		
		// 头像
		adapter = new SpinAdapter();
		spin = (Spinner)findViewById(R.id.spinner1);
		spin.setOnItemSelectedListener(this);
		spin.setAdapter(adapter);
		spin.setPrompt(context.getString(R.string.headicontitle));
		
		// 分组
		ArrayAdapter<CharSequence> adapterGroup = ArrayAdapter.createFromResource(this.context, R.array.groupIndicatorLabeles, android.R.layout.simple_spinner_item);
		adapterGroup.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinGroup = (Spinner)findViewById(R.id.spinner2);
		spinGroup.setOnItemSelectedListener(this);
		spinGroup.setAdapter(adapterGroup);
		spinGroup.setPrompt(context.getString(R.string.groupicontitle));
		
		okBtn = (Button)findViewById(R.id.okBtn);
		okBtn.setOnClickListener(this);
		cancelBtn = (Button)findViewById(R.id.cancelBtn);
		cancelBtn.setOnClickListener(this);
		
		pre = PreferenceManager.getDefaultSharedPreferences(context);
		editor = pre.edit();
		
		restoreData();
	}

	private class SpinAdapter implements SpinnerAdapter{

		@Override
		public int getCount() {
			return headIconIds.length;
		}

		@Override
		public Object getItem(int pos) {
			return null;
		}

		@Override
		public long getItemId(int pos) {
			return 0;
		}

		@Override
		public int getItemViewType(int pos) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			convertView = getLayoutInflater().inflate(R.layout.head_image_spinner_layout, null);
			ImageView hicon = (ImageView)convertView.findViewById(R.id.headericon);
			hicon.setImageResource(headIconIds[position]);
			TextView hnote = (TextView)convertView.findViewById(R.id.headernote);
			hnote.setText(context.getString(R.string.header)+position);
			hnote.setTextColor(Color.BLACK);
			return convertView;
		}

		@Override
		public int getViewTypeCount() {
			return 0;
		}

		@Override
		public boolean hasStableIds() {
			return false;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@Override
		public void registerDataSetObserver(DataSetObserver arg0) {
			
		}

		@Override
		public void unregisterDataSetObserver(DataSetObserver arg0) {
			
		}

		@Override
		public View getDropDownView(int position, View convertView, ViewGroup parent) {
			return getView(position, convertView, parent);
		}
		
	}


	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		headIconPos = position;
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
	}

	@Override
	public void onClick(View btn) {
		switch(btn.getId()){
		case R.id.okBtn:
			saveSettings();
			break;
		case R.id.cancelBtn:
			break;
		}
		dismiss();
	}
	
	private void saveSettings(){
		EditText nikeName = (EditText)findViewById(R.id.nicke_name);
		editor.putString("nickeName", nikeName.getText().toString());
		editor.putInt("headIconPos", headIconPos);
		editor.putInt("headIconId", headIconIds[headIconPos]);
		editor.putInt("groupId", spinGroup.getSelectedItemPosition());
		editor.commit();
		Intent intent = new Intent();
		intent.setAction(Constant.updateMyInformationAction);
		context.sendBroadcast(intent);
	}
	
	private void restoreData(){
		EditText nikeName = (EditText)findViewById(R.id.nicke_name);
		nikeName.setText(pre.getString("nickeName", "输入你的昵称"));
		headIconPos = pre.getInt("headIconPos", 0);
		spin.setSelection(headIconPos);
	}
}

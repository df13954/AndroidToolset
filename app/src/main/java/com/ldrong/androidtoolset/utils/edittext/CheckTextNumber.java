package com.ldrong.androidtoolset.utils.edittext;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class CheckTextNumber {
	/**
	 * 
	 * @param et 编辑控件
	 * @param tv 显示剩余数字
	 * @param num 显示个数
	 */
	public static void setEditTextChangeListener(final EditText et,final TextView tv,final int num){
		et.addTextChangedListener(new TextWatcher() {
			 private CharSequence temp;
	         private int selectionStart;
	         private int selectionEnd;
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				temp = s;
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int arg1, int arg2,
					int arg3) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				
				int number = 0 + s.length();
				tv.setText(number + "/" + num);

               selectionStart = et.getSelectionStart();
               selectionEnd = et.getSelectionEnd();
               //System.out.println("start="+selectionStart+",end="+selectionEnd);
               if (temp.length() > num) {
                   s.delete(selectionStart - 1, selectionEnd);
                   int tempSelection = selectionStart;
//                   et.setText(s);
                   et.removeTextChangedListener(this);
                   et.setText(s);  
                   et.addTextChangedListener(this);  
                   et.setSelection(tempSelection);
               }
			}
		});
	}
	public static void setlastEditTextChangeListener(final EditText et,final TextView tv,final int num){
		et.addTextChangedListener(new TextWatcher() {
			 private CharSequence temp;
	         private int selectionStart;
	         private int selectionEnd;
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				temp = s;
			}

			@Override
			public void beforeTextChanged(CharSequence s, int arg1, int arg2,
					int arg3) {
			}

			@Override
			public void afterTextChanged(Editable s) {

				int number = 0 + s.length();
				tv.setText(String.valueOf(num - number));

               selectionStart = et.getSelectionStart();
               selectionEnd = et.getSelectionEnd();
               //System.out.println("start="+selectionStart+",end="+selectionEnd);
               if (temp.length() > num) {
                   s.delete(selectionStart - 1, selectionEnd);
                   int tempSelection = selectionStart;
//                   et.setText(s);
                   et.removeTextChangedListener(this);
                   et.setText(s);
                   et.addTextChangedListener(this);
                   et.setSelection(tempSelection);
               }
			}
		});
	}
}

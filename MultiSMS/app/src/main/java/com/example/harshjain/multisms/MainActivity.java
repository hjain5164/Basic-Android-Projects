package com.example.harshjain.multisms;

import android.Manifest;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static android.app.LauncherActivity.*;

public class MainActivity extends AppCompatActivity {
ListView list;
EditText message,n,c;
Button send,refresh,add;
List<String> check;
//SharedPreferences sp;
String name[] = {"Harsh", "Hitesh", "Shrinath","Papa","Mummy","Saral sir","Pradyumna","Jio","Ankit","Vinisha"};
String no[] = {"8225835298", "8109681641", "7350580836","9826505252","9977489948","8602793619","8839143506","8839834426","8871381819","7987823669"};
//String temp = "",adddetails=null;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.list);
        message = (EditText)findViewById(R.id.message);
        send = (Button)findViewById(R.id.send);
//        n = (EditText)findViewById(R.id.name);
//        c = (EditText)findViewById(R.id.number);
//        refresh = (Button)findViewById(R.id.refersh);
//        add = (Button)findViewById(R.id.add);
//       /* sp = getSharedPreferences("MYprefs", Context.MODE_PRIVATE);
        //temp = sp.getString("MYprefs", null);
        final ArrayList<String> lst = new ArrayList<>();
        for (int i = 0; i < name.length; i++)
            lst.add(name[i] + "\n" + no[i]);
  /*      if(temp !=null)
        {
            lst.add(temp);
        }
*/
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},0);
        }


        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice, lst);
        list.setAdapter(adapter);
        list.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    check = new ArrayList<>();
                    SparseBooleanArray checked = list.getCheckedItemPositions();
                    for (int j = 0; j < checked.size(); j++) {
                        if(checked.valueAt(j) == true) {
                            String tag = String.valueOf(list.getItemAtPosition(checked.keyAt(j)));
                            check.add(tag);
                        }
                        else
                        {
                            check.remove(j);

                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    for (String s : check)
                    {
                        sb.append(s);
                        sb.append("\n");
                    }
                    String msg = message.getText().toString();
                    String f = sb.toString();
                    String no[];
                    no = f.split("\n");
                    SmsManager sms = SmsManager.getDefault();
                    for(int k=1; k<no.length;k+=2) {
                            sms.sendTextMessage(no[k],null,msg,null,null);
                    }
                    Toast.makeText(MainActivity.this, "Msg Send", Toast.LENGTH_SHORT).show();

                }
            });
  /*      add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = n.getText().toString(); //name
                String b = c.getText().toString(); //number
                //temp = sp.getString("MYprefs", null);
                if(adddetails==null)
                adddetails = a+"\n"+b;
                else
                    adddetails +="\n"+a+"\n"+b;
                Toast.makeText(MainActivity.this, adddetails, Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("MYprefs", adddetails);
                editor.clear();
                editor.commit();
                Toast.makeText(MainActivity.this,"Hey, value you entered is saved", Toast.LENGTH_SHORT).show();
                //  lst.add(a+"\n"+b);
                //Toast.makeText(MainActivity.this, "Contact Added\nClick Refresh", Toast.LENGTH_SHORT).show();
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sp = getSharedPreferences("MYprefs", Context.MODE_PRIVATE);
                temp = sp.getString("MYprefs", null);
                if(temp!=null) {
                    String [] t = temp.split("\n");
                    for(int k=0;k<t.length-1;k+=2)
                    {
                        lst.add(t[k]+"\n"+t[k+1]);
                    }
                }
                Toast.makeText(MainActivity.this, "Refreshed", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();

            }
        });*/
    }
}

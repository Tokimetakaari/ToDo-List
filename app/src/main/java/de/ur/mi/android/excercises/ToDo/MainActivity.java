package de.ur.mi.android.excercises.ToDo;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList todoItems = new ArrayList<String>();
    ArrayAdapter aa;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Button button = (Button) findViewById(R.id.add);
      button.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
             setAdapter();
             addToList();
             clearEntry();
             clearList();
         }
      });


   }





      private void setAdapter() {
          ListView myTaskList = (ListView) findViewById(R.id.list);
          aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
          myTaskList.setAdapter(aa);
          aa.notifyDataSetChanged();

  }

   private void addToList() {
      todoItems.add(getTask());

   }

   private void clearEntry() {
      EditText task = (EditText) findViewById(R.id.edit_task);
      task.setText("");

   }

   private String getTask() {
       EditText task = (EditText) findViewById(R.id.edit_task);
       if (task.getText().toString().isEmpty()) {
           return "U really should type Sht in it";
       } else {
           return task.getText().toString();
       }
   }


   private void clearList() {
       Button clear_button = (Button) findViewById(R.id.test);
       clear_button.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               ListView myTaskList = (ListView) findViewById(R.id.list);
               myTaskList.setAdapter(null);
               todoItems.clear();
               aa.notifyDataSetChanged();
           }
       });
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }

    }



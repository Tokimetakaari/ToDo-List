package de.ur.mi.android.excercises.ToDo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends Activity
{
    static ArrayList todoItems = new ArrayList<Tasks>();
    static ArrayAdapter aa;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Button button = (Button) findViewById(R.id.add);
      button.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
             setAdapter();
             addToList();
             clearList();
         }
      });
   }

      private void setAdapter() {
          ListView myTaskList = (ListView) findViewById(R.id.list);
          aa = new ArrayAdapter<Tasks>(this, android.R.layout.simple_list_item_1, todoItems);
          myTaskList.setAdapter(aa);
          aa.notifyDataSetChanged();

  }

   private void addToList() {
      Button addButton = (Button) findViewById(R.id.add);
      addButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent i = new Intent(MainActivity.this, AddTask.class);
              startActivity(i);
          }
      });

   }

   static public void addTask (Tasks task)
   {
        todoItems.add(task);
        aa.notifyDataSetChanged();
   }

   private void clearList() {
       Button clear_button = (Button) findViewById(R.id.clear);
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



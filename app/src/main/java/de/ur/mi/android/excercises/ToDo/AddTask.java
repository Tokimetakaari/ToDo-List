package de.ur.mi.android.excercises.ToDo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTask extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);
    }

    @Override
    public void onClick(View view)
    {
        Intent i = new Intent(AddTask.this, MainActivity.class);
        switch (view.getId())
        {
            case R.id.create_add: createTask();
                                  startActivity(i);
                break;
            case R.id.create_back: startActivity(i);
                break;
        }
    }

    private void createTask()
    {
        EditText taskname = (EditText) findViewById(R.id.nameText);
        String name = taskname.getText().toString();
        EditText taskdate = (EditText) findViewById(R.id.dateText);
        String date = taskdate.getText().toString();
        EditText tasknote = (EditText) findViewById(R.id.noteText);
        String note = tasknote.getText().toString();
        Tasks task = new Tasks(date, name, note);
        MainActivity.addTask(task);
    }
}

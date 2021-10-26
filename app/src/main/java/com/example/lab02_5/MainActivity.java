package com.example.lab02_5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<Employee> employees;
    private EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ViewByID
        final EditText etID=(EditText) findViewById(R.id.et_id);
        final EditText etFullname=(EditText) findViewById(R.id.et_fullname);
        final CheckBox cbManager=(CheckBox) findViewById(R.id.cb_manager);
        Button btnAdd=(Button) findViewById(R.id.btn_add);
        ListView lvEmployee=(ListView) findViewById(R.id.lv_employee);

        // Init data
        employees=new ArrayList<>();
        employeeAdapter=new EmployeeAdapter(MainActivity.this, 1, employees);

        // Set adapter for lvEmployee
        lvEmployee.setAdapter(employeeAdapter);

        // Handle clicks btnAdd
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Init new employee
                Employee employee=new Employee();
                employee.setId(etID.getText().toString());
                employee.setFullName(etFullname.getText().toString());
                employee.setManager(cbManager.isChecked());

                // Add new employee to list
                employees.add(employee);

                // Update new data to listview
                employeeAdapter.notifyDataSetChanged();

                // Remove added data
                etFullname.setText("");
                etID.setText("");
                cbManager.setChecked(false);
                // Focus to etID
                etID.requestFocus();
            }
        });

    }
}

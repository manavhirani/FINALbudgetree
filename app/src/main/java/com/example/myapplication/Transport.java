package com.example.myapplication;


import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Transport extends AppCompatActivity {
    Button Addtransport, btview;
    EditText edtransport;
    TextView tv;
    DatabaseHelper db;
   // public static int bal = 1000;
    //int samp=bal;
    //public static int samp1 = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        db = new DatabaseHelper(this);
        Addtransport = (Button) findViewById(R.id.button5);
        edtransport = (EditText) findViewById(R.id.transport);
        tv = (TextView) findViewById(R.id.textView8);
        AddData();
        //view();

    }

    public void AddData() {
        Addtransport.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean isInserted2 = db.insertData2(edtransport.getText().toString());

                        if (isInserted2 == true) {
                            Toast.makeText(Transport.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            int a = Integer.parseInt(edtransport.getText().toString());

                            Initialize.cashbalance = Initialize.cashbalance - a;


                        }

                        tv.setText(Integer.toString(Initialize.cashbalance));


                    }
                });
    }

   /* public void view() {
        btview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = db.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            Toast.makeText(Transport.this, "Nothing found", Toast.LENGTH_LONG).show();
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {





                            if(Integer.parseInt(res.getString(1))!=0) {
                                buffer.append("Transport :" + res.getString(1) + "\n");
                            }
                            if(Integer.parseInt(res.getString(2))!=0) {
                                buffer.append("Entertainment :" + res.getString(2) + "\n");
                            }
                            if(Integer.parseInt(res.getString(3))!=0) {
                                buffer.append("Household :" + res.getString(3) + "\n");
                            }
                            if(Integer.parseInt(res.getString(4))!=0) {
                                buffer.append("Shopping :" + res.getString(4) + "\n\n");
                            }
                            if(Integer.parseInt(res.getString(5))!=0) {
                                buffer.append("Food :" + res.getString(5) + "\n");
                            }
                            if(Integer.parseInt(res.getString(6))!=0) {
                                buffer.append("Others :" + res.getString(6) + "\n");
                            }


                        }

                        showMessage("Data",buffer.toString());


                    }


                });

    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
*/


}
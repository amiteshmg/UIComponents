package com.example.aadyam.uicomponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;


//import com.example.aadyam.uicomponentsdemo.R;

import java.util.ArrayList;

public class Register extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{

    RadioButton radioButton;
    RadioGroup radioGroup;
    Button button;
    EditText editText;
    CheckBox checkbox1,checkbox2,checkbox3,checkbox4;

    //dummy code


    String spinnerItem,name,categories,toggleoption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Intent intent=new Intent(Register.this,TimeSelectActivity.class);
        categories="";
        checkbox1=(CheckBox)findViewById(R.id.hindi_checkbox);
        checkbox2=(CheckBox)findViewById(R.id.english_checkbox);
        checkbox3=(CheckBox)findViewById(R.id.marathi_checkbox);
        checkbox4=(CheckBox)findViewById(R.id.tamil_checkbox);

        editText=(EditText)findViewById(R.id.name_edit);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    // The toggle is enabled
                    toggleoption=" ToggleChoice selected = ON ";
                }

                else
                    {

                        //Toggle is disabled
                        toggleoption="ToggleChoice selected =OFF";

                    }
            }
        });



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cities, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spin.setAdapter(adapter);


        radioGroup=(RadioGroup) findViewById(R.id.radiogroup);
        button=(Button)findViewById(R.id.submit);


        //radiobutton and radiogroup implementation

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // onCheckboxClicked((Button)v);

               if(checkbox1.isChecked())
                {
                    categories+=checkbox1.getText().toString();
                }

                if(checkbox2.isChecked())
                {
                    categories+=checkbox2.getText().toString();
                }

                if(checkbox3.isChecked())
                {
                    categories+=checkbox3.getText().toString();
                }

                if(checkbox4.isChecked()) {
                    categories += checkbox4.getText().toString();
                }


                name=editText.getText().toString();
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton=(RadioButton)findViewById(selectedId);
                Toast.makeText(Register.this,"name : "+name+" Gender: "+ radioButton.getText()+" City :"+spinnerItem+" Categories: "+categories+toggleoption, Toast.LENGTH_SHORT).show();
            }
        });

        startActivity(intent);



    }



    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
    {

        // An item was selected. You can retrieve the selected item using

        spinnerItem=(String)parent.getItemAtPosition(pos);

        //Toast.makeText(this,spinner_option,Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


  /*  public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.hindi_checkbox:
                if (checked)
                {
                    categories+=checkbox1.getText().toString();
                }
                // Put some meat on the sandwich
            else
                // Remove the meat
                break;
            case R.id.english_checkbox:
                if (checked)
                {
                    categories+=checkbox2.getText().toString();
                }
                // Cheese me

            case R.id.marathi_checkbox:
                if (checked)
            {
                categories+=checkbox3.getText().toString();
            }


            case R.id.tamil_checkbox:

                if(checked)
                {
                    categories+=checkbox4.getText().toString();
                }
            break;

            default:
                categories+="Select atleast 1 category";
                break;



                // I'm lactose intolerant

            // TODO: Veggie sandwich
        }

    }
    */

}

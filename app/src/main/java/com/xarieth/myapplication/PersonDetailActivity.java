package com.xarieth.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PersonDetailActivity extends AppCompatActivity {

    String person_id, person_first_name, person_last_name, person_birthday, person_email, person_mobilenumber, person_address, person_contactperson, person_contactpersonnumber;
    TextView txt_person_id, txt_person_first_name, txt_person_last_name, txt_person_birthday, txt_age, txt_person_email, txt_person_mobilenumber, txt_person_address, txt_person_contactperson, txt_person_contactpersonnumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        if (getIntent().getExtras() != null) {
            person_id = getIntent().getStringExtra("person_id");
            person_first_name = getIntent().getStringExtra("person_first_name");
            person_last_name = getIntent().getStringExtra("person_last_name");
            person_birthday = getIntent().getStringExtra("person_birthday");
            person_email = getIntent().getStringExtra("person_email");
            person_mobilenumber = getIntent().getStringExtra("person_mobilenumber");
            person_address = getIntent().getStringExtra("person_address");
            person_contactperson = getIntent().getStringExtra("person_contactperson");
            person_contactpersonnumber = getIntent().getStringExtra("person_contactpersonnumber");
        }

        txt_person_id = (TextView) findViewById(R.id.person_id);
        txt_person_first_name = (TextView) findViewById(R.id.person_first_name);
        txt_person_last_name = (TextView) findViewById(R.id.person_last_name);
        txt_person_birthday = (TextView) findViewById(R.id.person_birthday);
        txt_age = (TextView) findViewById(R.id.person_age);
        txt_person_email = (TextView) findViewById(R.id.person_email);
        txt_person_mobilenumber = (TextView) findViewById(R.id.person_number);
        txt_person_address = (TextView) findViewById(R.id.person_address);
        txt_person_contactperson = (TextView) findViewById(R.id.person_contact_person);
        txt_person_contactpersonnumber = (TextView) findViewById(R.id.person_contact_person_number);

        txt_person_id.setText(person_id);
        txt_person_first_name.setText(person_first_name);
        txt_person_last_name.setText(person_last_name);
        txt_person_birthday.setText(person_birthday);
        txt_person_email.setText(person_email);
        txt_person_mobilenumber.setText(person_mobilenumber);
        txt_person_address.setText(person_address);
        txt_person_contactperson.setText(person_contactperson);
        txt_person_contactpersonnumber.setText(person_contactpersonnumber);


        txt_age.setText(String.valueOf(getAge(person_birthday)));

    }

    public static int getAge(String dateOfBirth) {

        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();

        int age = 0;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        birthDate.setTime(convertedDate);
        if (birthDate.after(today)) {
            throw new IllegalArgumentException("Can't be born in the future");
        }

        age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

        // If birth date is greater than todays date (after 2 days adjustment of
        // leap year) then decrement age one year
        if ((birthDate.get(Calendar.DAY_OF_YEAR)
                - today.get(Calendar.DAY_OF_YEAR) > 3)
                || (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
            age--;

            // If birth date and todays date are of same month and birth day of
            // month is greater than todays day of month then decrement age
        } else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
                && (birthDate.get(Calendar.DAY_OF_MONTH) > today
                .get(Calendar.DAY_OF_MONTH))) {
            age--;
        }

        return age;
    }

}

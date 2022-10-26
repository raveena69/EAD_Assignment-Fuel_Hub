package com.example.eadassignment_fuelhub.stationOwner;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import com.example.eadassignment_fuelhub.R;
import com.example.eadassignment_fuelhub.stationOwner.Database.DatabaseHelper;
import com.example.eadassignment_fuelhub.stationOwner.Database.StationOwner;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {


    private final AppCompatActivity activity = RegisterActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout lay_Name;
    private TextInputLayout lay_Email;
    private TextInputLayout lay_Password;
    private TextInputLayout lay_ConfPassword;

    private EditText et_Name;
    private EditText et_Email;
    private EditText et_Password;
    private EditText et_ConfPassword;

    private AppCompatButton appCompatButtonRegister;
    private AppCompatTextView appCompatTextViewLoginLink;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private StationOwner stationOwner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    private void initViews() {
        nestedScrollView = findViewById(R.id.nestedScrollView);
        lay_Name = findViewById(R.id.lay_Name);
        lay_Email = findViewById(R.id.lay_Email);
        lay_Password = findViewById(R.id.lay_Password);
        lay_ConfPassword = findViewById(R.id.lay_ConfPassword);
        et_Name = findViewById(R.id.et_Name);
        et_Email = findViewById(R.id.et_Email);
        et_Password = findViewById(R.id.et_Password);
        et_ConfPassword = findViewById(R.id.et_ConfPassword);
        appCompatButtonRegister = findViewById(R.id.appCompatButtonRegister);
        appCompatTextViewLoginLink = findViewById(R.id.appCompatTextViewLoginLink);

    }


    private void initListeners() {
        appCompatButtonRegister.setOnClickListener(this);
        appCompatTextViewLoginLink.setOnClickListener(this);

    }


    private void initObjects() {
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        stationOwner = new StationOwner();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.appCompatButtonRegister:
                postDataToSQLite();
                break;

            case R.id.appCompatTextViewLoginLink:
                finish();
                break;
        }
    }


    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(et_Name, lay_Name, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(et_Email, lay_Email, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(et_Email, lay_Email, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(et_Password, lay_Password, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(et_Password, et_ConfPassword,
                lay_ConfPassword, getString(R.string.error_password_match))) {
            return;
        }

        if (!databaseHelper.checkUser(et_Email.getText().toString().trim())) {

            stationOwner.setName(et_Name.getText().toString().trim());
            stationOwner.setEmail(et_Email.getText().toString().trim());
            stationOwner.setPassword(et_Password.getText().toString().trim());

            databaseHelper.addUser(stationOwner);

            // Snack Bar to show success message that record saved successfully
            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();


        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }


    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        et_Name.setText(null);
        et_Email.setText(null);
        et_Password.setText(null);
        et_ConfPassword.setText(null);
    }
}
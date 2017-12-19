package strathmore.com.thelocator.date;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.joda.time.LocalDateTime;

import java.util.Date;

import strathmore.com.thelocator.login.LoginPage;
import strathmore.com.thelocator.MainActivity;
import strathmore.com.thelocator.R;

public class PlanVisit extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    // State key
    private static final String STATE_LOCAL_DATE_TIME = "state.local.date.time";
    /**
     *
     */
    private LocalDateTime mLocalDateTime = new LocalDateTime();


    Context context;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Bundle exists if we are being recreated
        if (savedInstanceState != null) {
            mLocalDateTime = (LocalDateTime)savedInstanceState.getSerializable(STATE_LOCAL_DATE_TIME);
        }
        setContentView(R.layout.plan_a_visit);

        Button btnplanvisit = (Button) findViewById(R.id.planvisit);
        btnplanvisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Insert the intent that it is to go to
                Intent intent = new Intent(PlanVisit.this, LoginPage.class);

                startActivity(intent);
            }
        });


        // Create the Date/Time text view
        createTextViewDateTime();

        // Create the choose date/time button
        createButtonChooseDateTime();





    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(STATE_LOCAL_DATE_TIME, mLocalDateTime);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mLocalDateTime = (LocalDateTime)savedInstanceState.getSerializable(STATE_LOCAL_DATE_TIME);
    }


    private void createTextViewDateTime() {
        TextView textView = (TextView)findViewById(R.id.datepicked);
        textView.setText(formatDateString(mLocalDateTime));
    }

    private void updateDateTimeTextView() {
        TextView textView = (TextView) findViewById(R.id.datepicked);
        textView.setText(formatDateString(mLocalDateTime));
    }

    private void createButtonChooseDateTime() {
        Button button = (Button)findViewById(R.id.datepick);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                // If there is already a Date displayed, use that.
                Date dateToUse = (mLocalDateTime == null) ? new LocalDateTime().toDate() : mLocalDateTime.toDate();
                DateTimeFragment dateFragment =
                        FragmentFactory.createDatePickerFragment(dateToUse, "The", DateTimeFragment.BOTH,
                                new DateTimeFragment.ResultHandler() {
                                    @Override
                                    public void setDate(Date result) {
                                        mLocalDateTime = new LocalDateTime(result.getTime());
                                        updateDateTimeTextView();
                                    }
                                });
                dateFragment.show(fragmentManager, DateTimeFragment.DIALOG_TAG);
            }
        });
    }

    private String formatDateString(LocalDateTime localDateTime) {
        return localDateTime.toString("MM/dd/yyyy hh:mm a");
    }

    private View safeFindViewById(int viewId) {
        final String METHOD = "createButtonChooseDateTime(" + viewId + ")";
        View ret = findViewById(viewId);
        if (ret == null) {
            Log.e(TAG, METHOD + "Something has gone horribly wrong.");
        }
        return ret;
    }





}

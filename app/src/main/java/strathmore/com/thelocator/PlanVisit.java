package strathmore.com.thelocator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlanVisit extends AppCompatActivity {

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_a_visit);

        Button btnplanvisit = (Button) findViewById(R.id.planvisit);
        btnplanvisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Insert the intent that it is to go to
                Intent intent = new Intent(PlanVisit.this, LogInActivity.class);

                startActivity(intent);
            }
        });
    }
}

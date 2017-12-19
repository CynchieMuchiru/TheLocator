package strathmore.com.thelocator.date;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

/**
 * Created by Cece on 19/12/2017.
 */

public abstract class AbstractDialogFragment extends DialogFragment {
   protected abstract void processFragmentArguments();

    @Override
    public abstract Dialog onCreateDialog(Bundle savedInstanceState);

    protected abstract void saveInstanceState(Bundle outState);

    protected abstract void restoreInstanceState(Bundle savedInstanceState);

    @Override
    public void onSaveInstanceState(Bundle outState) {
        saveInstanceState(outState);
    }
}

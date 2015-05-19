package net.weirdblackmagic.clotherswe;

/**
 * Created by ysengrimm on 19.05.15.
 */
import android.content.Context;
import android.os.AsyncTask;
import de.ovgu.cse.se.ClotherAPI.ConfigurationContext;
import de.ovgu.cse.se.ClotherAPI.IObjectProvider;
import de.ovgu.cse.se.ClotherAPI.ObjectProviderFactory;
import de.ovgu.cse.se.ClotherAPI.exceptions.UserdataNotCorrectException;

public class DatabaseConnector extends AsyncTask<String, Void, Boolean> {

    Context context;
    IObjectProvider provider;

    public DatabaseConnector(Context context) { }

    @Override
    protected Boolean doInBackground(String... params) {
        provider = ObjectProviderFactory.getObjectProvider(ConfigurationContext.TEST);

        try {
            provider.authenticate(params[0], params[1]);
        } catch (UserdataNotCorrectException e) {
            return false;
        }
        return true;
    }

    // onPostExecute displays the results of the AsyncTask.
    @Override
    protected void onPostExecute(Boolean result) {

    }
}

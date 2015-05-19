package net.weirdblackmagic.clotherswe;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import de.ovgu.cse.se.ClotherAPI.IObjectProvider;
import de.ovgu.cse.se.ClotherAPI.ObjectProviderFactory;
import de.ovgu.cse.se.ClotherAPI.models.User;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.MaterialSection;


public class ClotherMain extends MaterialNavigationDrawer {
    
    Boolean result;
    MaterialAccount account;

    IObjectProvider objectProvider;

    @Override
    public void init(Bundle bundle) {
        MaterialSection sectionTimeline = newSection("Home", new ClotherHome());
        MaterialSection sectionTags = newSection("Tags", new ClotherTags());
        account = new MaterialAccount(this.getResources(), "Peter Cat","catcat@cat.cat", null, R.drawable.cat);

        this.addAccount(account);

        addSection(sectionTimeline);
        addSection(sectionTags);

        result = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Only show items in the action bar relevant to this screen
        // if the drawer is not showing. Otherwise, let the drawer
        // decide what to show in the action bar.
        getMenuInflater().inflate(R.menu.clother_main, menu);

        if (result) {
            menu.findItem(R.id.action_login).setIcon(R.drawable.ic_lock_outline_white_36dp);
            invalidateOptionsMenu();
        } else {
            menu.findItem(R.id.action_login).setIcon(R.drawable.ic_lock_open_white_36dp);
            invalidateOptionsMenu();
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_login:
                try {
                    login();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void login() throws ExecutionException, InterruptedException {

        String[] values = {"testuser8@ovgu.de", "password"};
        result = new DatabaseConnector(getBaseContext()).execute(values).get();

        if (result) {
            Toast.makeText(getApplicationContext(), "Congratulation! You are now logged in", Toast.LENGTH_LONG).show();
            objectProvider = ObjectProviderFactory.getObjectProvider();
            User user = objectProvider.getUser();
            account.setTitle(user.getFirstname() + "  " + user.getLastname());
            account.setSubTitle(user.getEmail());
            notifyAccountDataChanged();
        } else {
            Toast.makeText(getApplicationContext(), "Username and/or Password are incorrect!", Toast.LENGTH_LONG).show();
        }
    }

}

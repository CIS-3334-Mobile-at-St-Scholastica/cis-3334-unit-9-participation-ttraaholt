package css.cis3334.unit9participation_menus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/*Participation 9: Detail 1 Added it here because I forgot to add it to original submission.

App 1: WhatsApp Messenger
1.	There is a action bar menu present. The items available are: search, text and a menu
icon.
2.	The floating action button in the app is a speech to text component. Clicking on the
button will allow google to listen in and help you find what you are looking for.
3.	The app makes use of a navigation drawer. When the menu icon is clicked we get 6
options: Gallery, Photo, Video, Audio, Location and Contact.
4.	The screen does not switch when the user swipes left or right.

App 2: Instagram
1.	Instagram has an action bar menu which differs from one screen to another. Some of the
things the action bars contains are: search, capture photo, messaging option.
2.	THere are no floating floating action button.
3.	The navigation drawer appears on the bottom of this app. It contains buttons for getting
to Instagram’s homepage, search option, add a picture, favorites and a button to get to your own home page.
*/

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delete) {
            Toast.makeText(getApplicationContext(), "Deleting a study mate is not available yet.", Toast.LENGTH_LONG)
                    .show();
            return true;
        }

        else if (id == R.id.action_add) {
            Toast.makeText(getApplicationContext(), "Adding study mates is not available yet.", Toast.LENGTH_LONG)
                    .show();
            return true;
        }
        else if (id == R.id.action_settings) {
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                return true;
            }
        }
        else if (id == R.id.action_email) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, "ttraaholt@css.edu");
                intent.putExtra(Intent.EXTRA_SUBJECT, "hello");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
        }
        else if (id == R.id.action_sms) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("smsto:" + "7152925525"));
            intent.putExtra("sms_body", "Hi");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

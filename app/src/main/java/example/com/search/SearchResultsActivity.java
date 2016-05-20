package example.com.search;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchResultsActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        handleIntent(getIntent());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            showResults(query);
        }
    }

    private void showResults(String query) {
        if (query.equalsIgnoreCase("Common Room")){
            ImageView imageview = (ImageView) findViewById(R.id.commonRoomPin);
            imageview.setVisibility(View.VISIBLE);
            TextView textview = (TextView) findViewById(R.id.CommonRoom_textView);
            textview.setVisibility(View.VISIBLE);

        }
        if (query.equalsIgnoreCase("Restroom")){
            ImageView imageview = (ImageView) findViewById(R.id.restroomPin);
            imageview.setVisibility(View.VISIBLE);
            TextView textview = (TextView) findViewById(R.id.Restroom_textView);
            textview.setVisibility(View.VISIBLE);


        }


    }

}

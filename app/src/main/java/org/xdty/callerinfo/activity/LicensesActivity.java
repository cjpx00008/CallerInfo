package org.xdty.callerinfo.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;

import org.xdty.callerinfo.R;

public class LicensesActivity extends AppCompatActivity {

    private final static String ACTION_LICENSE = "org.xdty.callerinfo.action.VIEW_LICENSES";
    private final static String ACTION_PRIVACY = "org.xdty.callerinfo.action.VIEW_PRIVACY";
    private final static String ACTION_FEATURE = "org.xdty.callerinfo.action.VIEW_FEATURE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licenses);

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        WebView webView = (WebView) findViewById(R.id.webView);

        String action = getIntent().getAction();
        String url = "file:///android_res/raw/licenses.html";

        switch (action) {
            case ACTION_LICENSE:
                break;
            case ACTION_PRIVACY:
                setTitle(R.string.privacy_notice);
                url = "file:///android_res/raw/privacy_notice.html";
                break;
            case ACTION_FEATURE:
                setTitle(R.string.feature_notice);
                url = "file:///android_res/raw/feature_notice.html";
                break;
        }
        webView.loadUrl(url);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.kolkatanightlifenews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class UploadActivity extends AppCompatActivity {

    private Toolbar mToolbar;
private ImageButton SelectpostImage;
private Button UpdatePostButton;
private EditText PostDescription;

private static final int Gallery_Pick = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        SelectpostImage = (ImageButton) findViewById(R.id.upload_post_image);
        UpdatePostButton = (Button) findViewById(R.id.update_post_button);
        PostDescription = (EditText) findViewById(R.id.update_post_page_toolbar);

        mToolbar = (Toolbar) findViewById(R.id.update_post_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("update post");

        SelectpostImage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                OpenGallery();
            }

            private void OpenGallery() {

                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                galleryIntent.setType("video/*");
                startActivityForResult(galleryIntent, Gallery_Pick);

            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id== android.R.id.home);
        {
            SendUsertoHomeActivity();
        }
        return super.onOptionsItemSelected(item);
    }

    private void SendUsertoHomeActivity() {
        Intent mainIentent = new Intent(UploadActivity.this,HomeActivity.class);
        startActivity(mainIentent);
    }
}

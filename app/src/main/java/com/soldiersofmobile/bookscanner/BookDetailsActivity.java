package com.soldiersofmobile.bookscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.soldiersofmobile.bookscanner.api.model.VolumeInfo;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookDetailsActivity extends AppCompatActivity {

    @BindView(R.id.title_text_view)
    TextView titleTextView;
    @BindView(R.id.subtitle_text_view)
    TextView subtitleTextView;
    @BindView(R.id.author_text_view)
    TextView authorTextView;
    @BindView(R.id.description_text_view)
    TextView desriptionTextView;
    @BindView(R.id.coverImageView)
    ImageView coverImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        ButterKnife.bind(this);
        VolumeInfo volumeInfo = (VolumeInfo) getIntent().getSerializableExtra(BookScannerActivity.VOLUME_INFO_EXTRA);
        Picasso.with(this)
                .load(volumeInfo.getImageLinks().getThumbnail())
                .into(coverImageView);

        titleTextView.setText(volumeInfo.getTitle());
        subtitleTextView.setText(volumeInfo.getSubtitle());
        String authors ="";
        Integer licz =0;
        for (String au : volumeInfo.getAuthors()) {
            licz=licz+1;
            authors=authors + au;
            if (licz<volumeInfo.getAuthors().size()) {
                authors=authors + ", ";
            }
        }
        authorTextView.setText(authors);
        desriptionTextView.setText(volumeInfo.getDescription());
    }
}

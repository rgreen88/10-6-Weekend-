package com.example.rynel.weekendtwoproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFActivity extends AppCompatActivity {

    //declaring pdfview object from pdfviewer widget
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        //setting pdf viewing
        setContentView(R.layout.activity_pdf);

        //binding pdfView, casting widget, and loading file
        pdfView = (PDFView) findViewById( R.id.pdfView );
        pdfView.fromAsset("pdf.pdf").load();
    }

}

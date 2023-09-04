package com.rahilcodsoft.quoteapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private Button refreshButton;
    private Button shareButton;

    private String[] quotes = {
            "Believe you can and you're halfway there.",
            "The only way to do great work is to love what you do.",
            "Don't watch the clock; do what it does. Keep going.",
            "The purpose of our lives is to be happy. — Dalai Lama",
    "Life is what happens when you're busy making other plans. — John Lennon",
    "Get busy living or get busy dying. — Stephen King",
    "You only live once, but if you do it right, once is enough. — Mae West",
    "Many of life’s failures are people who did not realize how close they were to success when they gave up.– Thomas A. Edison",
            "There is always light. If only we're brave enough to see it. If only we're brave enough to be it.",
            "If you want to lift yourself up, lift up someone else.",
            "You’re braver than you believe, stronger than you seem, and smarter than you think."


};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        refreshButton = findViewById(R.id.refreshButton);
        shareButton = findViewById(R.id.shareButton);

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayRandomQuote();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareCurrentQuote();
            }
        });


        displayRandomQuote();
    }

    private void displayRandomQuote() {
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.length);
        String randomQuote = quotes[randomIndex];
        quoteTextView.setText(randomQuote);
    }

    private void shareCurrentQuote() {
        String currentQuote = quoteTextView.getText().toString();
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Quote", currentQuote);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, "Quote copied to clipboard", Toast.LENGTH_SHORT).show();

    }
}


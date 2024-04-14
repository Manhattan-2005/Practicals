package com.shiva;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Practical_8_Program extends AppCompatActivity {

    public List<String> suggestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical8_program);

        suggestions.add("Shiva");
        suggestions.add("Radhe");
        suggestions.add("Prats");
        suggestions.add("Mia");
        suggestions.add("Yashwant");
        setup();
    }

    public void setup() {

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.auto_For_Practical8_Program);
        autoCompleteTextView.setAdapter(new MyAdapter(this, suggestions));
        autoCompleteTextView.setThreshold(1);

        autoCompleteTextView.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MyAdapter ad = (MyAdapter) autoCompleteTextView.getAdapter();
                ad.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

    }

    public class MyAdapter extends ArrayAdapter<String> {

        public MyAdapter(Context context, List<String> suggestions) {
            super(context, android.R.layout.simple_list_item_1, suggestions);
        }

        @NonNull
        @Override
        public Filter getFilter() {
            return new MyFilter();
        }

        private class MyFilter extends Filter {

            @Override
            protected FilterResults performFiltering(CharSequence input) {
                FilterResults results = new FilterResults();
                List<String> filteredSuggestions = new ArrayList<>();
                if (input.length() != 0) {
                    for (String suggestion : suggestions) {
                        if (suggestion.toLowerCase().contains(input.toString().toLowerCase())) {
                            filteredSuggestions.add(suggestion);
                        }
                    }
                    if (!filteredSuggestions.contains(input.toString()) && input.length() > 5) {
                        suggestions.add(input.toString());
                    }
                }
                if (filteredSuggestions.isEmpty()) {
                    results.values = new ArrayList<>(); // Set to empty list if no results
                } else {
                    results.values = filteredSuggestions;
                }
                results.count = filteredSuggestions.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                clear();
                addAll((List<String>) results.values);
                notifyDataSetChanged();
            }
        }
    }


    public void display(View v) {

        TextView t = findViewById(R.id.result_For_Practical8_Exercise2);
        EditText name = findViewById(R.id.auto_For_Practical8_Program);

        t.setText(String.format("Hello %s!", name.getText()));

    }

}
package com.example.physicsformulas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class WikiFormula extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_wiki_formula, null);

        ImageView imageViewFormula = v.findViewById(R.id.imageView_fragment_wiki_formula);
        imageViewFormula.setImageResource(getResources().getIdentifier("formula_" + MainActivity.formulaLogic.formulasList.get(MainActivity.formulaLogic.numCreatedWikiFormulas).id,
                "drawable", MainActivity.PACKAGE_NAME));
        TextView textViewFormula = v.findViewById(R.id.textView_fragment_wiki_formula);
        textViewFormula.setText(MainActivity.formulaLogic.formulasList.get(MainActivity.formulaLogic.numCreatedWikiFormulas).name);
        TextView textViewCounter = v.findViewById(R.id.textView_fragment_wiki_counter);
        textViewCounter.setText(Integer.toString((MainActivity.formulaLogic.numCreatedWikiFormulas) +1));
        MainActivity.formulaLogic.numCreatedWikiFormulas++;
        return v;
    }

}

package edu.gatech.unitconvertor;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class DistanceActivity extends Fragment implements OnClickListener {

	TextView textView;
	EditText editText;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Inflates the XML layout into the mainActivity container
		View view = inflater.inflate(R.layout.activity_distance, container,
				false);

		// Add listeners for button click events
		view.findViewById(R.id.btnMiles).setOnClickListener(this);
		view.findViewById(R.id.btnKilometers).setOnClickListener(this);

		// save widgets to use in onClick event
		textView = (TextView) view.findViewById(R.id.txtDistance);
		editText = (EditText) view.findViewById(R.id.editDistance);

		return view;
	}

	public void onClick(View v) {

		try {

			String txtInput = editText.getText().toString();

			if (v.getId() == R.id.btnMiles) {
				//Convert to miles
				textView.setText(txtInput + "km = " + 
						UnitConverter.formatDecimal(UnitConverter
								.toMiles(Double.parseDouble(txtInput))) + "mi");
			} else {
				//Convert to kilometers
				textView.setText(txtInput + "mi = " +
						UnitConverter.formatDecimal(UnitConverter
								.toKilometers(Double.parseDouble(txtInput))) + "km");	
			}

		} catch (NumberFormatException e) {

			//Catch if nothing was entered 
			textView.setText("Enter a distance to convert");

		}

	}

}

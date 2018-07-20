package com.badikirwan.dicoding.myflexiblefragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button btnChoose, btnClose;
    private RadioGroup rgOptions;
    private RadioButton rbSaf, rbMou, rbLvg, rbMoyes;
    private OnOptionDialogListener onOptionDialogLIstener;

    public OptionDialogFragment() {
        // Required empty public constructor
    }

    public OnOptionDialogListener getOnOptionDialogLIstener() {
        return onOptionDialogLIstener;
    }

    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogLIstener) {
        this.onOptionDialogLIstener = onOptionDialogLIstener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);
        btnChoose = (Button) view.findViewById(R.id.btn_shoose);
        btnChoose.setOnClickListener(this);
        btnClose = (Button) view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);
        rgOptions = (RadioGroup) view.findViewById(R.id.rg_options);
        rbSaf = (RadioButton) view.findViewById(R.id.rb_saf);
        rbMou = (RadioButton) view.findViewById(R.id.rb_mou);
        rbLvg = (RadioButton) view.findViewById(R.id.rb_lvg);
        rbMoyes = (RadioButton) view.findViewById(R.id.rb_moyes);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_close:
                getDialog().cancel();
                break;
            case R.id.btn_shoose:
                int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1) {
                    String coach = null;
                    switch (checkedRadioButtonId) {
                        case R.id.rb_saf:
                            coach = rbSaf.getText().toString().trim();
                            break;
                        case R.id.rb_mou:
                            coach = rbMou.getText().toString().trim();
                            break;
                        case R.id.rb_lvg:
                            coach = rbLvg.getText().toString().trim();
                            break;
                        case R.id.rb_moyes:
                            coach = rbMoyes.getText().toString().trim();
                    }
                    getOnOptionDialogLIstener().onOptionChoosen(coach);
                    getDialog().cancel();
                }
                break;
        }
    }

    public interface OnOptionDialogListener {
        void onOptionChoosen(String text);
    }
}

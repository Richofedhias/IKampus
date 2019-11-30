package com.example.i_kampus.homeUser.menuUtama;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.i_kampus.R;

public class DialogPutriActivity extends AppCompatDialogFragment {

    ImageView gambarprofil;
    TextView nama, email, hobi, asal, emailDev;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_dialog_putri, null);

        builder.setView(view)
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        gambarprofil = view.findViewById(R.id.gambarProfil);
        nama = view.findViewById(R.id.dg_namaProfil);
        asal = view.findViewById(R.id.dg_asalProfil);
        email = view.findViewById(R.id.dg_email);
        emailDev = view.findViewById(R.id.dg_emailProfil);
        hobi = view.findViewById(R.id.dg_hobiProfil);

        return builder.create();
    }
}
package com.example.e_survey.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.e_survey.R;
import com.example.e_survey.api.ApiInterfaces;
import com.example.e_survey.api.ApiServer;

public class FormSurveyFragment extends Fragment {

    EditText nomor_ktp, nama, jk, tempat_lahir, tgl_lahir, pekerjaan, email, nomor_hp, desa, kecamatan, kota;
    String sNomorKtp, sNama, sJk, sTempatLahir, sTglLahir, sPekerjaan, sEmail, sNomorHp, sDesa, sKecamatan, sKota;

    AppCompatButton btnSimpan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_form_survey, container, false);

        nomor_ktp = v.findViewById(R.id.nomor_ktp);
        nama = v.findViewById(R.id.nama);
        jk = v.findViewById(R.id.jk);
        tempat_lahir = v.findViewById(R.id.tempat_lahir);
        tgl_lahir = v.findViewById(R.id.tgl_lahir);
        pekerjaan = v.findViewById(R.id.pekerjaan);
        email = v.findViewById(R.id.email);
        nomor_hp = v.findViewById(R.id.nomor_hp);
        desa = v.findViewById(R.id.desa);
        kecamatan = v.findViewById(R.id.kecamatan);
        kota = v.findViewById(R.id.kota);

        btnSimpan = v.findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(view -> {
            sNomorKtp = nomor_ktp.getText().toString();
            sNama = nama.getText().toString().toString();
            sJk = jk.getText().toString();
            sTempatLahir = tempat_lahir.getText().toString();
            sTglLahir = tgl_lahir.getText().toString();
            sPekerjaan = pekerjaan.getText().toString();
            sEmail = email.getText().toString();
            sNomorHp = nomor_hp.getText().toString();
            sDesa = desa.getText().toString();
            sKecamatan = kecamatan.getText().toString();
            sKota = kota.getText().toString();
            postData(sNomorKtp, sNama, sJk, sTempatLahir, sTglLahir, sPekerjaan, sEmail, sNomorHp, sDesa, sKecamatan, sKota);
        });


        return v;
    }

    private void postData(String sNomorKtp, String sNama, String sJk, String sTempatLahir, String sTglLahir, String sPekerjaan, String sEmail, String sNomorHp, String sDesa, String sKecamatan, String sKota) {
        ApiInterfaces apiInterfaces = ApiServer.konekRetrofit().create(ApiInterfaces.class);
    }
}
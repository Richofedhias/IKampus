package com.example.i_kampus.homeAdmin;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.i_kampus.R;
import com.example.i_kampus.database.DbBeasiswa;
import com.example.i_kampus.database.DbKampus;
import com.example.i_kampus.database.DbProdi;
import com.example.i_kampus.database.DbSoal;
import com.example.i_kampus.database.Dbukm;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class InputKampus extends AppCompatActivity {
    private Spinner jenis, namaKampus1;
    private EditText telfonKampus, lokasiKampus, emailKampus, deskripsiKampus;
    private TextView gambarkampus;
    private ImageView iVgambarKampus;
    private Button pilihGambarKampus;
    private TextView tVdeskripsi, ContactUs;
    private Button simpan1, simpan2, simpan3, simpan4, simpan5, simpan6, pilihGambar;
    private Spinner beasiswa;
    private EditText namaBeasiswa, deskripsiBeasiswa, tanggalBeasiswa,tanggalAkhirBeasiswa,waktuTes;
    private TextView tVnamaBeasiswa, tVdeskripsiBeasiswa, tVtanggalBeasiswa, tVjenisBeasiswa, tVgambarBeasiswa,tVsampai,tvwaktuAkhir,tVwaktuTes;
    private ImageView iVgambarBeasiswa;
    private Button pilihgambarBeasiswa;
    private EditText namaProdi, deskripsiProdi, akreditasi;
    private TextView tVnamaProdi, tVdeskripsiProdi, tVakreditasi, tVgambarProdi;
    private ImageView iVgambarProdi;
    private Button pilihgambarProdi;
    private EditText namaUKM, deskripsiUKM;
    private TextView tVnamaUKM, tvdeskripsiUKM, tVgambarUKM;
    private ImageView iVgambarUKM;
    private Button pilihgambarUKM;
    private EditText jumlahPresentase;
    private Spinner fakultas;
    private TextView tVpresentase, tVfakultas;
    private EditText inputSoal, jawabanA, jawabanB, jawabanC, jawabanD, jawabanE, jawabanBenar;
    private TextView soal, tVjawabanA, tVjawabanB, tVjawabanC, tVjawabanD, tVjawabanE, tVgambar, tVjawaban;
    private ImageView iVgambarLatihanSoal;
    final String[] jenisInputan = {"Info Kampus", "Info Beasiswa", "Info Prodi", "Info UKM", "Presentase", "Latihan Soal"};

    private static final int PICK_IMAGE_REQUEST_KAMPUS = 1;
    private static final int PICK_IMAGE_REQUEST_BEASISWA = 1;
    private Uri mImageUri;
    private DatabaseReference dataKampus;
    private DatabaseReference dataBeasiswa;
    private DatabaseReference dataProdi;
    private DatabaseReference dataUkm;
    private DatabaseReference dataSoal;
    private StorageReference mStoreRef;
    private StorageReference mStoreRefBeasiswa;
    private StorageReference mStoreRefProdi;
    private StorageReference mStoreRefUkm;
    private StorageReference mStoreRefSoal;
    private StorageTask mUploadTask;
    ProgressBar mProgressBar1;
    ProgressBar mProgressBar2;
    ProgressBar mProgressBar3;
    ProgressBar mProgressBar4;
    ProgressBar mProgressBar5;
    ProgressBar mProgressBar6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_kampus);
        mProgressBar1 = findViewById(R.id.pb_kampus);
        mProgressBar2 = findViewById(R.id.pb_beasiswa);
        mProgressBar3 = findViewById(R.id.pb_prodi);
        mProgressBar4 = findViewById(R.id.pb_UKM);
        mProgressBar5 = findViewById(R.id.pb_Presentase);
        mProgressBar6 = findViewById(R.id.pb_LatihanSoal);

        inisialisasiInfoKampus();
        inisialisasiInfoBeasiswa();
        inisialisasiInfoProdi();
        inisialisasiLatihanSoal();
        inisialisasiPresentase();
        inisilisasiInfoUKM();
        hideInfoKampus();
        hideBeasiswa();
        hideInfoProdi();
        hideInfoUKM();
        hidePresentase();
        hideLatihanSoal();
        iVgambarBeasiswa.setVisibility(View.GONE);
        iVgambarProdi.setVisibility(View.GONE);
        iVgambarUKM.setVisibility(View.GONE);
        iVgambarLatihanSoal.setVisibility(View.GONE);
        mProgressBar1.setVisibility(View.GONE);
        mProgressBar2.setVisibility(View.GONE);
        mProgressBar3.setVisibility(View.GONE);
        mProgressBar4.setVisibility(View.GONE);
        mProgressBar5.setVisibility(View.GONE);
        mProgressBar6.setVisibility(View.GONE);
        ArrayAdapter<String> adapterBeasiswa = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, jenisBeasiswa);
        beasiswa.setAdapter(adapterBeasiswa);
        beasiswa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        pilihGambarKampus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
                iVgambarLatihanSoal.setVisibility(View.VISIBLE);
                mProgressBar1.setVisibility(View.VISIBLE);
            }
        });
        pilihgambarBeasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
        pilihgambarProdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
        pilihgambarUKM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
        pilihGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
        simpan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertKampus();
            }
        });
        simpan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertBeasiswa();
            }
        });
        simpan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertProdi();
            }
        });
        simpan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertUKM();
            }
        });
        simpan5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        simpan6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertLatihanSoal();
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, jenisInputan);
        jenis.setAdapter(adapter);
        jenis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    showInfoKampus();
                    hideBeasiswa();
                    hideInfoProdi();
                    hideInfoUKM();
                    hideLatihanSoal();
                    hidePresentase();
                    iVgambarLatihanSoal.setVisibility(View.GONE);

                } else if (position == 1) {
                    showInfoBeasiswa();
                    hideInfoKampus();
                    hideInfoProdi();
                    hideInfoUKM();
                    hideLatihanSoal();
                    hidePresentase();

                } else if (position == 2) {
                    hideInfoKampus();
                    showInfoProdi();
                    hideBeasiswa();
                    hideInfoUKM();
                    hideLatihanSoal();
                    hidePresentase();
                    hideInfoKampus();
                } else if (position == 3) {
                    showInfoUKM();
                    hideInfoProdi();
                    hideLatihanSoal();
                    hidePresentase();
                    hideInfoKampus();
                    hideBeasiswa();

                } else if (position == 4) {
                    showPresentase();
                    hideBeasiswa();
                    hideInfoProdi();
                    hideInfoKampus();
                    hideLatihanSoal();
                    hideInfoUKM();
                } else {
                    showLatihanSoal();
                    hideBeasiswa();
                    hideInfoProdi();
                    hideInfoKampus();
                    hidePresentase();
                    hideInfoUKM();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST_KAMPUS && resultCode == RESULT_OK && data != null && data.getData() != null) {
            mImageUri = data.getData();

            Picasso.with(this).load(mImageUri).into(iVgambarKampus);
            Picasso.with(this).load(mImageUri).into(iVgambarProdi);
            Picasso.with(this).load(mImageUri).into(iVgambarUKM);
            Picasso.with(this).load(mImageUri).into(iVgambarLatihanSoal);
            Picasso.with(this).load(mImageUri).into(iVgambarBeasiswa);
        }
    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST_KAMPUS);
    }


    private void inisialisasiInfoKampus() {
        jenis = findViewById(R.id.input_jenis);
        namaKampus1 = findViewById(R.id.namaKampus1);
        deskripsiKampus = findViewById(R.id.deskripsi_kampus);
        lokasiKampus = findViewById(R.id.lokasi_kampus);
        telfonKampus = findViewById(R.id.telp_kampus);
        emailKampus = findViewById(R.id.email_kampus);
        gambarkampus = findViewById(R.id.tVgambarKampus);
        iVgambarKampus = findViewById(R.id.iVgambarKampus);
        tVdeskripsi = findViewById(R.id.tVDeskripsi);
        ContactUs = findViewById(R.id.tVContact);
        pilihGambarKampus = findViewById(R.id.gambar_kampus);
        simpan1 = findViewById(R.id.btn_kampus);
        mStoreRef = FirebaseStorage.getInstance().getReference("GambarKampus");
        dataKampus = FirebaseDatabase.getInstance().getReference().child("Kampus");

    }

    private void hideInfoKampus() {
        deskripsiKampus.setVisibility(View.GONE);
        lokasiKampus.setVisibility(View.GONE);
        telfonKampus.setVisibility(View.GONE);
        emailKampus.setVisibility(View.GONE);
        tVdeskripsi.setVisibility(View.GONE);
        ContactUs.setVisibility(View.GONE);
        simpan1.setVisibility(View.GONE);
        pilihGambarKampus.setVisibility(View.GONE);
        gambarkampus.setVisibility(View.GONE);
        namaKampus1.setVisibility(View.GONE);
        iVgambarKampus.setVisibility(View.GONE);
    }

    private void showInfoKampus() {
        deskripsiKampus.setVisibility(View.VISIBLE);
        lokasiKampus.setVisibility(View.VISIBLE);
        telfonKampus.setVisibility(View.VISIBLE);
        emailKampus.setVisibility(View.VISIBLE);
        tVdeskripsi.setVisibility(View.VISIBLE);
        ContactUs.setVisibility(View.VISIBLE);
        simpan1.setVisibility(View.VISIBLE);
        pilihGambarKampus.setVisibility(View.VISIBLE);
        gambarkampus.setVisibility(View.VISIBLE);
        namaKampus1.setVisibility(View.VISIBLE);
        iVgambarKampus.setVisibility(View.VISIBLE);
    }

    private void insertKampus() {
//        final String kampus = namaKampus.getText().toString();
        final String deskripsi = deskripsiKampus.getText().toString();
        final String lokasi = lokasiKampus.getText().toString();
        final String telfon = telfonKampus.getText().toString();
        final String email = emailKampus.getText().toString();
//        if (TextUtils.isEmpty(kampus)) {
//            Toast.makeText(this, "Masukan Nama Kampus terlebih Dahulu", Toast.LENGTH_SHORT).show();
//        } else
        if (TextUtils.isEmpty(deskripsi)) {
            Toast.makeText(this, "Masukan Deskripsi Kampus  Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(lokasi)) {
            Toast.makeText(this, "Masukan Lokasi Kampuas Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(telfon)) {
            Toast.makeText(this, "Masukan Telfon Kampus  Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Masukan Firstname Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else {
//                loading.setTitle("Creating New Data Kampus");
//                loading.setMessage("Please Wait,
            StorageReference fileReference = mStoreRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(mImageUri));
            mUploadTask = fileReference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar1.setProgress(0);
                        }
                    }, 5000);
                    Toast.makeText(InputKampus.this, "Sukses Memasukan ke database", Toast.LENGTH_SHORT).show();
                    String gambar = taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();
                    DbKampus dbKampus = new DbKampus( deskripsi, lokasi, telfon, email, gambar);
                    String key = dataKampus.push().getKey();
                    dataKampus.child(key).setValue(dbKampus);
                }

            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(InputKampus.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mProgressBar1.setProgress((int) progress);
                        }
                    });

        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }


    private void inisialisasiInfoBeasiswa() {
        namaBeasiswa = findViewById(R.id.nama_beasiswa);
        deskripsiBeasiswa = findViewById(R.id.deskripsi_beasiswa);
        beasiswa = findViewById(R.id.jenis_beasiswa);
        tanggalBeasiswa = findViewById(R.id.tanggal_beasiswa);
        tVnamaBeasiswa = findViewById(R.id.tVnamaBeasiswa);
        tVdeskripsiBeasiswa = findViewById(R.id.tVdeskripsi_beasiswa);
        tVtanggalBeasiswa = findViewById(R.id.tVtanggalBeasiswa);
        tVjenisBeasiswa = findViewById(R.id.tVjenis_beasiswa);
        tVwaktuTes = findViewById(R.id.tVwaktutes);
        tanggalAkhirBeasiswa = findViewById(R.id.tanggal_akhir_beasiswa);
        tVsampai = findViewById(R.id.tVsampai);
        waktuTes = findViewById(R.id.waktu_tes);
        iVgambarBeasiswa = findViewById(R.id.iVgambarBeasiswa);
        tVgambarBeasiswa = findViewById(R.id.tVgambarBeasiswa);
        pilihgambarBeasiswa = findViewById(R.id.pilihgambarBeasiswa);
        mStoreRefBeasiswa = FirebaseStorage.getInstance().getReference("GambarBeasiswa");
        dataBeasiswa = FirebaseDatabase.getInstance().getReference().child("Beasiswa");
        simpan2 = findViewById(R.id.btn_beasiswa);
    }

    private void hideBeasiswa() {
        beasiswa.setVisibility(View.GONE);
        namaBeasiswa.setVisibility(View.GONE);
        deskripsiBeasiswa.setVisibility(View.GONE);
        tanggalBeasiswa.setVisibility(View.GONE);
        tVnamaBeasiswa.setVisibility(View.GONE);
        tVdeskripsiBeasiswa.setVisibility(View.GONE);
        tVtanggalBeasiswa.setVisibility(View.GONE);
        tVjenisBeasiswa.setVisibility(View.GONE);
        tVgambarBeasiswa.setVisibility(View.GONE);
        iVgambarBeasiswa.setVisibility(View.GONE);
        pilihgambarBeasiswa.setVisibility(View.GONE);
        tVwaktuTes.setVisibility(View.GONE);
        tanggalAkhirBeasiswa.setVisibility(View.GONE);
        tVsampai.setVisibility(View.GONE);
        waktuTes.setVisibility(View.GONE);
        simpan2.setVisibility(View.GONE);
    }

    private void showInfoBeasiswa() {

        beasiswa.setVisibility(View.VISIBLE);
        namaBeasiswa.setVisibility(View.VISIBLE);
        deskripsiBeasiswa.setVisibility(View.VISIBLE);
        tanggalBeasiswa.setVisibility(View.VISIBLE);
        tVnamaBeasiswa.setVisibility(View.VISIBLE);
        tVdeskripsiBeasiswa.setVisibility(View.VISIBLE);
        tVtanggalBeasiswa.setVisibility(View.VISIBLE);
        tVjenisBeasiswa.setVisibility(View.VISIBLE);
        tVgambarBeasiswa.setVisibility(View.VISIBLE);
        iVgambarBeasiswa.setVisibility(View.VISIBLE);
        pilihgambarBeasiswa.setVisibility(View.VISIBLE);
        tVwaktuTes.setVisibility(View.VISIBLE);
        tanggalAkhirBeasiswa.setVisibility(View.VISIBLE);
        tVsampai.setVisibility(View.VISIBLE);
        waktuTes.setVisibility(View.VISIBLE);
        simpan2.setVisibility(View.VISIBLE);
    }

    private void insertBeasiswa() {
        final String namabeasiswa = namaBeasiswa.getText().toString();
        final String deskripsibeasiswa = deskripsiBeasiswa.getText().toString();
        final String jenisbeasiswa = beasiswa.getSelectedItem().toString();
        final String tanggalbeasiswa = tanggalBeasiswa.getText().toString();

        if (TextUtils.isEmpty(namabeasiswa)) {
            Toast.makeText(this, "Masukan Nama Beasiswa Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(deskripsibeasiswa)) {
            Toast.makeText(this, "Masukan Deskripsi Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(tanggalbeasiswa)) {
            Toast.makeText(this, "Masukan Tanggal Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else {
            StorageReference fileReference = mStoreRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(mImageUri));
            mUploadTask = fileReference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar1.setProgress(0);
                        }
                    }, 5000);
                    Toast.makeText(InputKampus.this, "Sukses Memasukan ke database", Toast.LENGTH_SHORT).show();
                    String gambar = taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();
                    DbBeasiswa dbBeasiswa = new DbBeasiswa(namabeasiswa, deskripsibeasiswa, jenisbeasiswa, tanggalbeasiswa, gambar);
                    String key = dataBeasiswa.push().getKey();
                    dataBeasiswa.child(key).setValue(dbBeasiswa);
                }

            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(InputKampus.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mProgressBar1.setProgress((int) progress);
                        }
                    });
        }
    }

    final String jenisBeasiswa[] = {
            "Internal",
            "Eksternal"

    };


    private void inisialisasiInfoProdi() {
        namaProdi = findViewById(R.id.nama_prodi);
        deskripsiProdi = findViewById(R.id.deskrispi_prodi);
        tVnamaProdi = findViewById(R.id.tVnamaProdi);
        tVdeskripsiProdi = findViewById(R.id.tVDeskripsiProdi);
        akreditasi = findViewById(R.id.akreditasi_prodi);
        tVakreditasi = findViewById(R.id.tVakreditasi);
        tVgambarProdi = findViewById(R.id.tVgambarProdi);
        iVgambarProdi = findViewById(R.id.iVgambarProdi);
        pilihgambarProdi = findViewById(R.id.gambar_prodi);
        mStoreRefProdi = FirebaseStorage.getInstance().getReference("GambarProdi");
        dataProdi = FirebaseDatabase.getInstance().getReference().child("Prodi");
        simpan3 = findViewById(R.id.btn_prodi);

    }

    private void hideInfoProdi() {
        namaProdi.setVisibility(View.GONE);
        deskripsiProdi.setVisibility(View.GONE);
        tVnamaProdi.setVisibility(View.GONE);
        tVdeskripsiProdi.setVisibility(View.GONE);
        akreditasi.setVisibility(View.GONE);
        tVakreditasi.setVisibility(View.GONE);
        tVgambarProdi.setVisibility(View.GONE);
        iVgambarProdi.setVisibility(View.GONE);
        pilihgambarProdi.setVisibility(View.GONE);
        simpan3.setVisibility(View.GONE);
    }

    private void showInfoProdi() {

        namaProdi.setVisibility(View.VISIBLE);
        deskripsiProdi.setVisibility(View.VISIBLE);
        tVnamaProdi.setVisibility(View.VISIBLE);
        tVdeskripsiProdi.setVisibility(View.VISIBLE);
        akreditasi.setVisibility(View.VISIBLE);
        tVakreditasi.setVisibility(View.VISIBLE);
        tVgambarProdi.setVisibility(View.VISIBLE);
        iVgambarProdi.setVisibility(View.VISIBLE);
        pilihgambarProdi.setVisibility(View.VISIBLE);
        simpan3.setVisibility(View.VISIBLE);
    }

    private void insertProdi() {
        final String namaprodi = namaProdi.getText().toString();
        final String deskripsiprodi = deskripsiProdi.getText().toString();
        final String akreditasiprodi = akreditasi.getText().toString();
        if (TextUtils.isEmpty(namaprodi)) {
            Toast.makeText(this, "Masukan nama Prodi Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(deskripsiprodi)) {
            Toast.makeText(this, "Masukan Deskripsi Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else {
            StorageReference fileReference = mStoreRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(mImageUri));
            mUploadTask = fileReference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar1.setProgress(0);
                        }
                    }, 5000);
                    Toast.makeText(InputKampus.this, "Sukses Memasukan ke database", Toast.LENGTH_SHORT).show();
                    String gambar = taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();
                    DbProdi dbProdi = new DbProdi(namaprodi, deskripsiprodi, akreditasiprodi, gambar);
                    String key = dataProdi.push().getKey();
                    dataProdi.child(key).setValue(dbProdi);
                }

            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(InputKampus.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mProgressBar1.setProgress((int) progress);
                        }
                    });

        }
    }

    private void inisilisasiInfoUKM() {
        namaUKM = findViewById(R.id.nama_UKM);
        deskripsiUKM = findViewById(R.id.deskripsi_UKM);
        tVnamaUKM = findViewById(R.id.tVnamaUKM);
        tvdeskripsiUKM = findViewById(R.id.tVDeskripsiUKM);
        tVgambarUKM = findViewById(R.id.tVgambarUKM);
        iVgambarUKM = findViewById(R.id.iVgambarUKM);
        pilihgambarUKM = findViewById(R.id.gambar_UKM);
        mStoreRefUkm = FirebaseStorage.getInstance().getReference("GambarUkm");
        dataUkm = FirebaseDatabase.getInstance().getReference().child("UKM");
        simpan4 = findViewById(R.id.btn_UKM);
    }

    private void hideInfoUKM() {
        namaUKM.setVisibility(View.GONE);
        deskripsiUKM.setVisibility(View.GONE);
        tVnamaUKM.setVisibility(View.GONE);
        tvdeskripsiUKM.setVisibility(View.GONE);
        tVgambarUKM.setVisibility(View.GONE);
        iVgambarUKM.setVisibility(View.GONE);
        pilihgambarUKM.setVisibility(View.GONE);
        simpan4.setVisibility(View.GONE);
    }

    private void showInfoUKM() {
        namaUKM.setVisibility(View.VISIBLE);
        deskripsiUKM.setVisibility(View.VISIBLE);
        tVnamaUKM.setVisibility(View.VISIBLE);
        tvdeskripsiUKM.setVisibility(View.VISIBLE);
        tVgambarUKM.setVisibility(View.VISIBLE);
        iVgambarUKM.setVisibility(View.VISIBLE);
        pilihgambarUKM.setVisibility(View.VISIBLE);
        simpan4.setVisibility(View.VISIBLE);
    }

    private void insertUKM() {
        final String deskripsiukm = deskripsiUKM.getText().toString();
        final String namaukm = namaUKM.getText().toString();
        if (TextUtils.isEmpty(deskripsiukm)) {
            Toast.makeText(this, "Masukan Deskripsi Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(namaukm)) {
            Toast.makeText(this, "Masukan nama UKM Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        } else {
            StorageReference fileReference = mStoreRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(mImageUri));
            mUploadTask = fileReference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar1.setProgress(0);
                        }
                    }, 5000);
                    Toast.makeText(InputKampus.this, "Sukses Memasukan ke database", Toast.LENGTH_SHORT).show();
                    String gambar = taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();
                    Dbukm dbukm = new Dbukm(deskripsiukm, namaukm, gambar);
                    String key = dataUkm.push().getKey();
                    dataUkm.child(key).setValue(dbukm);
                }

            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(InputKampus.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mProgressBar1.setProgress((int) progress);
                        }
                    });
        }
    }

    private void inisialisasiPresentase() {
        jumlahPresentase = findViewById(R.id.input_presentase);
        fakultas = findViewById(R.id.fakultas_presentase);
        tVpresentase = findViewById(R.id.tVpresentase);
        tVfakultas = findViewById(R.id.tVfakultas);
        simpan5 = findViewById(R.id.btn_presentase);
    }

    private void hidePresentase() {
        jumlahPresentase.setVisibility(View.GONE);
        fakultas.setVisibility(View.GONE);
        tVpresentase.setVisibility(View.GONE);
        tVfakultas.setVisibility(View.GONE);
        simpan5.setVisibility(View.GONE);
    }

    private void showPresentase() {
        jumlahPresentase.setVisibility(View.VISIBLE);
        fakultas.setVisibility(View.VISIBLE);
        tVpresentase.setVisibility(View.VISIBLE);
        tVfakultas.setVisibility(View.VISIBLE);
        simpan5.setVisibility(View.VISIBLE);
    }

    private void inisialisasiLatihanSoal() {
        inputSoal = findViewById(R.id.input_soal);
        jawabanA = findViewById(R.id.a);
        jawabanB = findViewById(R.id.b);
        jawabanC = findViewById(R.id.c);
        jawabanD = findViewById(R.id.d);
        jawabanE = findViewById(R.id.e);
        soal = findViewById(R.id.soalKuesionerPenj);
        tVjawabanA = findViewById(R.id.tVjawabanA);
        tVjawabanB = findViewById(R.id.tVjawabanB);
        tVjawabanC = findViewById(R.id.tVjawabanC);
        tVjawabanD = findViewById(R.id.tVjawabanD);
        tVjawabanE = findViewById(R.id.tVjawabanE);
        tVgambar = findViewById(R.id.tVgambar);
        tVjawaban = findViewById(R.id.tVjawabanBenar);
        jawabanBenar = findViewById(R.id.jawaban_benar);
        iVgambarLatihanSoal = findViewById(R.id.iVgambarLatihanSoal);
        simpan6 = findViewById(R.id.btn_latihanSoal);
        pilihGambar = findViewById(R.id.pilih_gambar);
        mStoreRefSoal = FirebaseStorage.getInstance().getReference("GambarSoal");
        dataSoal = FirebaseDatabase.getInstance().getReference().child("Soal");
    }

    private void hideLatihanSoal() {
        inputSoal.setVisibility(View.GONE);
        jawabanA.setVisibility(View.GONE);
        jawabanB.setVisibility(View.GONE);
        jawabanC.setVisibility(View.GONE);
        jawabanD.setVisibility(View.GONE);
        jawabanE.setVisibility(View.GONE);
        soal.setVisibility(View.GONE);
        tVjawabanA.setVisibility(View.GONE);
        tVjawabanB.setVisibility(View.GONE);
        tVjawabanC.setVisibility(View.GONE);
        tVjawabanD.setVisibility(View.GONE);
        tVjawabanE.setVisibility(View.GONE);
        tVjawaban.setVisibility(View.GONE);
        jawabanBenar.setVisibility(View.GONE);
        tVgambar.setVisibility(View.GONE);
        iVgambarLatihanSoal.setVisibility(View.GONE);
        simpan6.setVisibility(View.GONE);
        pilihGambar.setVisibility(View.GONE);
    }

    private void showLatihanSoal() {

        inputSoal.setVisibility(View.VISIBLE);
        jawabanA.setVisibility(View.VISIBLE);
        jawabanB.setVisibility(View.VISIBLE);
        jawabanC.setVisibility(View.VISIBLE);
        jawabanD.setVisibility(View.VISIBLE);
        jawabanE.setVisibility(View.VISIBLE);
        soal.setVisibility(View.VISIBLE);
        tVjawabanA.setVisibility(View.VISIBLE);
        tVjawabanB.setVisibility(View.VISIBLE);
        tVjawabanC.setVisibility(View.VISIBLE);
        tVjawabanD.setVisibility(View.VISIBLE);
        tVjawabanE.setVisibility(View.VISIBLE);
        tVgambar.setVisibility(View.VISIBLE);
        iVgambarLatihanSoal.setVisibility(View.VISIBLE);
        tVjawaban.setVisibility(View.VISIBLE);
        jawabanBenar.setVisibility(View.VISIBLE);
        simpan6.setVisibility(View.VISIBLE);
        pilihGambar.setVisibility(View.VISIBLE);
    }

    private void insertLatihanSoal() {
        final String pertanyaan = inputSoal.getText().toString();
        final String opsiA = jawabanA.getText().toString();
        final String opsiB = jawabanB.getText().toString();
        final String opsiC = jawabanC.getText().toString();
        final String opsiD = jawabanD.getText().toString();
        final String opsiE = jawabanE.getText().toString();
        final String jawaban = jawabanBenar.getText().toString();
        if (TextUtils.isEmpty(pertanyaan)){
            Toast.makeText(this, "Masukan Soal Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(opsiA)){
            Toast.makeText(this, "Masukan Opsi A Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(opsiB)){
            Toast.makeText(this, "Masukan Opsi B Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(opsiC)){
            Toast.makeText(this, "Masukan Opsi C Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(opsiD)){
            Toast.makeText(this, "Masukan Opsi D Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(opsiE)){
            Toast.makeText(this, "Masukan Opsi E Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(jawaban)) {
            Toast.makeText(this, "Masukan Jawaban Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        }else{
            StorageReference fileReference = mStoreRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(mImageUri));
            mUploadTask = fileReference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar1.setProgress(0);
                        }
                    }, 5000);
                    Toast.makeText(InputKampus.this, "Sukses Memasukan ke database", Toast.LENGTH_SHORT).show();
                    String gambar = taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();
                    DbSoal dbSoal = new DbSoal(pertanyaan,opsiA,opsiB,opsiC,opsiD,opsiE,jawaban);
                    String key = dataSoal.push().getKey();
                    dataSoal.child(key).setValue(dbSoal);
                }

            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(InputKampus.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mProgressBar1.setProgress((int) progress);
                        }
                    });

        }
    }

}

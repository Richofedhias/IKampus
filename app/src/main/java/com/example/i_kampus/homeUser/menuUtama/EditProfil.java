package com.example.i_kampus.homeUser.menuUtama;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.i_kampus.R;
import com.example.i_kampus.database.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

public class EditProfil extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;

    private TextView gantigambar;
    private EditText firstname, lastname, email, notelp, sekolah;
    private RadioButton laki, perempuan;
    private RadioGroup gender;
    private Button simpan;
    private CircularImageView gambar;
    private ProgressBar progressBar;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;

    private Uri Imageuri;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private StorageTask mSimpanTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);
        inisialisasi();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        mStorageRef = FirebaseStorage.getInstance().getReference("GambarUser");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());

        gantigambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChosser();
            }
        });

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });


    }

    public void inisialisasi() {
        gantigambar = findViewById(R.id.ubah_gambar);
        simpan = findViewById(R.id.simpan);
        firstname = findViewById(R.id.firstname_edProfil);
        lastname = findViewById(R.id.lastname_edProfil);
        email = findViewById(R.id.email_edProfil);
        sekolah = findViewById(R.id.sekolah_edProfil);
        notelp = findViewById(R.id.telp_edProfil);
        gender = findViewById(R.id.gender_profil);
        laki = findViewById(R.id.laki_laki);
        perempuan = findViewById(R.id.perempuan);
        gambar = findViewById(R.id.gambar_edProfil);
        progressBar = findViewById(R.id.progressBar);

    }
    private void update(){
        String first = firstname.getText().toString();
        String last = lastname.getText().toString();
        String emaill = email.getText().toString();
        String notelpp = notelp.getText().toString();

        User user = new User(first,last,emaill,notelpp);
        mDatabaseRef.setValue(user);
        finish();
    }

    public void openFileChosser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Imageuri = data.getData();

            Picasso.with(this).load(Imageuri).into(gambar);
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

//    public void updateUser(final String firstName, final String lastName, final String email, final String noTelfon, final String key) {
//        if (Imageuri != null) {
//            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis() + "." + getFileExtension(Imageuri));
//
//            mSimpanTask = fileReference.putFile(Imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    Handler handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            progressBar.setProgress(0);
//                        }
//                    }, 3000);
//
//                    Toast.makeText(EditProfil.this, "Sukses Merubah Profil", Toast.LENGTH_LONG).show();
//                    mDatabaseRef.child(key).child("email").setValue(email);
//                    mDatabaseRef.child(key).child("firstName").setValue(firstName);
//                    mDatabaseRef.child(key).child("elastName").setValue(lastName);
//                    mDatabaseRef.child(key).child("noTelfon").setValue(noTelfon);
////  User user = new User(firstname.getText().toString().trim(), lastname.getText().toString().trim(), email.getText().toString().trim(), notelp.getText().toString().trim(), sekolah.getText().toString().trim(),
////                            taskSnapshot.getMetadata().getReference().getDownloadUrl().toString());
////                    String UserID = mDatabaseRef.push().getKey();
////                    mDatabaseRef.child(UserID).setValue(user);
//
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(EditProfil.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                    double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
//                    progressBar.setProgress((int) progress);
//                }
//            });
//        }
//
//        Intent intent = new Intent(EditProfil.this, Profil.class);
//        startActivity(intent);


    }

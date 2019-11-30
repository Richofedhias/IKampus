package com.example.i_kampus.homeUser.menuKuesioner;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.i_kampus.R;
import com.example.i_kampus.database.DbKuesioner;
import com.example.i_kampus.homeUser.menuUtama.LatihanSoal.LatihanSoal;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.List;

public class KuesionerPsikologi extends AppCompatActivity {
    List<DbKuesioner> quesList;
    int correct = 0;
    int wrong = 0;
    int hasil;
    int qid = 1;
    String jawab;
    String kategori;
    int total = 0;
    DbKuesioner currentQ;
    TextView txtQuestion, waktu;
    Firebase mQuestionRef, mChoice1Ref, mChoice2Ref, mChoice3Ref, mChoice4Ref, mChoice5Ref, mAnswerRef;
    Button choiceA, choiceB, choiceC, choiceD, choiceE,butNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuesioner_psikologi);
        txtQuestion=findViewById(R.id.soalKuesionerPenj);
        choiceA =findViewById(R.id.choiceA);
        choiceB =findViewById(R.id.choiceB);
        choiceC =findViewById(R.id.choiceC);
        choiceD =findViewById(R.id.choiceD);
        choiceE =findViewById(R.id.choiceE);
        waktu = findViewById(R.id.waktu);
//        butNext=(Button)findViewById(R.id.button1);
//        setQuestionView();
//        butNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
//                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
//                grp.clearCheck();
//                Log.d("", currentQ.getJawaban()+" "+answer.getText());
//                if(currentQ.getJawaban().equals(answer.getText()))
//                {
//                    score++;
//                    Log.d("score", "Your score"+score);
//                }
//                if(qid<7){
//                    currentQ=quesList.get(qid);
//                    setQuestionView();
//                }else{
//                    Intent intent = new Intent(KuesionerPenjurusan.this, HasilPenjurusan.class);
//                    Bundle b = new Bundle();
//                    b.putInt("score", score); //Your score
//                    intent.putExtras(b); //Put your score to your next Intent
//                    startActivity(intent);
//                    finish();
//                }
//            }
//        });
        updateQuestion();
//        waktu(10, waktu);

    }

    private void updateQuestion() {
        if (qid > 15) {
            if (hasil >= 139){
                kategori = "Genius";
            }else if(hasil >=1329){
                kategori = "Sangat Cerdas";
            }else if(hasil >=119) {
                kategori = "Cerdas";
            }else if(hasil >=90) {
                kategori = "Normal";
            }else if(hasil >=89) {
                kategori = "Rata - Rata";
            }else if(hasil >=79) {
                kategori = "Lambat";
            }else if(hasil >=69) {
                kategori = "Bodoh";
            }else if(hasil >=40 ) {
                kategori = "IQ Sangat Rendah";
            }else if(hasil >=20) {
                kategori = "Keterbelakangan Mental";
            }else if  (hasil == 0 ){
                kategori = "Idiot";
            }
            hasil = (correct * 10);
            Intent intent = new Intent(KuesionerPsikologi.this, HasilPsikologi.class);
            intent.putExtra("corect", String.valueOf(correct));
            intent.putExtra("incorrect", String.valueOf(wrong));
            intent.putExtra("hasil",String.valueOf(hasil));
            intent.putExtra("kategori",String.valueOf(kategori));
            startActivity(intent);
            finish();

        } else {
            mQuestionRef = new Firebase("https://i-kampus.firebaseio.com/Psikologi/"+ qid +"/question");
            mQuestionRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String quest = dataSnapshot.getValue(String.class);
                    txtQuestion.setText(quest);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mChoice1Ref = new Firebase("https://i-kampus.firebaseio.com/Psikologi/"+ qid +"/opsiA");
            mChoice1Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String choice = dataSnapshot.getValue(String.class);
                    choiceA.setText(choice);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mChoice2Ref = new Firebase("https://i-kampus.firebaseio.com/Psikologi/"+ qid +"/opsiB");
            mChoice2Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String choice = dataSnapshot.getValue(String.class);
                    choiceB.setText(choice);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mChoice3Ref = new Firebase("https://i-kampus.firebaseio.com/Psikologi/"+ qid +"/opsiC");
            mChoice3Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String choice = dataSnapshot.getValue(String.class);
                    choiceC.setText(choice);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mChoice4Ref = new Firebase("https://i-kampus.firebaseio.com/Psikologi/"+ qid +"/opsiD");
            mChoice4Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String choice = dataSnapshot.getValue(String.class);
                    choiceD.setText(choice);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mChoice5Ref = new Firebase("https://i-kampus.firebaseio.com/Psikologi/"+ qid +"/opsiE");
            mChoice5Ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String choice = dataSnapshot.getValue(String.class);
                    choiceE.setText(choice);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            mAnswerRef = new Firebase("https://i-kampus.firebaseio.com/Psikologi/"+ qid +"/jawaban");
            mAnswerRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    jawab = dataSnapshot.getValue(String.class);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            qid++;

            choiceA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (choiceA.getText().equals(jawab)){
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                correct++;
                                choiceA.setBackgroundColor(Color.parseColor("#91D8F7"));

                                updateQuestion();
                            }
                        },1000);
                    }
                    else {
                        wrong = wrong + 1;
                        choiceA.setBackgroundColor(Color.RED);
                        if (choiceB.getText().toString().equals(jawab)) {
                            choiceB.setBackgroundColor(Color.GREEN);
                        } else if (choiceC.getText().toString().equals(jawab)) {
                            choiceC.setBackgroundColor(Color.GREEN);
                        } else if (choiceD.getText().toString().equals(jawab)) {
                            choiceD.setBackgroundColor(Color.GREEN);
                        } else if (choiceE.getText().toString().equals(jawab)) {
                            choiceE.setBackgroundColor(Color.GREEN);
                        }
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                choiceA.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceB.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceC.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceD.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceE.setBackgroundColor(Color.parseColor("#91D8F7"));
                                updateQuestion();
                            }
                        }, 1000);
                    }
                }
            });

            choiceB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (choiceB.getText().equals(jawab)){
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                correct++;
                                choiceB.setBackgroundColor(Color.parseColor("#91D8F7"));

                                updateQuestion();
                            }
                        },1000);
                    }
                    else {
                        wrong = wrong + 1;
                        choiceB.setBackgroundColor(Color.RED);
                        if (choiceA.getText().toString().equals(jawab)) {
                            choiceA.setBackgroundColor(Color.GREEN);
                        } else if (choiceC.getText().toString().equals(jawab)) {
                            choiceC.setBackgroundColor(Color.GREEN);
                        } else if (choiceD.getText().toString().equals(jawab)) {
                            choiceD.setBackgroundColor(Color.GREEN);
                        } else if (choiceE.getText().toString().equals(jawab)) {
                            choiceE.setBackgroundColor(Color.GREEN);
                        }
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                choiceA.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceB.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceC.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceD.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceE.setBackgroundColor(Color.parseColor("#91D8F7"));
                                updateQuestion();
                            }
                        }, 1000);
                    }
                }
            });

            choiceC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (choiceC.getText().equals(jawab)){
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                correct++;
                                choiceC.setBackgroundColor(Color.parseColor("#91D8F7"));

                                updateQuestion();
                            }
                        },1000);
                    }
                    else {
                        wrong = wrong + 1;
                        choiceC.setBackgroundColor(Color.RED);
                        if (choiceA.getText().toString().equals(jawab)) {
                            choiceA.setBackgroundColor(Color.GREEN);
                        } else if (choiceB.getText().toString().equals(jawab)) {
                            choiceB.setBackgroundColor(Color.GREEN);
                        } else if (choiceD.getText().toString().equals(jawab)) {
                            choiceD.setBackgroundColor(Color.GREEN);
                        } else if (choiceE.getText().toString().equals(jawab)) {
                            choiceE.setBackgroundColor(Color.GREEN);
                        }
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                choiceA.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceB.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceC.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceD.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceE.setBackgroundColor(Color.parseColor("#91D8F7"));
                                updateQuestion();
                            }
                        }, 1000);
                    }
                }
            });

            choiceD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (choiceD.getText().equals(jawab)){
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                correct++;
                                choiceD.setBackgroundColor(Color.parseColor("#91D8F7"));

                                updateQuestion();
                            }
                        },1000);
                    }
                    else {
                        wrong = wrong + 1;
                        choiceD.setBackgroundColor(Color.RED);
                        if (choiceA.getText().toString().equals(jawab)) {
                            choiceA.setBackgroundColor(Color.GREEN);
                        } else if (choiceB.getText().toString().equals(jawab)) {
                            choiceB.setBackgroundColor(Color.GREEN);
                        } else if (choiceC.getText().toString().equals(jawab)) {
                            choiceC.setBackgroundColor(Color.GREEN);
                        } else if (choiceE.getText().toString().equals(jawab)) {
                            choiceE.setBackgroundColor(Color.GREEN);
                        }
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                choiceA.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceB.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceC.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceD.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceE.setBackgroundColor(Color.parseColor("#91D8F7"));
                                updateQuestion();
                            }
                        }, 1000);
                    }
                }
            });

            choiceE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (choiceE.getText().equals(jawab)){
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                correct++;
                                choiceE.setBackgroundColor(Color.parseColor("#91D8F7"));

                                updateQuestion();
                            }
                        },1000);
                    }
                    else {
                        wrong = wrong + 1;
                        choiceE.setBackgroundColor(Color.RED);
                        if (choiceA.getText().toString().equals(jawab)) {
                            choiceA.setBackgroundColor(Color.GREEN);
                        } else if (choiceB.getText().toString().equals(jawab)) {
                            choiceB.setBackgroundColor(Color.GREEN);
                        } else if (choiceC.getText().toString().equals(jawab)) {
                            choiceC.setBackgroundColor(Color.GREEN);
                        } else if (choiceD.getText().toString().equals(jawab)) {
                            choiceD.setBackgroundColor(Color.GREEN);
                        }
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                choiceA.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceB.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceC.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceD.setBackgroundColor(Color.parseColor("#91D8F7"));
                                choiceE.setBackgroundColor(Color.parseColor("#91D8F7"));
                                updateQuestion();
                            }
                        }, 1000);
                    }

                }
            });
        }
    }
}

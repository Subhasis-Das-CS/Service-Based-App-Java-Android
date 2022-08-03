package com.esoft.subhasis.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class Account extends AppCompatActivity {

    TextView name, phone, email, address;
    Button changepassword;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    String uid, userId;
    ImageView imageView;
    StorageReference storageReference;
    Toolbar toolbar;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        toolbar=findViewById(R.id.customtoolbar);
        toolbar.setTitle("Account");
        imageView=findViewById(R.id.imageView8);
        name=findViewById(R.id.showaccountname);
        phone=findViewById(R.id.showaccountphone);
        email=findViewById(R.id.showaccountmail);
        address=findViewById(R.id.showaccouontaddress);
        changepassword=findViewById(R.id.changepassword);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        uid=firebaseAuth.getCurrentUser().getUid();
        user = firebaseAuth.getCurrentUser();

        storageReference = FirebaseStorage.getInstance().getReference();

        userId= firebaseAuth.getCurrentUser().getUid();

        StorageReference profileRef = storageReference.child("users/"+firebaseAuth.getCurrentUser().getUid()+"/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(getApplicationContext()).load(uri).into(imageView);

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open gallery
                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGalleryIntent,1000);

            }
        });


        DocumentReference documentReference = firebaseFirestore.collection("users").document(uid);
        documentReference.addSnapshotListener(this,
                new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                        phone.setText("Phone: "+documentSnapshot.getString("phone"));
                        name.setText(documentSnapshot.getString("fName"));
                        email.setText("E-mail: "+documentSnapshot.getString("email"));
                        address.setText("Address: "+documentSnapshot.getString("address"));

                    }
                });


        changepassword.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        final EditText resetPassword = new EditText(v.getContext());

                        final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                        passwordResetDialog.setTitle("Reset Password ?");
                        passwordResetDialog.setMessage("Enter New Password > 6 Characters long.");
                        passwordResetDialog.setView(resetPassword);

                        passwordResetDialog.setPositiveButton("Yes",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // extract the email and send reset link
                                        String newPassword = resetPassword.getText().toString();
                                        user.updatePassword(newPassword).addOnSuccessListener(
                                                new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        Toast.makeText(Account.this, "Password Reset Successfully.", Toast.LENGTH_SHORT).show();
                                                    }
                                                }).addOnFailureListener(
                                                new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Toast.makeText(Account.this, "Password Reset Failed., Log Out & Log In Again", Toast.LENGTH_LONG).show();
                                                        Log.d("TAG", "Error password not updated"+e.toString());
                                                    }
                                                });
                                    }
                                });

                        passwordResetDialog.setNegativeButton("No",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // close
                                    }
                                });

                        passwordResetDialog.create().show();

                    }
                });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            if(resultCode == Activity.RESULT_OK){
                Uri imageUri = data.getData();

                //profileImage.setImageURI(imageUri);

                uploadImageToFirebase(imageUri);




            }
        }

    }
    private void uploadImageToFirebase(Uri imageUri) {

        //progressBar.setVisibility(View.VISIBLE);
        // uplaod image to firebase storage
        final StorageReference fileRef = storageReference.child("users/"+firebaseAuth.getCurrentUser().getUid()+"/profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.with(getApplicationContext()).load(uri).into(imageView);
                       // progressBar.setVisibility(View.GONE);

                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Account.this, "Failed.", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
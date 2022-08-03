package com.esoft.subhasis.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MoreOptions extends AppCompatActivity {

    Button button;
    Button food, dailyneeds, automobile, b2b, babycare, banquets, beauty, bills, bullksms, cabsandrental, cakeshops;
    Button caterers, civilcontractors, consultants, contractors, danceandmusic, decorators, doctors, educations, eventorg;
    Button florists, housekeeping, interiordesigners, internetandit, languageclasses, modularkitchen, packagesandmovers, party;
    Button pest, petandpetcare, realestate, rents, repairandservices, securityandcctv, trinninginstitutes, travel, weddingrequisites, more;

    Toolbar toolbar;
    MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_options);
        toolbar=findViewById(R.id.toolbar13);
        toolbar.setTitle("All Categories");
button=findViewById(R.id.button2);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent button=new Intent(MoreOptions.this, AllMoreMenu.class);
        startActivity(button);
    }
});

        food = findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "food");
                startActivity(repair);
            }
        });


        dailyneeds = findViewById(R.id.dailyneeds);
        dailyneeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "dailyneeds");
                startActivity(repair);
            }
        });
        automobile = findViewById(R.id.automobile);
        automobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "automobile");
                startActivity(repair);
            }
        });
        b2b = findViewById(R.id.b2b);
        b2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "b2b");
                startActivity(repair);
            }
        });
        babycare = findViewById(R.id.babycare);
        babycare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "babycare");
                startActivity(repair);
            }
        });
        banquets = findViewById(R.id.banquets);
        banquets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "banquets");
                startActivity(repair);
            }
        });
        beauty = findViewById(R.id.beauty);
        beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "beauty");
                startActivity(repair);
            }
        });
        bills = findViewById(R.id.bills);
        bills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "bills");
                startActivity(repair);
            }
        });
        bullksms = findViewById(R.id.bulksms);
        bullksms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "bulksms");
                startActivity(repair);
            }
        });
        cabsandrental = findViewById(R.id.cabsandcarrental);
        cabsandrental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "cabsandrental");
                startActivity(repair);
            }
        });
        cakeshops = findViewById(R.id.cakeshops);
        cakeshops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "cakeshops");
                startActivity(repair);
            }
        });
        caterers = findViewById(R.id.caterers);
        caterers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "caterers");
                startActivity(repair);
            }
        });
        civilcontractors = findViewById(R.id.civilcontractors);
        civilcontractors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "civilcontractors");
                startActivity(repair);
            }
        });
        consultants = findViewById(R.id.consultants);
        consultants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "consultants");
                startActivity(repair);
            }
        });
        contractors = findViewById(R.id.contractors);
        contractors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "contractors");
                startActivity(repair);
            }
        });
        danceandmusic = findViewById(R.id.danceandmusic);
        danceandmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "danceandmusic");
                startActivity(repair);
            }
        });
        decorators = findViewById(R.id.decorators);
        decorators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "decorators");
                startActivity(repair);
            }
        });
        doctors = findViewById(R.id.doctorss);
        doctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "doctor");
                startActivity(repair);
            }
        });
        educations = findViewById(R.id.educations);
        educations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "education");
                startActivity(repair);
            }
        });
        eventorg = findViewById(R.id.eventorg);
        eventorg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "eventorg");
                startActivity(repair);
            }
        });
        florists = findViewById(R.id.florists);
        florists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "florists");
                startActivity(repair);
            }
        });
        housekeeping = findViewById(R.id.housekeeping);
        housekeeping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "housekeeping");
                startActivity(repair);
            }
        });
        interiordesigners = findViewById(R.id.interiordesigners);
        interiordesigners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "designing");
                startActivity(repair);
            }
        });
        internetandit = findViewById(R.id.internetandit);
        internetandit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "internetandit");
                startActivity(repair);
            }
        });
        languageclasses = findViewById(R.id.languageclasses);
        languageclasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "languageclasses");
                startActivity(repair);
            }
        });
        modularkitchen = findViewById(R.id.modularkitchen);
        modularkitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "modularkitchen");
                startActivity(repair);
            }
        });
        packagesandmovers = findViewById(R.id.packersandmovers);
        packagesandmovers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "packersandmovers");
                startActivity(repair);
            }
        });
        party = findViewById(R.id.party);
        party.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "party");
                startActivity(repair);
            }
        });
        pest = findViewById(R.id.pest);
        pest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "pest");
                startActivity(repair);
            }
        });
        petandpetcare = findViewById(R.id.petandpetcare);
        petandpetcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "petandpetcare");
                startActivity(repair);
            }
        });
        realestate = findViewById(R.id.realestate);
        realestate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "realestate");
                startActivity(repair);
            }
        });
        rents = findViewById(R.id.rent);
        rents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "rent");
                startActivity(repair);
            }
        });
        repairandservices = findViewById(R.id.repairandservices);
        repairandservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "repair");
                startActivity(repair);
            }
        });
        securityandcctv = findViewById(R.id.securityandcctv);
        securityandcctv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "securityandcctv");
                startActivity(repair);
            }
        });

        trinninginstitutes = findViewById(R.id.trainninginstitute);
        trinninginstitutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "trainninginstitute");
                startActivity(repair);
            }
        });
        travel = findViewById(R.id.travel);
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "travel");
                startActivity(repair);
            }
        });
        weddingrequisites = findViewById(R.id.weddingrequisites);
        weddingrequisites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "weddingrerquisites");
                startActivity(repair);
            }
        });
        more = findViewById(R.id.mores);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent repair = new Intent(getApplicationContext(), AllOptions.class);
                repair.putExtra("option", "more");
                startActivity(repair);
            }
        });


    }

}
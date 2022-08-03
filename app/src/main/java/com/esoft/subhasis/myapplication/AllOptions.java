package com.esoft.subhasis.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AllOptions extends AppCompatActivity {
    Toolbar toolbar;
    String[] mainarray;
    String option;
    String category;
    ListView listView;
    String[] medicalfacilities={"Polyclinics","Hearing Aids", "Aaya Centres", "Hospitals", "Home Medical Services"};
    String[] doctors ={"Ayurvedic Doctors", "Bone and Joints Doctor", "Cardiologists", "Chest Specialists", "Child specialist doctors", "Cosmetic Surgeons", "Dentists","Dermatologists", "Diabetologists", "Dietetians", "ENT Specialists", "EYE Specialists", "Gastroenterologists &","General Physician", "Gynecologists and obstetricians", "Homeopathic Doctors", "Neonatologists","Neurologists","Neurosurgeons","Oncologists","On Call Doctors","Opthalmologists","Orthopaedic Doctors", "Paedetricians","Physiotherapists","Physiotherapists for Home","Piles Doctors", "Psychriatists", "Psychologists", "Psychotherapists", "Radiologists","Rheumatologists", "Sexologists", "Sexologists for female", "Sexologists for male", "Skin & Hair Doctors","Skin Doctors","Speech Therapists", "Spine surgeons", "Thyroid Doctors", "Trichologists", "Ultrasonologists", "Unani Doctors", "Urologists", "Veterinary Doctors"  };
    String[] education={"Private Schools", "Government Schools", "Coachings", "Private Tutors", "Colleges", "Universities", "Other Institutuins" };
    String[] sports={"Football", "Cricket", "Tennis", "Volleyball", "Table Tennis", "Basket ball", "Badminton"};
    String[] consultants={"Lawyers", "Chartered Accountants", "Auditors", "Income tax consultants", "GST Compliance Consultants"};
    String[] rent={"Air Coolers On Hire", "Bridal Wear On Hire", "Bunglows On Hire", "Bs On Hire", "Car On Hire", "Computers On Hire", "Cottages On Hire", "Cranes On Hire", "DJ Equipments On Hire", "Farm House On Hire", "Furniture On Hire","Generators On Hire", "Laptops On Hire", "Mini Bus On Hire", "Mini Trucks On Hire", "Motorcycles on hire", "Offices On Hire", "Rooms On Hire", "Sound Systems On Hire", "Tempo Travellers On Hire", "Trucks On Hire","Vans On Hire"};
    String[] homeservices={"Appliances Repair", "Home Cleaning", "Disinfection services", "Carpenters", "Electricians", "Painters", "Pest Control Services", "Plumbers", "Massage Services", "Make Up & hair Styling"};
    String[] designing={"Interior Designing", "Interior Designer Institutes", "Interior Decorators","Commercial", "Residents", "Architects"};
    String[] repair={"AC", "Air Cooler", "CCTV Camera", "Camera", "Car", "Car AC", "Computers", "Computer Hardware", "Computer Printer", "DVD Player", "Electric Chimney","Elevator", "Furniture", "Gas Stove", "Generator", "Geyser", "Inverter", "Laptop", "Microwave Oven", "Mobile Phone", "Motor Cycle", "projectors", "Refrigerators", "Ro Water Purifier", "Scooter", "Sewing Machine", "Sofa set", "TV", "Tablet", "Treadmill", "UPS", "Washing Machine", "Water Purifier", "Wrist Watch"};
    String[] food={"Cuisine", "Home Delivery"};
    String[] dailyneeds={"Grocery", "Milk & Milk Products", "Medicines", "Plumber", "Electricians", "Cleaning Services", "Fruits & Vegitables", "AC Service", "Masseur", "Statioery Store",
            "Mlikman", "Paperwala", "Gardener"};
    String[] automobile={"New Car", "Sell Car", "Used Car", "Two Wheelers"};
    String[] b2b={"Electronics & Electrical...", "Idustrial Machinery", "Construction Mechinery", "Logistics & Transpotation", "Food & Beverages", "Apparel"};
    String[] babycare={"Baby Food", "Baby Sisters", "Baby Sleep", "Bath", "Books", "Clothes", "Cream"};
    String[] banquets={"5 Star Hall", "AC Hall", "Non AC Hall", "Lawn for Event", "Roof Top Hall"};
    String[] beauty={"Parlours", "spa", "Salons", "Makeup"};
    String[] bills={"Mobile", "Gas", "Landline", "Electricity", "DTH"};
    String[] bulksms={"Bulk SMS Service", "IVR Service Providers", "Bulk Email Services", "VOIP Services", "Call Centre Solution"};
    String[] cabsandcarrental={"Book A Cab Online"};
    String[] cakeshops={"Cake Delivery", "Wedding Cake Retailers", "Customised Cake Retailers"};
    String[] caterers={"Party Cateres", "Birthday Party Cateres", "House Warming"};
    String[] civilcontractors={"Carpentry", "Electrical", "Flooring", "Furniture", "Plumbing"};

    String[] contractors={"Building Contractors"};
    String[] danceandmusic={"All Dance Classes", "Tollywood", "Classical Dance", "Salsa", "Hip Hop"};
    String[] decorators={"Mandop", "Weeding", "Flower", "Party", "Ballon", "Stage"};
    String[] eventorg={"Private", "Corporate", "Seminar", "Stage Show", "Wedding", "Trade Fair"};
    String[] florists={"Florists"};
    String[] housekeeping={"Cooks", "Maids", "Driver", "Gardeners", "Laundey", "Cleaning"};
    String[] internetandit={"Web & APP Development", "Cyber Cafe", "wifi Service", "Broadband"};
    String[] languageclasses={"French", "German", "Korean", "Japanese", "English", "Bengali", "Hindi"};
    String[] modularkitche={"Cabinets", "Chimneys", "Gas Stove"};
    String[] packersandmovers={"Courier Services", "Transport Services"};
    String[] party={"Party Organizers"};
    String[] pest={"Commercial", "Residential"};
    String[] petandpetcare={"Food", "Shops", "Veterinary Doctors"};
    String[] realestate={"Buy", "Rent", "Sell", "PG Hostel Room"};
    String[] securityandcctv={"Security Service", "CCTV Cameras", "Bodygurds"};
    String[] trainninginstitute={"Driving School", "Computer Academies"};
    String[] travel={"Flights", "Bus", "Trains", "Car", "Tempo", "Hotel", "Resorts"};
    String[] weddingrequisites={"Wedding Planners"};
    String[] more={"Delivery Services", "Other Services", "Uncommon Product Shops"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_options);
        listView=findViewById(R.id.listview);
        toolbar=findViewById(R.id.toolbar2);

        toolbar.setTitle("List Of Categories");
        option=getIntent().getStringExtra("option");


        if(option.equals("weddingrequisites")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, weddingrequisites);
            listView.setAdapter(adapter);
            category="weddingrequisites";
            mainarray=weddingrequisites;
        }


        if(option.equals("more")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, more);
            listView.setAdapter(adapter);
            category="more";
            mainarray=more;
        }

        if(option.equals("travel")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, travel);
            listView.setAdapter(adapter);
            category="travel";
            mainarray=travel;
        }

        if(option.equals("trainninginstitute")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, trainninginstitute);
            listView.setAdapter(adapter);
            category="trainninginstitute";
            mainarray=trainninginstitute;
        }

        if(option.equals("securityandcctv")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, securityandcctv);
            listView.setAdapter(adapter);
            category="securityandcctv";
            mainarray=securityandcctv;
        }

        if(option.equals("rent")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, rent);
            listView.setAdapter(adapter);
            category="rent";
            mainarray=rent;
        }


        if(option.equals("realestate")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, realestate);
            listView.setAdapter(adapter);
            category="realestate";
            mainarray=realestate;
        }

        if(option.equals("petandpetcare")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, petandpetcare);
            listView.setAdapter(adapter);
            category="petsandpetcare";
            mainarray=petandpetcare;
        }


        if(option.equals("pest")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, pest);
            listView.setAdapter(adapter);
            category="pest";
            mainarray=pest;
        }

        if(option.equals("party")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, party);
            listView.setAdapter(adapter);
            category="party";
            mainarray=party;
        }


        if(option.equals("packersandmovers")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, packersandmovers);
            listView.setAdapter(adapter);
            category="packersandmovers";
            mainarray=packersandmovers;
        }

        if(option.equals("modularkitchen")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, modularkitche);
            listView.setAdapter(adapter);
            category="modularkitchen";
            mainarray=modularkitche;
        }

        if(option.equals("languageclasses")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, languageclasses);
            listView.setAdapter(adapter);
            category="languageclasses";
            mainarray=languageclasses;
        }

        if(option.equals("internetandit")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, internetandit);
            listView.setAdapter(adapter);
            category="internetandit";
            mainarray=internetandit;
        }


        if(option.equals("housekeeping")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, housekeeping);
            listView.setAdapter(adapter);
            category="housekeeping";
            mainarray=housekeeping;
        }

        if(option.equals("florists")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, florists);
            listView.setAdapter(adapter);
            category="florists";
            mainarray=florists;
        }

        if(option.equals("eventorg")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, eventorg);
            listView.setAdapter(adapter);
            category="eventorg";
            mainarray=eventorg;
        }

        if(option.equals("decorators")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, decorators);
            listView.setAdapter(adapter);
            category="decorators";
            mainarray=decorators;
        }

        if(option.equals("danceandmusic")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, danceandmusic);
            listView.setAdapter(adapter);
            category="danceandmusic";
            mainarray=danceandmusic;
        }

        if(option.equals("contractors")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, contractors);
            listView.setAdapter(adapter);
            category="contractors";
            mainarray=contractors;
        }

        if(option.equals("consultants")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line,consultants);
            listView.setAdapter(adapter);
            category="consultants";
            mainarray=consultants;
        }

        if(option.equals("civilcontractors")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, civilcontractors);
            listView.setAdapter(adapter);
            category="civilcontractors";
            mainarray=civilcontractors;
        }

        if(option.equals("caterers")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, caterers);
            listView.setAdapter(adapter);
            category="caterers";
            mainarray=caterers;
        }

        if(option.equals("cakeshops")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line,cakeshops);
            listView.setAdapter(adapter);
            category="cakeshops";
            mainarray=cakeshops;
        }

        if(option.equals("cabsandcarrental")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, cabsandcarrental);
            listView.setAdapter(adapter);
            category="cabsandcarrental";
            mainarray=cabsandcarrental;
        }

        if(option.equals("bulksms")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, bulksms);
            listView.setAdapter(adapter);
            category="bulksms";
            mainarray=bulksms;
        }

        if(option.equals("bills")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, bills);
            listView.setAdapter(adapter);
            category="bills";
            mainarray=bills;
        }

        if(option.equals("beauty")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, beauty);
            listView.setAdapter(adapter);
            category="beauty";
            mainarray=beauty;
        }

        if(option.equals("banquets")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, banquets);
            listView.setAdapter(adapter);
            category="banquets";
            mainarray=banquets;
        }

        if(option.equals("babycare")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, babycare);
            listView.setAdapter(adapter);
            category="babycare";
            mainarray=babycare;
        }
        if(option.equals("b2b")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, b2b);
            listView.setAdapter(adapter);
            category="b2b";
            mainarray=b2b;
        }

        if(option.equals("automobile")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, automobile);
            listView.setAdapter(adapter);
            category="automobile";
            mainarray=automobile;
        }


        if(option.equals("medicalfacilities")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, medicalfacilities);
            listView.setAdapter(adapter);
            category="medicalfacilities";
            mainarray=medicalfacilities;
        }



        if(option.equals("food")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, food);
            listView.setAdapter(adapter);
            category="food";
            mainarray=food;
        }

        if(option.equals("dailyneeds")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, dailyneeds);
            listView.setAdapter(adapter);
            category="dailyneeds";
            mainarray=dailyneeds;
        }
        if(option.equals("doctor")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, doctors);
            listView.setAdapter(adapter);
            category="doctors";
            mainarray=doctors;
        }
        if(option.equals("education")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, education);
            listView.setAdapter(adapter);
            category="education";
            mainarray=education;
        }

        if(option.equals("homeservices")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, homeservices);
            listView.setAdapter(adapter);
            category="homeservices";
            mainarray=homeservices;
        }
        if(option.equals("sports")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, sports);
            listView.setAdapter(adapter);
            category="sport";
            mainarray=sports;
        }

        if(option.equals("consultants")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, consultants);
            listView.setAdapter(adapter);
            category="consultants";
            mainarray=consultants;
        }
        if(option.equals("rent")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, rent);
            listView.setAdapter(adapter);
            category="rent";
            mainarray=rent;
        }

        if(option.equals("designing")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, designing);
            listView.setAdapter(adapter);
            category="designing";
            mainarray=designing;
        }
        if(option.equals("repair")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllOptions.this, android.R.layout.simple_dropdown_item_1line, repair);
            listView.setAdapter(adapter);
            category="repair";
            mainarray=repair;
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String temp=mainarray[position];
                Toast.makeText(AllOptions.this,temp, Toast.LENGTH_SHORT ).show();
                Intent l=new Intent(getApplicationContext(), Profiles.class);
                l.putExtra("url", temp);
                l.putExtra("category", category);
                startActivity(l);

            }
        });

    }
}
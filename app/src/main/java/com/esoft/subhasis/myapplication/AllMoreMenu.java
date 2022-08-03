package com.esoft.subhasis.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class AllMoreMenu extends AppCompatActivity {


    SearchView searchView;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_more_menu);

        ArrayAdapter<String> adapter;
        searchView=findViewById(R.id.sv);
        listView=findViewById(R.id.morelist);
        listView.setTextFilterEnabled(true);
        String[] array= {"Polyclinics","Hearing Aids", "Aaya Centres", "Hospitals", "Home Medical Services",
        "Ayurvedic Doctors", "Bone and Joints Doctor", "Cardiologists", "Chest Specialists", "Child specialist doctors", "Cosmetic Surgeons", "Dentists","Dermatologists", "Diabetologists", "Dietetians", "ENT Specialists", "EYE Specialists", "Gastroenterologists &","General Physician", "Gynecologists and obstetricians", "Homeopathic Doctors", "Neonatologists","Neurologists","Neurosurgeons","Oncologists","On Call Doctors","Opthalmologists","Orthopaedic Doctors", "Paedetricians","Physiotherapists","Physiotherapists for Home","Piles Doctors", "Psychriatists", "Psychologists", "Psychotherapists", "Radiologists","Rheumatologists", "Sexologists", "Sexologists for female", "Sexologists for male", "Skin & Hair Doctors","Skin Doctors","Speech Therapists", "Spine surgeons", "Thyroid Doctors", "Trichologists", "Ultrasonologists", "Unani Doctors", "Urologists", "Veterinary Doctors",
        "Private Schools", "Government Schools", "Coachings", "Private Tutors", "Colleges", "Universities", "Other Institutuins" ,
      "Football", "Cricket", "Tennis", "Volleyball", "Table Tennis", "Basket ball", "Badminton",
        "Lawyers", "Chartered Accountants", "Auditors", "Income tax consultants", "GST Compliance Consultants",
      "Air Coolers On Hire", "Bridal Wear On Hire", "Bunglows On Hire", "Bs On Hire", "Car On Hire", "Computers On Hire", "Cottages On Hire", "Cranes On Hire", "DJ Equipments On Hire", "Farm House On Hire", "Furniture On Hire","Generators On Hire", "Laptops On Hire", "Mini Bus On Hire", "Mini Trucks On Hire", "Motorcycles on hire", "Offices On Hire", "Rooms On Hire", "Sound Systems On Hire", "Tempo Travellers On Hire", "Trucks On Hire","Vans On Hire",
        "Appliances Repair", "Home Cleaning", "Disinfection services", "Carpenters", "Electricians", "Painters", "Pest Control Services", "Plumbers", "Massage Services", "Make Up & hair Styling",
        "Interior Designing", "Interior Designer Institutes", "Interior Decorators","Commercial", "Residents", "Architects",
        "AC", "Air Cooler", "CCTV Camera", "Camera", "Car", "Car AC", "Computers", "Computer Hardware", "Computer Printer", "DVD Player", "Electric Chimney","Elevator", "Furniture", "Gas Stove", "Generator", "Geyser", "Inverter", "Laptop", "Microwave Oven", "Mobile Phone", "Motor Cycle", "projectors", "Refrigerators", "Ro Water Purifier", "Scooter", "Sewing Machine", "Sofa set", "TV", "Tablet", "Treadmill", "UPS", "Washing Machine", "Water Purifier", "Wrist Watch",
        "Cuisine", "Home Delivery",
        "Grocery", "Milk & Milk Products", "Medicines", "Plumber", "Electricians", "Cleaning Services", "Fruits & Vegitables", "AC Service", "Masseur", "Statioery Store",
                "Mlikman", "Paperwala", "Gardener",
        "New Car", "Sell Car", "Used Car", "Two Wheelers",
        "Electronics & Electrical...", "Idustrial Machinery", "Construction Mechinery", "Logistics & Transpotation", "Food & Beverages", "Apparel",
        "Baby Food", "Baby Sisters", "Baby Sleep", "Bath", "Books", "Clothes", "Cream",
        "5 Star Hall", "AC Hall", "Non AC Hall", "Lawn for Event", "Roof Top Hall",
        "Parlours", "spa", "Salons", "Makeup",
        "Mobile", "Gas", "Landline", "Electricity", "DTH",
        "Bulk SMS Service", "IVR Service Providers", "Bulk Email Services", "VOIP Services", "Call Centre Solution",
        "Book A Cab Online",
        "Cake Delivery", "Wedding Cake Retailers", "Customised Cake Retailers",
        "Party Cateres", "Birthday Party Cateres", "House Warming",
        "Carpentry", "Electrical", "Flooring", "Furniture", "Plumbing",

      "Building Contractors",
        "All Dance Classes", "Tollywood", "Classical Dance", "Salsa", "Hip Hop",
       "Mandop", "Weeding", "Flower", "Party", "Ballon", "Stage",
        "Private", "Corporate", "Seminar", "Stage Show", "Wedding", "Trade Fair",
        "Florists",
        "Cooks", "Maids", "Driver", "Gardeners", "Laundey", "Cleaning",
        "Web & APP Development", "Cyber Cafe", "wifi Service", "Broadband",
        "French", "German", "Korean", "Japanese", "English", "Bengali", "Hindi",
        "Cabinets", "Chimneys", "Gas Stove",
        "Courier Services", "Transport Services",
        "Party Organizers",
        "Commercial", "Residential",
        "Food", "Shops", "Veterinary Doctors",
        "Buy", "Rent", "Sell", "PG Hostel Room",
        "Security Service", "CCTV Cameras", "Bodygurds",
        "Driving School", "Computer Academies",
        "Flights", "Bus", "Trains", "Car", "Tempo", "Hotel", "Resorts",
        "Wedding Planners",
        "Delivery Services", "Other Services", "Uncommon Product Shops"

};

        adapter=new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, array);
        listView.setAdapter(adapter);



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.onActionViewExpanded();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
                Intent pro=new Intent(AllMoreMenu.this, Profiles.class);
                pro.putExtra("url", selectedItem);
                startActivity(pro);
            }
        });
           }




}